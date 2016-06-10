#Android UI Libs之AndroidTreeView   
***  
#1. 说明  
***  
[AndroidTreeView](https://github.com/bmelnychuk/AndroidTreeView)，顾名思义，Android上面的树形视图。  
该库的特点：  
- 可扩展与销毁的N叉树  
- 为节点自定义值，视图，样式  
- 旋转屏幕后保存状态  
- 节点的选中模式  
- 动态添加，删除节点  

**注意：接近Android4.0的版本树的层次太深可能很容易导致程序崩溃。**  

#2. 配置  
***  
在模块的build.gradle中添加依赖：`compile 'com.github.bmelnychuk:atv:1.2.+'`  

#3. 基本使用  
***  
```  
    /**
     * AndroidTreeView的基本使用
     */
    public void baseUsage(){
        //创建根节点
        TreeNode root = TreeNode.root();
        //创建一般节点
        TreeNode parent = new TreeNode("父节点");
        TreeNode child0 = new TreeNode("子节点1");
        TreeNode child1 = new TreeNode("子节点2");
        //添加子节点
        parent.addChildren(child0, child1);
        root.addChild(parent);
        //创建树形视图
        AndroidTreeView tView = new AndroidTreeView(this, root);
        //将树形视图添加到layout中
        layout.addView(tView.getView());
    }  
``` 

程序运行界面如下：  
![](http://i.imgur.com/EqE6odN.gif)  

#4. 高级使用  
***  
我们可以看到上一节基本使用中的界面很丑，节点中只有文本信息，我们可以为节点自定义视图来提高用户体验。  

为节点创建已定义视图，继承`TreeNode.BaseNodeViewHolder`并重写`createNodeView`方法：  
```
public class MyHolder extends TreeNode.BaseNodeViewHolder<IconTreeItem> {
    ...
    @Override
    public View createNodeView(TreeNode node, IconTreeItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.layout_profile_node, null, false);
        TextView tvValue = (TextView) view.findViewById(R.id.node_value);
        tvValue.setText(value.text);

        return view;
    }
    ...
    public static class IconTreeItem {
        public int icon;
        public String text;
    }
}
```  
将节点与ViewHolder联系起来：  
```  
  IconTreeItem nodeItem = new IconTreeItem();
  TreeNode child1 = new TreeNode(nodeItem).setViewHolder(new MyHolder(mContext));  
```  


本库中示例中有8个自定义的ViewHolder，我利用其中之一`IconTreeItemHolder`来实现自定义节点视图：  
```  
    /**
     * AndroidTreeView的高级使用：为节点自定义视图
     */
    public void customViewForNode(){
        //创建根节点
        TreeNode root = TreeNode.root();
        //创建节点item
        IconTreeItemHolder.IconTreeItem nodeItem = new IconTreeItemHolder.IconTreeItem(R.string.ic_laptop,"我的设备");
        IconTreeItemHolder.IconTreeItem nodeItem2 = new IconTreeItemHolder.IconTreeItem(R.string.ic_folder,"文件夹");
        IconTreeItemHolder.IconTreeItem nodeItem3 = new IconTreeItemHolder.IconTreeItem(R.string.ic_drive_file,"文件");
        //创建一般节点
        TreeNode device = new TreeNode(nodeItem);
        TreeNode fold = new TreeNode(nodeItem2);
        TreeNode file = new TreeNode(nodeItem3);
        //添加子节点
        fold.addChild(file);
        device.addChild(fold);
        root.addChild(device);
        //创建树形视图
        AndroidTreeView tView = new AndroidTreeView(this, root);
        //设置树形视图开启默认动画
        tView.setDefaultAnimation(true);
        //设置树形视图默认的样式
        tView.setDefaultContainerStyle(R.style.TreeNodeStyleCustom);
        //设置树形视图默认的ViewHolder
        tView.setDefaultViewHolder(IconTreeItemHolder.class);
        //将树形视图添加到layout中
        layout.addView(tView.getView());
    }  
```  
程序运行后的界面是这样的：  
![](http://i.imgur.com/UEq4UaT.gif)  

程序源代码下载，我的github仓库：[https://github.com/lavor-zl/UILibs](https://github.com/lavor-zl/UILibs) 


**欢迎关注我的简书专题：[Android技术漫谈](http://www.jianshu.com/collection/4833a48d1cb2)**   
**欢迎关注我的微信公众号：Android技术漫谈**  
![](http://i.imgur.com/u75x3BP.jpg)


 
