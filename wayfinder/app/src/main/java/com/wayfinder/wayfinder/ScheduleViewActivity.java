package com.wayfinder.wayfinder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleViewActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ImageView schedTitle;
    ImageView schedPrev;
    ImageView schedNext;
    ImageView schedBg;
    int currentIndex = 0;
    int currentTabIndex;
    int selectedPosition;
    ViewPager mViewPager;

    List<Integer> selectedImages = new ArrayList<>(6);
    List<Integer> selectedTabs = new ArrayList<>(6);
    List<View> tabViewList = new ArrayList<>();
    CustomPagerAdapter customPagerAdapter;

    int[]colors = new int[]{Color.RED, Color.BLACK, Color.YELLOW, Color.BLUE, Color.GREEN, Color.GRAY};
    private void setupViewPager()
    {


        if(customPagerAdapter==null) {
            customPagerAdapter = new CustomPagerAdapter(this, selectedImages);
            mViewPager.setAdapter(customPagerAdapter);
            tabLayout.setupWithViewPager(mViewPager);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().hide();
        }
        else
            customPagerAdapter.notifyDataSetChanged();

        for (int i = 0; i < tabLayout.getTabCount(); i++) {

            if(selectedPosition == i)
                tabLayout.getTabAt(i).setCustomView(getPagerView(selectedTabs.get(i)));
            else
                tabLayout.getTabAt(i).setCustomView(tabViewList.get(i));
        }
    }

    private void setupTabs(int position)
    {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if(position!=i)
                tabLayout.getTabAt(i).setCustomView(tabViewList.get(i));
            else
                tabLayout.getTabAt(i).setCustomView(getPagerView(selectedTabs.get(i)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);
        mViewPager = (ViewPager) findViewById(R.id.navigationViewPager);

        tabLayout = findViewById(R.id.tabLayoutNavigation);
        //setupViewPager();
        schedNext = findViewById(R.id.scheduleNext);
        schedPrev = findViewById(R.id.schedulePrevious);
        schedTitle = findViewById(R.id.scheduleTitle);
        schedBg = findViewById(R.id.schedBg);
        schedPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex == 0)
                {
                    ScheduleViewActivity.this.finish();
                    Log.d(" home ", " home ");
                }
                else if(currentIndex == 1)
                {
                    schedThursday();
                    setupViewPager();
                }
                else if(currentIndex == 2)
                {
                    schedFriday();
                    setupViewPager();
                }
            }
        });
        schedNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex == 0)
                {
                    schedFriday();
                    setupViewPager();
                }
                else if(currentIndex == 1)
                {
                    schedSaturday();
                    setupViewPager();
                }
                else if(currentIndex == 2)
                {
                    ScheduleViewActivity.this.finish();
                    Log.d(" home ", " home ");
                }
            }
        });
        schedThursday();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectedPosition = position;
                setupViewPager();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager();

    }



    public class ViewPagerAdapter extends PagerAdapter
    {

        @Override
        public int getCount() {
            return selectedImages.size();
        }



        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return true;
        }




        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            LayoutInflater inflater = (LayoutInflater) ScheduleViewActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ImageView imageView = new ImageView(ScheduleViewActivity.this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(500,350);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundColor(colors[position]);

            container.addView(imageView);
            return imageView;
        }


    }


    private void schedThursday()
    {
        currentIndex = 0;
        currentTabIndex = 5;
        selectedImages.clear();
        selectedImages.add(R.drawable.louiecomplete);
        selectedImages.add(R.drawable.chotcomplete);
        selectedImages.add(R.drawable.marcuscomplete);
        selectedImages.add(R.drawable.sandipancomplete);
        selectedImages.add(R.drawable.boycomplete);
        selectedImages.add(R.drawable.dickcomplete);

        tabLayout.removeAllTabs();

        tabViewList.clear();
        tabViewList.add(getPagerView(R.drawable.louieunsel));
        tabViewList.add(getPagerView(R.drawable.chotunsel));
        tabViewList.add(getPagerView(R.drawable.marcusunsel));
        tabViewList.add(getPagerView(R.drawable.sandipanunsel));
        tabViewList.add(getPagerView(R.drawable.boyunsel));
        tabViewList.add(getPagerView(R.drawable.dickunsel));

        selectedTabs.clear();
        selectedTabs.add(R.drawable.louiesel);
        selectedTabs.add(R.drawable.chotsel);
        selectedTabs.add(R.drawable.marcussel);
        selectedTabs.add(R.drawable.sandipansel);
        selectedTabs.add(R.drawable.boysel);
        selectedTabs.add(R.drawable.dicksel);


        schedTitle.setImageResource(R.drawable.schedtitlethu);
        schedPrev.setImageResource(R.drawable.home);
        schedNext.setImageResource(R.drawable.next);
        schedBg.setBackground(ContextCompat.getDrawable(this, R.drawable.thuschedbg));
        //schedBg.setImageResource(R.drawable.thuschedbg);
         mViewPager.setAdapter(null);
            mViewPager.setAdapter(customPagerAdapter);
    }

    private void schedFriday()
    {
        currentIndex = 1;
        currentTabIndex = 3;
        selectedImages.clear();
        selectedImages.add(R.drawable.merleecomplete);
        selectedImages.add(R.drawable.cheukcomplete);
        selectedImages.add(R.drawable.simoncomplete);
        selectedImages.add(R.drawable.arielcomplete);

        tabLayout.removeAllTabs();


        tabViewList.clear();
        tabViewList.add(getPagerView(R.drawable.merleeunsel));
        tabViewList.add(getPagerView(R.drawable.cheukunsel));
        tabViewList.add(getPagerView(R.drawable.simonunsel));
        tabViewList.add(getPagerView(R.drawable.arielunsel));


        selectedTabs.clear();
        selectedTabs.add(R.drawable.merleesel);
        selectedTabs.add(R.drawable.cheuksel);
        selectedTabs.add(R.drawable.simonsel);
        selectedTabs.add(R.drawable.arielsel);



        schedTitle.setImageResource(R.drawable.schedtitlefri);
        schedPrev.setImageResource(R.drawable.previous);
        schedNext.setImageResource(R.drawable.next);
        schedBg.setBackground(ContextCompat.getDrawable(this, R.drawable.frischedbg));
        mViewPager.setAdapter(null);
        mViewPager.setAdapter(customPagerAdapter);
    }

    private void schedSaturday()
    {
        currentIndex = 2;
        currentTabIndex = 2;
        selectedImages.clear();
        selectedImages.add(R.drawable.charlescomplete);
        selectedImages.add(R.drawable.emilycomplete);
        selectedImages.add(R.drawable.tomcomplete);
        tabLayout.removeAllTabs();


        tabViewList.clear();
        tabViewList.add(getPagerView(R.drawable.charlesunsel));
        tabViewList.add(getPagerView(R.drawable.emilyunsel));
        tabViewList.add(getPagerView(R.drawable.tomunsel));

        selectedTabs.clear();
        selectedTabs.add(R.drawable.charlessel);
        selectedTabs.add(R.drawable.emilysel);
        selectedTabs.add(R.drawable.tomsel);

        schedTitle.setImageResource(R.drawable.schedtitlesat);
        schedPrev.setImageResource(R.drawable.previous);
        schedNext.setImageResource(R.drawable.home);
        schedBg.setBackground(ContextCompat.getDrawable(this, R.drawable.satschedbg));
        mViewPager.setAdapter(null);
        mViewPager.setAdapter(customPagerAdapter);
    }

    public View getPagerView(int resource)
    {
        View view = getLayoutInflater().inflate(R.layout.customtablayout, null);
        view.findViewById(R.id.icon).setBackgroundResource(resource);
        return view;
    }

}
