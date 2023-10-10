package main;

import controller.AutonomousControllerImpl;
import controller.ControllerImpl;
import model.Model;
import model.ModelImpl;
import view.InputUiImpl;
import view.View;
import view.ViewImpl;
import view.WebViewServer;


public class Main {
    static public void main(String[] args) {

        Model model = new ModelImpl();
        View view = new ViewImpl(model);
        InputUiImpl inputUI = new InputUiImpl();
        ControllerImpl controller = new ControllerImpl(model);
        inputUI.addObserver(controller);
        AutonomousControllerImpl autController = new AutonomousControllerImpl(model);
        WebViewServer webViewServer = new WebViewServer(model);
        autController.start();
        view.display();
        inputUI.display();
        webViewServer.display();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutting down the WSS");
            webViewServer.stopServer();
            System.out.println("WSS stopped");
        }));
    }
}
