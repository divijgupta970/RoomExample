package com.newsapp.roomexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.newsapp.roomexample.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Student> studentList=new ArrayList<>();
    private RecyclerView recyclerView;
    private StudentsAdapter adapter;
    private StudentsDatabase database;
    private MainActivityClickHandler handlers;
    private ActivityMainBinding activityMainBinding;
    private static final int REQUESTCODE=10;
    private static final int RESULTCODE=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        handlers=new MainActivityClickHandler(this);
        activityMainBinding.setClickHandler(handlers);

        adapter=new StudentsAdapter(studentList,getApplicationContext());

        recyclerView=findViewById(R.id.recyclerViewMain);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                new DeleteStudentAsyncTask().execute(studentList.get(viewHolder.getAdapterPosition()));
                studentList.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);

        database= Room.databaseBuilder(getApplicationContext(),StudentsDatabase.class,"StudentsDB").build();
        new GetAllStudentsAsyncTask().execute();

        MaterialToolbar toolbar=findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUESTCODE&&resultCode==RESULTCODE){
            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c);
            Student student=new Student(0,data.getStringExtra("name"),data.getStringExtra("email"),formattedDate,data.getStringExtra("country"));
            new CreateStudentAsyncTask().execute(student);
        }
    }

    private class GetAllStudentsAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            studentList.addAll(database.getStudentDAO().getStudents());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            adapter.notifyDataSetChanged();
        }
    }
    private class CreateStudentAsyncTask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            long id = database.getStudentDAO().addStudent(students[0]);
            Student student = database.getStudentDAO().getStudent(id);
            if(student!=null){
                studentList.add(student);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }
    private class DeleteStudentAsyncTask extends AsyncTask <Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            database.getStudentDAO().deleteStudent(students[0]);
            return null;
        }
    }
    public class MainActivityClickHandler{
        private Context context;

        public MainActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onFABClicked(View view){
            startActivityForResult(new Intent(MainActivity.this,AddDetailsActivity.class),REQUESTCODE);
        }
    }
}
