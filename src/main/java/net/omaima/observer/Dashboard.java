package net.omaima.observer;

import net.omaima.state.NetworkState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dashboard implements NetworkObserver {

    private final List<String> history = new ArrayList<>();

    @Override
    public void onStateChanged(NetworkState state) {
        history.add(state.getName());
        System.out.println("New network state: " + state.getName());
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }
}