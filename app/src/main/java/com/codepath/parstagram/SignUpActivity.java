package com.codepath.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText etNewUsername;
    private EditText etPasswordOne;
    private EditText etPasswordTwo;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNewUsername = findViewById(R.id.etNewUsername);
        etPasswordOne = findViewById(R.id.etPasswordOne);
        etPasswordTwo = findViewById(R.id.etPasswordTwo);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = etNewUsername.getText().toString();
                if (etPasswordOne.getText().toString().equals(etPasswordOne.getText().toString())){
                    String password = etPasswordOne.getText().toString();
                    createUser(username, password);
                } else {
                    Toast.makeText(SignUpActivity.this, "try entering your passwords again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createUser(String username, String password) {
        Log.i(TAG, "attempting to set up: " + username);
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // successful signup
                    goLoginActivity();
                } else {
                    // unsuccessful signup
                    Log.e(TAG, "issue with creating user" + e);
                    return;
                }
            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}