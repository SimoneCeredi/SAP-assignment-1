package view;

import controller.UserInputObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class InputUiImpl implements UserInputSource, View {
    private List<UserInputObserver> observers;

    private MyFrame frame;

    public InputUiImpl() {
        observers = new ArrayList<>();
        frame = new MyFrame();
    }

    public void addObserver(UserInputObserver obs) {
        observers.add(obs);
    }

    public void display() {
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });
    }

    private void log(String msg) {
        System.out.println("[InputUI] " + msg);
    }

    class MyFrame extends JFrame implements ActionListener {

        public MyFrame() {
            super("My Input UI");

            setSize(300, 70);
            setResizable(false);

            JButton button = new JButton("Update");
            button.addActionListener(this);

            JPanel panel = new JPanel();
            panel.add(button);

            setLayout(new BorderLayout());
            add(panel, BorderLayout.NORTH);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                    System.exit(0);
                }
            });
        }

        public void actionPerformed(ActionEvent ev) {
            try {
                log("New input detected.");
                for (UserInputObserver obs : observers) {
                    obs.notifyNewUpdateRequested();
                }
            } catch (Exception ignored) {
            }
        }
    }
}
