package net.omaima;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import net.omaima.activation.Identity;
import net.omaima.activation.Sigmoid;
import net.omaima.activation.Softmax;
import net.omaima.core.NeuralNetwork;
import net.omaima.layers.HiddenLayer;
import net.omaima.layers.InputLayer;
import net.omaima.layers.OutputLayer;
import net.omaima.observer.Dashboard;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputLayer input = new InputLayer(3);
        HiddenLayer hidden = new HiddenLayer(5, new Sigmoid());
        OutputLayer output = new OutputLayer(2, new Identity(), new Softmax());

        hidden.connectFrom(input);
        output.connectFrom(hidden);

        NeuralNetwork network = new NeuralNetwork(List.of(input, hidden, output));

        Dashboard dashboard = new Dashboard();
        network.addObserver(dashboard);

        System.out.println("Etat initial: " + network.getState().getName());

        network.train(); // Construction -> Training -> Trained, notifie dashboard

        double[] result = network.predict(new double[]{0.2, 0.5, 0.8});
        System.out.println("Prediction: " + Arrays.toString(result));
        System.out.println("Historique dashboard: " + dashboard.getHistory());
    }
}
