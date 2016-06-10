#Android UI Libs之LabelView 
***  
#1. 说明  
***  
[LabelView](https://github.com/linger1216/labelview)，顾名思义，标签视图，利用该库，我们可以给视图添加上一个标签。  
我们经常在网页上看到“Fork me on Github”的Banner,而利用该库我们可以在Android上显示这样的Banner。  
![](http://i.imgur.com/YIapm55.png)  

#2. 配置  
***  
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
    compile 'com.github.linger1216:labelview:v1.1.0'
}  
```  

#3. 基本使用  
***  
该库自带可以在Button,ImageView,TextView上打标签的类：`LabelButtonView`，`LabelImageView`，`LabelTextView`。  

- `LabelButtonView`的使用：  
```  
<com.lid.lib.LabelButtonView
        android:id="@+id/labelButton"
        android:layout_width="200dp"
        android:layout_height="48dp"
        android:background="#03a9f4"
        android:gravity="center"
        android:text="lavor-zl"
        android:textColor="#ffffff"
        app:label_backgroundColor="#C2185B"
        app:label_distance="20dp"
        app:label_height="20dp"
        app:label_orientation="RIGHT_TOP"
        app:label_text="Github"
        app:label_textSize="12sp" />  
```
- `LabelImageView`的使用：  
```  
<com.lid.lib.LabelImageView
        android:id="@+id/labelImage"
        android:layout_width="200dp"
        android:layout_height="150dp"
        android:scaleType="centerCrop"
        android:src="@drawable/image"
        app:label_backgroundColor="#C2185B"
        app:label_orientation="LEFT_TOP"
        app:label_text="lavor" />  
```  
- `LabelTextView`的使用：  
```
 <com.lid.lib.LabelTextView
        android:id="@+id/labelText"
        android:layout_width="200dp"
        android:layout_height="48dp"
        android:layout_marginTop="8dp"
        android:background="#212121"
        android:gravity="center"
        android:padding="16dp"
        android:text="Android技术漫谈"
        android:textColor="#ffffff"
        app:label_backgroundColor="#03A9F4"
        app:label_distance="15dp"
        app:label_orientation="LEFT_TOP"
        app:label_text="微信"
        app:label_textSize="10sp" />  
```  
![](http://i.imgur.com/W1dP4LS.png)  

属性说明：android命名空间的属性就不用说了，我们来说一下app命名空间的属性。  
![](http://i.imgur.com/QmNJ0kz.jpg)  
除了上图中属性外，还有一个重要的属性就是`app:label_orientation`，它代表标签的方向：  
- `LEFT_TOP`：代表左上方，为默认值  
- `RIGHT_TOP`：代表右上方  
- `LEFT_BOTTOM`：代表左下方  
- `RIGHT_BOTTOM`：代表右下方  

#4. 高级使用  
***  
如果我们要在自定义视图中打标签怎么办，其实很简单，一般只需要四步就可以：  
- 创建一个视图类继承你需要打标签视图  
- 使用`LabelViewHelper`的对象作为新类的成员变量  
- 在构造方法和`onDraw`方法中调用`LabelViewHelper`中的方法  
- 在其他相关方法中调用`LabelViewHelper`中的方法  
***  
```  
public class LabelXXXView extends YourView {
    LabelViewHelper utils;
    public LabelXXXView(Context context) {
        this(context, null);
    }
    public LabelXXXView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public LabelXXXView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        utils = new LabelViewHelper(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        utils.onDraw(canvas, getMeasuredWidth(), getMeasuredHeight());
    }
    public void setLabelHeight(int height) {
        utils.setLabelHeight(this, height);
    }
    public int getLabelHeight() {
        return utils.getLabelHeight();
    }
    public void setLabelDistance(int distance) {
        utils.setLabelDistance(this, distance);
    }
    public int getLabelDistance() {
        return utils.getLabelDistance();
    }
    public boolean isLabelVisual() {
        return utils.isLabelVisual();
    }
    public void setLabelVisual(boolean enable) {
        utils.setLabelVisual(this, enable);
    }
    public int getLabelOrientation() {
        return utils.getLabelOrientation();
    }
    public void setLabelOrientation(int orientation) {
        utils.setLabelOrientation(this, orientation);
    }
    public int getLabelTextColor() {
        return utils.getLabelTextColor();
    }
    public void setLabelTextColor(int textColor) {
        utils.setLabelTextColor(this, textColor);
    }
    public int getLabelBackgroundColor() {
        return utils.getLabelBackgroundColor();
    }
    public void setLabelBackgroundColor(int backgroundColor) {
        utils.setLabelBackgroundColor(this, backgroundColor);
    }
    public String getLabelText() {
        return utils.getLabelText();
    }
    public void setLabelText(String text) {
        utils.setLabelText(this, text);
    }
    public int getLabelTextSize() {
        return utils.getLabelTextSize();
    }
    public void setLabelTextSize(int textSize) {
        utils.setLabelTextSize(this, textSize);
    }
}  
```  

当然，我们对自定义View打标签并不总是按上面的方法来进行的。  
比如，我要给`EditText`打标签，按照上面的方法来，结果是这样的
![](http://i.imgur.com/fcYh7wa.png)
我们发现下面的横线不见了，怎么回事啊。  
这是因为`EditText`一般没有自定义属性，就调用了下面这个构造方法：  
```  
public EditText(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.editTextStyle);
    }  
```  
可以看到这个构造方法里面自动给它添加了一个`com.android.internal.R.attr.editTextStyle`样式，正是这个样式才使得`EditText下面有横线。而按照上面的四步来，我们就丢失了这个样式，现在我们想要这个样式怎么办。别担心，很简单，在原来四步的基础上保持不变，修改第三个构造方法就可以了，将  
```  
public LabelEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        utils = new LabelViewHelper(context, attrs, defStyleAttr);
    }  
```  
修改为：  
```  
public LabelEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        utils = new LabelViewHelper(context, attrs, defStyleAttr);
    }  
```  
我们来看看修改后的界面：  
![](http://i.imgur.com/zDujNEe.png)

**对于这两种情况，xml中的定义是一样的： ** 
```  
<com.lavor.labelviewdemo.LabelEditView
        android:layout_width="match_parent"
        android:layout_height="48dp"
        app:label_backgroundColor="#03A9F4"
        app:label_distance="15dp"
        app:label_orientation="RIGHT_TOP"
        app:label_text="微信"
        app:label_textSize="10sp"/>  
```

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)

