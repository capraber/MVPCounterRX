package com.globant.counter.android.util.bus.observers;

/**
 * Created by equattrocchio on 05/07/17.
 */

public abstract class DoubleBusObserver extends BusObserver<Double> {
    public DoubleBusObserver() {
        super(Double.class);
    }
}