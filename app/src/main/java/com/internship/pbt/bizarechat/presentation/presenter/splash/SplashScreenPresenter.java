package com.internship.pbt.bizarechat.presentation.presenter.splash;

import com.internship.pbt.bizarechat.presentation.presenter.Presenter;


public interface SplashScreenPresenter extends Presenter {

    void reSignIn();

    void onLoginSuccess();

    void onLoginFailure();
}
