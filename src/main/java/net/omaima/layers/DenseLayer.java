package net.omaima.layers;

import net.omaima.activation.ActivationFunction;
import net.omaima.activation.VectorActivationFunction;
import net.omaima.core.Connection;
import net.omaima.core.Neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DenseLayer implements Layer {

    protected final List<Neuron> neurons = new ArrayList<>();
    private final VectorActivationFunction vectorActivation;

    public DenseLayer(int size, ActivationFunction activation, VectorActivationFunction vectorActivation) {
        this.vectorActivation = vectorActivation;
        for (int i = 0; i < size; i++) {
            neurons.add(new Neuron(0, activation));
        }
    }

    /** Connecte entierement cette couche a la couche precedente (poids aleatoires dans [0,1]). */
    public void connectFrom(Layer previousLayer) {
        Random random = new Random();
        for (Neuron destination : neurons) {
            for (Neuron source : previousLayer.getNeurons()) {
                double weight = random.nextDouble();
                destination.addConnection(new Connection(source, destination, weight));
            }
        }
    }

    @Override
    public double[] forward(double[] input) {
        double[] result = new double[neurons.size()];
        for (int i = 0; i < neurons.size(); i++) {
            result[i] = neurons.get(i).forward(input);
        }
        if (vectorActivation != null) {
            result = vectorActivation.activate(result);
        }
        return result;
    }

    @Override
    public List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neurons);
    }
}
