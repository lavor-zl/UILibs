#Android UI Libs之CircleIndicator  
***  
#1. 说明  
***  
[CircleIndicator](https://github.com/ongakuer/CircleIndicator)，顾名思义，圆形指示器，只一个可以用来做轮播的第三方库。  

#2. 配置  
***  
在模块的build.gradle中添加依赖：`compile 'me.relex:circleindicator:1.2.1@aar'`   

#3. 基本使用  
***  
在xml布局文件中定义`ViewPager`与`CircleIndicator`：  
```  
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="150dp">
        <android.support.v4.view.ViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="150dp">
        </android.support.v4.view.ViewPager>
        <me.relex.circleindicator.CircleIndicator
            android:id="@+id/indicator"
            android:layout_width="match_parent"
            android:layout_height="48dp"/>
    </RelativeLayout>  
```  
**注意：`ViewPager`与`CircleIndicator`一般放在同一个`RelativeLayout`中，并且`CircleIndicator`放在后面**  

在java文件中的相关操作：  
```  
        this.indicator = (CircleIndicator) findViewById(R.id.indicator);
        this.viewpager = (ViewPager) findViewById(R.id.view_pager);
        List<Fragment> list=new ArrayList<>();
        myFragment1 = new MyFragment(R.drawable.image1);
        myFragment2 = new MyFragment(R.drawable.image2);
        myFragment3 = new MyFragment(R.drawable.image3);
        list.add(myFragment1);
        list.add(myFragment2);
        list.add(myFragment3);
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),list);
        viewpager.setAdapter(myPagerAdapter);
        indicator.setViewPager(viewpager);  
```
`MyFragment`是我自定义的Fragment，它里面包含一个`ImageView`，`MyPagerAdapter`是我自定义的Adapter。  

程序运行界面：  
![](http://i.imgur.com/o79UcNo.gif)  

我们发现可以轮播，但是不能循环，我们想要循环怎么办，别担心，下一节我们来实现循环轮播。  

`CircleIndicator`还有下面一些属性，属性命名很规则，一看名字就知道属性是干什么的：
- app:ci_width：
- app:ci_height
- app:ci_margin
- app:ci_drawable
- app:ci_drawable_unselected
- app:ci_animator
- app:ci_animator_reverse
- app:ci_orientation (default:horizontal)
- app:ci_gravity (default:center)

#4. 高级使用  
***  
该库的LoopingViewPager目录下面为我们提供了循环的ViewPager，我们需要将其中的`LoopPagerAdapterWrapper`，`LoopViewPager`这两个类复制到我们的项目中来就。然后要将`android.support.v4.view.ViewPager`改为`com.lavor.circleindicatordemo.LoopViewPager`。  
- 当我们的Adapter是继承自`FragmentPagerAdapter` 时，无法使用该循环的ViewPager（即`LoopViewPager`）  
- 当我们的Adapter是`SamplePagerAdapter`时，`SamplePagerAdapter`是该库实例中的一个Adapter时，可以循环轮播，但是明显从最后一个滑动到第一个时，第一页显示了两次，貌似利用该库中的`LoopViewPager`还无法解决这个问题。

**我们要实现循环轮播的最佳解决方案： ** 
- 利用另一个库[LoopViewPager](https://github.com/yanzm/LoopViewPager)下面的`LoopViewPager`  
- 修改[CircleIndicator](https://github.com/ongakuer/CircleIndicator)下面`CircleIndicator`的源代码，将`setViewPager(ViewPager viewPager)`方法中的`ViewPager`改为上面所提库中的`LoopViewPager`，并将与之关联的`ViewPager`都改为上面所提库中的`LoopViewPager`，其他关联代码对应改过来。  

程序运行后的界面： 
![](http://i.imgur.com/1NnDuJM.gif)  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)

