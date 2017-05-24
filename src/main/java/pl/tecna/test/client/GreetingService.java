package pl.tecna.test.client;

import javax.servlet.http.HttpSession;

import org.mariuszgromada.math.mxparser.Expression;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.tecna.test.server.GreetingServiceImpl;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("../gwt-rpc")

public interface GreetingService extends RemoteService {

 public String calculator();
  String greetServer(String name) throws IllegalArgumentException;

  
}
