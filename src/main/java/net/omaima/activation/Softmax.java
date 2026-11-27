package net.omaima.activation;

import java.util.Arrays;

public class Softmax implements VectorActivationFunction{
    @Override
    public double[] activate(double[] values) {
        double max = Arrays.stream(values).max().orElse(0);

        double[] exponentials = new double[values.length];
        double sum = 0;

        for (int i = 0; i < values.length; i++) {
            exponentials[i] = Math.exp(values[i] - max);
            sum += exponentials[i];
        }
        for (int i = 0; i < values.length; i++) {
            exponentials[i] /= sum;
        }
        return exponentials;
    }
}
