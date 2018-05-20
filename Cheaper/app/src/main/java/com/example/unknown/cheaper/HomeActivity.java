package com.example.unknown.cheaper;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG ="HomeActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

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

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter =new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllAdsFragment(),"كل الإعلانات");
        adapter.addFragment(new TodayAdsFragment(),"إعلانات اليوم");

        viewPager.setAdapter(adapter);
    }



}
