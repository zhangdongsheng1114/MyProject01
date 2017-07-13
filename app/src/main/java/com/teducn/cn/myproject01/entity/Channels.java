package com.teducn.cn.myproject01.entity;

/**
 * Created by tarena on 2017/5/28.
 */

public class Channels {
    private String name;
    private int imageId;
    private int imageRightId;

    public Channels(String name, int imageId, int imageRightId) {
        this.name = name;
        this.imageId = imageId;
        this.imageRightId = imageRightId;
    }

    public int getImageRightId() {
        return imageRightId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
