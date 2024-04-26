package com.example.swapnilsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mobileNo, message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNo = findViewById(R.id.mobileNo);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send_btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMS();
            }
        });
    }

    private void sendSMS() {
        String number = mobileNo.getText().toString();
        String msg = message.getText().toString();

        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, it, PendingIntent.FLAG_IMMUTABLE);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, msg, pi, null);

        Toast.makeText(getApplicationContext(), "Message sent successfully!", Toast.LENGTH_SHORT).show();
    }
}
