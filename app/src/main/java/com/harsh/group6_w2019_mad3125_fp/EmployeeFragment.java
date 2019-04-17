package com.harsh.group6_w2019_mad3125_fp;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import CustomAdapters.CustomAdapterForRecyclerView;
import model.SampleMain;
import model.SingleToneExample;
import model.abstracts.Employee;

import static model.SampleMain.*;

public class EmployeeFragment extends Fragment   {

    ArrayList<Employee> employees_list;
    Context con;
    RecyclerView recyclerView;
    CustomAdapterForRecyclerView adapter;

    FragmentTransaction fragmentTransaction;
    EmployeeDatailsFragment employeeDatailsFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.con = inflater.getContext();
        Log.e("***************","inside onCreateView");

        View v =  inflater.inflate(R.layout.employee_fragment_layout, container, false);


        employees_list = SingleToneExample.getObj().getList();

        this.recyclerView = v.findViewById(R.id.recycler_view);
        adapter = new CustomAdapterForRecyclerView(employees_list, this.con, new CustomAdapterForRecyclerView.SetCustomClickListener() {
            @Override
            public void customOnClick(Employee employee) {
                Toast.makeText(EmployeeFragment.this.con, employee.getName(), Toast.LENGTH_LONG).show();
                if(employeeDatailsFragment == null) {
                     employeeDatailsFragment = new EmployeeDatailsFragment();
                }
                 employeeDatailsFragment.employeeObject(employee);
                 fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.frame_layout , employeeDatailsFragment , "");
                 fragmentTransaction.commit();
                 fragmentTransaction.addToBackStack(null);

            }
        });
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.con));

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);



    }



}
