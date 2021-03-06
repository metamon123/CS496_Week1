package com.example.q.cs496_week1;


import android.os.Handler;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Date;

public class ServiceThread extends Thread{
    Handler handler;
    boolean isRun = true;


    public ServiceThread(Handler handler){
        this.handler = handler;
    }

    public void stopForever(){
        synchronized (this) {
            this.isRun = false;
        }
    }

    public void run() {
        while(isRun){
            handler.sendEmptyMessage(0);
            try{
                Thread.sleep(1000 * 20);
            } catch(Exception e){}
        }
    }
}