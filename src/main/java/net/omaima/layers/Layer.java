package net.omaima.layers;

import net.omaima.core.Neuron;

import java.util.List;

public interface Layer {

    double[] forward(double[] input);

    List<Neuron> getNeurons();
}

