package model;

import view.ModelObserver;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model{
    private List<ModelObserver> observers;
    private int state;

    public ModelImpl(){
        state = 0;
        observers = new ArrayList<>();
    }

    public synchronized void update(){
        state++;
        log("state updated: " + state);
        notifyObservers();
    }

    public synchronized int getState(){
        return state;
    }

    public synchronized void addObserver(ModelObserver obs){
        observers.add(obs);
    }

    private synchronized void notifyObservers(){
        for (ModelObserver obs: observers){
            obs.notifyModelUpdated();
        }
    }

    private synchronized void log(String msg) {
        System.out.println("[Model] " + msg);
    }
}
