package controller;

import model.Model;

public class ControllerImpl implements UserInputObserver {

    private Model model;

    public ControllerImpl(Model model) {
        this.model = model;
    }

    public void notifyNewUpdateRequested() {
        log("New update requested by the user");
        model.update();
    }

    private void log(String msg) {
        System.out.println("[Controller] " + msg);
    }
}

