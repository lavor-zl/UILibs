#Android UI Libs之Titanic  
***  
#1. 说明  
***  
[Titanic](https://github.com/RomainPiel/Titanic)是一个可以展示下沉的TextView的库。  
![](http://i.imgur.com/Uzf0y8k.gif)  

#2. 配置  
***  
该库的作者没有上传该库到任何仓库上，也没有提供库文件，我们需要要源代码下载下来，自己编译库文件。  
我编译好的库文件命名为：titanic1.0.0.aar  

将titanic1.0.0.aar文件复制到我们模块的libs目录下面，然后在模块的build.gradle上面添加依赖：  
```
dependencies {
    compile(name:'titanic1.0.0', ext:'aar')
}  
```  

#3. 基本使用  
***  
在xml中定义`TitanicTextView`：  
```  
    <com.romainpiel.titanic.library.TitanicTextView
        android:id="@+id/my_text_view"
        android:text="Android技术漫谈"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:gravity="center"
        android:textColor="#212121"
        android:textSize="70sp"
        android:paddingLeft="5dp"
        android:paddingRight="5dp"/>  
```  
在java文件中进行相关操作：  
```  
 TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);
        // 开启下沉动画
        new Titanic().start(tv);  
```  
程序运行界面如下：  
![](http://i.imgur.com/UcLwBlA.gif)  

我们感觉这个字体不漂亮，想换一种字体怎么办。  
为了方便，我直接使用使用该库样例中的字体库：`Satisfy-Regular.ttf`，并使用该库样例中的`Typefaces`类。将字体库复制到自己的`assets`目录下面。  
现在，我们在前面代码的基础上修改部分代码，使`TitanicTextView`可以用一种新的字体。  
xml布局文件中的代码不需要改变，仅仅只需要改变java文件中的代码。  
```  
TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);
        // 设置我们想要的字体
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));
        // 开启下沉动画
        new Titanic().start(tv);
```  
程序运行界面如下：  
![](http://i.imgur.com/JKKcmvU.gif)  
我们发现英文字体变了，但是中文字体没有变，这是因为该字体库只包含英文不包含中文，如果想要中文字体也变化，就去找一个包含中文的字体库。  

如果我们需要停止下沉动画，只需要调用`Titanic`的`cancel()`方法即可。  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)
