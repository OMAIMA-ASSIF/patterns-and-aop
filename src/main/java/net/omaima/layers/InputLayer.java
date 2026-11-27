package net.omaima.layers;


import net.omaima.activation.Identity;
import net.omaima.core.Neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputLayer implements Layer {

    private final List<Neuron> neurons = new ArrayList<>();

    public InputLayer(int size) {
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron(0, new Identity()));
        }
    }

    @Override
    public double[] forward(double[] input) {
        if (input.length != neurons.size()) {
            throw new IllegalArgumentException("Invalid input dimension: expected " + neurons.size());
        }
        return input.clone();
    }

    @Override
    public List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neurons);
    }
}

