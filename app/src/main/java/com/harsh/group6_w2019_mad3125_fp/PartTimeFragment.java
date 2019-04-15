package com.harsh.group6_w2019_mad3125_fp;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import model.abstracts.PartTime;

public class PartTimeFragment extends Fragment {


    RadioGroup parttimeType;
    FragmentManager fragmentManager;
    CommissionBasedFragment commissionBasedFragment;
    FixBasedFragment fixBasedFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.parttime_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.parttimeType = getActivity().findViewById(R.id.radio_group_parttime_type);
        this.parttimeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                FragmentTransaction fragmentTransaction;
                switch (checkedId)
                {
                    case R.id.radio_fix_parttime :
                        if(PartTimeFragment.this.commissionBasedFragment == null)
                        {
                            PartTimeFragment.this.commissionBasedFragment = new CommissionBasedFragment();
                        }
                        PartTimeFragment.this.fragmentManager.beginTransaction();
                         fragmentTransaction = PartTimeFragment.this.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout_parttime_type, PartTimeFragment.this.commissionBasedFragment);
                        fragmentTransaction.commit();
                        break;

                    case R.id.radio_commission_parttime :
                        if(PartTimeFragment.this.fixBasedFragment == null)
                        {
                            PartTimeFragment.this.fixBasedFragment = new FixBasedFragment();
                        }
                        PartTimeFragment.this.fragmentManager.beginTransaction();
                         fragmentTransaction = PartTimeFragment.this.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout_parttime_type, PartTimeFragment.this.fixBasedFragment);
                        fragmentTransaction.commit();
                }
            }
        });


        this.fragmentManager = getActivity().getSupportFragmentManager();



    }
}
