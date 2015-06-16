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
public class SpectaclesListAdapter extends BaseAdapter {
    private List<Spectacles> listSpectacles = null;
    LayoutInflater layoutInflater;
    Context context;

    public SpectaclesListAdapter(Context context, List<Spectacles> listSpectacles){
        this.listSpectacles = listSpectacles;
        layoutInflater = LayoutInflater.from(context);
        this.listSpectacles = listSpectacles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listSpectacles.size();
    }

    @Override
    public Object getItem(int position) {
        return listSpectacles.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.spectacles_row, null);
            holder = new ViewHolder();

            holder.nomView = (TextView) convertView.findViewById(R.id.name);
            holder.debutView = (TextView) convertView.findViewById(R.id.debut);
            holder.dureeView = (TextView) convertView.findViewById(R.id.duree);
            holder.pictureView = (ImageView) convertView.findViewById(R.id.picture);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.nomView.setText(listSpectacles.get(position).getName());
        holder.debutView.setText(listSpectacles.get(position).getDebut());
        holder.dureeView.setText(listSpectacles.get(position).getDuree());
        holder.pictureView.setBackground(listSpectacles.get(position).getPicture());
        return convertView;
    }
}
