#Android UI Libs之trianglify  
***  
#1. 说明  
***  
[trianglify](https://github.com/manolovn/trianglify)是一个可以由不同颜色三角形组成的视图，一般可以用来作漂亮的背景图。  
![](http://i.imgur.com/YOqT21a.png)  

#2. 配置  
***  
在模块的build.gradle上面添加依赖  
```  
dependencies {
   compile 'com.commit451:NativeStackBlur:1.0.2'
 }  
```  

**注意：模块的`minSdkVersion`不能小于15**  

#3. 基本使用  
***  
##1. 最简单使用  
***  
在xml布局中使用 `TrianglifyView` 
```  
    <com.manolovn.trianglify.TrianglifyView
        android:id="@+id/trianglify_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />  
```  
程序界面如下：  
![](http://i.imgur.com/Omrb7JQ.png)  

##2. 设置相关属性使用  
***  
`TrianglifyView`还有下面一些属性：  
- `app:cellSize`：间隔此距离时在x,y轴上取一次点
- `app:variance`：画点时x，y轴值变化的最大值，默认值50
- `app:bleedX`：画点时x轴向左右衍生的距离，默认值200
- `app:bleedY`：画点时y轴向上下衍生的距离，默认值200
- `app:colorGenerator`：设置颜色生成器的类名，默认颜色生成器是`RandomColorGenerator`
- `app:pointGenerator`：设置点生成器的类名，默认值点生成器是`RegularPointGenerator`  

此时，上面四个属性没有绝对的意义，他们都是在点生成器中起作用的，我只是按照`RegularPointGenerator`来大概说了一下他们的含义，要理解他们的含义就看点生成器中的`generatePoints`方法。该库自带一个颜色生成器`RandomColorGenerator`，两个点生成器`RegularPointGenerator`和`CircularPointGenerator`。我们还可以自定义颜色生成器和电生成器。  
- 自定义颜色生成器，要实现`ColorGenerator`接口  
- 自定义点生成器，要实现`PointGenerator`接口    

有没有感觉有点迷糊啊，说一下我的理解吧，看看能不能更好地帮大家进行理解。  
- 点生成器将所有的点得到  
- 颜色生成器将每次画三角形的颜色得到  
- 然后将相邻的点连起来，连起来后会有很多三角形区域，在三角形区域填充颜色  

在xml布局中使用 定义`TrianglifyView`如下：  
```  
<com.manolovn.trianglify.TrianglifyView
android:id="@+id/trianglify_view"
android:layout_width="match_parent"
android:layout_height="match_parent"
app:cellSize="75"
app:variance="40"
app:bleedX="50"
app:bleedY="50"
app:colorGenerator="com.manolovn.trianglify.generator.point.CircularPointGenerator"/>  
```  

程序运行界面如下：  
![](http://i.imgur.com/AHmQ82v.png)  

**注意：目前作者并没有将最新的库上传到jcenter仓库，但是他的README.md文档确是按照最新的库讲解的。**  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)