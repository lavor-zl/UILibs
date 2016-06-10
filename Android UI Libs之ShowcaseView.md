#Android UI Libs之ShowcaseView  
***  
#1. 说明  
***  
[ShowcaseView](https://github.com/amlcurran/ShowcaseView)，顾名思义，展柜视图，展示界面上某一部分的作用，一个用来做新手引导与使用说明的最佳第三方库。  

#2. 配置  
***  
在模块中添加依赖：`compile 'com.github.amlcurran.showcaseview:library:5.4.3'`  

#3. 使用  
***  
`ShowcaseView`的使用非常简单  
```  
 ViewTarget target = new ViewTarget(R.id.target, this);
        new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(target)
                .setContentTitle("ShowcaseView")
                .setContentText("This is highlighting the Home button")
                .hideOnTouchOutside()
                .build();  
```  
![](http://i.imgur.com/R7fdr2M.png)  

- `ViewTarget`：是我们要展示的View  
- `withMaterialShowcase()`：设置主题为`Material`，一共有三种主题  
   - `Material`  
   - `New style`  
   - `Holo`  
- `setTarget`：设置要展示的View  
- `setContentTitle`：设置标题  
- `setContentText`：设置内容  
- `hideOnTouchOutside`：设置触摸时隐藏  

#4. 用户注册引导  
***  
我做了一个简单的用户注册引导界面：  
![](http://i.imgur.com/WzMzlRo.gif)  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)