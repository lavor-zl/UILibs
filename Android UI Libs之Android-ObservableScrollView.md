#Android UI Libs之Android-ObservableScrollView  
***  
#1. 说明
[Android-ObservableScrollView](https://github.com/ksoichiro/Android-ObservableScrollView)，顾名思义，Android上观察滚动的视图，可以监听滚动视图的滚动状态。它可以很简单地与Toolbar进行交互，并且很方便地创建Material Design的app。 

#2. 配置  
***  
在模块的build.gradle中添加依赖：`compile 'com.github.ksoichiro:android-observablescrollview:1.5.0'`  

#3. 基本使用  
***  
[Android-ObservableScrollView](https://github.com/ksoichiro/Android-ObservableScrollView)提供一些可以观察滚动事件的滚动视图：  
- `ObservableGridView`：扩展自`GridView`  
- `ObservableListView`：扩展自`ListView`    
- `ObservableRecyclerView`：扩展自`RecyclerView`    
- `ObservableScrollView`：扩展自`ScrollView`    
- `ObservableWebView`：扩展自`WebView`    

我以`ObservableListView`来说明其基本使用方法：   
***  
在xml中定义`ObservableListView` ：
```  
<com.github.ksoichiro.android.observablescrollview.ObservableListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
</com.github.ksoichiro.android.observablescrollview.ObservableListView>  
```  

在java文件中对`ObservableListView`的相关操作：  
```  
        this.listview = (ObservableListView) findViewById(R.id.list_view);
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            items.add("数据 " + i);
        }
        //为listview设置Adapter
        listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));
        //为listview设置滚动回调观察者
        listview.setScrollViewCallbacks(this);  
```  
所在Activity实现了`ObservableScrollViewCallbacks`接口，并覆盖该接口中的所有方法：  
```  
 /**
     * 滚动时
     * @param scrollY
     * @param firstScroll
     * @param dragging
     */
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        Log.i("onScrollChanged","Y轴的坐标："+scrollY);

    }
    /**
     * 按下时
     */
    @Override
    public void onDownMotionEvent() {

    }
    /**
     * 拖曳结束或者取消时
     * @param scrollState
     */
    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if(scrollState==ScrollState.DOWN){
            Log.i("onUpOrCancelMotionEvent","向下滚动");
        }else if(scrollState==ScrollState.UP){
            Log.i("onUpOrCancelMotionEvent","向上滚动");
        }else {
            Log.i("onUpOrCancelMotionEvent","停止滚动");
        }
    }  
```  

**即使调用了`listview.setScrollViewCallbacks(this)`方法，listview还可以调用`listview.setOnScrollListener()`，它们会同时起作用。**  

[Android-ObservableScrollView](https://github.com/ksoichiro/Android-ObservableScrollView)还给出了很多交互的[Activity](https://github.com/ksoichiro/Android-ObservableScrollView/tree/master/samples/src/main/java/com/github/ksoichiro/android/observablescrollview/samples)。  


程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)
