package com.example.crypto_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Base64;

public class Encoder extends AppCompatActivity {
    EditText etenc;
    TextView enctv;

    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);
        etenc=findViewById(R.id.etenc);
        enctv=findViewById(R.id.enctv);
        cpb=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void enc(View view) {
        String temp = etenc.getText().toString();
        String rv = Base64.getEncoder().encodeToString(temp.getBytes());
        enctv.setText(rv);
    }
    public  void cp2(View view){
        String data=enctv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp=ClipData.newPlainText("text",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show();

        }
    }
}