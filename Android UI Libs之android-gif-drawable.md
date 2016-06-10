#Android UI Libs之android-gif-drawable  
***  
我们经常需要显示gif图片，但是Android自带的ImageView不能完全显示gif图片，它只会显示gif图片的第1帧。那我们要显示gif图片怎么办。本着不重复“造轮子”的原则，本人推荐使用[android-gif-drawable](https://github.com/koral--/android-gif-drawable)。android-gif-drawabl的功能很强大，不仅可以在显示gif图片，还可以让gif图片作为文本和按钮的背景图片显示等。  

要使用 android-gif-drawabl，首先要添加依赖`compile 'pl.droidsonroids.gif:android-gif-drawable:1.1.15'`  

显示gif图片：  
```
        <pl.droidsonroids.gif.GifImageView
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:src="@drawable/image"
        />  
```  

以gif图片作为文本的背景图片：  
```
        <pl.droidsonroids.gif.GifTextView
        android:text="hello"
        android:background="@drawable/image"
        android:layout_width="100dp"
        android:layout_height="100dp" />  
```  

以gif图片作为文按钮的背景图片：  
```
        <pl.droidsonroids.gif.GifImageButton
        android:text="hello"
        android:background="@drawable/image"
        android:layout_width="100dp"
        android:layout_height="100dp" />  
```

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)