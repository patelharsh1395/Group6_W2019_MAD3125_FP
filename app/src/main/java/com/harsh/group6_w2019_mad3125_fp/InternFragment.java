package com.harsh.group6_w2019_mad3125_fp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.harsh.group6_w2019_mad3125_fp.interfaces.DataFromAddEmployeeFragment;

public class InternFragment extends Fragment implements DataFromAddEmployeeFragment {

    TextView name;
    TextView age;
    RadioGroup gender;

    TextView schoolName;
    Button addIntern;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.intern_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.schoolName = view.findViewById(R.id.text_schoolname);


        this.addIntern = view.findViewById(R.id.btn_add_intern);
        this.addIntern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void viewsFromAddEmployeeFragment(TextView name, TextView age, RadioGroup gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
    }
}
