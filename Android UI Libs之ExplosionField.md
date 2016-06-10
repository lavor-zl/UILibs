#Android UI Libs之ExplosionField  
***  
#1. 说明  
***  
[ExplosionField](https://github.com/tyrantgit/ExplosionField)让视图爆炸成粉尘效果。  
![](http://i.imgur.com/HjhNwmy.gif)  

#2.配置  
***  
在模块的build.gradle上面添加依赖  
```  
dependencies {
   compile 'tyrantgit:explosionfield:1.0.1'
 }  
```  

#3. 基本使用  
***  
点击一个按钮让`icon`与`image`爆炸
```  
        this.image = (ImageView) findViewById(R.id.image);
        this.button = (Button) findViewById(R.id.button);
        this.icon = (ImageView) findViewById(R.id.icon);
        //创建ExplosionField对象
        final ExplosionField mExplosionField = ExplosionField.attach2Window(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //让icon爆炸
                mExplosionField.explode(icon);
                //让image爆炸
                mExplosionField.explode(image);

            }
        });  
```  

程序界面如下：  
![](http://i.imgur.com/rHJf9DX.gif)  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)
