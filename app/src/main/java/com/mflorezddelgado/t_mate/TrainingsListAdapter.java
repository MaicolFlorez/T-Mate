package com.mflorezddelgado.t_mate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainingsListAdapter extends RecyclerView.Adapter<TrainingsListAdapter.TrainingsViewHolder> {

    private ArrayList<Entrenamiento> trainingList;
    private Context trContext;

    public TrainingsListAdapter(ArrayList<Entrenamiento> trainingList, Context trContext) {
        this.trainingList = trainingList;
        this.trContext = trContext;
    }

    @NonNull
    @Override
    public TrainingsListAdapter.TrainingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(trContext).inflate(R.layout.trainings_card,parent,false);

        return new TrainingsListAdapter.TrainingsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingsListAdapter.TrainingsViewHolder holder, int position) {
        Entrenamiento entrenamiento = trainingList.get(position);

        holder.trainTitle.setText(entrenamiento.titulo);
        holder.trainDesc.setText(entrenamiento.descripcion);
        holder.trainCaract.setText(entrenamiento.caracteristicas);
    }

    @Override
    public int getItemCount() {
        return trainingList.size();
    }

    public static class TrainingsViewHolder extends RecyclerView.ViewHolder{
        TextView trainTitle, trainDesc, trainCaract;
        public TrainingsViewHolder(@NonNull View itemView) {
            super(itemView);
            trainTitle = itemView.findViewById(R.id.tvTrainTitle);
            trainDesc = itemView.findViewById(R.id.tvTrainDesc);
            trainCaract = itemView.findViewById(R.id.tvTrainCaract);
        }
    }
}
