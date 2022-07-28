package com.example.cardiacrecorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList m_id, m_time, m_date, m_sp, m_dp, m_hr, m_cmt;

    CustomAdapter(Activity activity, Context context, ArrayList m_id, ArrayList m_time, ArrayList m_date,
                  ArrayList m_sp, ArrayList m_dp, ArrayList m_hr, ArrayList m_cmt){
        this.activity = activity;
        this.context = context;
        this.m_id = m_id;
        this.m_time = m_time;
        this.m_date = m_date;
        this.m_sp = m_sp;
        this.m_dp = m_dp;
        this.m_hr = m_hr;
        this.m_cmt = m_cmt;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.m_id_txt.setText(String.valueOf(m_id.get(position)));
        holder.m_time_txt.setText(String.valueOf(m_time.get(position)));
        holder.m_date_txt.setText(String.valueOf(m_date.get(position)));
        holder.m_sp_txt.setText(String.valueOf(m_sp.get(position)));
        holder.m_dp_txt.setText(String.valueOf(m_dp.get(position)));
        holder.m_hr_txt.setText(String.valueOf(m_hr.get(position)));
        holder.m_cmt_txt.setText(String.valueOf(m_cmt.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(m_id.get(position)));
                intent.putExtra("title", String.valueOf(m_time.get(position)));
                intent.putExtra("author", String.valueOf(m_date.get(position)));
                intent.putExtra("pages", String.valueOf(m_sp.get(position)));
                intent.putExtra("title", String.valueOf(m_dp.get(position)));
                intent.putExtra("author", String.valueOf(m_hr.get(position)));
                intent.putExtra("pages", String.valueOf(m_cmt.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return m_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView m_id_txt, m_time_txt, m_date_txt, m_sp_txt, m_dp_txt, m_hr_txt, m_cmt_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            m_id_txt = itemView.findViewById(R.id.m_id);
            m_time_txt = itemView.findViewById(R.id.m_date);
            m_date_txt = itemView.findViewById(R.id.m_time);
            m_sp_txt = itemView.findViewById(R.id.m_sp);
            m_dp_txt = itemView.findViewById(R.id.m_dp);
            m_hr_txt = itemView.findViewById(R.id.m_hr);
            m_cmt_txt = itemView.findViewById(R.id.m_cmt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview

        }

    }

}
