package net.omaima.adapter;

public class LegacyActivation implements OldActivation {

    @Override
    public double compute(double value) {
        return Math.tanh(value);
    }
}
