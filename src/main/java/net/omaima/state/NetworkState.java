package net.omaima.state;

import net.omaima.core.NeuralNetwork;

public interface NetworkState {

    void train(NeuralNetwork network);

    double[] predict(NeuralNetwork network, double[] input);

    String getName();
}
