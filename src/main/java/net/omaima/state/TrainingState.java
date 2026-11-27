package net.omaima.state;

import net.omaima.core.NeuralNetwork;

public class TrainingState implements NetworkState {

    @Override
    public void train(NeuralNetwork network) {
        throw new IllegalStateException("Training is already in progress");
    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        throw new IllegalStateException("Cannot predict during training");
    }

    @Override
    public String getName() {
        return "TRAINING";
    }
}
