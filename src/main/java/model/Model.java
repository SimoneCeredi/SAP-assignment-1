package model;

public interface Model extends ModelObserverSource{
    void update();

    int getState();
}
