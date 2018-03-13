package com.example.hdx.pettool_nb_iot;

/*
 * Created by hdx on 2018/3/8.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class PetAdapter extends BaseAdapter{
    private LinkedList<petItemInfo> mPetData;
    private Context mContext;

    public PetAdapter(LinkedList<petItemInfo> mPetData, Context mContext){
        this.mPetData = mPetData;
        this.mContext = mContext;
    }

    @Override
    public int getCount(){
        return mPetData.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(mContext).inflate(R.layout.pet_list_item,parent,false);
        ImageView petImg = (ImageView) convertView.findViewById(R.id.pet_img);
        TextView petName = (TextView) convertView.findViewById(R.id.pet_name);
        TextView petStatus = (TextView) convertView.findViewById(R.id.pet_status);
        petImg.setBackgroundResource(mPetData.get(position).getPetImg());
        petName.setText(mPetData.get(position).getPetName());
        petStatus.setText(mPetData.get(position).getStatus());
        return convertView;
    }
}
