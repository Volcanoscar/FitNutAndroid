package me.dailydreamer.nutapp;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by lixc1 on 2015/8/9.
 */
public class ActList {
    private static ActList sActList;
    private static Integer sOrder;
    private ArrayList<Act> mActs;

    private Act mAct;
    private String mCount;

    private ActList(){
        mActs = new ArrayList<Act>();
        addAct(new Act("A", 2));
        addAct(new Act("B", 2));
        addAct(new Act("C", 2));
    }

    public static ActList get(){
        if (sActList == null)
            sActList = new ActList();
        return sActList;
    }

    public void addAct(Act act){
        mActs.add(act);
    }

    public Act getNextAct(){
        if (++sOrder < mActs.size())
            mAct = mActs.get(sOrder);
        else {
            mAct = new Act("Finish", 0);
        }
        return mAct;
    }

    public Act initAct(){
        sOrder = 0;
        mAct = mActs.get(sOrder);
        return mAct;
    }

    public int getNutProgress(){
        Float tmp = (float)sOrder / mActs.size();
        Log.d("progress", tmp.toString());
        if (tmp < 0.05)
            return 0;
        else if (tmp > 0.95)
            return 3;
        else if (tmp < 0.5)
            return 1;
        else
            return 2;
    }

    public int getLedProgress(){
        return (int)((float)sOrder * 12 / mActs.size());
    }

    public ArrayList<Act> getActs(){
        return mActs;
    }

    public int getGroupNumber(){
        return mActs.size();
    }

    public Act getmAct() {
        return mAct;
    }

    public void setmAct(Act mAct) {
        this.mAct = mAct;
    }

    public String getmCount() {
        return mCount;
    }

    public void setmCount(String mCount) {
        this.mCount = mCount;
    }
}
