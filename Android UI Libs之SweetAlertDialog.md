##Android UI Libs之SweetAlertDialog  
***  
#1. 说明  
***   
[SweetAlertDialog](https://github.com/pedant/sweet-alert-dialog)是一个漂亮聪明的警告对话框。  

#2. 配置  
***  
- 首先在工程的build.gradle上面添加maven中心仓库  
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
    compile 'cn.pedant.sweetalert:library:1.3'
}  
```   
- 最后，因为该库的aar文件的清单文件中有`android:icon`，如果我们程序的`AndroidManifest.xml`文件中也有`android:icon`就会出现冲突，我们可以在`AndroidManifest.xml`文件中`manifest`节点中添加`xmlns:tools="http://schemas.android.com/tools"`，在`application`节点中添加`tools:replace="android:icon"`来解决这个问题。  
![](http://i.imgur.com/JHa5F3J.png)  

#3. 基本使用  
***  
`SweetAlertDialog`有6种类型的警告框：
- 普通警告框  
- 错误警告框  
- 警告警告框  
- 成功警告框  
- 自定义图像警告框  
- 进度警告框  

##1. 普通警告框  
***  
在Java文件中使用普通警告框：  
```
 new SweetAlertDialog(this)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();  
```  
![](http://i.imgur.com/yAyfLXV.png)  

##2. 错误警告框  
***  
```  
 new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
```  
![](http://i.imgur.com/heEKWyD.png)  

##3. 警告警告框  
***  
```  
  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();  
``` 
![](http://i.imgur.com/yXUsuqZ.png)  

##4. 成功警告框  
***  
```  
new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
```  
![](http://i.imgur.com/0NxKJTv.png)  

##5. 自定义图像警告框  
***  
```  
 new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .setCustomImage(R.drawable.image)
                    .show();  
```  
![](http://i.imgur.com/4uR97F1.png)  

##6. 进度警告框  
***  
```
 SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog. setTitleText("对话框标题")
                    .setContentText("对话框内容");
            pDialog.setCancelable(false);
            pDialog.show();  
```  
![](http://i.imgur.com/609kMDL.png)  

#4. 相关说明与讲解  
***  
我们知道Android系统自带的警告对话框（AlertDialog）有`PositiveButton`与`NegativeButton`。`SweetAlertDialog`中的`ConfirmButton`与`CancelButton`与之对应。`ConfirmButton`默认是显示的，它里面的文本默认是“OK”，`CancelButton`默认是不显示的，并且是不存在的。  
要想`CancelButton`显示,首先要通过`setCancelText`方法设置文本，只有这样才会新建一个`CancelButton`，否则`CancelButton`为`null`，然后设置通过`showCancelButton(true)`使`CancelButton`显示。  

`进度警告框`中`ConfirmButton`与`CancelButton`是不会显示的，并且其他警告框都可以通过点击这两个按钮来关闭警告框，但是`进度警告框`不可以，一般来说，我们会在某个进度任务执行开始时显示`进度警告框`，执行完毕时在代码里面控制关闭警告框。  

一些方法说明：  
- `setCancelable(boolean flag)`：设置是否可以通过按下“返回键”来关闭警告框，默认值是true    
- `setConfirmClickListener (OnSweetClickListener listener)`：为`ConfirmButton`设置点击事件监听器  
- `setCancelClickListener (OnSweetClickListener listener)`：为`CancelButton`设置点击事件监听器  
- `dismiss()`：关闭警告框  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs)   


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**  
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)  



