package com.hurley.wanandroid.module.main;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.hurley.wanandroid.R;
import com.hurley.wanandroid.app.Constants;
import com.hurley.wanandroid.base.BaseActivity;
import com.hurley.wanandroid.utils.SharedPreferencesUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import site.gemus.openingstartanimation.OpeningStartAnimation;
import site.gemus.openingstartanimation.RedYellowBlueDrawStrategy;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/19 11:26 AM
 *      github  : https://github.com/HurleyJames
 *      desc    : 闪屏页面
 * </pre>
 */
@Route(path = "/main/SplashActivity")
public class SplashActivity extends AppCompatActivity implements OnPermission, Animation.AnimationListener {

    @BindView(R.id.iv_splash_bg)
    ImageView mIvSplashBg;
    @BindView(R.id.iv_splash_icon)
    ImageView mIvSplashIcon;
    @BindView(R.id.tv_splash_name)
    TextView mTvSplashName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //判断是否是第一次打开应用
        /*boolean isFirstOpen = SharedPreferencesUtil.getBoolean(this,
                SharedPreferencesUtil.FIRST_OPEN, true);
        if (isFirstOpen) {
            //如果是首次打开应用，则显示引导页
            ARouter.getInstance().build("/main/GuideActivity");
            finish();
            return;
        }*/

        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initStartAnim();
        ImmersionBar.with(this)
                .fullScreen(true)
                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                .transparentNavigationBar()
                .init();
    }

    private void requestFilePermission() {
        XXPermissions.with(this)
                .permission(Permission.Group.STORAGE)
                .request(this);
    }

    @Override
    public void hasPermission(List<String> granted, boolean isAll) {
        ARouter.getInstance().build("/main/HomeActivity").navigation();
        finish();
    }

    @Override
    public void noPermission(List<String> denied, boolean quick) {
        if (quick) {
            ToastUtils.showShort("没有权限访问文件，请手动授予权限");
            XXPermissions.gotoPermissionSettings(SplashActivity.this, true);
        }else {
            ToastUtils.showShort("请先授予文件读写权限");
            getWindow().getDecorView().postDelayed(new Runnable() {
                @Override
                public void run() {
                    requestFilePermission();
                }
            }, 2000);
        }
    }

    /**
     * 启动动画
     */
    private void initStartAnim() {
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.4f, 1.0f);
        aa.setDuration(Constants.ANIM_TIME * 2);
        aa.setAnimationListener(this);
        mIvSplashBg.startAnimation(aa);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(Constants.ANIM_TIME);
        mIvSplashIcon.startAnimation(sa);

        RotateAnimation ra = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(Constants.ANIM_TIME);
        mTvSplashName.startAnimation(ra);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        requestFilePermission();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (XXPermissions.isHasPermission(SplashActivity.this, Permission.Group.STORAGE)) {
            hasPermission(null, true);
        } else {
            requestFilePermission();
        }
    }
}