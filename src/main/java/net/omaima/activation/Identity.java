package net.omaima.activation;

public class Identity implements ActivationFunction {

    @Override
    public double activate(double x) {
        return x;
    }
}
