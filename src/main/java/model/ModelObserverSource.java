package model;

import view.ModelObserver;

public interface ModelObserverSource {
    void addObserver(ModelObserver observer);
}
