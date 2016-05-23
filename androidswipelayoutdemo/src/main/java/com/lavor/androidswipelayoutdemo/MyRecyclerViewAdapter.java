package com.lavor.androidswipelayoutdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.List;

/**
 * Created by shitian on 2016-05-22.
 */
public class MyRecyclerViewAdapter extends RecyclerSwipeAdapter<MyRecyclerViewAdapter.MyViewHolder>{
    private Context context;
    private List<String> list;
    public MyRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.surface.setText(list.get(position));
        viewHolder.bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private SwipeLayout swipeLayout;
        private Button bottom;
        private TextView surface;
        public MyViewHolder(View itemView) {
            super(itemView);
            swipeLayout=(SwipeLayout)itemView.findViewById(R.id.swipe_layout);
            bottom=(Button)itemView.findViewById(R.id.bottom);
            surface=(TextView)itemView.findViewById(R.id.surface);
        }
    }
}
