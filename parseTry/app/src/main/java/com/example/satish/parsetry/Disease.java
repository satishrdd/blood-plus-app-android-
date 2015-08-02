package com.example.satish.parsetry;

/**
 * Created by satish on 1/26/2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class Disease extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Intent b = new Intent(Disease.this, Snake.class);
                                startActivity(b);
                                break;

                            case 1:
                                Intent myIntent = new Intent(Disease.this, Bleeding.class);
                                startActivity(myIntent);
                                break;}
                        break;
                    case 1:
                        switch(childPosition){
                            case 0:
                                Intent c = new Intent(Disease.this, Precaution.class);
                                startActivity(c);
                                break;
                            case 1:
                                Intent d = new Intent(Disease.this,Advantages.class );
                                startActivity(d);
                                break;
                        }
                        break;
                }
                return false;
            }
        });

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding child data
        listDataHeader.add("First aid");
        listDataHeader.add("Blood Donation");


        // Adding child data
        List<String> Firstaid = new ArrayList<>();
        Firstaid.add("    Snake Bite");
        Firstaid.add("    Severe Bleeding");

        List<String> BloodDonation = new ArrayList<String>();
        BloodDonation.add("     Precautions");
        BloodDonation.add("     Advantages");


        listDataChild.put(listDataHeader.get(0), Firstaid); // Header, Child data
        listDataChild.put(listDataHeader.get(1), BloodDonation);

    }}
