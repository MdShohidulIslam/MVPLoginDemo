package com.example.mvplogindemo;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doSignIn(String email, String password) {

        // email test@gmail.com
        // password 1234

        if(email.equals("test@gmail.com") && password.equals("1234")){
            view.onSuccess("Sign In Successful");

        }
        else{
            view.onError("Wrong Email or Password");
        }

    }
}
