package me.dailydreamer.nutapp;

/**
 * Created by lixc1 on 2015/8/9.
 */
public class Act {
    private String mName;
    private Integer mNum;
    private Integer mWeight;

    public Act(String name, Integer num){
        mName = name;
        mNum = num;
        mWeight = 10;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmNum() {
        return mNum;
    }

    public void setmNum(Integer mNum) {
        this.mNum = mNum;
    }

    public Integer getmWeight() {
        return mWeight;
    }

    public void setmWeight(Integer mWeight) {
        this.mWeight = mWeight;
    }
}
