package pl.tecna.test.server;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.groovy.control.CompilerConfiguration;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import pl.tecna.test.client.GreetingService;
import pl.tecna.test.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
public class GreetingServiceImpl implements GreetingService {

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
					"Name must be at least 3 characters long");
		}

		String serverInfo = httpRequest.getServletContext().getServerInfo();
		String userAgent = httpRequest.getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		
		return "saved"+input;
	}
	
	@Override
	public  String saveExpression(String input) throws IllegalArgumentException {
				input = escapeHtml(input);
				
				if (!FieldVerifier.isValidName(input)) {
							return "Name must be at least 3 characters long";
				}
				if (!FieldVerifier.isNumberExpresion(input)) {
							return "Please correct your expression";
				}
				
				httpSession.setAttribute("input", input);
				return "saved:"+input;
		 
			}
	@Override		
	public String solveExpression() throws IllegalArgumentException{
				  String expression = (String)httpSession.getAttribute("input");
				  Binding binding=new Binding();
				  binding.setVariable("env",System.getenv());
				  binding.setVariable("sys",System.getProperties());
				  CompilerConfiguration config=new CompilerConfiguration();
				  GroovyShell shell=new GroovyShell(binding,config);
				  Object result=shell.evaluate(expression);
				  if (result == null) {
				    return "error";
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
