package com.example.bg.mybooks;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class slider extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public slider(Context context)
    {
        this.context =context;
    }
    public int[] slider_image={
            R.drawable.ic1,
            R.drawable.ic2,
            R.drawable.ic3
    };
    public  String[] slider_heading={
            "head1",
            "head2",
            "head3"

    };
    public String[] slide_desc={
            "des1",
            "des2",
            "des3"
    };
    @Override
    public int getCount() {
        return slider_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==(RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.screens,container,false);

        ImageView slideImageView =(ImageView) view.findViewById(R.id.slide_img);
        TextView slideHeading =(TextView) view.findViewById(R.id.slide_head);
        TextView slideDescription=(TextView)view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slider_image[position]);
        slideHeading.setText(slider_heading[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
