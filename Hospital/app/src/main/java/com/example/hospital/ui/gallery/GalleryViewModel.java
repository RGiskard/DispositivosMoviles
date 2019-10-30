package com.example.hospital.ui.gallery;

import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment Registro médico");
    }

    public LiveData<String> getText() {
        return mText;
    }
}