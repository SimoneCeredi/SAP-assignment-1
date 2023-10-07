package main;

import controller.AutonomousControllerImpl;
import controller.ControllerImpl;
import model.ModelImpl;
import model.ModelObserverSource;
import view.InputUiImpl;
import view.View;
import view.ViewImpl;

public class Main {
    static public void main(String[] args) throws Exception {

        ModelObserverSource model = new ModelImpl();
        View view = new ViewImpl(model);
        InputUiImpl inputUI = new InputUiImpl();
        ControllerImpl controller = new ControllerImpl(model);
        inputUI.addObserver(controller);
        AutonomousControllerImpl autController = new AutonomousControllerImpl(model);
        autController.start();
        view.display();
        inputUI.display();
    }
}
