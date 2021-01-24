package com.example.aplikasiperpusku;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class tambahdata extends AppCompatActivity {

    Button btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihdata);

        btn1=(Button)findViewById(R.id.lihat);
        btn2=(Button)findViewById(R.id.tambah);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent (tambahdata.this, MainActivity.class );
                startActivity ( inte );

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent (tambahdata.this, Create.class );
                startActivity ( inte );

            }
        });

    }
}

