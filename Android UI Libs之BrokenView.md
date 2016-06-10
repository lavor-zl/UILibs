#Android UI Libs之BrokenView    
***  
#1. 说明  
***  
[BrokenView](https://github.com/zhanyongsheng/BrokenView)让视图产生玻璃破裂的效果。  
![](http://i.imgur.com/qJ4nzXv.gif)  

**注意：该库只能在API14以上的设备上运行**  

#2. 配置  
***  
在模块的build.gradle上面添加依赖  
```  
dependencies {
   compile 'com.zys:brokenview:1.0.3'
 }  
```  

#3. 基本使用  
***  
触摸一个视图让它慢慢破裂：  
```  
this.image = (ImageView) findViewById(R.id.image);
//创建BrokenView的对象
BrokenView brokenView = BrokenView.add2Window(this);
//创建BrokenTouchListener的对象
BrokenTouchListener listener = new BrokenTouchListener.Builder(brokenView).build();
//为image设置触摸事件监听
image.setOnTouchListener(listener);        
```  
程序运行界面：  
![](http://i.imgur.com/TGvOArU.gif)  

`BrokenTouchListener.Builder`中有很多配置参数：  
```
BrokenTouchListener.Builder(brokenView).
    setComplexity(...).          // 设置破裂的复杂度，默认值12
    setBreakDuration(...).       // 设置视图破裂持续的时间，默认值700ms
    setFallDuration(...).        // 设置视图坠落持续的时间，默认值2000ms
    setCircleRiftsRadius(...).   // 设置以触摸点为中心的圆形裂痕半径，默认值是66dp
    setEnableArea().             // 设置可以使指定子视图产生破裂效果
    setEnableArea(...).          // 设置子视图可以产生破裂效果的区域，保证子视图没有设置触摸事件监听
    setPaint(...).               // 设置裂痕的画笔
    build();                  
```  

`BrokenView`还可以设置回调来监听破裂动画的状态：  
```
        brokenView.setCallback(new BrokenCallback() {
            //开始破裂
            @Override
            public void onStart(View v) {
                super.onStart(v);
            }
            //取消结束破裂
            @Override
            public void onCancelEnd(View v) {
                super.onCancelEnd(v);
            }
            //坠落结束
            @Override
            public void onFallingEnd(View v) {
                super.onFallingEnd(v);
            }
            //坠落中
            @Override
            public void onFalling(View v) {
                super.onFalling(v);
            }
            //重新开始破裂
            @Override
            public void onRestart(View v) {
                super.onRestart(v);
            }
            //取消破裂
            @Override
            public void onCancel(View v) {
                super.onCancel(v);
            }
        });
```

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)