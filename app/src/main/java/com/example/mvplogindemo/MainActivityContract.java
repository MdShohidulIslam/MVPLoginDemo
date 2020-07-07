package com.example.mvplogindemo;

public interface MainActivityContract {

    interface View{
        void onSuccess(String message);
        void onError(String message);
    }
    interface Presenter{
        void doSignIn(String email, String password);
    }
}
