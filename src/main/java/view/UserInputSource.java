package view;

import controller.UserInputObserver;

public interface UserInputSource {
    void addObserver(UserInputObserver observer);
}
