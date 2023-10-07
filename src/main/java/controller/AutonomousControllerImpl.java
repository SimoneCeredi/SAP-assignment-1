package controller;

import model.Model;

public class AutonomousControllerImpl extends Thread {
    private final Model model;

    public AutonomousControllerImpl(Model model) {
        this.model = model;
    }

    public void run() {
        while (true) {
            log("Changing pro-actively the model...");
            model.update();
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
            }
        }
    }

    private void log(String msg) {
        System.out.println("[Autonomous Controller] " + msg);
    }
}
