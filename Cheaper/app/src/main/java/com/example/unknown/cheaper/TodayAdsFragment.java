package com.example.unknown.cheaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.unknown.cheaper.ImageSlider.ProductDetailsActivity;

import java.util.ArrayList;

public class TodayAdsFragment extends Fragment {
    private static final String TAG ="TodayAdsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.today_ads_fragments,container,false);

        final ArrayList<AdsClass> allAds = new ArrayList<>();

        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));
        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));
        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));
        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));
        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));
        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));
        allAds.add(new AdsClass("حزاء بناتي" , "مول",100,99.9));

        GridView gridView =(GridView)view.findViewById(R.id.today_ads_gridView);


        AdsAdapterGridView adapter = new AdsAdapterGridView(getActivity(),allAds );
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
