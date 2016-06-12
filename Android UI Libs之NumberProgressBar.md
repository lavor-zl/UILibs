#Android UI Libs之NumberProgressBar  
***  
#1. 说明  
***  
[NumberProgressBar](https://github.com/daimajia/NumberProgressBar)，顾名思义，数字进度条。该库实现了一个漂亮，简洁的数字进度条。

#2. 配置  
***  
在模块的build.gradle上面添加依赖  
```  
dependencies {
    compile 'com.daimajia.numberprogressbar:library:1.2@aar'
}  
```    

#3. 基本使用  
***  
##1. 最简单的使用  
***  
- 在xml布局文件中定义`NumberProgressBar`：   
```
    <com.daimajia.numberprogressbar.NumberProgressBar
        android:id="@+id/number_progress_bar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>  
```  
程序显示界面如下：  
![](http://i.imgur.com/3JG5dMo.png)  
- 在java文件中改变进度条的进度：  
```  
        setContentView(R.layout.activity_main_number_progress_bar);
        this.numberprogressbar = (NumberProgressBar) findViewById(R.id.number_progress_bar);
        //设置进度条的进度，参数的值在0-mMax之间取值，mMax默认值是100
        numberprogressbar.setProgress(20);  
```  
程序运行界面如下：  
![](http://i.imgur.com/57LsUOQ.png)  

##2. 预设样式说明  
***  
`NumberProgressBar`有8这种预设样式：  
- NumberProgressBar_Default: 默认的样式
- NumberProgressBar_Passing_Green 
- NumberProgressBar_Relax_Blue 
- NumberProgressBar_Grace_Yellow 
- NumberProgressBar_Warning_Red 
- NumberProgressBar_Funny_Orange 
- NumberProgressBar_Beauty_Red 
- NumberProgressBar_Twinkle_Night  

这8种预设样式从上到下一次对应这8个进度条：  
![](http://i.imgur.com/pf3bgsF.jpg)  

在xml中使用预设样式的简单式例：  
```  
    <com.daimajia.numberprogressbar.NumberProgressBar
        android:id="@+id/number_progress_bar"
        style="@style/NumberProgressBar_Default"/>  
```  

##3. 常用属性说明  
***  
`NumberProgressBar`分三块：已到达区域，文本区域，未到达区域：  
![](http://i.imgur.com/wxIL31c.jpg)  

- 已到达区域属性：  
  - `app:progress_reached_color`：已到达区域颜色  
  - `app:progress_reached_bar_height`：已到达区域高度  

- 文本区域属性：  
  - `app:progress_text_size`：文本字体大小
  - `app:progress_text_color`：文本颜色
  - `app:progress_text_offset`：文本偏移量，是指文本距离已到达区域与未到达区域的距离
  - `app:progress_text_visibility`：文本可见性，默认是可见  

- 未到达区域：
  - `app:progress_unreached_color`：未到达区域颜色  
  - `app:progress_unreached_bar_height`：未到达区域高度  

- 进度条属性：  
  - `app:max`：进度条的最大进度值
  - `app:progress`：进度条当前进度值  
**注意：`app:max`后来改成了`app:progress_max`，`app:progress`改成了`app:progress_curent`，但是作者没有将最新的库上传到jcenter仓库**    

关于文本区域显示文本的一些说明：文本区域显示文本由三部分组成：前缀，当前进度值，后缀  
- 前缀只能在java文件中设置：`numberprogressbar.setPrefix()`，前缀默认值是空串
- 当前进度值既可以在xml布局中设置也可以在java文件中设置  
- 后缀只能在java文件中设置：`numberprogressbar.setSuffix()`，后缀默认值是`%`  


程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs)   


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**  
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)  



  