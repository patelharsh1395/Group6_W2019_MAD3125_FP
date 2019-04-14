package com.harsh.group6_w2019_mad3125_fp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment  {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int yyyy, int mm, int dd) {
              //  Toast.makeText(getContext(),"year "+year+" month "+month+" day "+day, Toast.LENGTH_LONG).show();

              TextView text_age =  getActivity().findViewById(R.id.text_date_of_birth);
              //text_age.setText("DateOfBirth : "+year+"/"+month+"/"+day);
              text_age.setText(SpanningForString.forDate((String)"DateOfBirth : "+yyyy+"/"+(mm+1)+"/"+dd));
            }
        },year,month,day);
    }
}
