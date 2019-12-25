package com.newsapp.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.newsapp.roomexample.databinding.ActivityAddDetailsBinding;
import com.newsapp.roomexample.db.Student;

public class AddDetailsActivity extends AppCompatActivity {
    private ActivityAddDetailsBinding activityAddDetailsBinding;
    private AddDetialsActivityClickHandler handlers;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityAddDetailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_add_details);
        handlers=new AddDetialsActivityClickHandler(this);
        activityAddDetailsBinding.setClickHandler(handlers);

        student=new Student();
        activityAddDetailsBinding.setStudent(student);

    }

    public class AddDetialsActivityClickHandler{
        private Context context;

        public AddDetialsActivityClickHandler(Context context) {
            this.context = context;
        }

        public void submitClickHandler(View view){
            String name=student.getName();
            String email=student.getEmail();
            String country=student.getCountry();
            if(name!=null&&email!=null&&country!=null){
                if(!name.isEmpty()&&!email.isEmpty()&&!country.isEmpty()){
                    Intent intent = new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("email",email);
                    intent.putExtra("country",country);
                    setResult(20,intent);
                    finish();
                }
            }
            else{
                Toast.makeText(context, "Fill all details", Toast.LENGTH_LONG).show();
            }
        }
    }
}
