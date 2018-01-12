package com.example.admin.mvplogin.handleLogin;

/**
 * Handle Logic Listener(Coding)
 */

public class LoginLogicPresenterImp implements OnLoginPresenter{

    LoginView loginView; // Object to do something when check condition

    public LoginLogicPresenterImp(LoginView loginView){
        this.loginView = loginView; // Constructor to call func HandleLogin when we implement viewInterface
    }

    @Override
    public void handleLogin(String name, String password) { // handle Logic (Account Pass and we get in EditText)
        if (name.equals("admin") && password.equals("123")){
            loginView.loginSuccess(); // call viewInterface method
        }else {
            loginView.loginFail();  // call viewInterface method
        }
    }
}
