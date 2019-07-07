package com.example.xmly.test5;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xmly.test5.view.CustomSearchPathView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ComponentName jobService;
    private CustomSearchPathView searchView;
    private Button startButton;
    private Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        for (String item : list) {
//            Log.i(TAG, "onCreate: --0--");
//            if (item.equals("1")){
//                Log.i(TAG, "onCreate: --------remove-----");
//                System.out.println(item);
//                list.remove(item);
//            }
//        }
//        Log.i(TAG, "onCreate: --jackie---");
//
////        Intent service = new Intent(this, CarAndHomeJobService.class);
////        startService(service);
//        jobService = new ComponentName(this, MyJobServices.class);
//        Intent service = new Intent(this, MyJobServices.class);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(service);
//        }
////        startService(service);
//
////        result = (TextView) findViewById(R.id.result_tv);
//        Button btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                pollServer();
//            }
//        });

        searchView = findViewById(R.id.search_view);
        closeBtn = findViewById(R.id.btn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.closeSearckAnimator();
            }
        });
        startButton = findViewById(R.id.btn_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.startSearckAnimator(new CustomSearchPathView.OnAnimatorEndListener() {
                    @Override
                    public void end() {

                    }
                });
            }
        });

    }


    private void pollServer() {
        JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int jobId;
        for (int i = 0; i < 10; i++) {
            jobId = i;
            JobInfo jobInfo = new JobInfo.Builder(jobId, jobService)
                    .setMinimumLatency(5000)// 设置任务运行最少延迟时间
                    .setOverrideDeadline(6000)// 设置deadline，若到期还没有达到规定的条件则会开始执行
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)// 设置网络条件
                    .setRequiresCharging(true)// 设置是否充电的条件
                    .setRequiresDeviceIdle(false)// 设置手机是否空闲的条件
                    .build();
//            result.append("scheduling job " + i + "!\n");
            scheduler.schedule(jobInfo);
        }
    }


}
