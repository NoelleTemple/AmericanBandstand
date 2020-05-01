package com.example.americanbandstand.ui.Songs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SongViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SongViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is song fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}