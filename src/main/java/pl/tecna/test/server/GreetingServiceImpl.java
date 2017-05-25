package pl.tecna.test.server;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;
import org.codehaus.groovy.control.CompilerConfiguration;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import pl.tecna.test.client.GreetingService;
import pl.tecna.test.domain.ExpressionEntity;
import pl.tecna.test.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
public class GreetingServiceImpl implements GreetingService {

	@Inject
	private EntityManagerProvider em;

	@Inject
	private HttpSession httpSession;
	@Inject
	private HttpServletRequest httpRequest;
	@Override
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = httpRequest.getServletContext().getServerInfo();
		String userAgent = httpRequest.getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Helloooo, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}
	@Transactional
	public String saveExpression(String input) throws IllegalArgumentException {
		input = escapeHtml(input); 
		ExpressionEntity expressionEntity =  em.get().find(ExpressionEntity.class, httpSession.getId());
		if(expressionEntity!=null){
			expressionEntity.setExpression(input);
		}
		else{
			expressionEntity = new ExpressionEntity();
			expressionEntity.setSessionId(httpSession.getId());
			expressionEntity.setExpression(input);
		}
		em.get().persist(expressionEntity);
		return "Expression: "+input+" saved.";
	}
	
	public String solveExpression() throws IllegalArgumentException{
		  ExpressionEntity expressionEntity =  em.get().find(ExpressionEntity.class, httpSession.getId());
		  if(expressionEntity==null)return"Expression not found.";
		  String expression = expressionEntity.getExpression();
		  Binding binding=new Binding();
		  binding.setVariable("env",System.getenv());
		  binding.setVariable("sys",System.getProperties());
		  CompilerConfiguration config=new CompilerConfiguration();
		  GroovyShell shell=new GroovyShell(binding,config);
		  Object result=shell.evaluate(expression);
		  if (result == null) {
		    return "";
		  }
		 else {
		    return result.toString().trim();
		  }
	}
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 *
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
