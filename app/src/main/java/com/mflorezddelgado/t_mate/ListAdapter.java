package com.mflorezddelgado.t_mate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TeamsViewHolder>{
    private ArrayList<Teams> teamsList;
    //private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(ArrayList<Teams> teamsList, Context context) {
        this.teamsList = teamsList;
        this.context = context;
    }


    @NonNull
    @Override
    public ListAdapter.TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_teams,parent,false);

        return new TeamsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.TeamsViewHolder holder, int position) {
        Teams teams = teamsList.get(position);

        holder.nameTeam.setText(teams.name);
        holder.descTeam.setText(teams.desc);
        holder.memberTeam.setText(teams.member);

    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public static class TeamsViewHolder extends RecyclerView.ViewHolder{

        TextView nameTeam, descTeam, memberTeam;
        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTeam = itemView.findViewById(R.id.tvNameTeam);
            descTeam = itemView.findViewById(R.id.tvDescTeam);
            memberTeam = itemView.findViewById(R.id.tvMemberTeam);
        }
    }
}
