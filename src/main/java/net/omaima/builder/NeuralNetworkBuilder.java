package net.omaima.builder;

import net.omaima.activation.ActivationFunction;
import net.omaima.activation.VectorActivationFunction;
import net.omaima.core.NeuralNetwork;
import net.omaima.layers.HiddenLayer;
import net.omaima.layers.InputLayer;
import net.omaima.layers.Layer;
import net.omaima.layers.OutputLayer;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetworkBuilder {

    private final List<Layer> layers = new ArrayList<>();
    private Layer lastLayer;

    public NeuralNetworkBuilder inputLayer(int size) {
        InputLayer input = new InputLayer(size);
        layers.add(input);
        lastLayer = input;
        return this;
    }

    public NeuralNetworkBuilder hiddenLayer(int size, ActivationFunction activation) {
        requireInputLayer();
        HiddenLayer hidden = new HiddenLayer(size, activation);
        hidden.connectFrom(lastLayer);
        layers.add(hidden);
        lastLayer = hidden;
        return this;
    }

    public NeuralNetworkBuilder outputLayer(int size, ActivationFunction activation, VectorActivationFunction vectorActivation) {
        requireInputLayer();
        OutputLayer output = new OutputLayer(size, activation, vectorActivation);
        output.connectFrom(lastLayer);
        layers.add(output);
        lastLayer = output;
        return this;
    }

    /** Conserve pour compatibilite avec l'enonce qui mentionne fullyConnect() explicitement. */
    public NeuralNetworkBuilder fullyConnect() {
        // Chaque couche se connecte deja a la precedente au moment de son ajout
        // (voir hiddenLayer/outputLayer) : ce point d'extension reste disponible
        // si une strategie de connexion differente (ex: partielle) est ajoutee.
        return this;
    }

    public NeuralNetwork build() {
        if (layers.size() < 2) {
            throw new IllegalStateException("A network needs at least an input layer and one more layer");
        }
        return new NeuralNetwork(layers);
    }

    private void requireInputLayer() {
        if (layers.isEmpty()) {
            throw new IllegalStateException("inputLayer(...) must be called first");
        }
    }
}
