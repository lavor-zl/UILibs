#Android UI Libs之android-stackblur  
***  
#1. 说明  
***  
[android-stackblur](https://github.com/kikoso/android-stackblur)是一个对图像进行模糊化处理的库，但是该作者没有将之上传到任何仓库，我们不能在AndroidStudio中通过添加依赖的方式来配置该库，并且自己下载了该库还要经过一系列的处理才能完全使用该库的功能，很不方便。不过不用担心，[有好心人fork了这个仓库](https://github.com/Commit451/NativeStackBlur)并将之上传到jcenter仓库，并且将之java层的封装做了修改，使之使用起来更方便，不过修改后的使用方式还是和原方式相近，并且对提供的aar文件做了优化，使之占用更小的空间。  

#2. 配置  
***  
在模块的build.gradle上面添加依赖  
```  
dependencies {
   compile 'com.commit451:NativeStackBlur:1.0.2'
 }  
```  
#3. 基本使用  
***  
我在Activity中放置一个ImageView和一个Button，点击Button后模糊化Image中的图片。  
```
  this.blurbutton = (Button) findViewById(R.id.blur_button);
        this.image = (ImageView) findViewById(R.id.image);
        blurbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap source= BitmapFactory.decodeResource(getResources(),R.drawable.image);
                //对Bitmap进行模糊化处理，第一个参数代表原始Bitmap，第二个参数代表模糊半径
                //半径越大，处理后的图片就越模糊
                Bitmap bm = NativeStackBlur.process(source, 5);
                image.setImageBitmap(bm);
            }
        });  
```  

程序运行界面：  
![](http://i.imgur.com/nPM3jNa.gif)  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)