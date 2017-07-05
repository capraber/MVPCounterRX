package com.globant.counter.android.util.bus.observers;

/**
 * Created by equattrocchio on 05/07/17.
 */

public abstract class LongBusObserver extends BusObserver<Long> {
    public LongBusObserver() {
        super(Long.class);
    }
}
