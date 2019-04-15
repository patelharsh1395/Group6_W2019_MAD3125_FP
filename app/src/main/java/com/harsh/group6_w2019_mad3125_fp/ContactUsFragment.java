package com.harsh.group6_w2019_mad3125_fp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import model.Intern;

public class ContactUsFragment extends Fragment {

    TextView message;
    TextView email;
    TextView call;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactus_fragment_layout, container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.message = view.findViewById(R.id.text_message);
        this.message.setText(SpanningForString.forSMS(this.message.getText().toString()));
        this.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "+1 123 456 7890"));
                startActivity(mIntent);
            }
        });


        this.call = view.findViewById(R.id.text_call);
        this.call.setText(SpanningForString.forCall(this.call.getText().toString()));
        this.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_DIAL);
                mIntent.setData(Uri.parse("tel:"+"+1 123 456 7890"));
                startActivity(mIntent);
            }
        });



        this.email = view.findViewById(R.id.text_email);
        this.email.setText(SpanningForString.forEmail(this.email.getText().toString()));
        this.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_SENDTO);
                mIntent.setData(Uri.parse("mailto:" + "123@gmail.com"));
                startActivity(mIntent);
            }
        });

    }
}
