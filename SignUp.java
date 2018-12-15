package com.krishna.instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private EditText edtSignUpEmail, edtSignUpUserName, edtSignUpPassword;
    private Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSignUpEmail = findViewById(R.id.edtSignUpEmail);
        edtSignUpUserName = findViewById(R.id.edtSignUpUserName);
        edtSignUpPassword = findViewById(R.id.edtSignUpPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);


        // if there is a parse user after every signup session
        // there will be tokens so not to have any problems we logout the user.

        // If parseuser.get
        if (ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }





    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnSignUp:
                final ParseUser appUser = new ParseUser();
                appUser.setEmail(edtSignUpEmail.getText().toString());
                appUser.setUsername(edtSignUpUserName.getText().toString());
                appUser.setPassword(edtSignUpPassword.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(SignUp.this,appUser.getUsername()+ "The user is successfully signed up",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SignUp.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;

            case R.id.btnLogin:

                Intent intent = new Intent(SignUp.this,LoginActivity.class);
                startActivity(intent);

                break;

        }

    }
}
