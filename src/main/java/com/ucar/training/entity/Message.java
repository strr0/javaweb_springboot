package com.ucar.training.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String mName;
    private String mData;
    private String mDate;

    public Message(){}
    public Message(String mName, String mData){
        this.mName = mName;
        this.mData = mData;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.mDate = df.format(new Date());
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmName() {
        return mName;
    }
    public void setmData(String mData) {
        this.mData = mData;
    }
    public String getmData() {
        return mData;
    }
    public String getmDate() {
        return mDate;
    }
}
