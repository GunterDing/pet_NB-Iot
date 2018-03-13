package com.example.hdx.pettool_nb_iot;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        android.view.View.OnClickListener{

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<View>();

    private LinearLayout mTabPosition;
    private LinearLayout mTabPets;
    private LinearLayout mTabUser;
    private ImageButton mPositionImg;
    private ImageButton mPetsImg;
    private ImageButton mUserImg;

    private MapView mMapView;
    private static BaiduMap mBaiduMap;

    private PetAdapter mPetAdapter;
    private List<petItemInfo> mPetData;
    private ListView mPetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);


        initView();
        initViewPage();
        initEachPage();
        initEvent();
    }

    private void initView(){
        mViewPager = (ViewPager)findViewById(R.id.id_viewpage);
        mTabPosition = (LinearLayout)findViewById(R.id.id_tab_map);
        mTabPets = (LinearLayout)findViewById(R.id.id_tab_pet);
        mTabUser = (LinearLayout)findViewById(R.id.id_tab_user);
        mPositionImg = (ImageButton)findViewById(R.id.id_tab_map_img);
        mPetsImg = (ImageButton)findViewById(R.id.id_tab_pet_img);
        mUserImg = (ImageButton)findViewById(R.id.id_tab_user_img);
    }

    private void initEachPage(){
        mMapView = (MapView) LayoutInflater.from(this).inflate(R.layout.position_view_layout, null).findViewById(R.id.mapView);
        mBaiduMap = mMapView.getMap();
        mPetList = (ListView) LayoutInflater.from(this).inflate(R.layout.pets_view_layout, null).findViewById(R.id.id_pet_list);
        mPetData = new LinkedList<petItemInfo>();
        mPetData.add(new petItemInfo("小美", false, R.mipmap.ic_launcher_round));
        mPetData.add(new petItemInfo("大壮", true, R.mipmap.ic_launcher_round));
        mPetData.add(new petItemInfo("二狗", false, R.mipmap.ic_launcher_round));
        mPetData.add(new petItemInfo("黄鹤楼", true, R.mipmap.ic_launcher_round));
        mPetAdapter = new PetAdapter((LinkedList<petItemInfo>) mPetData, MainActivity.this);
        mPetList.setAdapter(mPetAdapter);
    }


    private void initViewPage() {
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tabViewPosition = mLayoutInflater.inflate(R.layout.position_view_layout,null);
        View tabViewPets = mLayoutInflater.inflate(R.layout.pets_view_layout,null);
        View tabViewUser = mLayoutInflater.inflate(R.layout.user_view_layout,null);

        mViews.add(tabViewPosition);
        mViews.add(tabViewPets);
        mViews.add(tabViewUser);

        mPagerAdapter = new PagerAdapter(){
            @Override
            public void destroyItem(ViewGroup container, int position, Object object){
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position){
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1){
                return  arg0 == arg1;
            }

            @Override
            public int getCount(){
                return mViews.size();
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.id_tab_map:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.id_tab_pet:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.id_tab_user:
                mViewPager.setCurrentItem(2);
                break;
        }
    }

    private void initEvent() {
        mTabPosition.setOnClickListener(this);
        mTabPets.setOnClickListener(this);
        mTabUser.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}

