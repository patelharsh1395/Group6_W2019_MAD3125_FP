package com.harsh.group6_w2019_mad3125_fp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddEmployeesFragment extends Fragment implements View.OnClickListener {

    TextView text_age;
    TextView text_name;
    TextView text_date_of_birth;
    RadioGroup gender;
    RadioGroup vehicle;
    RadioGroup employementtype;
    FullTimeFragment fullTimeFragment;
    PartTimeFragment partTimeFragment;
    InternFragment internFragment;

    FragmentManager fragmentManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_employee_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.vehicle = view.findViewById(R.id.radio_group_vehicle);
        this.text_age = view.findViewById(R.id.text_age);
        this.text_name = view.findViewById(R.id.text_name);
        this.fragmentManager = this.getActivity().getSupportFragmentManager();




        this.text_date_of_birth = view.findViewById(R.id.text_date_of_birth);
        this.text_date_of_birth.setText(SpanningForString.forDate((String)this.text_date_of_birth.getText()));
        this.text_date_of_birth.setOnClickListener(this) ;

        this.gender = view.findViewById(R.id.radio_group_gender);
        this.gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radio_female :
                        Toast.makeText(AddEmployeesFragment.this.getContext(), "Female" , Toast.LENGTH_LONG).show();
                        break;
                        default:
                            Toast.makeText(AddEmployeesFragment.this.getContext(), "male" , Toast.LENGTH_LONG).show();
                            break;
                }
            }
        });



        this.employementtype = view.findViewById(R.id.radio_group_employment);
        this.employementtype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                FragmentTransaction fragmentTransaction;

                switch (checkedId)
                {
                    case R.id.radio_parttime :
                        if(AddEmployeesFragment.this.partTimeFragment  == null)
                        {
                            AddEmployeesFragment.this.partTimeFragment = new PartTimeFragment();
                            AddEmployeesFragment.this.partTimeFragment.viewsFromAddEmployeeFragment(text_name, text_age ,gender, text_date_of_birth , vehicle);
                        }
                        fragmentTransaction = AddEmployeesFragment.this.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout_employment, AddEmployeesFragment.this.partTimeFragment);
                        fragmentTransaction.commit();
                        Toast.makeText(AddEmployeesFragment.this.getContext(), "parttime" , Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_fulltime :
                        if(AddEmployeesFragment.this.fullTimeFragment  == null)
                        {
                            AddEmployeesFragment.this.fullTimeFragment = new FullTimeFragment();
                            AddEmployeesFragment.this.fullTimeFragment.viewsFromAddEmployeeFragment(text_name, text_age ,gender , text_date_of_birth , vehicle);
                        }
                        fragmentTransaction = AddEmployeesFragment.this.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout_employment, AddEmployeesFragment.this.fullTimeFragment);
                        fragmentTransaction.commit();
                        Toast.makeText(AddEmployeesFragment.this.getContext(), "fulltime" , Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_intern :
                        if(AddEmployeesFragment.this.internFragment  == null)
                        {
                            AddEmployeesFragment.this.internFragment = new InternFragment();
                            AddEmployeesFragment.this.internFragment.viewsFromAddEmployeeFragment(text_name, text_age ,gender , text_date_of_birth , vehicle);
                        }
                        fragmentTransaction = AddEmployeesFragment.this.fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout_employment, AddEmployeesFragment.this.internFragment);
                        fragmentTransaction.commit();
                        Toast.makeText(AddEmployeesFragment.this.getContext(), "intern" , Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });






    }

    @Override
    public void onClick(View v) {
        DatePickerFragment dtfragment = new DatePickerFragment();
        dtfragment.show(getActivity().getSupportFragmentManager(), "DatePicker");
    }



}
