package com.example.it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView summa, period, monthpay, rate;
    SeekBar seekBar,seekBar2,seekBar3,seekBar4;
    Button btn;
    private double res;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar)findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar)findViewById(R.id.seekBar4);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar4.setOnSeekBarChangeListener(this);

        summa = (TextView) findViewById(R.id.textView);
        summa.setText("0");
        period = (TextView) findViewById(R.id.textView2);
        period.setText("0");
        monthpay = (TextView) findViewById(R.id.textView3);
        monthpay.setText("0");
        rate = (TextView) findViewById(R.id.textView8);
        rate.setText("0");

        btn = (Button) findViewById(R.id.count);
        intent = new Intent(this, InfoActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt(summa.getText().toString());
                int per = Integer.parseInt(period.getText().toString());
                int pay = Integer.parseInt(monthpay.getText().toString());
                double percent = Integer.parseInt(rate.getText().toString());
                res=sum;
                res =res * (1 + percent/1200);
                for(int i = 1;i < per;i++){
                    res =(res+pay) * (1 + percent/1200);
                }
                intent.putExtra("ccc",Integer.toString((int) Math.floor(res)));
                intent.putExtra("sss",Integer.toString((int)(res-sum-pay*(per-1))));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        update();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void update(){
        summa.setText(String.valueOf(seekBar.getProgress()*1000));
        period.setText(String.valueOf(seekBar2.getProgress()));
        monthpay.setText(String.valueOf(seekBar3.getProgress()*1000));
        rate.setText(String.valueOf(seekBar4.getProgress()));
    }
}