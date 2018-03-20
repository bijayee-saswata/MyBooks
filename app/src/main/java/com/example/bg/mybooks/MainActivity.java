package com.example.bg.mybooks;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {


    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private slider sliderAdapter;
    private TextView[] mDots;
    private Button mbtn,toLogin;
    private int mcurrent;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user= FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            startActivity(new Intent(MainActivity.this,myFile.class));
        }
        else {
            // No user is signed in
            setContentView(R.layout.activity_main);
            mSlideViewPager=(ViewPager)findViewById(R.id.screen);
            mDotLayout=(LinearLayout) findViewById(R.id.dots);
            mbtn=(Button)findViewById(R.id.toLoginBtn);
            sliderAdapter= new slider(MainActivity.this);
            mSlideViewPager.setAdapter(sliderAdapter);
            toLogin =(Button)findViewById(R.id.toLoginBtn);
            toLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setContentView(R.layout.activity_main);
                    startActivity(new Intent(MainActivity.this, onBoardActivity.class));
                }

            });
            addDotsIndicator(0);
            mSlideViewPager.addOnPageChangeListener(viewListener);
        }
    }

    public void addDotsIndicator(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for (int i=0;i<mDots.length;i++)
        {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length >0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.dotcolor));
        }
    }

    ViewPager.OnPageChangeListener viewListener =new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mcurrent=i;
            if (mcurrent==2)
            {
                mbtn.setEnabled(true);
                mbtn.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}