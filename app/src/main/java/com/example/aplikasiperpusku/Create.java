package com.example.aplikasiperpusku;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Create extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button save, back;
    EditText nim1, nama1, buku1, tglpinjam1, tglkembali1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dbHelper = new DataHelper(this);
        nim1 = (EditText)findViewById(R.id.nim);
        nama1 = (EditText)findViewById(R.id.nama);
        buku1 = (EditText)findViewById(R.id.buku);
        tglpinjam1 = (EditText)findViewById(R.id.tglpinjam);
        tglkembali1 = (EditText)findViewById(R.id.tglkembali);
        save = (Button)findViewById(R.id.simpan);
        back = (Button)findViewById(R.id.kembali);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into perpusku (nim, nama, buku, tglpinjam, tglkembali) values('" +
                        nim1.getText().toString()+"','"+
                        nama1.getText().toString() +"','" +
                        buku1.getText().toString()+"','"+
                        tglpinjam1.getText().toString() +"','" +
                        tglkembali1.getText().toString() + "')");
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
