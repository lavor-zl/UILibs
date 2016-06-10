#Android UI Libs之SwipeToLoadLayout  
***  
#1. 说明  
***  
[SwipeToLoadLayout](https://github.com/Aspsine/SwipeToLoadLayout)，顾名思义，滑动加载布局，可以实现下拉刷新与上拉加载更多。该库支持对ListView，GridView，RecyclerView，WebView，ScrollView等滑动视图的下载刷新与上拉加载更多。

#2. 配置  
***  
- 首先在工程的build.gradle上面添加JitPack仓库  
```  
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}  
```  
- 其次，在模块的build.gradle上面添加依赖  
```  
dependencies {
    compile 'com.github.Aspsine:SwipeToLoadLayout:1.0.3'
}  
```    

#3. 基本使用  
***  
- 在xml中定义`SwipeToLoadLayout`： 
`SwipeToLoadLayout`下面定义三个子视图，第一个子代表下拉刷新的头部，第二个代表滑动视图主体，第三个代表上拉加载更多的尾部
```  
     <com.aspsine.swipetoloadlayout.SwipeToLoadLayout
        android:id="@+id/swipeToLoadLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout
            android:id="@id/swipe_refresh_header"
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:gravity="center"/>

        <android.support.v7.widget.RecyclerView
            android:id="@+id/swipe_target"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        </android.support.v7.widget.RecyclerView>

        <com.aspsine.swipetoloadlayout.SwipeLoadMoreFooterLayout
            android:id="@id/swipe_load_more_footer"
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:gravity="center" />
    </com.aspsine.swipetoloadlayout.SwipeToLoadLayout>
```  
**注意：这三个子视图的id必须是上面所写的，否则会出错**  

- 在java文件中进行相关操作：  
```  
        this.swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        this.recyclerView = (RecyclerView) findViewById(R.id.swipe_target);
        //为recyclerView设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("原始数据");
        }
        myAdapter = new MyAdapter(list);
        //为recyclerView设置适配器
        recyclerView.setAdapter(myAdapter);
        //为swipeToLoadLayout设置下拉刷新监听者
        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                for (int i = 0; i < 20; i++) {
                    list.add(0,"刷新获得的数据");
                }
                myAdapter.notifyDataSetChanged();
                //设置下拉刷新结束
                swipeToLoadLayout.setRefreshing(false);
            }
        });
        //为swipeToLoadLayout设置上拉加载更多监听者
        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                for (int i = 0; i < 20; i++) {
                    list.add("加载更多获得的数据");
                }
                myAdapter.notifyDataSetChanged();
                //设置上拉加载更多结束
                swipeToLoadLayout.setLoadingMore(false);
            }
        });
```   

程序运行界面如下：  
![](http://i.imgur.com/VG8H1AW.gif)

`SwipeToLoadLayout`常用属性：  
- `app:refresh_enabled`：设置是否可以下拉刷新  
- `app:load_more_enabled`：设置是否可以上拉加载更多  
- `app:swipe_style`：设置下拉刷新与上拉加载的样式，其值为`classic`，`above`，`blew`或`scale` 
- `app:refresh_trigger_offset`：触发下拉刷新的偏移量，默认值是下拉刷新头部的高度  
- `app:load_more_trigger_offset`：触发上拉加载更多的偏移量，默认值是上拉加载更多的高度  
- `app:refresh_final_drag_offset`：下拉刷新最大可以拖动的偏移量  
- `app:load_more_final_drag_offset`：上拉加载更多最大可以拖动的偏移量  
- `app:release_to_refreshing_scrolling_duration`：释放下拉刷新持续滚动的时间  
- `app:release_to_loading_more_scrolling_duration`：释放上拉加载更多持续滚动的时间  
- `app:refresh_complete_delay_duration`：下拉刷新完成延迟的持续时间  
- `app:load_more_complete_delay_duration`：上拉加载更多完成延迟的持续时间  
- `app:refresh_complete_to_default_scrolling_duration`：默认完成下拉刷新持续滚动时间  
- `app:load_more_complete_to_default_scrolling_duration`： 默认完成上拉加载更多持续滚动时间  
- `app:default_to_refreshing_scrolling_duration`：默认下拉刷新滚动时间  
- `app:default_to_loading_more_scrolling_duration`：默认上拉加载更多滚动时间  

#4. 自定义下拉刷新头部与上拉加载更多尾部  
***  
- 定义下拉刷新头部视图只需要实现`SwipeRefreshTrigger`, `SwipeTrigger`两个接口就行  
```  
public class RefreshHeaderView extends TextView implements SwipeRefreshTrigger, SwipeTrigger {

    public RefreshHeaderView(Context context) {
        super(context);
    }

    public RefreshHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onRefresh() {
        setText("REFRESHING");
    }

    @Override
    public void onPrepare() {
        setText("");
    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            if (yScrolled >= getHeight()) {
                setText("RELEASE TO REFRESH");
            } else {
                setText("SWIPE TO REFRESH");
            }
        } else {
            setText("REFRESH RETURNING");
        }
    }

    @Override
    public void onRelease() {
    }

    @Override
    public void onComplete() {
        setText("COMPLETE");
    }

    @Override
    public void onReset() {
        setText("");
    }
}  
```  

- 定义上拉加载更多尾部视图只需要实现`SwipeLoadMoreTrigger`, `SwipeTrigger`两个接口就行  
```  
public class LoadMoreFooterView extends TextView implements SwipeTrigger, SwipeLoadMoreTrigger {
    public LoadMoreFooterView(Context context) {
        super(context);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {
        setText("LOADING MORE");
    }

    @Override
    public void onPrepare() {
        setText("");
    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            if (yScrolled <= -getHeight()) {
                setText("RELEASE TO LOAD MORE");
            } else {
                setText("SWIPE TO LOAD MORE");
            }
        } else {
            setText("LOAD MORE RETURNING");
        }
    }

    @Override
    public void onRelease() {
        setText("LOADING MORE");
    }

    @Override
    public void onComplete() {
        setText("COMPLETE");
    }

    @Override
    public void onReset() {
        setText("");
    }
}
```  

然后将原来xml文件中的下拉刷新头部与上拉加载更多尾部改为现在自定义的类。  
程序运行界面如下：  
![](http://i.imgur.com/OJzP83R.gif)  


程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)