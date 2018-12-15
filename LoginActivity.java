package com.krishna.instagramclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLoginEmail, edtLoginPassword;
    private Button btnInstaLogin,btnInstaSignUp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        edtLoginEmail = findViewById(R.id.edtLoginEmail);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);

        btnInstaLogin = findViewById(R.id.btnInstaLogin);
        btnInstaSignUp = findViewById(R.id.btnInstaSignUp);

        btnInstaSignUp.setOnClickListener(this);
        btnInstaLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case  R.id.btnInstaLogin :
                ParseUser.logInInBackground(edtLoginEmail.getText().toString(), edtLoginPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!= null && e == null){
                            Toast.makeText(LoginActivity.this,user.getUsername()+"",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            break;

            case R.id.btnInstaSignUp :
                break;


        }
    }
}
