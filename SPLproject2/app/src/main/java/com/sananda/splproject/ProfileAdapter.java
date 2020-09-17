package com.sananda.splproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProfileAdapter extends ArrayAdapter <ProfileData>
{
    private Activity context;
    private List<ProfileData> profileList;

    public ProfileAdapter(Activity context,List<ProfileData> profileList)
    {
        super(context,R.layout.sample_profile,profileList);
        this.context=context;
        this.profileList=profileList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_profile,null,true);

        ProfileData profileData= profileList.get(position);

        TextView t1=view.findViewById(R.id.name);
        t1.setText("NAME :" + profileData.getName());

        TextView t2=view.findViewById(R.id.address);
        t2.setText("ADDRESS :" + profileData.getAddress());

        TextView t3=view.findViewById(R.id.phone);
        t3.setText("PHONE :" + profileData.Phone);

        TextView t4=view.findViewById(R.id.length);
        t4.setText("LENGHT"+ profileData.getLength());

        TextView t5=view.findViewById(R.id.Body);
        t5.setText("BODY : "+profileData.getBody());
        return view;
    }
}
