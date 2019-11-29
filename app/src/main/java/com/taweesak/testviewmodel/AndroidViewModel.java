package com.taweesak.testviewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AndroidViewModel extends androidx.lifecycle.AndroidViewModel {

    MutableLiveData<String> number;

    public AndroidViewModel(@NonNull Application application) {
        super(application);
        number = new MutableLiveData<String>();
    }

    // รับค่าเข้่ามา
    void setString(String item){
        number.setValue(item);
    }

    //ส่งค่าออกไป
    public LiveData<String> getData(){
        return number;
    }

}
