package net.omaima.state;

import net.omaima.core.NeuralNetwork;

public class TrainedState implements NetworkState {

    @Override
    public void train(NeuralNetwork network) {
        throw new IllegalStateException("Network is already trained");
    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        return network.forwardPropagation(input);
    }

    @Override
    public String getName() {
        return "TRAINED";
    }
}
