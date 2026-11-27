package net.omaima.layers;

import net.omaima.activation.ActivationFunction;
import net.omaima.activation.VectorActivationFunction;

public class OutputLayer extends DenseLayer {

    public OutputLayer(int size, ActivationFunction activation, VectorActivationFunction vectorActivation) {
        super(size, activation, vectorActivation);
    }
}

