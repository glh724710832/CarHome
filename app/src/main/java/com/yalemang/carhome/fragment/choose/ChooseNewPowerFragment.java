package com.yalemang.carhome.fragment.choose;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.yalemang.carhome.R;

public class ChooseNewPowerFragment extends Fragment {


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_new_power_fragment,container,false);
        return view;
    }
}
