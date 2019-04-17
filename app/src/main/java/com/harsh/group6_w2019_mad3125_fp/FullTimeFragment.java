package com.harsh.group6_w2019_mad3125_fp;

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

import com.harsh.group6_w2019_mad3125_fp.interfaces.DataFromAddEmployeeFragment;

import org.w3c.dom.Text;

import model.Car;
import model.FullTime;
import model.MotorCycle;
import model.SingleToneExample;
import model.abstracts.Vehicle;
import model.enums.Gender;

public class FullTimeFragment extends Fragment implements DataFromAddEmployeeFragment {


    TextView name;
    TextView age;
    RadioGroup gender;
    TextView dateOfBirth;
    RadioGroup vehicle;

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

                String name_string = name.getText().toString();
                int age_int = Integer.parseInt(age.getText().toString().substring(6));
                Gender gender_enum = null;
                int salary_int = Integer.parseInt(salary.getText().toString());
                int bonus_int = Integer.parseInt(bonus.getText().toString());
                switch (gender.getCheckedRadioButtonId())
                {
                    case R.id.radio_female :
                        gender_enum = Gender.FEMALE;
                        break;

                    case R.id.radio_male :
                        gender_enum = Gender.MALE;
                        break;
                }
                Vehicle vehicle_Vehicle = null;
                switch (vehicle.getCheckedRadioButtonId())
                {
                    case R.id.radio_car :
                        vehicle_Vehicle = new Car("","","", 0 );
                        break;
                    case  R.id.radio_motorCycle :
                        vehicle_Vehicle = new MotorCycle("","","",0);
                        break;

                }
                SingleToneExample.getObj().addIntoList(new FullTime(salary_int, bonus_int ,name_string , age_int , gender_enum , vehicle_Vehicle));
                Toast.makeText(getActivity(), "Employee Added", Toast.LENGTH_LONG).show();
                salary.setText(null);
                bonus.setText(null);
                name.setText(null);
                age.setText(null);
                dateOfBirth.setText(SpanningForString.forDate("DateOfBirth : YYYY/MM/DD"));
                gender.clearCheck();
                vehicle.clearCheck();
            }
        });
    }

    @Override
    public void viewsFromAddEmployeeFragment(TextView name, TextView age, RadioGroup gender, TextView dateOfBirth , RadioGroup vehicle) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.vehicle = vehicle;
    }
}
