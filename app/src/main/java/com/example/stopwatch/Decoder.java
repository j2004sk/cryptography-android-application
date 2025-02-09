package com.example.stopwatch;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Decoder extends AppCompatActivity {

    EditText etdec;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_decoder);

        etdec=findViewById(R.id.etdec);
        dectv=findViewById(R.id.dectv);
        cplboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

    }
    public void dec(View view)
    {
        String temp=etdec.getText().toString();
        String rv=decode.dec(temp);
        dectv.setText(rv);
    }
    public void cpl(View view)
    {
        String data=dectv.getText().toString().trim();
        if(!data.isEmpty())
        {
            ClipData temp=ClipData.newPlainText("text",data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }
}