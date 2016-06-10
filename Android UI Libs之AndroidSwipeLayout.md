#Android UI Libs之AndroidSwipeLayout  
***  
#1. 说明  
***  
[AndroidSwipeLayout](https://github.com/daimajia/AndroidSwipeLayout)，顾名思义，Android平台上的滑动布局，是一个可以让我们很方便使用滑动的库，典型的应用就是侧滑删除与侧滑菜单。  

#2. 配置  
***  
在模块中添加依赖：`compile "com.daimajia.swipelayout:library:1.2.0@aar"`  

#3.基本使用  
***  
![](http://i.imgur.com/fMrFZk4.jpg)  

##1. Show Mode  
- LayDown 
![](http://i.imgur.com/sJGmvBG.gif)  
- PullOut  
![](http://i.imgur.com/Y2po5eG.gif)  

##2. Drag edge  
- LEFT
- RIGHT
- TOP
- BOTTOM  

##3. 在xml布局文件中使用`SwipeLayout`  
- `SwipeLayout`的最后一个孩子是`SurfaceView`，其他孩子都是`BottomView`  
- `BottomView`最好添加上`andorid:layout_gravity`属性  

```  
 <com.daimajia.swipe.SwipeLayout
        android:layout_width="match_parent"
        android:layout_height="80dp">
        <!-- Bottom View Start-->
        <LinearLayout
            android:background="#66ddff00"
            android:id="@+id/bottom_wrapper"
            android:layout_width="160dp"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <!--What you want to show-->
            <TextView
                android:text="欢迎关注我的微信公众号：Android技术漫谈"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
        </LinearLayout>
        <!-- Bottom View End-->

        <!-- Surface View Start -->
        <LinearLayout
            android:padding="10dp"
            android:background="#ffffff"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <!--What you want to show in SurfaceView-->
            <TextView
                android:text="欢迎关注我的github:lavor-zl"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
        </LinearLayout>
        <!-- Surface View End -->
    </com.daimajia.swipe.SwipeLayout>
```  
![](http://i.imgur.com/4lvyn2K.gif)  

##4. 在java文件中对`SwipeLayout`进行一些相关操作
```  
SwipeLayout swipeLayout =  (SwipeLayout)findViewById(R.id.sample1);

//set show mode.
swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

//add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
swipeLayout.addDrag(SwipeLayout.DragEdge.Left, findViewById(R.id.bottom_wrapper));

swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView.
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
               //you are swiping.
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
               //when the BottomView totally show.
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
               //when user's hand released.
            }
        });  
```

#4. 高级使用  
***  
我们经常需要在`ListView`，`RecyclerView`等中使用侧滑删除或者侧滑菜单，那么我们如何利用AndroidSwipeLayout来实现呢。  

`Adapter`的定义如下：  
```  
public class MyRecyclerViewAdapter extends RecyclerSwipeAdapter<MyRecyclerViewAdapter.MyViewHolder>{
    private Context context;
    private List<String> list;
    public MyRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.surface.setText(list.get(position));
        viewHolder.bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private SwipeLayout swipeLayout;
        private Button bottom;
        private TextView surface;
        public MyViewHolder(View itemView) {
            super(itemView);
            swipeLayout=(SwipeLayout)itemView.findViewById(R.id.swipe_layout);
            bottom=(Button)itemView.findViewById(R.id.bottom);
            surface=(TextView)itemView.findViewById(R.id.surface);
        }
    }
}
```  

`adapter.xml`的内容：  
```  
<com.daimajia.swipe.SwipeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/swipe_layout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <!-- Bottom View Start-->
    <LinearLayout
        android:background="#66ddff00"
        android:id="@+id/bottom_wrapper"
        android:layout_width="160dp"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <!--What you want to show-->
        <Button
            android:id="@+id/bottom"
            android:text="删除"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </LinearLayout>
    <!-- Bottom View End-->

    <!-- Surface View Start -->
    <LinearLayout
        android:padding="10dp"
        android:background="#ffffff"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <!--What you want to show in SurfaceView-->
        <Button
            android:id="@+id/surface"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </LinearLayout>
    <!-- Surface View End -->
</com.daimajia.swipe.SwipeLayout>  
```  

`ReccyclerView`相关设置
```  
 List<String> list=new ArrayList<>();
        for(int i=0;i<40;i++){
             list.add("欢迎关注我的github:lavor-zl:"+(i+1));
        }
        MyRecyclerViewAdapter myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(myRecyclerViewAdapter);  
```   

这些代码基本上实现了侧滑删除，程序运行界面如下
![](http://i.imgur.com/CehPfQl.gif)  

继承`RecyclerSwipeAdapter`的`Adapter`比继承`RecyclerView.Adapter`的`Adapter`多了很多方法，常用的有下面几个：
- `openItem(int position)`：打开某个item的侧滑  
- `closeItem(int position)`：关闭某个打开的侧滑  
- `getOpenItems()`：获取所有打开的item
- `isOpen(int position)`:判断某个位置的item是否打开侧滑  
- `getMode()`：获取侧滑显示模式  
- `setMode(Attributes.Mode mode)`：设置侧滑显示模式

同理可以操作`ListView`等，操作`ListView`时可以让`Adapter`继承`BaseSwipeAdapter`  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg) 