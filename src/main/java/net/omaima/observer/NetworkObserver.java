package net.omaima.observer;

import net.omaima.state.NetworkState;

public interface NetworkObserver {
    void onStateChanged(NetworkState state);
}
