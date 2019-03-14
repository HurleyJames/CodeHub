package com.hurley.wanandroid.net.callback;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/14 5:36 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 通用的Rx线程转换类
 * </pre>
 */
public class RxSchedulers {

    static final ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return (upstream).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };


    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }
}
