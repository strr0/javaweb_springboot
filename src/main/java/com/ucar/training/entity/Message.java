package com.ucar.training.entity;

public class Message {
    private String mName;
    private String mData;

    public Message(){}
    public Message(String mName, String mData){
        this.mName = mName;
        this.mData = mData;
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
}
