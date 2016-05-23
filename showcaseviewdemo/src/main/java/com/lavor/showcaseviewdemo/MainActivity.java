package com.lavor.showcaseviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class MainActivity extends AppCompatActivity {

    private android.widget.EditText username;
    private android.widget.EditText password;
    private android.widget.Button register;
    private ShowcaseView usernameShowcaseView;
    private ShowcaseView passwordShowcaseView;
    private ShowcaseView registerShowcaseView;
    private ViewTarget registerTarget;
    private ViewTarget passwordTarget;
    private ViewTarget usernameTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_showcase_view);
        registerGuide();

    }

    /**
     * 简单的用户注册引导
     */
    public  void registerGuide(){
        this.register = (Button) findViewById(R.id.register);
        this.password = (EditText) findViewById(R.id.password);
        this.username = (EditText) findViewById(R.id.username);
        usernameTarget = new ViewTarget(username);
        passwordTarget = new ViewTarget(password);
        registerTarget = new ViewTarget(register);
        final Button usernameButton=new Button(this);
        usernameButton.setText("下一步");
        final Button passwordButton=new Button(this);
        passwordButton.setText("下一步");
        final Button registerButton=new Button(this);
        registerButton.setText("明白了");
        usernameShowcaseView=new ShowcaseView.Builder(this)
                .withHoloShowcase()
                .setTarget(usernameTarget)
                .setContentTitle("第一步")
                .setContentText("请输入用户名")
                .replaceEndButton(usernameButton)
                .build();
        passwordShowcaseView=new ShowcaseView.Builder(MainActivity.this)
                .withHoloShowcase()
                .setTarget(passwordTarget)
                .setContentTitle("第二步")
                .setContentText("请输入密码")
                .replaceEndButton(passwordButton)
                .build();
        passwordShowcaseView.hide();
        registerShowcaseView=new ShowcaseView.Builder(MainActivity.this)
                .withHoloShowcase()
                .setTarget(registerTarget)
                .setContentTitle("第三步")
                .setContentText("请点击注册按钮")
                .replaceEndButton(registerButton)
                .build();
        registerShowcaseView.hide();
        usernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameShowcaseView.hide();
                passwordShowcaseView.show();
            }
        });
        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordShowcaseView.hide();
                registerShowcaseView.show();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerShowcaseView.hide();
            }
        });
    }

    /**
     * ShowcaseView的基本使用
     */
    public void baseUsage(){
        ViewTarget target = new ViewTarget(R.id.register, this);
        new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(target)
                .setContentTitle("我的微信公众号")
                .setContentText("Android 技术漫谈")
                .hideOnTouchOutside()
                .build();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
