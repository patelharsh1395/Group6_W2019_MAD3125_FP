package com.harsh.group6_w2019_mad3125_fp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FullTimeFragment extends Fragment {

    TextView salary;
    TextView bonus;
    Button addIntern;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fulltime_fragment_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.salary = view.findViewById(R.id.text_salary);

        this.bonus = view.findViewById(R.id.text_bonus);


        this.addIntern = view.findViewById(R.id.btn_fulltime_employee);
        this.addIntern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
