package com.example.securedata;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseOp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase.loadLibs(this);
        db = new DatabaseOp(MainActivity.this);

        db.insertData("Deepali","Shinde");

       // android.database.sqlite.SQLiteDatabase db = DatabaseOp.getInstance(this).getWritableDatabase("somePass");

    }
}