package com.example.bg.mybooks;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;


public class onBoardActivity extends AppCompatActivity {


    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private slider sliderAdapter;
    private TextView[] mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        mSlideViewPager=(ViewPager)findViewById(R.id.screen);
        mDotLayout=(LinearLayout)findViewById(R.id.dots);

        sliderAdapter= new slider(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
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
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}