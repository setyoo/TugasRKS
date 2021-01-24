package com.example.aplikasiperpusku;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    EditText username, password;
    Button login, ulang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.pass);
        login = (Button)findViewById(R.id.masuk);
        ulang = (Button)findViewById(R.id.reset);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_input = username.getText().toString();
                String password_input = password.getText().toString();

                if (username_input.equals("admin"))
                {
                    if (password_input.equals("admin"))
                    {
                        Intent intent = new Intent(login.this, menu.class);
                        startActivity(intent);
                    } else
                    {
                        password.setError("Password Salah!");
                    }
                } else {
                    username.setError("Username Salah!");
                }
            }
        });

        ulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
            }
        });
    }
}

