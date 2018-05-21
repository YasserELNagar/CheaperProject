package com.example.unknown.cheaper;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unknown.cheaper.Clases.NavItemsClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Button btn;

    private static final String TAG ="HomeActivity";
    DrawerLayout mDrawerLayout;
    private SectionsPageAdapter mSectionsPageAdapter;
    Button btn_left_openNav;
    private ViewPager mViewPager;


    //navigation drawer elements
    ////////////////////

    static boolean state = true;

    private ExpandableListView listView_stores_catgories;
    private ExpandableListAdapter listAdapter;
    ListView listViews;
    ArrayList<NavItemsClass> ContentantItems;
    ListView listViews2;
    ArrayList<NavItemsClass> ContentantItems2;
    List<String> Departments_Childs;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;



    ////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Set up view pager with adapter
        mViewPager =(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        GetViewElements();

        initializeData();

        HandleDrawerClicks();

        checkAuthorizations();


        View view = findViewById(R.id.actionbarlayout);
        btn_left_openNav =(Button)findViewById(R.id.btn_left) ;
        btn_left_openNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
            });



    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter =new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllAdsFragment(),"كل الإعلانات");
        adapter.addFragment(new TodayAdsFragment(),"إعلانات اليوم");

        viewPager.setAdapter(adapter);
    }


    ////navigation drawer code
/////////////////////////////

    // fill childs wirh data in ("extendable list view") and listview elements
    private void initializeData() {



        ContentantItems = new ArrayList<NavItemsClass>(Arrays.asList(
                new NavItemsClass(getString(R.string.HOME_PAGE),R.drawable.ic_home_black_24dp),
                new NavItemsClass(getString(R.string.SIGN_IN),R.drawable.login_icon),
                new NavItemsClass(getString(R.string.Stores), R.drawable.store)

        ));


        ContentantItems2 = new ArrayList<NavItemsClass>(Arrays.asList(

                new NavItemsClass(getString(R.string.Search),R.drawable.ic_search_black_24dp),
                new NavItemsClass(getString(R.string.Contact_us),R.drawable.ic_chat_24dp)
        ));


        NavigationItemsAdapter adapter = new NavigationItemsAdapter(getApplicationContext(),ContentantItems);
        listViews.setAdapter(adapter);
        NavigationItemsAdapter adapter2 = new NavigationItemsAdapter(getApplicationContext(),ContentantItems2);

        listViews2.setAdapter(adapter2);


        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add(getString(R.string.Departments));

        Departments_Childs = new ArrayList<>();
        Departments_Childs.add(getString(R.string.MobilesAndAcsseories));
        Departments_Childs.add(getString(R.string.watches));
        Departments_Childs.add(getString(R.string.JewelleryAndAccessories));
        Departments_Childs.add(getString(R.string.ShoesAndBags));

        listHash.put(listDataHeader.get(0), Departments_Childs);



        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView_stores_catgories.setAdapter(listAdapter);

    }


    // if he siginedin the list will remove sigin item
    private void checkAuthorizations() {
        if (state == true) {
            ContentantItems.remove(1);
            ContentantItems2.add(new NavItemsClass (getString(R.string.Notification),R.drawable.ic_notifications_none_black_24dp));
            ContentantItems2.add(new NavItemsClass (getString(R.string.SIGN_OUT),R.drawable.ic_exit_to_app_24dp));

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
                if (ContentantItems.get(i).getName().equals(getString(R.string.HOME_PAGE).toString())) {
                    // Home page
                    Toast.makeText(HomeActivity.this, getString(R.string.HOME_PAGE).toString(), Toast.LENGTH_SHORT).show();
                } else if (ContentantItems.get(i).getName().equals(getString(R.string.SIGN_IN))) {
                    //SIGN_IN Page
                    Toast.makeText(HomeActivity.this, getString(R.string.SIGN_IN).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems.get(i).getName().equals(getString(R.string.Stores))) {
                    //Stores Page
                    Toast.makeText(HomeActivity.this, getString(R.string.Stores).toString(), Toast.LENGTH_SHORT).show();

                }


            }
        });

        //   List part2 clicks Handle
        listViews2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=ContentantItems2.get(i).toString();

                if (ContentantItems2.get(i).getName().equals(getString(R.string.Search))) {
                    //Search Page

                    Toast.makeText(HomeActivity.this, getString(R.string.Search).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems2.get(i).getName().equals(getString(R.string.Contact_us))) {
                    //Contact_us Page
                    Toast.makeText(HomeActivity.this, getString(R.string.Contact_us).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems2.get(i).getName().equals(getString(R.string.SIGN_OUT))) {
                    //Return To Home Page Or sigin page
                    Toast.makeText(HomeActivity.this, getString(R.string.SIGN_OUT).toString(), Toast.LENGTH_SHORT).show();

                } else if (ContentantItems2.get(i).getName().equals(getString(R.string.Notification))) {
                    //Return Notification page
                    Toast.makeText(HomeActivity.this, getString(R.string.Notification).toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        //  EXTENDABLE List clicks Handle

        listView_stores_catgories.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if (Departments_Childs.get(i1).equals(getString(R.string.MobilesAndAcsseories))) {
                    // MobilesAndAcsseories  page
                    Toast.makeText(HomeActivity.this, getString(R.string.MobilesAndAcsseories).toString(), Toast.LENGTH_SHORT).show();

                } else if (Departments_Childs.get(i1).equals(getString(R.string.watches))) {
                    // watches  page
                    Toast.makeText(HomeActivity.this, getString(R.string.watches).toString(), Toast.LENGTH_SHORT).show();

                } else if (Departments_Childs.get(i1).equals(getString(R.string.JewelleryAndAccessories))) {
                    // JewelleryAndAccessories  page
                    Toast.makeText(HomeActivity.this, getString(R.string.JewelleryAndAccessories).toString(), Toast.LENGTH_SHORT).show();

                } else if (Departments_Childs.get(i1).toString().equals(getString(R.string.ShoesAndBags))) {
                    // ShoesAndBags page
                    Toast.makeText(HomeActivity.this, getString(R.string.ShoesAndBags).toString(), Toast.LENGTH_SHORT).show();

                }

                return false;
            }
        });

    }

    private  void GetViewElements(){
        listView_stores_catgories = (ExpandableListView) findViewById(R.id.expandableListView);
        listViews = (ListView) findViewById(R.id.listofitems);
        listViews2 = (ListView) findViewById(R.id.listofitems2);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.navigation);

    }

/////////////////////////////////

}
