package pl.tecna.test.client;

public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  @DefaultMessage("Enter math expression")
  String nameField();

  @DefaultMessage("Send")
  String sendButton();
  
  @DefaultMessage("Solve")
  String solveButton();
}
