#Android UI Libs之CircleImageView  
***  
我们经常看到一些任务的图像都是圆形的，那么在Android中我们怎么让一张图片显示成圆形啊。  
有一个很好的开源库[CircleImageView](https://github.com/hdodenhof/CircleImageView)帮我们实现了这个功能。  

  
CircleImageView的使用非常简单，首先我们在module中添加依赖：`compile 'de.hdodenhof:circleimageview:2.0.0'`  

在xml布局中使用CircleImageView：  
```
        <de.hdodenhof.circleimageview.CircleImageView
        android:id="@+id/circleImage"
        android:layout_width="96dp"
        android:layout_height="96dp"
        android:src="@drawable/image"
        app:civ_border_width="2dp"
        app:civ_border_color="#FF000000"/>  
```  
- `app:civ_border_width`：代表边框宽度  
- `app:civ_border_color`：代表边框颜色  

来看一下我们程序的界面：  
![](http://i.imgur.com/jIbqyYi.png)

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)