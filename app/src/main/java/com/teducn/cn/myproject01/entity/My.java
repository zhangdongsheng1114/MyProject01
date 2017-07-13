package com.teducn.cn.myproject01.entity;

/**
 * Created by tarena on 2017/5/29.
 */

public class My {
    private String myname;
    private int myimageId;
    private int myimageRightId;

    public My(String myname, int myimageId, int myimageRightId) {
        this.myname = myname;
        this.myimageId = myimageId;
        this.myimageRightId = myimageRightId;
    }

    public String getMyname() {
        return myname;
    }

    public int getMyimageId() {
        return myimageId;
    }

    public int getMyimageRightId() {
        return myimageRightId;
    }
}
