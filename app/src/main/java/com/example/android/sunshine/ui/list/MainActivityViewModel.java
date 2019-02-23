package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.ListWeatherEntry;

import java.util.List;

class MainActivityViewModel extends ViewModel {

    LiveData<List<ListWeatherEntry>> mWeathers;

    MainActivityViewModel(SunshineRepository repository) {
        mWeathers = repository.getWeatherForecasts();
    }

    LiveData<List<ListWeatherEntry>> getWeathers() {
        return mWeathers;
    }

}
