 #Android UI Libs之PhotoView  
***  
#1. 说明  
***  
[PhotoView](https://github.com/chrisbanes/PhotoView)可以帮助我们快速简单的实现一个放大`ImageView`中图片的功能，这个功能在查看图片时非常常用，通过触摸放大图片。  

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
     compile 'com.github.chrisbanes:PhotoView:1.2.6'
}  
```  

#3. 基本使用  
***  
使用该库来放大`ImageView`中图片有两种方式：  
- 直接使用`PhoteView`  
在xml中定义`PhoteView`：  
```  
    <uk.co.senab.photoview.PhotoView
        android:id="@+id/image"
        android:src="@drawable/image"
        android:scaleType="fitXY"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />  
```  
程序运行界面如下：  
![](http://i.imgur.com/YvTNg42.gif)  

- 配合`PhotoViewAttacher`使用`ImageView`：  
在xml中定义`ImageView`：   
```
    <ImageView
        android:id="@+id/image"
        android:src="@drawable/image"
        android:scaleType="fitXY"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />  
```  
在java文件中进行相关操作：  
```  
        this.image = (ImageView) findViewById(R.id.image);
        mAttacher = new PhotoViewAttacher(image);  
```
程序运行界面如下：  
![](http://i.imgur.com/m0dXoOk.gif)  


程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)
