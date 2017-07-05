package com.globant.counter.android.util.bus;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.globant.counter.android.util.bus.observers.BusObserver;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {
    private static Map<Activity, CompositeDisposable> disposableMap = new HashMap<>();
    private static PublishSubject<Object> publishSubject = PublishSubject.create();

    private RxBus() {
        // Nothing
    }

    public static void post(@NonNull Object object) {
        publishSubject.onNext(object);
    }

    @SuppressWarnings("unchecked")
    public static void subscribe(@NonNull Activity key, @NonNull BusObserver busObserver) {
        CompositeDisposable compositeDisposable = disposableMap.get(key);
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(publishSubject.subscribe(busObserver));
        disposableMap.put(key, compositeDisposable);
    }

    public static void clear(@NonNull Activity key) {
        CompositeDisposable compositeDisposable = disposableMap.get(key);
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        disposableMap.remove(key);
    }

    public static void clearAll() {
        for (Map.Entry<Activity, CompositeDisposable> entry : disposableMap.entrySet()) {
            entry.getValue().clear();
        }
        disposableMap.clear();
    }
}
