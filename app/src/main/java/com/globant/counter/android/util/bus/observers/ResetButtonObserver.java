package com.globant.counter.android.util.bus.observers;

/**
 * Created by equattrocchio on 05/07/17.
 */

public abstract class ResetButtonObserver extends BusObserver<ResetButtonObserver.ResetButtonPressed> {
    public ResetButtonObserver() {
        super(ResetButtonPressed.class);
    }

    public static class ResetButtonPressed {
    }
}