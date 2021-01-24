package com.example.aplikasiperpusku;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button save, back;
    TextView nim3, nama3, buku3, tglpinjam3, tglkembali3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DataHelper(this);
        nim3 = (EditText)findViewById(R.id.nim_update);
        nama3 = (EditText)findViewById(R.id.nama_update);
        buku3 = (EditText)findViewById(R.id.buku_update);
        tglpinjam3 = (EditText)findViewById(R.id.tglpinjam_update);
        tglkembali3 = (EditText)findViewById(R.id.tglkembali_update);
        save = (Button)findViewById(R.id.simpan_update);
        back = (Button)findViewById(R.id.kembali_update);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM perpusku WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            nim3.setText(cursor.getString(0).toString());
            nama3.setText(cursor.getString(1).toString());
            buku3.setText(cursor.getString(2).toString());
            tglpinjam3.setText(cursor.getString(3).toString());
            tglkembali3.setText(cursor.getString(4).toString());
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update perpusku set nama='"+
                        nama3.getText().toString() +"', buku='" +
                        buku3.getText().toString()+"', tglpinjam='"+
                        tglpinjam3.getText().toString() +"', tglkembali='" +
                        tglkembali3.getText().toString() + "' where no='" + nim3.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
