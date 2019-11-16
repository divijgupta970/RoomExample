package com.newsapp.roomexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.newsapp.roomexample.databinding.CardViewMainBinding;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>{

    private List<Student> studentList;
    private Context mCtx;

    public StudentsAdapter(List<Student> studentList, Context mCtx) {
        this.studentList = studentList;
        this.mCtx = mCtx;
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder{

        private CardViewMainBinding cardViewMainBinding;

        public StudentsViewHolder(@NonNull CardViewMainBinding cardViewMainBinding) {
            super(cardViewMainBinding.getRoot());
            this.cardViewMainBinding=cardViewMainBinding;

        }
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardViewMainBinding cardViewMainBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.card_view_main, parent, false);
        return new StudentsViewHolder(cardViewMainBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {

        Student currStudent=studentList.get(position);
        holder.cardViewMainBinding.setStudent(currStudent);

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

}
