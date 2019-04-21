package com.example.hp.mindicator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class Tab3 extends Fragment{
    private static Button button,button1,button2;
    private static TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.tab3,null);
        button=v.findViewById(R.id.button_source_fare);
        button1=v.findViewById(R.id.button_destination_fare);
        button2=v.findViewById(R.id.button_search_fare);
        textView = v.findViewById(R.id.text_fare);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity().getApplicationContext(),SelectStation.class);
                i.putExtra("activity",3);
               startActivity(i);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity().getApplicationContext(),SelectStation.class);
                i.putExtra("activity",4);
                i.putExtra("station",button.getText().toString());
                startActivity(i);            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((button.getText().toString()).equals("Source") || (button1.getText().toString()).equals("Destination")){
                    Toast.makeText(getActivity().getApplicationContext(), "Enter Details first", Toast.LENGTH_SHORT).show();
                }      else {


                    Dictionary<String, Integer> cantt = new Hashtable<String, Integer>();
                    cantt.put("Kamachha", 10);
                    cantt.put("Lanka", 12);
                    cantt.put("Rathyatra", 6);
                    cantt.put("Ravindrapuri", 10);
                    cantt.put("Sigra", 6);
                    cantt.put("Vidyapeeth", 6);

                    Dictionary<String, Integer> dlw = new Hashtable<String, Integer>();
                    dlw.put("CANTT.", 12);
                    dlw.put("Hari Nagar", 10);
                    dlw.put("Lahartara", 10);
                    dlw.put("Manduadih", 6);

                    Dictionary<String, Integer> harinagar = new Hashtable<String, Integer>();
                    harinagar.put("CANTT.", 6);

                    Dictionary<String, Integer> kamachha = new Hashtable<String, Integer>();
                    kamachha.put("Lanka", 6);
                    kamachha.put("Ravindrapuri", 6);

                    Dictionary<String, Integer> lahartara = new Hashtable<String, Integer>();
                    lahartara.put("CANTT.", 10);
                    lahartara.put("Hari Nagar", 6);

                    Dictionary<String, Integer> lanka = new Hashtable<String, Integer>();
                    lanka.put("CANTT.", 15);
                    lanka.put("DLW", 6);
                    lanka.put("Hari Nagar", 15);
                    lanka.put("Lahartara", 12);
                    lanka.put("Manduadih", 10);
                    lanka.put("Sundarpur", 6);

                    Dictionary<String, Integer> manduadih = new Hashtable<String, Integer>();
                    manduadih.put("CANTT.", 12);
                    manduadih.put("Hari Nagar", 10);
                    manduadih.put("Lahartara", 6);

                    Dictionary<String, Integer> rathyatra = new Hashtable<String, Integer>();
                    rathyatra.put("Kamachha", 6);
                    rathyatra.put("Lanka", 10);
                    rathyatra.put("Ravindrapuri", 6);

                    Dictionary<String, Integer> ravindrapuri = new Hashtable<String, Integer>();
                    ravindrapuri.put("Lanka", 6);

                    Dictionary<String, Integer> sigra = new Hashtable<String, Integer>();
                    sigra.put("Kamachha", 6);
                    sigra.put("Lanka", 10);
                    sigra.put("Rathyatra", 6);
                    sigra.put("Ravindrapuri", 10);

                    Dictionary<String, Integer> sundarpur = new Hashtable<String, Integer>();
                    sundarpur.put("CANTT.", 15);
                    sundarpur.put("DLW", 6);
                    sundarpur.put("Hari Nagar", 12);
                    sundarpur.put("Lahartara", 10);
                    sundarpur.put("Manduadih", 6);

                    Dictionary<String, Integer> vidyapeeth = new Hashtable<String, Integer>();
                    vidyapeeth.put("Kamachha", 6);
                    vidyapeeth.put("Lanka", 12);
                    vidyapeeth.put("Rathyatra", 6);
                    vidyapeeth.put("Ravindrapuri", 10);
                    vidyapeeth.put("Sigra", 6);


                    switch (button.getText().toString()) {
                        case "CANTT.":
                            textView.setText("Rs " + cantt.get(button1.getText().toString()).toString());
                            break;
                        case "DLW":
                            textView.setText("Rs " + dlw.get(button1.getText().toString()).toString());
                            break;
                        case "Hari Nagar":
                            textView.setText("Rs " + harinagar.get(button1.getText().toString()).toString());
                            break;
                        case "Kamachha":
                            textView.setText("Rs " + kamachha.get(button1.getText().toString()).toString());
                            break;
                        case "Lahartara":
                            textView.setText("Rs " + lahartara.get(button1.getText().toString()).toString());
                            break;
                        case "Lanka":
                            textView.setText("Rs " + lanka.get(button1.getText().toString()).toString());
                            break;
                        case "Manduadih":
                            textView.setText("Rs " + manduadih.get(button1.getText().toString()).toString());
                            break;
                        case "Rathyatra":
                            textView.setText("Rs " + rathyatra.get(button1.getText().toString()).toString());
                            break;
                        case "Ravindrapuri":
                            textView.setText("Rs " + ravindrapuri.get(button1.getText().toString()).toString());
                            break;
                        case "Sigra":
                            textView.setText("Rs " + sigra.get(button1.getText().toString()).toString());
                            break;
                        case "Sundarpur":
                            textView.setText("Rs " + sundarpur.get(button1.getText().toString()).toString());
                            break;
                        case "Vidyapeeth":
                            textView.setText("Rs " + vidyapeeth.get(button1.getText().toString()).toString());
                            break;
                    }


                }
            }
        });
       return v;
    }
    public static void set_data(){
        button.setText(SelectStation.selectedItem);
        button.setTextColor(Color.parseColor("#000000"));
    }
    public static void set_data_1(){
        button1.setText(SelectStation.selectedItem);
        button1.setTextColor(Color.parseColor("#000000"));
    }


}
