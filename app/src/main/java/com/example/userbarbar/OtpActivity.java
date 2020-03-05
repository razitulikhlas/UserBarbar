package com.example.userbarbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OtpActivity extends AppCompatActivity {

    private TextView time_otp;
    private Button btn_resend_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        time_otp = (TextView) findViewById(R.id.tv_time_otp);
        btn_resend_otp = findViewById(R.id.btn_resend_otp);
        btn_resend_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time_otp.setVisibility(View.VISIBLE);
                timer();
            }
        });

        timer();
    }

    private void timer() {
        btn_resend_otp.setVisibility(View.GONE);
        new CountDownTimer(6000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time_otp.setText(""+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                time_otp.setText("0");
                time_otp.setVisibility(View.GONE);
                btn_resend_otp.setVisibility(View.VISIBLE);
                Toast.makeText(OtpActivity.this, "Selamat Bergabung Razitul Ikhlas", Toast.LENGTH_LONG
                ).show();
            }
        }.start();
    }
}
