package com.sananda.splproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends ArrayAdapter<dataHandler> {
    private Activity context;
    private List<dataHandler> dataList;

    public DataAdapter(Activity context, List<dataHandler> dataList) {
        super(context,R.layout.sample_layout, dataList);
        this.context=context;
        this.dataList=dataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        dataHandler dataHandler= dataList.get(position);

        TextView t1=view.findViewById(R.id.readyShirtPrice);
        t1.setText("READY ITEM:" + dataHandler.getCost());


        return view;
    }
}
