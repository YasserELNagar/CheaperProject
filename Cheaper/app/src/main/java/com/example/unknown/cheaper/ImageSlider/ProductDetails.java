package com.example.unknown.cheaper.ImageSlider;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import com.example.unknown.cheaper.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ProductDetails extends AppCompatActivity {
    private static ViewPager mPager;
    ArrayList<String> stores;
    GridView gridView;

    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.shooes1, R.drawable.shooes2, R.drawable.shooes3jpg};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        init();

        TextView someTextView = (TextView) findViewById(R.id.pricebeforeoffere);
        someTextView.setText("500جنيه");
        someTextView.setPaintFlags(someTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        gridView =(GridView)findViewById(R.id.clall);
        stores = new ArrayList<>(Arrays.asList(
                new String("القاهره"),
                new String("ابها")));
        callgridviewadapter adapter = new callgridviewadapter(ProductDetails.this,stores);
        gridView.setAdapter(adapter);
    }


    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new imageadapter(ProductDetails.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

}

