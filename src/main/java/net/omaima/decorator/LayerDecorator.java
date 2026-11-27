package net.omaima.decorator;

import net.omaima.core.Neuron;
import net.omaima.layers.Layer;

import java.util.List;

public abstract class LayerDecorator implements Layer {

    protected final Layer layer;

    protected LayerDecorator(Layer layer) {
        this.layer = layer;
    }

    @Override
    public List<Neuron> getNeurons() {
        return layer.getNeurons();
    }
}