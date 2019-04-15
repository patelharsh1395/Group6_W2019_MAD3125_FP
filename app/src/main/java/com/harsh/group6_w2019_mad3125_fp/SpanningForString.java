package com.harsh.group6_w2019_mad3125_fp;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;

public class SpanningForString {

    public static SpannableString forDate(String dtText)
    {

        SpannableString spannableString = new SpannableString(dtText);
        ForegroundColorSpan forgroundcolor = new ForegroundColorSpan(Color.BLUE);
        UnderlineSpan underline = new UnderlineSpan();
        spannableString.setSpan(forgroundcolor , 14, dtText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(underline , 14, dtText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        return spannableString;
    }
    public static SpannableString forSMS(String smsText)
    {
        SpannableString spannableString = new SpannableString(smsText);
        ForegroundColorSpan forgroundcolor = new ForegroundColorSpan(Color.BLUE);
        UnderlineSpan underline = new UnderlineSpan();
        spannableString.setSpan(forgroundcolor, 10, smsText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        spannableString.setSpan(underline, 10, smsText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );


        return spannableString;
    }


    public static  SpannableString forEmail(String emailText)
    {
        SpannableString spannableString = new SpannableString(emailText);
        ForegroundColorSpan forgroundcolor = new ForegroundColorSpan(Color.BLUE);
        UnderlineSpan underline = new UnderlineSpan();
        spannableString.setSpan(forgroundcolor, 8, emailText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        spannableString.setSpan(underline, 8, emailText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );


        return  spannableString;
    }
    public static  SpannableString forCall(String callText)
    {
        SpannableString spannableString = new SpannableString(callText);
        ForegroundColorSpan forgroundcolor = new ForegroundColorSpan(Color.BLUE);
        UnderlineSpan underline = new UnderlineSpan();
        spannableString.setSpan(forgroundcolor, 7, callText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        spannableString.setSpan(underline, 7, callText.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

        return  spannableString;
    }

}
