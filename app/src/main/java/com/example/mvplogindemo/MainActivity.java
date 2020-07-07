package com.example.mvplogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    MainActivityContract.Presenter presenter;

    private TextView etEmail, etPassword;
    private Button signInBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remove the title bar
        getSupportActionBar().hide();

        //Remove the Notification Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        presenter=new MainActivityPresenter(this);

        etEmail=findViewById(R.id.etEmail_id);
        etPassword=findViewById(R.id.etPassword_id);

        signInBtn=findViewById(R.id.signIn_btn_id);
        clearBtn=findViewById(R.id.clear_btn_id);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // validate inputs
                String email1=etEmail.getText().toString();
                String password1=etPassword.getText().toString();

                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                    onError("Field's Reqired");
                }
                else{
                    presenter.doSignIn(email1,password1);

                    Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    etEmail.setText("");
                    etPassword.setText("");
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etEmail.setText("");
                etPassword.setText("");

            }
        });

    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
