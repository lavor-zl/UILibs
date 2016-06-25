package com.lavor.widget.sweet_alert_dialogdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {
    private android.widget.Button showNormal;
    private android.widget.Button showError;
    private android.widget.Button showWarning;
    private android.widget.Button showSuccess;
    private android.widget.Button showCustomImage;
    private android.widget.Button showProgress;
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.showNormal:showSweetAlertDialog(0);break;
                case R.id.showError:showSweetAlertDialog(1);break;
                case R.id.showWarning:showSweetAlertDialog(2);break;
                case R.id.showSuccess:showSweetAlertDialog(3);break;
                case R.id.showCustomImage:showSweetAlertDialog(4);break;
                case R.id.showProgress:showSweetAlertDialog(5);break;
                default:break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweet_alert_dialog_activity_main);
        this.showProgress = (Button) findViewById(R.id.showProgress);
        this.showCustomImage = (Button) findViewById(R.id.showCustomImage);
        this.showSuccess = (Button) findViewById(R.id.showSuccess);
        this.showWarning = (Button) findViewById(R.id.showWarning);
        this.showError = (Button) findViewById(R.id.showError);
        this.showNormal = (Button) findViewById(R.id.showNormal);
        this.showProgress.setOnClickListener(onClickListener);
        this.showCustomImage.setOnClickListener(onClickListener);
        this.showSuccess.setOnClickListener(onClickListener);
        this.showWarning.setOnClickListener(onClickListener);
        this.showError.setOnClickListener(onClickListener);
        this.showNormal.setOnClickListener(onClickListener);




    }

    public void showSweetAlertDialog(int type) {
        if (type == 0) {
            new SweetAlertDialog(this)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 1) {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 2) {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 3) {
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .show();
        } else if (type == 4) {
            new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("对话框标题")
                    .setContentText("对话框内容")
                    .setConfirmText("确定")
                    .setCustomImage(R.drawable.image)
                    .show();
        } else if (type == 5) {
            final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("对话框标题")
                    .setContentText("对话框内容");
            pDialog.setCancelable(false);
            pDialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        pDialog.dismiss();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
