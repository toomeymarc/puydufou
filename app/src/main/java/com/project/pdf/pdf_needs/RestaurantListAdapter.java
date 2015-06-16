package com.project.pdf.pdf_needs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pdf.pdf_activity.R;

import java.util.List;

/**
 * Created by Jordan on 15/06/2015.
 */
public class RestaurantListAdapter extends BaseAdapter {
    private List<Restaurants> listRestaurant = null;
    LayoutInflater layoutInflater;
    Context context;

    public RestaurantListAdapter(Context context, List<Restaurants> listRestaurant){
        this.listRestaurant = listRestaurant;
        layoutInflater = LayoutInflater.from(context);
        this.listRestaurant = listRestaurant;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listRestaurant.size();
    }

    @Override
    public Object getItem(int position) {
        return listRestaurant.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.restaurant_row, null);
            holder = new ViewHolder();

            holder.nomView = (TextView) convertView.findViewById(R.id.name);
            holder.pictureView = (ImageView) convertView.findViewById(R.id.picture);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.nomView.setText(listRestaurant.get(position).getName());
        holder.pictureView.setBackground(listRestaurant.get(position).getPicture());
        return convertView;
    }
}
