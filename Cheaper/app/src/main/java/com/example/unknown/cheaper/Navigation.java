package com.example.unknown.cheaper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Navigation extends AppCompatActivity {
    boolean state = true;

    // listView_stores_catgories
    private ExpandableListView listView_stores_catgories;
    private ExpandableListAdapter listAdapter;
    ListView listViews;
    ArrayList<String> ContentantItems;
    ListView listViews2;
    ArrayList<String> ContentantItems2;
    List<String> Departments_Childs;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        GetViewElements();

        initializeData();

        HandleDrawerClicks();

        checkAuthorizations();
    }



    // fill childs wirh data in ("extendable list view") and listview elements
    private void initializeData() {

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView_stores_catgories.setAdapter(listAdapter);

        ContentantItems = new ArrayList<>(Arrays.asList(
                new String(getString(R.string.HOME_PAGE)),
                new String(getString(R.string.SIGN_IN)),
                new String(getString(R.string.Stores))

        ));


        ContentantItems2 = new ArrayList<>(Arrays.asList(

                new String(getString(R.string.Search)),
                new String(getString(R.string.Contact_us))
        ));


        listViews.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ContentantItems));


        listViews2.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ContentantItems2));


        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add(getString(R.string.Departments));

        Departments_Childs = new ArrayList<>();
        Departments_Childs.add(getString(R.string.MobilesAndAcsseories));
        Departments_Childs.add(getString(R.string.watches));
        Departments_Childs.add(getString(R.string.JewelleryAndAccessories));
        Departments_Childs.add(getString(R.string.ShoesAndBags));

        listHash.put(listDataHeader.get(0), Departments_Childs);

    }
    // if he siginedin the list will remove sigin item
    private void checkAuthorizations() {
        if (state == true) {
            ContentantItems.remove(1);
            ContentantItems2.add(getString(R.string.Notification));
            ContentantItems2.add(getString(R.string.SIGN_OUT));

            listAdapter.notifyDataSetChanged();

        } else {

        }

    }


    //this method handles clicks and movements between activities
    private void HandleDrawerClicks(){

        //   List part1 clicks Handle
        listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (ContentantItems.get(i).toString().equals(getString(R.string.HOME_PAGE).toString())) {
                    // Home page
                    Toast.makeText(Navigation.this, getString(R.string.HOME_PAGE).toString(), Toast.LENGTH_SHORT).show();
                } else if (ContentantItems.get(i).toString().equals(getString(R.string.SIGN_IN))) {
                    //SIGN_IN Page
                    Toast.makeText(Navigation.this, getString(R.string.SIGN_IN).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems.get(i).toString().equals(getString(R.string.Stores))) {
                    //Stores Page
                    Toast.makeText(Navigation.this, getString(R.string.Stores).toString(), Toast.LENGTH_SHORT).show();

                }


            }
        });

        //   List part2 clicks Handle
        listViews2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (ContentantItems2.get(i).toString().equals(getString(R.string.Search))) {
                    //Search Page
                    Toast.makeText(Navigation.this, getString(R.string.Search).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems2.get(i).toString().equals(getString(R.string.Contact_us))) {
                    //Contact_us Page
                    Toast.makeText(Navigation.this, getString(R.string.Contact_us).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems2.get(i).toString().equals(getString(R.string.SIGN_OUT))) {
                    //Return To Home Page Or sigin page
                    Toast.makeText(Navigation.this, getString(R.string.SIGN_OUT).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems2.get(i).toString().equals(getString(R.string.Notification))) {
                    //Return Notification page
                    Toast.makeText(Navigation.this, getString(R.string.Notification).toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        //  EXTENDABLE List clicks Handle

        listView_stores_catgories.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if (Departments_Childs.get(i1).equals(getString(R.string.MobilesAndAcsseories))) {
                    // MobilesAndAcsseories  page
                    Toast.makeText(Navigation.this, getString(R.string.MobilesAndAcsseories).toString(), Toast.LENGTH_SHORT).show();

                } else if (Departments_Childs.get(i1).equals(getString(R.string.watches))) {
                    // watches  page
                    Toast.makeText(Navigation.this, getString(R.string.watches).toString(), Toast.LENGTH_SHORT).show();

                } else if (Departments_Childs.get(i1).equals(getString(R.string.JewelleryAndAccessories))) {
                    // JewelleryAndAccessories  page
                    Toast.makeText(Navigation.this, getString(R.string.JewelleryAndAccessories).toString(), Toast.LENGTH_SHORT).show();

                } else if (Departments_Childs.get(i1).toString().equals(getString(R.string.ShoesAndBags))) {
                    // ShoesAndBags page
                    Toast.makeText(Navigation.this, getString(R.string.ShoesAndBags).toString(), Toast.LENGTH_SHORT).show();

                }

                return false;
            }
        });

    }

    private  void GetViewElements(){
        listView_stores_catgories = (ExpandableListView) findViewById(R.id.expandableListView);
        listViews = (ListView) findViewById(R.id.listofitems);
        listViews2 = (ListView) findViewById(R.id.listofitems2);
    }


}