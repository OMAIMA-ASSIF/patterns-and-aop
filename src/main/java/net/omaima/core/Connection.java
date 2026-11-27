package net.omaima.core;

public class Connection {

    private final Neuron source;
    private final Neuron destination;
    private double weight;

    public Connection(Neuron source, Neuron destination, double weight) {
        validateWeight(weight);
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    private static void validateWeight(double weight) {
        if (weight < 0 || weight > 1) {
            throw new IllegalArgumentException("Weight must be between 0 and 1, got: " + weight);
        }
    }

    public Neuron getSource() {
        return source;
    }

    public Neuron getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }
}

