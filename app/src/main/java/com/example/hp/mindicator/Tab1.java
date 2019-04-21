package com.example.hp.mindicator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tab1 extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private int lastExpandedPosition = -1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab1,null);
        expListView = (ExpandableListView) v.findViewById(R.id.lvExp);


        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity().getApplicationContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }


        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        return v;    }




    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("CANTT");
        listDataHeader.add("DLW");
        listDataHeader.add("Hari Nagar");
        listDataHeader.add("Kamachha");
        listDataHeader.add("Lahartara");
        listDataHeader.add("Lanka");
        listDataHeader.add("Manduadih");
        listDataHeader.add("Rathyatra");
        listDataHeader.add("Ravindrapuri");
        listDataHeader.add("Sigra");
        listDataHeader.add("Sundarpur");
        listDataHeader.add("Vidyapeeth");


        // Adding child data
        List<String> cantt = new ArrayList<String>();
        cantt.add("Kamachha");
        cantt.add("Lanka");
        cantt.add("Rathyatra");
        cantt.add("Ravindrapuri");
        cantt.add("Sigra");
        cantt.add("Vidyapeeth");

        List<String> dlw = new ArrayList<String>();
        dlw.add("CANTT");
        dlw.add("Hari Nagar ");
        dlw.add("Lahartara");
        dlw.add("Manduadih");


        List<String> hari_nagar = new ArrayList<String>();
        hari_nagar.add("CANTT");

        List<String> kamachha= new ArrayList<String>();
        kamachha.add("Lanka");
        kamachha.add("Ravindrapuri");

        List<String> lahartara= new ArrayList<String>();
        lahartara.add("CANTT");
        lahartara.add("Hari Nagar");

        List<String> lanka= new ArrayList<String>();
        lanka.add("CANTT");
        lanka.add("DLW");
        lanka.add("Hari Nagar");
        lanka.add("Lahartara");
        lanka.add("Manduadih");
        lanka.add("Sundarpur");

        List<String> manduadih= new ArrayList<String>();
        manduadih.add("CANTT");
        manduadih.add("Hari Nagar");
        manduadih.add("Lahartara");

        List<String> rathyatra= new ArrayList<String>();
        rathyatra.add("Kamachha");
        rathyatra.add("Lanka");
        rathyatra.add("Ravindrapuri");

        List<String> ravindrapuri= new ArrayList<String>();
        ravindrapuri.add("Lanka");


        List<String> sigra= new ArrayList<String>();
        sigra.add("Kamachha");
        sigra.add("Lanka");
        sigra.add("Rathyatra");
        sigra.add("Ravindrapuri");

        List<String> sundarpur= new ArrayList<String>();
        sundarpur.add("CANTT");
        sundarpur.add("DLW");
        sundarpur.add("Hari Nagar");
        sundarpur.add("Lahartara");
        sundarpur.add("Manduadih");



        List<String> vidyapeeth= new ArrayList<String>();
        vidyapeeth.add("Kamachha");
        vidyapeeth.add("Lanka");
        vidyapeeth.add("Rathyatra");
        vidyapeeth.add("Ravindrapuri");
        vidyapeeth.add("Sigra");





        listDataChild.put(listDataHeader.get(0),cantt );
        listDataChild.put(listDataHeader.get(1),dlw );
        listDataChild.put(listDataHeader.get(2),hari_nagar );
        listDataChild.put(listDataHeader.get(3),kamachha);
        listDataChild.put(listDataHeader.get(4),lahartara );
        listDataChild.put(listDataHeader.get(5), lanka);
        listDataChild.put(listDataHeader.get(6),manduadih );
        listDataChild.put(listDataHeader.get(7),rathyatra );
        listDataChild.put(listDataHeader.get(8),ravindrapuri );
        listDataChild.put(listDataHeader.get(9),sigra);
        listDataChild.put(listDataHeader.get(10),sundarpur);
        listDataChild.put(listDataHeader.get(11),vidyapeeth);



        // Header, Child data

    }
}