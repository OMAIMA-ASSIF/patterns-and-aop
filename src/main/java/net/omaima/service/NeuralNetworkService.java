package net.omaima.service;

import net.omaima.aspect.RequiresRole;
import net.omaima.core.NeuralNetwork;
import org.springframework.stereotype.Service;

@Service
public class NeuralNetworkService {

    @RequiresRole("ADMIN")
    public void trainNetwork(NeuralNetwork network) {
        network.train();
    }

    @RequiresRole("USER")
    public double[] predict(NeuralNetwork network, double[] input) {
        return network.predict(input);
    }
}
