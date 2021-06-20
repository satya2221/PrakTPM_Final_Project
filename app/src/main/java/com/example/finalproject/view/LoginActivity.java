package com.example.finalproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.view.activity.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password;
    private Button button_login;
    SharedPreferences sharedPreferences;

    private static final String shared_pref_name = "mypref";
    private static final String key_uname = "username";
    private static final String key_pass = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button_login = findViewById(R.id.button_login);

        sharedPreferences = getSharedPreferences(shared_pref_name, MODE_PRIVATE);

        String name = sharedPreferences.getString(key_uname, null);

        if(name != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Isi namanya", Toast.LENGTH_LONG).show();
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(key_uname, username.getText().toString());
                    editor.putString(key_pass, password.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}