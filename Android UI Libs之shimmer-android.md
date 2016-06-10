#Android UI Libs之shimmer-android  
***  
#1. 说明  
***  
[shimmer-android](https://github.com/facebook/shimmer-android)是Facebook出品的给任意视图添加微光效果的第三方库。  
![](http://i.imgur.com/yw1s55V.gif)  

#2. 配置  
***  
在模块的build.gradle上面添加依赖  
```  
dependencies {
   compile 'com.facebook.shimmer:shimmer:0.1.0@aar'
 }  
```  

**注意：模块的`minSdkVersion`不能小于16**   

#3. 基本使用  
***  
在xml中定义一个`ShimmerFrameLayout`，它的子视图就可以起微光效果  
```
    <com.facebook.shimmer.ShimmerFrameLayout
        android:id="@+id/shimmer_view_container"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        >
        <!--我们希望起微光效果的视图-->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="我的微信公众号：Android技术漫谈" />
    </com.facebook.shimmer.ShimmerFrameLayout>  
```  
在java文件中开启微光动画  
```  
ShimmerFrameLayout container =
                (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        //开启微光动画
        container.startShimmerAnimation();  
```  

程序运行界面如下：  
![](http://i.imgur.com/ud3iJo0.gif)  

`ShimmerFrameLayout`有很多方法，可以设置相关属性：  
- `setAutoStart()`：设置是否自动启动微光动画  
- `setBaseAlpha`：设置基视图的背景颜色  
- `setDuration()`：从一个布局到另一个布局亮点需要时间。  
- `setRepeatCount()`：设置当前动画重复的次数  
- `setRepeatDelay()`：延迟多长时间重复当前动画  
- `setRepeatMode()`：设置动画重复的模式  
- `setMaskShape()`：设置当前高亮面具的形状  
- `setAngle()`：设置当前高亮面具的角度  


程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)


