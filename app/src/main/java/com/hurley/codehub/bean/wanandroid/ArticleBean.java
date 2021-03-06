package com.hurley.codehub.bean.wanandroid;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/2/26 2:12 PM
 *      github  : https://github.com/HurleyJames
 *      desc    : 文章实体类
 * </pre>
 */
public class ArticleBean {

    /**
     * curPage : 1
     * offset : 0
     * over : false
     * pageCount : 2
     * size : 20
     * total : 38
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements Serializable {

        /**
         * author : xxq2dream
         * chapterId : 10
         * chapterName : Activity
         * courseId : 13
         * desc :
         * envelopePic :
         * id : 48029
         * link : https://juejin.im/post/5c19a1236fb9a04a102f39aa
         * niceDate : 刚刚
         * origin :
         * originId : 7784
         * publishTime : 1551235950000
         * title : Fragment中调用startActivityForResult的那些坑
         * userId : 965
         * visible : 0
         * zan : 0
         */

        private int id;
        private String title;
        private int chapterId;
        private String chapterName;
        private String superChapterName;
        private String envelopePic;
        private String link;
        private String author;
        private String origin;
        private long publishTime;
        private String zan;
        private String desc;
        private int visible;
        private String niceDate;
        private int courseId;
        private boolean collect;
        private boolean top;
        private boolean latest;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public String getsuperChapterName() {
            return superChapterName;
        }

        public void setsuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }


        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public boolean isLatest() {
            return latest;
        }

        public void setLatest(boolean latest) {
            this.latest = latest;
        }
    }
}
