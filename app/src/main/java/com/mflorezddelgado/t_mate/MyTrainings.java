package com.mflorezddelgado.t_mate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyTrainings extends RecyclerView.Adapter<MyTrainings.ViewHolder>{
    private List<Entrenamiento> mData;
    private LayoutInflater mInflater;
    private Context context;

    public MyTrainings(List<Entrenamiento> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public MyTrainings.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_teams, null);
        return new MyTrainings.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyTrainings.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<Entrenamiento> items){ mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView Titulo, Desc, Carac;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.IconImageView);
            Titulo = itemView.findViewById(R.id.nameTeam);
            Desc = itemView.findViewById(R.id.descTeam);
            Carac = itemView.findViewById(R.id.memberTeam);
        }

        void bindData(final Entrenamiento item){
            Titulo.setText(item.getTitulo());
            Desc.setText(item.getDescripcion());
            Carac.setText(item.getCaracteristicas());
        }
    }

}
