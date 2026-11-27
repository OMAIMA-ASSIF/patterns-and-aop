package net.omaima.core;

import net.omaima.activation.ActivationFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Neuron {

    private double bias;
    private final List<Connection> incoming = new ArrayList<>();
    private ActivationFunction activation;

    public Neuron(double bias, ActivationFunction activation) {
        this.bias = bias;
        this.activation = activation;
    }

    public void addConnection(Connection connection) {
        if (connection.getDestination() != this) {
            throw new IllegalArgumentException("Wrong destination neuron for this connection");
        }
        incoming.add(connection);
    }
    public double forward(double[] inputs) {
        if (inputs.length != incoming.size()) {
            throw new IllegalArgumentException(
                    "Input size (" + inputs.length + ") does not match connection count (" + incoming.size() + ")"
            );
        }

        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * incoming.get(i).getWeight();
        }

        return activation.activate(sum);
    }

    public List<Connection> getIncoming() {
        return Collections.unmodifiableList(incoming);
    }

    public void setActivation(ActivationFunction activation) {
        this.activation = activation;
    }

    public double getBias() {
        return bias;
    }
}

