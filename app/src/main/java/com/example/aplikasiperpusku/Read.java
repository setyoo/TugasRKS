package com.example.aplikasiperpusku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Read extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button back,pesan;
    TextView nim2, nama2, buku2, tglpinjam2, tglkembali2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        dbHelper = new DataHelper(this);
        nim2 = (TextView) findViewById(R.id.nim_lihat);
        nama2 = (TextView)findViewById(R.id.nama_lihat);
        buku2 = (TextView)findViewById(R.id.buku_lihat);
        tglpinjam2 = (TextView)findViewById(R.id.tglpinjam_lihat);
        tglkembali2 = (TextView)findViewById(R.id.tglkembali_lihat);
        back = (Button)findViewById(R.id.kembali_lihat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM perpusku WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            nim2.setText(cursor.getString(0).toString());
            nama2.setText(cursor.getString(1).toString());
            buku2.setText(cursor.getString(2).toString());
            tglpinjam2.setText(cursor.getString(3).toString());
            tglkembali2.setText(cursor.getString(4).toString());
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
