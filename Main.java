package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    public EditText content, name;
    public Button writeF,readF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (EditText) findViewById(R.id.fileC);
        name = (EditText) findViewById(R.id.fileN);
        writeF = (Button) findViewById(R.id.write);
        readF = (Button) findViewById(R.id.read);

        writeF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToFile(name.getText().toString(),content.getText().toString());
            }
        });

        readF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReadActivity.class);
                intent.putExtra("ReadFile",name.getText().toString());
                startActivity(intent);
            }
        });
    }
    public void writeToFile(String FileName, String Contents){
        File path = getApplicationContext().getFilesDir();
        try{
            FileOutputStream writer = new FileOutputStream(new File(path,FileName));
            writer.write(Contents.getBytes());
            writer.close();
            Toast.makeText(getApplicationContext(), "Written to FIle :"+  path + "/" + FileName, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
