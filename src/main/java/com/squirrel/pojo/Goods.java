package com.squirrel.pojo;

import java.util.ArrayList;
import java.util.List;

public class Goods {
    private Integer id;

    private Integer catelogId;

    private Integer userId;

    private String name;

    private Float price;

    private Float realPrice;

    private String startTime;

    private String endTime;

    private String polishTime;

    private Integer commetNum;

    private String describle;

    private int state;

    private User user;
    private List<Image> images;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(Integer catelogId) {
        this.catelogId = catelogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Float realPrice) {
        this.realPrice = realPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getCommetNum() {
        return commetNum;
    }

    public void setCommetNum(Integer commetNum) {
        this.commetNum = commetNum;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
    }

    public String getPolishTime() {
        return polishTime;
    }

    public void setPolishTime(String polishTime) {
        this.polishTime = polishTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", catelogId=" + catelogId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", realPrice=" + realPrice +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", polishTime='" + polishTime + '\'' +
                ", commetNum=" + commetNum +
                ", describle='" + describle + '\'' +
                '}';
    }
}
