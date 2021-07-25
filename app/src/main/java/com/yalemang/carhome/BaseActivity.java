package com.yalemang.carhome;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());

        initView();
        initData();
    }



    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();
}
