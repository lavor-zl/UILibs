#Android UI Libs之android-viewbadger  
***  
#1. 说明  
***  
[android-viewbadger](https://github.com/jgilfelt/android-viewbadger)是一个比较古老的库，但是直到现在它依然有很大的使用价值，它可以在运行时，不依赖布局而直接给视图加上“徽章”，最典型的应用就是显示未读消息的数量。  

#2. 配置  
***  
该库的作者很久没有更新此库了，因此也没有将它上传到一个仓库中去，我们要使用它，可以将该库lib目录下面的android-viewbadger.jar复制到我们的工程中去。用惯了gradle的时候感觉这样下载好麻烦，别担心，有热心的小伙伴fork了这个库，并将它传到了Jitpack仓库中。  

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
    compile 'com.github.deano2390:android-viewbadger:1.0.0'
}  
```  
- 有些人反应在模块中添加依赖失败，可以试试在模块的build.gradle上面添加这样的依赖   
```  
dependencies {
    compile 'com.github.deano2390:android-viewbadger:1.0.0@aar'
}  
```  

#3. 基本使用  
***  
```  
        //获取添加“徽章”的目标View
        View target  = (TextView) findViewById(R.id.text);
        BadgeView badge = new BadgeView(this, target);
        badge.setText("1");
        //设置文本颜色
        badge.setTextColor(Color.BLACK);
        //设置背景颜色
        badge.setBadgeBackgroundColor(Color.YELLOW);
        //显示
        badge.show();  
```  
`BadgeView`的使用非常简单，主要就是熟悉它常用的方法。  

程序运行后的界面： 
![](http://i.imgur.com/0pGO0aL.png)   

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)
  