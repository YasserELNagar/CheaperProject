package com.example.unknown.cheaper.ImageSlider;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.unknown.cheaper.HomeActivity;
import com.example.unknown.cheaper.LoginActivity;
import com.example.unknown.cheaper.R;
import com.example.unknown.cheaper.SignupActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ProductDetailsActivity extends AppCompatActivity {
    private static ViewPager mPager;
    ArrayList<String> stores;
    GridView gridView;
    TextView someTextView;

    //dialog view elements
    Button signin_btn;
    Button signup_btn;
    Button continue_btn;


    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.shooes1, R.drawable.shooes2, R.drawable.shooes3jpg};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        GetViewElements();

        initializeImageFlipper();

        someTextView = (TextView) findViewById(R.id.pricebeforeoffere);
        someTextView.setText("500جنيه");
        someTextView.setPaintFlags(someTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        stores = new ArrayList<>(Arrays.asList(
                new String("القاهره"),
                new String("ابها")));
        callgridviewadapter adapter = new callgridviewadapter(ProductDetailsActivity.this,stores);
        gridView.setAdapter(adapter);



        HandleClick();


    }

    ///method to handle gridview click actions
    private void HandleClick(){

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(LoginActivity.CurrentUser!=null){

                    Dialog dialog = new Dialog(ProductDetailsActivity.this,R.style.Theme_Dialog);
                    dialog.setContentView(R.layout.special_dialog_should_signin_layout);
                    dialog.setTitle(R.string.SorrySigninFirstToCall);

                    signin_btn=dialog.findViewById(R.id.signin_btn);
                    signup_btn=dialog.findViewById(R.id.signup_btn);
                    continue_btn=dialog.findViewById(R.id.continue_btn);


                    //this code to handle button clicks transition actions

                    signin_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(ProductDetailsActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    });

                    signup_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ProductDetailsActivity.this,SignupActivity.class);
                            startActivity(intent);
                        }
                    });

                    continue_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ProductDetailsActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                    });


                    dialog.show();



                }

            }
        });

    }



    private void initializeImageFlipper() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);


        mPager.setAdapter(new imageadapter(ProductDetailsActivity.this,XMENArray));
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


    private void GetViewElements(){
        gridView =(GridView)findViewById(R.id.clall);
        mPager = (ViewPager) findViewById(R.id.pager);
    }

}

