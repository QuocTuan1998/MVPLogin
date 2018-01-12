package com.example.admin.mvplogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.mvplogin.handleLogin.LoginLogicPresenterImp;
import com.example.admin.mvplogin.handleLogin.LoginView;

public class MainActivity extends AppCompatActivity
        implements LoginView,View.OnClickListener{ // implement func result and Event ClickListener

    EditText edAccount, edPassword;
    Button btnLogin;
    LoginLogicPresenterImp logicPresenterImp; // declare Object presenter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        edAccount = findViewById(R.id.edAccount);
        edPassword = findViewById(R.id.edPassWord);
        // new Object (Constructor) because we implement View so we just reference that View
        logicPresenterImp = new LoginLogicPresenterImp(this);
        btnLogin.setOnClickListener(this); // Even Button Click Listener
    }

    @Override
    public void onClick(View view) {
//        get Account and Password
        String account = edAccount.getText().toString();
        String password = edPassword.getText().toString();
//        call func Logic
        logicPresenterImp.handleLogin(account, password);
    }

    @Override
    public void loginSuccess() {
//        because we call this func in Handle Logic so we don't need call it again
        Toast.makeText(MainActivity.this, "Login Success !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Login Failed ! ", Toast.LENGTH_SHORT).show();
    }
}
