package com.ucar.training.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private int mId;
    private String mName;
    private String mData;
    private String mTime;

    public Message(){}
    public Message(int mId, String mName, String mData, String mTime){
        this.mId = mId;
        this.mName = mName;
        this.mData = mData;
        this.mTime = mTime;
    }
    public Message(String mName, String mData){
        this(-1, mName, mData, null);
    }

    public int getmId() {
        return mId;
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

    public String getmTime() {
        return mTime;
    }
}
