package net.omaima.layers;

import net.omaima.activation.ActivationFunction;

public class HiddenLayer extends DenseLayer {

    public HiddenLayer(int size, ActivationFunction activation) {
        super(size, activation, null);
    }
}
