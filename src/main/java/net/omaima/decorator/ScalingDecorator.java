package net.omaima.decorator;

import net.omaima.layers.Layer;

public class ScalingDecorator extends LayerDecorator {

    private final double factor;

    public ScalingDecorator(Layer layer, double factor) {
        super(layer);
        this.factor = factor;
    }

    @Override
    public double[] forward(double[] input) {
        double[] result = layer.forward(input);
        for (int i = 0; i < result.length; i++) {
            result[i] *= factor;
        }
        return result;
    }
}
