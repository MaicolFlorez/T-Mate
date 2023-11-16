package com.mflorezddelgado.t_mate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventsViewHolder> {

    private ArrayList<Evento> eventList;
    private Context evContext;

    public EventListAdapter(ArrayList<Evento> eventList, Context evContext) {
        this.eventList = eventList;
        this.evContext = evContext;
    }

    @NonNull
    @Override
    public EventListAdapter.EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(evContext).inflate(R.layout.events_card,parent,false);

        return new EventListAdapter.EventsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdapter.EventsViewHolder holder, int position) {
        Evento evento = eventList.get(position);

        holder.eventTopic.setText(evento.asunto);
        holder.eventDesc.setText(evento.descripcion);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder{
        TextView eventTopic, eventDesc;
        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTopic = itemView.findViewById(R.id.tvEventTopic);
            eventDesc = itemView.findViewById(R.id.tvEventDesc);
        }
    }
}
