package com.example.hp.mindicator;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectStation extends AppCompatActivity {

    private ListView lv;
    public static String selectedItem="";

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;
    Button button3,button1,button2,button4;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    String products[] = {"CANTT.","DLW","Hari Nagar","Kamachha","Lahartara","Lanka","Manduadih","Rathyatra","Ravindrapuri","Sigra","Sundarpur","Vidyapeeth"};
    String cantt[]={"Kamachha","Lanka","Rathyatra","Ravindrapuri","Sigra","Vidyapeeth"};
    String dlw[]= {"CANTT.","Hari Nagar","Lahartara","Manduadih"};
    String harinagar[]={"CANTT."};
    String kamachha[]={"Lanka","Ravindrapuri"};
    String lahartara[]={"CANTT.","Hari Nagar"};
    String lanka[]={"CANTT.","DLW","Hari Nagar","Lahartara","Manduadih","Sundarpur"};
    String manduadih[]={"CANTT.","Hari Nagar","Lahartara"};
    String rathyatra[]={"Kamachha","Lanka","Ravindrapuri"};
    String ravindrapuri[] ={"Lanka"};
    String sigra[]={"Kamachha","Lanka","Rathyatra","Ravindrapuri"};
    String sundarpur[]={"CANTT.","DLW","Hari Nagar","Lahartara","Manduadih"};
    String vidyapeeth[]={"Kamachha","Lanka","Rathyatra","Ravindrapuri","Sigra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station);

        final int page = getIntent().getIntExtra("activity",0);
        final String station = getIntent().getStringExtra("station");






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Station");

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, R.id.station_name, array(station,page));
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectedItem = (String) parent.getItemAtPosition(position);
                if(page==1){
                Tab2.set_data();
                }
                else if(page==2){
                   Tab2.set_data_1();
                }else if(page==3){
                    Tab3.set_data();
                }else if(page==4){
                    Tab3.set_data_1();
                }
                finish();
            //   Toast.makeText(SelectStation.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                SelectStation.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private String[] array(String str,int i) {

        if (i == 1 || i==3) {
            return products;
        }else if (i==2 || i==4){
            switch(str){
                case "CANTT.":
                    return cantt;

                case "DLW":
                    return dlw;

                case "Hari Nagar":
                    return harinagar;

                case "Kamachha":
                    return kamachha;

                case "Lahartara":
                    return lahartara;

                case "Lanka":
                    return lanka;

                case "Manduadih":
                    return manduadih;

                case "Rathyatra":
                    return rathyatra;

                case "Ravindrapuri":
                    return ravindrapuri;

                case "Sigra":
                    return sigra;

                case "Sundarpur":
                    return sundarpur;

                case "Vidyapeeth":
                    return vidyapeeth;





            }

        }
                return products;
            }
        }
