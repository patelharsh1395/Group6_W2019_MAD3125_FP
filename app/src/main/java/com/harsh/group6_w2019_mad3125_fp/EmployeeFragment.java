package com.harsh.group6_w2019_mad3125_fp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import CustomAdapters.CustomAdapterForRecyclerView;
import model.SampleMain;
import model.SingleToneExample;
import model.abstracts.Employee;

import static model.SampleMain.*;

public class EmployeeFragment extends Fragment {

    ArrayList<Employee> employees_list;
    Context con;
    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.con = inflater.getContext();
        return inflater.inflate(R.layout.employee_fragment_layout, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        employees_list = SampleMain.mainMethod();
        this.recyclerView = getView().findViewById(R.id.recycler_view);
        CustomAdapterForRecyclerView adapter = new CustomAdapterForRecyclerView(employees_list, this.con, new CustomAdapterForRecyclerView.SetCustomClickListener() {
            @Override
            public void customOnClick(Employee e) {
                Toast.makeText( EmployeeFragment.this.con , e.getName() , Toast.LENGTH_LONG ).show();
            }
        });
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.con));

    }


}
