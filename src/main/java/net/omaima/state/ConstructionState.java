package net.omaima.state;


import net.omaima.core.NeuralNetwork;

public class ConstructionState implements NetworkState {

    @Override
    public void train(NeuralNetwork network) {
        network.changeState(new TrainingState());
        try {
            network.executeTraining();
            network.changeState(new TrainedState());
        } catch (RuntimeException e) {
            network.changeState(new ConstructionState());
            throw e;
        }
    }

    @Override
    public double[] predict(NeuralNetwork network, double[] input) {
        throw new IllegalStateException("Network must be trained before prediction (current state: CONSTRUCTION)");
    }

    @Override
    public String getName() {
        return "CONSTRUCTION";
    }
}

