package com.hurley.codehub.module.wanandroid.core.article;

import com.hurley.codehub.app.LoadType;
import com.hurley.codehub.base.BaseContract;
import com.hurley.codehub.bean.wanandroid.ArticleBean;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/3/18 2:49 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 文章列表 Contract类
 * </pre>
 */
public interface SystemArticleListContract {

    interface View extends BaseContract.BaseView {
        /**
         * 设置体系文章列表
         *
         * @param articleBean
         * @param loadType
         */
        void setSystemArticles(ArticleBean articleBean, @LoadType.checker int loadType);

        /**
         * 在文章列表页面成功收藏文章
         *
         * @param position
         * @param articleBean
         */
        void collectArticleSuccess(int position, ArticleBean.DatasBean articleBean);
    }

    interface Presenter extends BaseContract.BasePresenter<SystemArticleListContract.View> {

        /**
         * 加载体系文章
         *
         * @param cid
         */
        void loadSystemArticles(int cid);

        /**
         * 刷新
         */
        void refresh();

        /**
         * 加载更多
         */
        void loadMore();

        /**
         * 收藏文章
         *
         * @param position
         * @param articleBean
         */
        void collectArticle(int position, ArticleBean.DatasBean articleBean);

        /**
         * 将点击的文章模块、父模块保存至自己的数据库
         *
         * @param chapterName
         * @param superChapterName
         */
        void saveArticle(String chapterName, String superChapterName);
    }
}
