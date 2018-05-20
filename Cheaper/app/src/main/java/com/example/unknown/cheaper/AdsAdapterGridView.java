package com.example.unknown.cheaper;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unknown.cheaper.Clases.AdsClass;

import java.util.ArrayList;

public class AdsAdapterGridView extends ArrayAdapter {

    ArrayList<AdsClass> allAds;

    public AdsAdapterGridView(@NonNull Context context, ArrayList<AdsClass> allAds) {
        super(context, 0);
        this.allAds=allAds;
    }

    @Override
    public int getCount() {
        return allAds.size();
    }

    @Override
    public Object getItem(int position) {
        return allAds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return allAds.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdsClass currentAds = allAds.get(position);

        adsViewholder viewholder ;

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.special_all_ads_gridview,null);

            viewholder=new adsViewholder(convertView);

            convertView.setTag(viewholder);
        }
        else {
            viewholder= (adsViewholder) convertView.getTag();
        }

        viewholder.productname.setText((String.valueOf(currentAds.getProductName())));
        viewholder.storename.setText((String.valueOf(currentAds.getStoreName())));
        viewholder.price_before_offer.setText((String.valueOf(currentAds.getPrice_befor_offer())));
        viewholder.price_before_offer.setPaintFlags(viewholder.price_before_offer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        viewholder.price_after_offer.setText((String.valueOf(currentAds.getPrice_after_offer())));
        //viewholder.image.setImageResource(currentAds.getImage());


        return convertView;
    }

    public class adsViewholder{

        TextView productname;
        TextView storename;
        TextView price_before_offer;
        TextView price_after_offer;
        //ImageView image;

        public adsViewholder(View view){

            price_after_offer = (TextView) view.findViewById(R.id.price_after_offer_textview);
            productname = (TextView) view.findViewById(R.id.product_name_textview);
            price_before_offer = (TextView) view.findViewById(R.id.price_before_offer_textview);
            storename = (TextView) view.findViewById(R.id.store_name_textview);
            //image =  view.findViewById(R.id.image_gridview);

        }

    }
}
