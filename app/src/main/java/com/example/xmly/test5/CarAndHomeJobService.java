package com.example.xmly.test5;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CarAndHomeJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        startJobSheduler();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public void startJobSheduler() {
        try {
            Log.i("jackie----", "startJobSheduler: -----");
            JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this, CarAndHomeJobService.class));
            builder.setPeriodic(5);
            builder.setPersisted(true);
            builder.setRequiresCharging(true);
            builder.setOverrideDeadline(3000);
            JobScheduler jobScheduler = (JobScheduler) this.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            jobScheduler.schedule(builder.build());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_REDELIVER_INTENT;
    }
}
