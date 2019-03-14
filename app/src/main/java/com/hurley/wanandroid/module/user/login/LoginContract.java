package com.hurley.wanandroid.module.user.login;


import com.hurley.wanandroid.base.BaseContract;
import com.hurley.wanandroid.bean.UserBean;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/2 1:45 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 登录 Contract类
 * </pre>
 */
public interface LoginContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<LoginContract.View> {
        void login(String username, String password);
    }
}
