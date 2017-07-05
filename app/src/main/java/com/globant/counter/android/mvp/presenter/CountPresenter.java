package com.globant.counter.android.mvp.presenter;

import android.app.Activity;

import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver;
import com.globant.counter.android.util.bus.observers.ResetButtonObserver;
import com.globant.counter.android.util.bus.RxBus;
import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;

public class CountPresenter {

    private CountModel model;
    private CountView view;

    public CountPresenter(CountModel model, CountView view) {
        this.model = model;
        this.view = view;
    }

    public void onCountButtonPressed() {
        model.inc();
        view.setCount(String.valueOf(model.getCount()));
    }

    public void onResetButtonPressed() {
        model.reset();
        view.setCount(String.valueOf(model.getCount()));
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }

        RxBus.subscribe(activity, new CountButtonUpBusObserver() {
            @Override
            public void onEvent(CountButtonUpBusObserver.CountButtonUp value) {
                onCountButtonPressed();
            }
        });

        RxBus.subscribe(activity, new ResetButtonObserver() {
            @Override
            public void onEvent(ResetButtonPressed value) {
                onResetButtonPressed();
            }
        });

    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }
        RxBus.clear(activity);
    }
}
