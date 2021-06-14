package com.example.shillongsalattime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.TextView;

public class output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent=getIntent();

        TextView date=(TextView) findViewById(R.id.outdate);
        TextView sh=(TextView) findViewById(R.id.textView6);
        TextView sn=(TextView) findViewById(R.id.textView7);
        TextView z=(TextView) findViewById(R.id.textView8);
        TextView a=(TextView) findViewById(R.id.textView9);
        TextView m=(TextView) findViewById(R.id.textView10);
        TextView i=(TextView) findViewById(R.id.textView11);

         /*  FOR SETTING DIFFERNT COLOUR OF SAME TEXTVIEW.....HERE TO CHANGE THE COLOUR OF NOTE

         TextView note1=(TextView) findViewById(R.id.note1);
        TextView note2=(TextView) findViewById(R.id.note2);

        String n1="** NOTE : Fajr Time Starts After Sehree Ends. **";
        String n2="** NOTE : The Timings shown above are the starting time of respective prayers. **";

        SpannableStringBuilder s1=new SpannableStringBuilder(n1);
        SpannableStringBuilder s2=new SpannableStringBuilder(n2);

        ForegroundColorSpan wh=new ForegroundColorSpan(Color.GREEN);

        s1.setSpan(wh,3,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s2.setSpan(wh,3,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        note1.setText(s1);
        note2.setText(s2); */



        int dt=intent.getIntExtra("dt",0);
        int mn =intent.getIntExtra("mn",0);
        int yy =intent.getIntExtra("yy",0);
        String dd="DATE: "+dt+"/"+mn+"/"+yy;

        String sehree=intent.getStringExtra("sh");
        String sunrise=intent.getStringExtra("sn");
        String zohar=intent.getStringExtra("z");
        String asar=intent.getStringExtra("a");
        String maghrib=intent.getStringExtra("m");
        String isha=intent.getStringExtra("i");




        date.setText(dd);
        sh.setText("  SEHREE END   : "+sehree + "  AM");
        sn.setText("  SUNRISE          : "+sunrise + "  AM");
        z.setText("  ZOHAR             : "+zohar + "  AM");
        a.setText("  ASR                   : "+asar + "  PM");
        m.setText("  MAGHRIB         : "+maghrib + "  PM");
        i.setText("  ISHA                  : "+isha + "  PM");



    }
}