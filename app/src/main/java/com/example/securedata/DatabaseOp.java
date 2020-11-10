package com.example.securedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOp extends SQLiteOpenHelper {

    private static DatabaseOp instance;

    static String DATABASE_NAME = "Test_Database.db";
    String password = "Deep";

    static public synchronized DatabaseOp getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseOp(context);
        }
        return instance;
    }

    public DatabaseOp(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createAllTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Student");
    }

    public void createAllTable(SQLiteDatabase db) {
        String CREATE_COLOR_PORTFOLIO_TABLE = "CREATE TABLE Student (Name INTEGER PRIMARY KEY,Sirname TEXT)";
        db.execSQL(CREATE_COLOR_PORTFOLIO_TABLE);
    }

    public void insertData(String name,String sirname){
       //  SQLiteDatabase db = instance.getWritableDatabase(password);
       SQLiteDatabase db = this.getWritableDatabase();


                    ContentValues contentCombinationValues = new ContentValues();
                    contentCombinationValues.put("Name", name);
                    contentCombinationValues.put("Sirname", sirname);
                    db.insert("Student", null, contentCombinationValues);

    }

}
