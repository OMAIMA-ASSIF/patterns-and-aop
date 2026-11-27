package net.omaima.core;

import net.omaima.layers.Layer;
import net.omaima.observer.NetworkObserver;
import net.omaima.state.ConstructionState;
import net.omaima.state.NetworkState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NeuralNetwork {

    private final List<Layer> layers;
    private NetworkState state;
    private final List<NetworkObserver> observers = new ArrayList<>();

    public NeuralNetwork(List<Layer> layers) {
        if (layers == null || layers.isEmpty()) {
            throw new IllegalArgumentException("Network must have at least one layer");
        }
        this.layers = new ArrayList<>(layers);
        this.state = new ConstructionState();
    }

    public void train() {
        state.train(this);
    }

    /** Alias de train(), tel que mentionne dans l'enonce. */
    public void fit() {
        train();
    }

    public double[] predict(double[] input) {
        return state.predict(this, input);
    }

    public double[] forwardPropagation(double[] input) {
        double[] result = input.clone();
        for (Layer layer : layers) {
            result = layer.forward(result);
        }
        return result;
    }

    public void executeTraining() {
        // A completer avec un algorithme d'apprentissage (ex: backpropagation)
    }

    public void changeState(NetworkState newState) {
        this.state = newState;
        notifyObservers();
    }

    public void addObserver(NetworkObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NetworkObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (NetworkObserver observer : observers) {
            observer.onStateChanged(state);
        }
    }

    public NetworkState getState() {
        return state;
    }

    public List<Layer> getLayers() {
        return Collections.unmodifiableList(layers);
    }
}
