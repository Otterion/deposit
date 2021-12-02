package com.example.it;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView tv, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv = findViewById(R.id.result);
        tv2 = findViewById(R.id.profit);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            tv.setText(bundle.getString("ccc"));
            tv2.setText(bundle.getString("sss"));
        }
    }
}