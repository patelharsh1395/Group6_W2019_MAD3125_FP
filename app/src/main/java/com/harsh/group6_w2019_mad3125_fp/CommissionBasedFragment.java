package com.harsh.group6_w2019_mad3125_fp;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
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
import android.widget.Toast;

import com.harsh.group6_w2019_mad3125_fp.interfaces.DataFromPartTimeFragment;

import model.CommissionBasedPartTime;
import model.SingleToneExample;
import model.enums.Gender;

public class CommissionBasedFragment extends Fragment implements DataFromPartTimeFragment
{

    TextView name;
    TextView age;
    RadioGroup gender;
    TextView ratePerHour;
    TextView numberOfHours;


    TextView commission;
    Button addParttimeCommissionBasedEmployee;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.commission_based_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.commission = view.findViewById(R.id.text_commission);

        this.addParttimeCommissionBasedEmployee = view.findViewById(R.id.btn_add_commission_based);
        this.addParttimeCommissionBasedEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int commission_int =  Integer.parseInt(commission.getText().toString());
                int rate_int = Integer.parseInt(ratePerHour.getText().toString());
                float hours_float = Float.parseFloat(numberOfHours.getText().toString());
                String name_string = name.getText().toString();
                int age_int = Integer.parseInt(age.getText().toString().substring(6));
                Gender gender_enum = null;
                switch (gender.getCheckedRadioButtonId())
                {
                    case R.id.radio_female :
                        gender_enum = Gender.FEMALE;
                        break;

                    case R.id.radio_male :
                        gender_enum = Gender.MALE;
                        break;
                }
                SingleToneExample.getObj().addIntoList(new CommissionBasedPartTime(commission_int, rate_int, hours_float, name_string , age_int , gender_enum, null));
                Toast.makeText(getActivity(), "Employee Added", Toast.LENGTH_LONG).show();
             //   Intent mIntent = new Intent(getContext(), NavigationDrawerAct.class);
               // startActivity(mIntent);
            }
        });

    }

    @Override
    public void viewsFromPartTimeFragment(TextView name, TextView age, RadioGroup gender, TextView ratePerHour, TextView numberOfHours) {
                this.name = name;
                this.age = age;
                this.gender = gender;
                this.ratePerHour = ratePerHour;
                this.numberOfHours = numberOfHours;
    }
}
