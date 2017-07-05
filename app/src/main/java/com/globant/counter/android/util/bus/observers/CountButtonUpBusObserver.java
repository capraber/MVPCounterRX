package com.globant.counter.android.util.bus.observers;

/**
 * Created by equattrocchio on 05/07/17.
 */

public abstract class CountButtonUpBusObserver extends BusObserver<CountButtonUpBusObserver.CountButtonUp> {
    public CountButtonUpBusObserver() {
        super(CountButtonUp.class);
    }

    public static class CountButtonUp {
    }
}