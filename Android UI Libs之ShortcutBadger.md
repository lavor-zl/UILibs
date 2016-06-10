#Android UI Libs之ShortcutBadger  
***  
#1. 说明  
***  
[ShortcutBadger](https://github.com/leolin310148/ShortcutBadger)与前面介绍过的[android-viewbadger](https://github.com/jgilfelt/android-viewbadger)类似，都是加上“徽章”，ShortcutBadger是给app快捷launch添加数字“徽章”，android-viewbadger是给视图添加文本“徽章”。ShortcutBadger常用来在app快捷launch上显示未读的消息的个数。  

支持的机型：  
![](http://i.imgur.com/ozpzykr.png)  

#2. 配置  
***  
- 首先在工程的build.gradle上面添加mavenCentral仓库  
```  
allprojects {
    repositories {
        ...
        mavenCentral()
    }
}  
```  
- 其次，在模块的build.gradle上面添加依赖  
```  
dependencies {
    compile 'me.leolin:ShortcutBadger:1.1.4@aar'
}  
```  

#3. 基本使用  
***  
- 向app的launch快捷添加数字“徽章”  
```
    int badgeCount = 1;
    ShortcutBadger.applyCount(context, badgeCount); //1.1.4版本添加数字“徽章”的方法
    ShortcutBadger.with(getApplicationContext()).count(badgeCount); //1.1.3版本添加数字“徽章”的方法
```  
- 删除app的launch快捷上的数字“徽章”  
  - 方法1：
```  
    ShortcutBadger.removeCount(context); //1.1.4版本删除数字“徽章”的方法
    ShortcutBadger.with(getApplicationContext()).remove();  //1.1.3版本删除数字“徽章”的方法
```  
  - 方法2：  
```
    ShortcutBadger.applyCount(context, 0); //for 1.1.4
    ShortcutBadger.with(getApplicationContext()).count(0); //for 1.1.3  
```  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)
