package com.harsh.group6_w2019_mad3125_fp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.harsh.group6_w2019_mad3125_fp.interfaces.DataFromAddEmployeeFragment;

import model.Car;
import model.Intern;
import model.MotorCycle;
import model.SingleToneExample;
import model.abstracts.Vehicle;
import model.enums.Gender;

public class InternFragment extends Fragment implements DataFromAddEmployeeFragment {

    TextView name;
    TextView age;
    RadioGroup gender;
    TextView dateOfBirth;
    RadioGroup vehicle;

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



                if(!schoolName.getText().toString().isEmpty() && !name.getText().toString().isEmpty() &&  !age.getText().toString().isEmpty() && !(gender.getCheckedRadioButtonId() == -1))
                {


                    String schoolname_string = schoolName.getText().toString();
                    String name_string = name.getText().toString();
                    int age_int = Integer.parseInt(age.getText().toString().substring(6));
                    Gender gender_enum = null;
                    switch (gender.getCheckedRadioButtonId()) {
                        case R.id.radio_female:
                            gender_enum = Gender.FEMALE;
                            break;

                        case R.id.radio_male:
                            gender_enum = Gender.MALE;
                            break;
                    }
                    Vehicle vehicle_Vehicle = null;
                    switch (vehicle.getCheckedRadioButtonId()) {
                        case R.id.radio_car:
                            vehicle_Vehicle = new Car("", "", "", 0);
                            break;
                        case R.id.radio_motorCycle:
                            vehicle_Vehicle = new MotorCycle("", "", "", 0);
                            break;

                    }
                    SingleToneExample.getObj().addIntoList(new Intern(schoolname_string, name_string, age_int, gender_enum, vehicle_Vehicle));
                    Toast.makeText(getActivity(), "Employee Added", Toast.LENGTH_LONG).show();
                    schoolName.setText(null);
                    name.setText(null);
                    age.setText(null);
                    dateOfBirth.setText(SpanningForString.forDate("DateOfBirth : YYYY/MM/DD"));
                    vehicle.clearCheck();
                    gender.clearCheck();


                }
                else
                {

                    Toast.makeText(getActivity(), "No field can be empty and unselected" , Toast.LENGTH_LONG).show();


                }

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
