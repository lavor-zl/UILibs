package com.lavor.androidtreeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lavor.androidtreeviewdemo.holder.HeaderHolder;
import com.lavor.androidtreeviewdemo.holder.IconTreeItemHolder;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

public class MainActivity extends AppCompatActivity {

    private android.widget.LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tree_view);
        this.layout = (LinearLayout) findViewById(R.id.layout);
//        baseUsage();
        customViewForNode();

    }

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
}
