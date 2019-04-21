package com.example.hp.mindicator;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class Tab2 extends Fragment {
     private static Button button,button1,button2,button3,button4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab2,null);
        button=v.findViewById(R.id.button_source);
        button1=v.findViewById(R.id.button_destination);
        button2=v.findViewById(R.id.button_timepicker);
        button3=v.findViewById(R.id.button_timepicker_);
        button4=v.findViewById(R.id.button_search);


        Calendar calendar =Calendar.getInstance();
        int hour =calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        button2.setText(String.valueOf(hour)+":"+String.valueOf(minute));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(),SelectStation.class);
                i.putExtra("activity",1);
                startActivity(i);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(),SelectStation.class);
                i.putExtra("activity",2);
                i.putExtra("station",button.getText().toString());
                startActivity(i);
                          }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new MyTimePickerFragment();
                newFragment.show(getFragmentManager(), "time picker");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new TimePickerFragment();
                df.show(getFragmentManager(),"time picker");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("location", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("loc1", "LANKA");
                editor.putString("loc2", "CANTT.");
                editor.commit();
                bundle.putString("loc1", "LANKA");
                bundle.putString("loc2", "CANTT");
                bundle.putInt("time", 2400);


                Intent intent = new Intent(getActivity().getApplicationContext(), ShowBus.class);


                intent.putExtras(bundle);

                startActivity(intent);
            }
        });


        return v;    }
    public static void set_data(){
    button.setText(SelectStation.selectedItem);
    button.setTextColor(Color.parseColor("#000000"));
}
    public static void set_data_1(){
        button1.setText(SelectStation.selectedItem);
        button1.setTextColor(Color.parseColor("#000000"));
    }
}