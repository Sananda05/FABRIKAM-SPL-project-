package com.sananda.splproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static com.sananda.splproject.R.*;

public class FabricDataAdapter extends ArrayAdapter<FabricDataHandler> {
    private Activity context;
    private List<FabricDataHandler> dataList;

    public FabricDataAdapter(Activity context, List<FabricDataHandler> dataList) {
        super(context, layout.sample_layout_for_custom, dataList);
        this.context=context;
        this.dataList=dataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(layout.sample_layout_for_custom, null, true);

        FabricDataHandler fabricDataHandler = dataList.get(position);

        TextView t2=view.findViewById(R.id.fabric);
        t2.setText("SHIRT DESIGN:" + fabricDataHandler.getTag());

        /*TextView t3=view.findViewById(R.id.sleeve);
        t3.setText("SLEEVE:" + fabricDataHandler.getTag());

        TextView t4=view.findViewById(R.id.pocket);
        t4.setText("POCKET:" + fabricDataHandler.getTag());*/

        return view;

    }

    }
