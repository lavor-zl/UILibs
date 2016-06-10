#Android UI Libs之DiscreteSeekBar  
***  
#1. 说明  
***  
[DiscreteSeekBar](https://github.com/AnderWeb/discreteSeekBar)可以实现漂亮的滑动条。  
![](http://i.imgur.com/jqlJcJR.gif)

#2. 配置  
***  
在模块的build.gradle上面添加依赖：  
```
dependencies {
    compile 'org.adw.library:discrete-seekbar:1.0.1'
}  
```  

#3. 基本使用  
***  
在xml中定义`DiscreteSeekBar`如下：  
```
  <org.adw.library.widgets.discreteseekbar.DiscreteSeekBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:dsb_min="2"
        app:dsb_max="15" />  
```  
程序运行界面如下：  
![](http://i.imgur.com/iktIDGa.gif)  

`DiscreteSeekBar`相关属性：
- `app:dsb_min`: 最小值
- `app:dsb_max`: 最大值
- `app:dsb_value`: 当前值
- `app:dsb_allowTrackClickToDrag`: 允许点击滑动条到达指定位置，默认值是true
- `app:dsb_indicatorFormatter`: 指示器上显示的文本
- `app:dsb_indicatorPopupEnabled`: 弹出指示器是否显示，默认值是true
- `app:dsb_progressColor`: 进度条颜色，一般指洗涤器与静态时的拇指的颜色
- `app:dsb_trackColor`: 追踪器的颜色
- `app:dsb_indicatorTextAppearance`: 指示器文本的颜色
- `app:dsb_indicatorColor`: 指示器颜色
- `app:dsb_indicatorElevation`: 对应于android:elevation，只能在API21+使用
- `app:dsb_rippleColor`: 波纹颜色，只能在API21+使用
- `app:dsb_trackHeight`: 追踪器的高度
- `app:dsb_scrubberHeight`: 洗涤器的高度
- `app:dsb_thumbSize`: 拇指（当前所在位置的圆形）大小
- `app:dsb_indicatorSeparation`: 在垂直方向上，弹出指示器与拇指的距离  

![](http://i.imgur.com/ZXUYwMv.png)  


程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)