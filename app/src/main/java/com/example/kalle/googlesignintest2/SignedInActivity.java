package com.example.kalle.googlesignintest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.R.attr.data;

public class SignedInActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView welcomeString;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String dName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);
        findViewById(R.id.signOutBtn).setOnClickListener(this);
        welcomeString = (TextView)findViewById(R.id.welcomeTV);
        welcomeString.setText("Welcome " + user.getDisplayName());

        Button signInButton = (Button) findViewById(R.id.signOutBtn);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.signOutBtn:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this,MainActivity.class);
                Bundle extras = new Bundle();
                startActivity(intent);
                break;
        }
    }
}
