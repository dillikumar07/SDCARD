package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

public class ReadActivity extends AppCompatActivity {

    public TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Intent intent = getIntent();
        t1 = (TextView) findViewById(R.id.content);

      String FileName = intent.getStringExtra("ReadFile");
      String readFileContents = readFromFile(FileName);
      t1.setText(readFileContents);
    }
    public String readFromFile(String FileName){
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path+"/"+ FileName);
        byte[] contents = new byte[(int) readFrom.length()];
        try{
            FileInputStream input = new FileInputStream(readFrom);
            input.read(contents);
            return new String(contents);
        }
        catch(Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }
}
