package com.example.aplikasiperpusku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "perpusku.db";
    private static int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "create table perpusku(nim integer primary key, nama text null, buku text null, tglpinjam text null, tglkembali text null);";
        Log.d("Data", "onCreate" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO perpusku (nim, nama, buku, tglpinjam, tglkembali) VALUES ('1800018353', 'M SETYO DWI PUTRA', 'Matematika Diskrit', '22-12-2020', '27-12-2020'),"+ "('1800018348', 'Andhi Yanto Wibowo', 'Algoritma Pemrograman', '25-12-2020', '28-12-2020'),"
                + "('1800018378', 'Ahmad Jamaluddin', 'Kalkulus Informatika', '20-12-2020', '25-12-2020'),"+ "('1800018344', 'Yunisa Apriliani', 'Pengolahan Citra', '15-12-2020', '25-12-2020'),"+ "('1800018211', 'Ilham Syahputra', 'Pemrograman Mobile', '21-12-2020', '25-12-2020'),"
                + "('1800018209', 'Annisa Putri Yulianti', 'Kalkulus Informatika', '15-12-2020', '20-12-2020');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
    {

    }
}


