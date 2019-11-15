package com.newsapp.roomexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>{

    private List<Student> studentList;
    private Context mCtx;

    public StudentsAdapter(List<Student> studentList, Context mCtx) {
        this.studentList = studentList;
        this.mCtx = mCtx;
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder{

        private TextView name, email, date, country;
        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.tvName);
            email=itemView.findViewById(R.id.tvEmail);
            date=itemView.findViewById(R.id.tvDate);
            country=itemView.findViewById(R.id.tvCountry);

        }
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_main, parent, false);
        return new StudentsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {

        holder.name.setText(studentList.get(position).getName());
        holder.email.setText(studentList.get(position).getEmail());
        holder.date.setText(studentList.get(position).getDate());
        holder.country.setText(studentList.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

}
