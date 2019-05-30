package com.example.xmly.test5;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyJobServices extends JobService{

        private static final String TAG = "MyJobService";

        /**
         * false: 该系统假设任何任务运行不需要很长时间并且到方法返回时已经完成。
         * true: 该系统假设任务是需要一些时间并且当任务完成时需要调用jobFinished()告知系统。
         */
        @Override
        public boolean onStartJob(JobParameters params) {
            Log.i(TAG, "Totally and completely working on job " + params.getJobId());
            if (isNetworkConnected()) {
                new SimpleDownloadTask().execute(params);
                return true;
            } else {
                Log.i(TAG, "No connection on job " + params.getJobId() + "; sad face");
            }
            return false;
        }

        /**
         * 当收到取消请求时，该方法是系统用来取消挂起的任务的。
         * 如果onStartJob()返回false，则系统会假设没有当前运行的任务，故不会调用该方法。
         */
        @Override
        public boolean onStopJob(JobParameters params) {
            Log.i(TAG, "stop job " + params.getJobId());
            return false;
        }

        private boolean isNetworkConnected() {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            return (info != null && info.isConnected());
        }

        private class SimpleDownloadTask extends
                AsyncTask<JobParameters, Void, String> {

            private JobParameters mJobParam;

            @Override
            protected String doInBackground(JobParameters... params) {
                mJobParam = params[0];
                try {
                    InputStream is = null;
                    int len = 50;
                    URL url = new URL("http://www.baidu.com");
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("GET");
                    conn.connect();
                    int responseCode = conn.getResponseCode();
                    Log.i(TAG, "response code is : " + responseCode);
                    is = conn.getInputStream();
                    Reader reader = null;
                    reader = new InputStreamReader(is, "UTF-8");
                    char[] buffer = new char[len];
                    reader.read(buffer);
                    return new String(buffer);
                } catch (Exception e) {
                    return "unable to retrieve web page";
                }
            }

            @Override
            protected void onPostExecute(String result) {
                jobFinished(mJobParam, false);
                Log.i(TAG, "获取结果：" + result);
            }
        }
}
