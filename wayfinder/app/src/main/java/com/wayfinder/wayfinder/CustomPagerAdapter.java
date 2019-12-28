package com.wayfinder.wayfinder;

import android.content.Context;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    List<Integer> resourceList = new ArrayList<>();
    public CustomPagerAdapter(Context context) {
        mContext = context;
    }


    public CustomPagerAdapter(Context context, List<Integer> resourceList)
    {
        this.resourceList = resourceList;
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ImageView layout = (ImageView) inflater.inflate(R.layout.custom_speaker_layout, collection, false);
        layout.setBackground(ContextCompat.getDrawable(mContext, resourceList.get(position)));
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return resourceList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return "";
    }


}
