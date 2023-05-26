package com.example.evaluationtask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;


public class BottomSheet extends Fragment {


    public BottomSheet(FragmentActivity remoteFragment) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        return view;
    }


    public void show() {
    }

    public void setContentView(View view) {
    }
}