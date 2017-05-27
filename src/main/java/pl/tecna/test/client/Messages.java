package pl.tecna.test.client;

public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  @DefaultMessage("Wprowadź wyrażenie")
  String nameField();

  @DefaultMessage("Wyślij")
  String sendButton();
  
  @DefaultMessage("Oblicz")
  String calcButton();
}
