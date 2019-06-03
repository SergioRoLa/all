package com.example.sergiorl.scheduleweb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    private View.OnClickListener listener;

    ArrayList<Assignatures> assignaturesArrayList;
    public Adaptador(ArrayList<Assignatures> assignaturesArrayList) {
        this.assignaturesArrayList = assignaturesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.assignature, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (hour >= assignaturesArrayList.get(i).getInitHour() && hour < assignaturesArrayList.get(i).getEndHour()){
            viewHolder.itemView.setBackgroundResource(R.drawable.custom_style_textview_selected);
        } else {
            viewHolder.itemView.setBackgroundResource(R.drawable.custom_style_textview_unselected);
        }
        viewHolder.tagAssignature.setText(assignaturesArrayList.get(i).getAssignature());
    }

    public int getItemCount(){
        return assignaturesArrayList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public void onClick(View v){
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tagAssignature;
        public ViewHolder(View view){
            super(view);
            tagAssignature = (TextView) view.findViewById(R.id.assignature);
        }
    }

}

