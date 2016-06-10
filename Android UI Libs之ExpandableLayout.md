#Android UI Libs之ExpandableLayout  
***  
#1. 说明  
***  
[ExpandableLayout](https://github.com/traex/ExpandableLayout)，顾名思义，可扩展的布局，是一个可以帮助我们实现折叠功能的第三方库，折叠时，只显示头部，打开时，显示头部与内容。  

#2. 配置  
***  
在模块中添加依赖：`compile 'com.github.traex.expandablelayout:library:1.2.2'`  

因为添加依赖的aar文件中设置了应用程序图标，所以我们要在清单文件`AndroidManifest.xml`的`manifest`里面添加`xmlns:tools="http://schemas.android.com/tools"`，application里面面添加上`tools:replace="android:icon"`，不然会有冲突。  

![](http://i.imgur.com/qjDAJYJ.png)  

#3. 使用方法  
***  
扩展单个内容时使用`ExpandableLayoutItem`，扩展ListView时使用`ExpandableLayoutListView`。  

##1. 扩展单个内容  
***  
扩展单个内容时的xml布局，`expandable:headerLayout`代表头部，`expandable:contentLayout`代表内容
`xmlns:expandable="http://schemas.android.com/apk/res-auto"`  

```
    <com.andexert.expandablelayout.library.ExpandableLayout
        android:id="@+id/first"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        expandable:headerLayout="@layout/view_header"
        expandable:contentLayout="@layout/view_content"
        android:background="#e74c3c"/>  
```  
![](http://i.imgur.com/Iket3CU.gif)  

##2. 扩展Listview  
***  
扩展ListView时的xml布局，`expandable:headerLayout`代表头部，`expandable:contentLayout`代表内容  
```
    <com.andexert.expandablelayout.library.ExpandableLayoutListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </com.andexert.expandablelayout.library.ExpandableLayoutListView>  
```  

ListView中item对应的xml布局文件如下：  
```  
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:expandable="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.andexert.expandablelayout.library.ExpandableLayoutItem
        android:id="@+id/row"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        expandable:headerLayout="@layout/view_header"
        expandable:contentLayout="@layout/view_content"
        android:background="#e74c3c"/>
</LinearLayout>  
```  

java文件中的相关代码：  
```
    private String[] array={"微信公众号","Android技术漫谈","Android","Android开发"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.header_text, array);
        final ExpandableLayoutListView expandableLayoutListView = (ExpandableLayoutListView) findViewById(R.id.list_view);
        expandableLayoutListView.setAdapter(arrayAdapter);
    }  
```  

![](http://i.imgur.com/z93FYTz.gif)  

**注意：如果`ExpandableLayoutListView`中的item中有`EditView`,那么`ExpandableLayoutListView`要设置`android:windowSoftInputMode="adjustPan"`来阻止自身的重绘与item的关闭**  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)