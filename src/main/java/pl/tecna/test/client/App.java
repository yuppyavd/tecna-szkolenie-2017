package pl.tecna.test.client;

import pl.tecna.test.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
//import pl.tecna.test.server.GreetingServiceImpl;

import org.mariuszgromada.math.mxparser.*;
//import org.mariuszgromada.math;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
  private final GreetingServiceAsync greetingService2 = GWT.create(GreetingService.class);
  
  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	 
	  
    final Button sendButton = new Button( messages.sendButton() );
    final TextBox nameField = new TextBox();
    nameField.setText( messages.nameField() );
    final Label errorLabel = new Label();
    final Button sendButton2 = new Button( messages.sendButton2() );
    
    // We can add style names to widgets
    
    sendButton.addStyleName("sendButton");
    sendButton.addStyleName("send");
    // Add the nameField and sendButton to the RootPanel
    // Use RootPanel.get() to get the entire body element
    RootPanel.get("nameFieldContainer").add(nameField);
    RootPanel.get("sendButtonContainer").add(sendButton);
    RootPanel.get("errorLabelContainer").add(errorLabel);
    RootPanel.get("sendButtonContainer").add(sendButton2);

    // Focus the cursor on the name field when the app loads
    nameField.setFocus(true);
    nameField.selectAll();

    // Create the popup dialog box
    final DialogBox dialogBox = new DialogBox();
    dialogBox.setText("Remote Procedure Call");
    dialogBox.setAnimationEnabled(true);
    final Button closeButton = new Button("Close");
    // We can set the id of a widget by accessing its Element
    closeButton.getElement().setId("closeButton");
    final Label textToServerLabel = new Label();
    final HTML serverResponseLabel = new HTML();
    VerticalPanel dialogVPanel = new VerticalPanel();
    dialogVPanel.addStyleName("dialogVPanel");
    dialogVPanel.add(new HTML("<b>Sending equasion to the server:</b>"));
    dialogVPanel.add(textToServerLabel);
    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
    dialogVPanel.add(closeButton);
    dialogBox.setWidget(dialogVPanel);
    
    
    
    // Create second the popup dialog box
    final DialogBox dialogBox2 = new DialogBox();
    dialogBox2.setText("Remote Procedure Call");
    dialogBox2.setAnimationEnabled(true);
    final Button closeButton2= new Button("Close");
    // We can set the id of a widget by accessing its Element
    closeButton2.getElement().setId("closeButton2");
    final Label textToServerLabel2 = new Label();
    final HTML serverResponseLabel2 = new HTML();
    VerticalPanel dialogVPanel2 = new VerticalPanel();
    dialogVPanel2.addStyleName("dialogVPanel");
    dialogVPanel2.add(new HTML("<b>Server replies:</b>"));
    dialogVPanel2.add(serverResponseLabel2);
    dialogVPanel2.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
    dialogVPanel2.add(closeButton2);
    dialogBox2.setWidget(dialogVPanel2);


    // Add a handler to close the DialogBox
    closeButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        dialogBox.hide();
        dialogBox2.hide();
        sendButton.setEnabled(true);
        sendButton.setFocus(true);
      }
    });
    

    // Add a handler to close second DialogBox
    closeButton2.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
    	dialogBox.hide();
        dialogBox2.hide();
        sendButton2.setEnabled(true);
        sendButton2.setFocus(true);
      }
    });


    // Create a handler for the sendButton and nameField
    class MyHandler implements ClickHandler, KeyUpHandler {
      /**
       * Fired when the user clicks on the sendButton.
       */
      public void onClick(ClickEvent event) {
        sendNameToServer();
      }

      /**
       * Fired when the user types in the nameField.
       */
      public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
          sendNameToServer();
        }
      }
      

      /**
       * Send the name from the nameField to the server and wait for a response.
       */
      private void sendNameToServer() {
        // First, we validate the input.
        errorLabel.setText("");
        String textToServer = nameField.getText();
        if (!FieldVerifier.isValidName(textToServer)) {
          errorLabel.setText("Please enter at least four characters");
          return;
        }

        // Then, we send the input to the server.
        sendButton.setEnabled(false);
        textToServerLabel.setText(textToServer);
        serverResponseLabel.setText("");
        greetingService.greetServer(textToServer, new AsyncCallback<String>() {
          public void onFailure(Throwable caught) {
            // Show the RPC error message to the user
            dialogBox.setText("Remote Procedure Call - Failure");
            serverResponseLabel.addStyleName("serverResponseLabelError");
            serverResponseLabel.setHTML(SERVER_ERROR);
            dialogBox.center();
            closeButton.setFocus(true);
          }

          public void onSuccess(String result) {
            dialogBox.setText("Remote Procedure Call");
            serverResponseLabel.removeStyleName("serverResponseLabelError");
            serverResponseLabel.setHTML(result);
            dialogBox.center();
            closeButton.setFocus(true);
          }
        });
      }
    }

    
    
    closeButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
          dialogBox.hide();
          sendButton2.setEnabled(true);
          sendButton2.setFocus(true);
        }
      });

      // Create a handler for the sendButton and nameField
      class MyHandler2 implements ClickHandler {
        /**
         * Fired when the user clicks on the sendButton.
         */
        public void onClick(ClickEvent event) {
          greetingService.calculator( new AsyncCallback<String>() {
              public void onFailure(Throwable caught) {
                  // Show the RPC error message to the user
                  dialogBox2.setText("Remote Procedure Call - Failure");
                  serverResponseLabel2.addStyleName("serverResponseLabelError");
                  serverResponseLabel2.setHTML(SERVER_ERROR);
                  dialogBox2.center();
                  closeButton2.setFocus(true);
                }

                public void onSuccess(String result) {
                  serverResponseLabel2.setHTML(result);
                  dialogBox2.center();
                  closeButton2.setFocus(true);
                }
              }); {
        	  
          }
//          dialogBox2.setText("Remote Procedure Call TEST");
//          serverResponseLabel2.removeStyleName("serverResponseLabelError");
//          serverResponseLabel2.setHTML(result);
//          dialogBox2.center();
//          closeButton2.setFocus(true);
        }

        /**
         * Fired when the user types in the nameField.
         */
//        public void onKeyUp(KeyUpEvent event) {
//          if (event.getNativeKeyCode() == KeyCodes.KEY_ALT) {
//            sendNameToServer();
//          }
//        }
//        

        /**
         * Send the name from the nameField to the server and wait for a response.
         */
        private void sendNameToServer() {
          // First, we validate the input.
          errorLabel.setText("");
          String textToServer = nameField.getText();
          if (!FieldVerifier.isValidName(textToServer)) {
            errorLabel.setText("Please enter longer equasion characters");
            return;
          }

          // Then, we send the input to the server.
          sendButton2.setEnabled(false);
          textToServerLabel.setText(textToServer);
          serverResponseLabel.setText("");
          
          greetingService2.greetServer(textToServer, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
              // Show the RPC error message to the user
              dialogBox2.setText("Remote Procedure Call - Failure");
              serverResponseLabel2.addStyleName("serverResponseLabelError");
              serverResponseLabel2.setHTML(SERVER_ERROR);
              dialogBox2.center();
              closeButton2.setFocus(true);
            }

            public void onSuccess(String result) {
              dialogBox2.setText("Remote Procedure Call");
              serverResponseLabel2.removeStyleName("serverResponseLabelError");
              serverResponseLabel2.setHTML(result);
              dialogBox2.center();
              closeButton2.setFocus(true);
            }
          });
        }
      }
    
    
    
    // Add a handler to send the name to the server
    MyHandler handler = new MyHandler();
    MyHandler2 handler2 = new MyHandler2();
    sendButton.addClickHandler(handler);
    nameField.addKeyUpHandler(handler);
    sendButton2.addClickHandler(handler2);
 //   nameField.addKeyUpHandler(handler2);
  }
}
