package pl.tecna.test.server;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pl.tecna.test.client.GreetingService;
import pl.tecna.test.shared.FieldVerifier;
import org.mariuszgromada.math.mxparser.*;

/**
 * The server side implementation of the RPC service.
 */
public class GreetingServiceImpl implements GreetingService {

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
		HttpSession session=httpRequest.getSession();
		
		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		String a=input;
		session.setAttribute("object", input);
		//return "The result is " +v;
		return input;
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
	public String calculator()
	{
		HttpSession session=httpRequest.getSession();
		String a;
		a=session.getAttribute("object").toString();
		Expression e = new Expression(a);
		double v = e.calculate();
		return "The result is" +v;
	}
}

