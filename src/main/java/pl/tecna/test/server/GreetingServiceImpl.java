package pl.tecna.test.server;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import pl.tecna.test.client.GreetingService;
import pl.tecna.test.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
public class GreetingServiceImpl implements GreetingService {

	@Inject
	private HttpServletRequest httpRequest;

	@Override
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidExpression(input)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Brak operatora działania!");
		}

		String serverInfo = httpRequest.getServletContext().getServerInfo();
		String userAgent = httpRequest.getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Twoje wyrażenie: " + input + " zostało pobrane!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
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
