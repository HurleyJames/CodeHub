package com.hurley.wanandroid.module.user;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.hurley.wanandroid.R;
import com.hurley.wanandroid.api.PathContainer;
import com.hurley.wanandroid.app.Constants;
import com.hurley.wanandroid.base.BaseFragment;
import com.hurley.wanandroid.event.LoginEvent;
import com.hurley.wanandroid.event.LogoutEvent;
import com.hurley.wanandroid.module.main.HomeActivity;
import com.hurley.wanandroid.module.user.login.LoginActivity;
import com.hurley.wanandroid.net.CookiesManager;
import com.hurley.wanandroid.net.callback.RxBus;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * <pre>
 *      @author hurley
 *      date   : 2018/11/19 下午7:20
 *      github : https://github.com/HurleyJames
 *      desc   : 用户界面
 * </pre>
 */
public class UserFragment extends BaseFragment<UserPresenter> implements UserContract.View {

    private static final String TAG = "UserFragment";

    @BindView(R.id.ll_login)
    LinearLayout mLlLogin;
    @BindView(R.id.tv_login_status)
    TextView mTvLoginStatus;
    @BindView(R.id.btn_user_collect)
    Button mBtnCollect;
    @BindView(R.id.btn_user_analysis)
    Button mBtnAnalysis;
    @BindView(R.id.btn_user_setting)
    Button mBtnSetting;
    @BindView(R.id.btn_user_about)
    Button mBtnAbout;
    @BindView(R.id.btn_user_logout)
    Button mBtnLogout;

    /**
     * 是否登录
     */
    private boolean isLogin;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initView(View view) {
        setUserStatus();
        //登录成功后需重新设置用户状态
        RxBus.getInstance().toFlowable(LoginEvent.class).subscribe(loginEvent -> setUserStatus());
    }

    @OnClick({R.id.ll_login, R.id.btn_user_collect, R.id.btn_user_analysis, R.id.btn_user_setting, R.id.btn_user_about, R.id.btn_user_logout})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_login:
                //登录界面
                if (!isLogin) {
                    //未登录
                    ARouter.getInstance().build(PathContainer.LOGIN).navigation();
                }
                break;
            case R.id.btn_user_collect:
                //收藏界面
                if (isLogin) {
                    //已登录
                    ARouter.getInstance().build(PathContainer.COLLECTION)
                            .withString(Constants.USERNAME, SPUtils.getInstance(Constants.MY_SHARED_PREFERENCE).getString(Constants.USERNAME))
                            .withString(Constants.PASSWORD, SPUtils.getInstance(Constants.MY_SHARED_PREFERENCE).getString(Constants.PASSWORD))
                            .withBoolean(Constants.LOGIN_STATUS, SPUtils.getInstance(Constants.MY_SHARED_PREFERENCE).getBoolean(Constants.LOGIN_STATUS))
                            .navigation();
                } else {
                    //未登录
                    toast(R.string.login_please);
                }
                break;
            case R.id.btn_user_analysis:
                //分析界面
                ARouter.getInstance().build(PathContainer.LOADING).navigation();
                //ARouter.getInstance().build(PathContainer.ANALYSIS).navigation();
                break;
            case R.id.btn_user_setting:
                //设置界面
                ARouter.getInstance().build(PathContainer.SETTING).navigation();
                break;
            case R.id.btn_user_about:
                //关于界面
                ARouter.getInstance().build(PathContainer.ABOUT).navigation();
                break;
            case R.id.btn_user_logout:
                logout();
                break;
            default:
                break;
        }
    }

    /**
     * 设置用户状态
     */
    public void setUserStatus() {
        isLogin = SPUtils.getInstance(Constants.MY_SHARED_PREFERENCE).getBoolean(Constants.LOGIN_STATUS);
        if (isLogin) {
            //已登录
            LogUtils.e("已登录");
            mTvLoginStatus.setText(SPUtils.getInstance(Constants.MY_SHARED_PREFERENCE).getString(Constants.USERNAME));
            mBtnLogout.setVisibility(View.VISIBLE);
        } else {
            //未登录
            LogUtils.e("未登录");
            mTvLoginStatus.setText(R.string.click_login);
            mBtnLogout.setVisibility(View.GONE);
        }
    }

    /**
     * 退出登录
     */
    private void logout() {
        //退出登录
        SPUtils.getInstance(Constants.MY_SHARED_PREFERENCE).clear();
        setUserStatus();
        //清除Cookies
        CookiesManager.clearAllCookies();
        //发送退出登录的消息
        RxBus.getInstance().post(new LogoutEvent());
    }
}
