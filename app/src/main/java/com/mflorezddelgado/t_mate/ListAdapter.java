package com.mflorezddelgado.t_mate;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<Teams> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<Teams> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_teams, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Teams> items){ mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, desc, member;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.IconImageView);
            name = itemView.findViewById(R.id.nameTeam);
            desc = itemView.findViewById(R.id.descTeam);
            member = itemView.findViewById(R.id.memberTeam);
        }

        void bindData(final Teams item){
            iconImage.setImageResource(item.getImage());
            name.setText(item.getName());
            desc.setText(item.getDesc());
            member.setText(item.getMember());
        }
    }

}
