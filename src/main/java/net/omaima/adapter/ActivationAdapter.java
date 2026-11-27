package net.omaima.adapter;

import net.omaima.activation.ActivationFunction;

public class ActivationAdapter implements ActivationFunction {

    private final OldActivation oldActivation;

    public ActivationAdapter(OldActivation oldActivation) {
        this.oldActivation = oldActivation;
    }

    @Override
    public double activate(double x) {
        return oldActivation.compute(x);
    }
}