package com.globant.counter.android.util.bus.observers;

public abstract class LongBusObserver extends BusObserver<Long> {
    public LongBusObserver() {
        super(Long.class);
    }
}
