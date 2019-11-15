package com.newsapp.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

public class AddDetailsActivity extends AppCompatActivity {
    private TextInputEditText etName, etEmail, etCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);
        MaterialToolbar toolbar=findViewById(R.id.toolbarDetails);
        setSupportActionBar(toolbar);
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etCountry=findViewById(R.id.etCountry);
    }

    public void submitFunction(View view) {
        String name=etName.getText().toString();
        String email=etEmail.getText().toString();
        String country=etCountry.getText().toString();
        if(!name.isEmpty()&&!email.isEmpty()&&!country.isEmpty()){
            Intent intent = new Intent();
            intent.putExtra("name",name);
            intent.putExtra("email",email);
            intent.putExtra("country",country);
            setResult(20,intent);
            finish();
        }
        else{
            Toast.makeText(this, "Fill all details", Toast.LENGTH_LONG).show();
        }
    }
}
