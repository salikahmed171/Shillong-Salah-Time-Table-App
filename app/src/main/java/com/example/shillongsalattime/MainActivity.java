package com.example.shillongsalattime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

     time_class tc=new time_class();

       //When Select Date Button is Clicked
    public void find_date(View view){


        Animation up=AnimationUtils.loadAnimation(this,R.anim.scaleup);
        Animation down=AnimationUtils.loadAnimation(this,R.anim.scaledown);

        Button b=(Button) findViewById(R.id.date);
        b.startAnimation(up);
        b.startAnimation(down);

        DatePickerDialog pick=new DatePickerDialog(this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        );
        pick.show();
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dat) {
       TextView tv=findViewById(R.id.textView);
        String date= dat + "/ " + (month+1) + "/ " + year;
        tv.setText(date);
        tc.setDate(dat,month+1,year);
        //This can also be used to set date as above ((time_class) this.getApplication()).setDate(dat,month,year);


    }



    //When Know Time Button Is Clicked
    @SuppressLint("ShowToast")
    public void jump(View view){

        TextView t=(TextView) findViewById(R.id.textView);
        String check=t.getText().toString();
        if(check.equals("DD/ MM/ YYYY"))
         {
             Toast.makeText(MainActivity.this,"Please Select a Date",Toast.LENGTH_SHORT).show();
         }


        else {

            Intent i = new Intent(MainActivity.this, output.class);
            Button bt = (Button) findViewById(R.id.knowtime);
            Animation up = AnimationUtils.loadAnimation(this, R.anim.scaleup);
            Animation down = AnimationUtils.loadAnimation(this, R.anim.scaledown);

            bt.startAnimation(up);
            bt.startAnimation(down);

        // int d=((time_class) this.getApplication()).getDate();This can also be used to get date as below line
           int dt=tc.getDate();
           int mn=tc.getMonth();
           int yy=tc.getYear();

            tc.know_time_table();

            String sehree = tc.getSehree();
            String sunrise = tc.getSunrise();
            String zohar = tc.getZohar();
            String asar = tc.getAsar();
            String maghrib = tc.getMaghrib();
            String isha = tc.getIsha();

            i.putExtra("dt",dt);
            i.putExtra("mn",mn);
            i.putExtra("yy",yy);

            i.putExtra("sh", sehree);
            i.putExtra("sn", sunrise);
            i.putExtra("z", zohar);
            i.putExtra("a", asar);
            i.putExtra("m", maghrib);
            i.putExtra("i", isha);
            startActivity(i);

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        time_class tc=(time_class) getApplicationContext();  //For Global variable and in time_class also it is extends Application





    }


}