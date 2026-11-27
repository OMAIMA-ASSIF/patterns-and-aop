package net.omaima.factory;

import net.omaima.activation.ActivationFunction;
import net.omaima.activation.Identity;
import net.omaima.activation.Sigmoid;
import net.omaima.adapter.ActivationAdapter;
import net.omaima.adapter.LegacyActivation;

public final class ActivationFactory {

    private ActivationFactory() {
    }

    public static ActivationFunction create(String type) {
        return switch (type.toLowerCase()) {
            case "sigmoid" -> new Sigmoid();
            case "identity" -> new Identity();
            case "legacy" -> new ActivationAdapter(new LegacyActivation());
            default -> throw new IllegalArgumentException("Unknown activation function: " + type);
        };
    }
}