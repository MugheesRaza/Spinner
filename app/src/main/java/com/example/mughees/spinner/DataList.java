package com.example.mughees.spinner;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Mughees on 24-Feb-2018.
 */

public class DataList extends ArrayAdapter<Data>{
    private Activity context;
    private List<Data> dataList;
    public DataList(Activity context, List<Data> dataList)
    {
        super(context, R.layout.list_layout,dataList);
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View LisItemView  = inflater.inflate(R.layout.list_layout,null,true);
        TextView textSp1 = (TextView)LisItemView.findViewById(R.id.text_view_sp1);
        TextView textSp2 = (TextView)LisItemView.findViewById(R.id.text_view_sp2);
        TextView textSp3 = (TextView)LisItemView.findViewById(R.id.text_view_sp3);
        TextView textSp4 = (TextView)LisItemView.findViewById(R.id.text_view_sp4);

        Data data = dataList.get(position);
        textSp1.setText(data.getSpi1());
        textSp2.setText(data.getSpi2());
        textSp3.setText(data.getSpi3());
        textSp4.setText(data.getSpi4());
        return LisItemView;
    }
}
