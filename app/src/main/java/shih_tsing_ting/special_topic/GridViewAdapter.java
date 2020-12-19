package shih_tsing_ting.special_topic;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class GridViewAdapter extends BaseAdapter {
     Context mContext;
     ArrayList<Measure>measureArray;
     ArrayList<HashMap<String,Object>> notes;

    public GridViewAdapter(Context context, ArrayList<Measure> measureArray)
    {
        super();
        this.mContext=context;
        this.measureArray=measureArray;
    }
    @Override
    public int getCount() {
        return measureArray.size();
    }

    @Override
    public Object getItem(int position) {
        return measureArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.measure_item,parent,false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.measure_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false){
            /*@Override
            public boolean canScrollHorizontally() {
                return false;
            }*/
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL));
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(mContext,measureArray.get(position),position);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}
