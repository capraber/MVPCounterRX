package com.globant.counter.android.util.bus.observers;

/**
 * Created by equattrocchio on 05/07/17.
 */

public abstract class StringBusObserver extends BusObserver<String> {
    public StringBusObserver() {
        super(String.class);
    }
}
