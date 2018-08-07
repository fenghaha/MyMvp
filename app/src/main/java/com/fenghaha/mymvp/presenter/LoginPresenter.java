package com.fenghaha.mymvp.presenter;

import com.fenghaha.mymvp.Bean.Student;
import com.fenghaha.mymvp.model.LoginModel;
import com.fenghaha.mymvp.view.LoginView;

/**
 * Created by FengHaHa on2018/6/15 0015 20:08
 */
public class LoginPresenter implements MvpCallBack<Student> {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    public void login(String username, String password) {
        loginView.showLoading();
        loginModel.login(username, password, this);
    }

    @Override
    public void onSuccess(Student data) {
        loginView.hideLoading();
        loginView.showToast("欢迎"+data.getName()+"登陆成功!");
        loginView.completeLogin();
    }

    @Override
    public void onFailure(String msg) {
        loginView.hideLoading();
        loginView.showToast(msg);
    }

    @Override
    public void onError() {
        loginView.hideLoading();
        loginView.showToast("登录失败!");
    }

    @Override
    public void onComplete() {
        loginView.hideLoading();
    }
}
