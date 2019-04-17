package com.harsh.group6_w2019_mad3125_fp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harsh.group6_w2019_mad3125_fp.interfaces.DateFromEmployeeDetailsFragment;

import model.Car;
import model.CommissionBasedPartTime;
import model.FixedBasedPartTime;
import model.FullTime;
import model.Intern;
import model.abstracts.Employee;
import model.abstracts.PartTime;
import model.enums.Gender;

public class EmployeeDatailsFragment extends Fragment implements DateFromEmployeeDetailsFragment {


    Employee employee;
    TextView name;
    TextView age;
    TextView gender;
    TextView vehicle;
    CardView parttime_card;
    CardView fulltime_card;
    CardView intern_card;
    TextView employment_type;
    TextView total_earning;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.employee_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.name = view.findViewById(R.id.text_name_value);
        this.age = view.findViewById(R.id.text_age_value);
        this.gender = view.findViewById(R.id.text_gender_value);
        this.vehicle = view.findViewById(R.id.text_vehicle_value);
        this.parttime_card = view.findViewById(R.id.parttime_card);
        this.fulltime_card = view.findViewById(R.id.fulltime_card);
        this.intern_card = view.findViewById(R.id.intern_card);
        this.employment_type = view.findViewById(R.id.text_employment_type_value);
        this.total_earning = view.findViewById(R.id.text_total_earning_val);

        this.name.setText(employee.getName().toUpperCase());
        this.age.setText(employee.getAge()+"");
        this.gender.setText(employee.getGen() == Gender.MALE ? "MALE" : "FEMALE");
        this.vehicle.setText(employee.getVehicle() == null ? "null" : employee.getVehicle() instanceof Car ? "CAR" : "MOTER CYCLE");

        if(employee instanceof PartTime)
        {

            fulltime_card.setVisibility(View.GONE);
            intern_card.setVisibility(View.GONE);
            TextView rate = view.findViewById(R.id.text_rate_value);
            TextView hour = view.findViewById(R.id.text_hours_value);
            TextView commission_fixedamount_value = view.findViewById(R.id.text_commission_fixedamount_value);
            TextView commission_fixedamount_label = view.findViewById(R.id.text_commission_fixedamount_label);

            rate.setText("$ "+((PartTime) employee).getRate());
            hour.setText(((PartTime) employee).getHours()+"");

            if(employee instanceof CommissionBasedPartTime)
            {
                this.employment_type.setText("COMMISSION BASED");
                commission_fixedamount_label.setText("COMMISSION");
                commission_fixedamount_value.setText(((CommissionBasedPartTime) employee).getCommission()+"%");
                this.total_earning.setText("$ "+((CommissionBasedPartTime)employee).commissionCalcEarnings());

            }
            else
            {
                this.employment_type.setText("Fixed BASED");
                commission_fixedamount_label.setText("FIXED AMOUNT");
                commission_fixedamount_value.setText("$ "+((FixedBasedPartTime) employee).getFixedamount());
                this.total_earning.setText("$ "+((FixedBasedPartTime)employee).fixedAmountCalcEarnings());
            }



        }// part time
        else if(employee instanceof FullTime)
        {
            this.employment_type.setText("FULL TIME");
            parttime_card.setVisibility(View.GONE);
            intern_card.setVisibility(View.GONE);

            TextView salary = view.findViewById(R.id.text_salary_value);
            TextView bonus = view.findViewById(R.id.text_bonus_value);

            salary.setText("$ "+((FullTime) employee).getSalary());
            bonus.setText("$ "+((FullTime) employee).getBonus());
            this.total_earning.setText("$ "+((FullTime)employee).calcEarning());

        }
        else
        {

            this.employment_type.setText("INTERN");
            parttime_card.setVisibility(View.GONE);
            fulltime_card.setVisibility(View.GONE);

            TextView stiphend = view.findViewById(R.id.text_stiphend_value);
            TextView school = view.findViewById(R.id.text_school_value);

            stiphend.setText("$ "+employee.calcEarning());
            school.setText(((Intern)employee).getSchoolname());
            this.total_earning.setText("$ "+((Intern)employee).calcEarning());


        }


    }

    @Override
    public void employeeObject(Employee employee) {
        this.employee = employee;
    }
}
