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

import com.example.unknown.cheaper.Clases.AdsClass;
import com.example.unknown.cheaper.ImageSlider.ProductDetailsActivity;

import java.util.ArrayList;

public class AllAdsFragment extends Fragment {
    private static final String TAG ="AllAdsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_ads_fragments,container,false);


        final ArrayList<AdsClass> allAds = new ArrayList<>();

        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول العرب",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول مصر",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول مصر",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول العرب",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول مصر",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول العرب",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول مصر ",4000,2000));
        allAds.add(new AdsClass("حزاء اديدس رياضى" , "مول العرب",4000,2000));


        GridView gridView =(GridView)view.findViewById(R.id.all_ads_gridView);


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
