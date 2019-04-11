package com.harsh.group6_w2019_mad3125_fp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnSignin;
    private Button btnClear;
    private TextView lblmsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        lblmsg = findViewById(R.id.lblMessage);
        btnSignin = findViewById(R.id.btnSignin);
        btnClear = findViewById(R.id.btnClear);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if(email.trim().length() == 0 || TextUtils.isEmpty(email))
                {
                    edtEmail.setError("Enter Email Id of user");
                    return;
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    edtEmail.setError("Enter Valid Email Id");
                    return;
                }

                Toast.makeText( LoginActivity.this,email,Toast.LENGTH_SHORT).show();
                if(email.equals("admin123@gmail.com") && password.equals( "123"))
                {
                    lblmsg.setText("login successful");
                    lblmsg.setTextColor(Color.GREEN);
                    Intent mIntent = new Intent(LoginActivity.this,VehicleActivity.class);
                    mIntent.putExtra("name","sushmitha");
                    startActivity(mIntent);



                }
                else
                {
                    AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(LoginActivity.this);
                    alertdialogBuilder.setTitle("status");
                    alertdialogBuilder.setMessage("ivalid details")
                            .setCancelable(false)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {

                                    LoginActivity.this.finish();
                                }
                            })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    dialog.cancel();


                                }
                            });

                    AlertDialog alertDialog = alertdialogBuilder.create();
                    alertDialog.show();
                }

            }
        });

    }
}






