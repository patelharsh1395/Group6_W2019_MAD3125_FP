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

}
