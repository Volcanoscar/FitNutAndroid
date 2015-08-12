package me.dailydreamer.nutapp;

import java.util.ArrayList;

/**
 * Created by lixc1 on 2015/8/9.
 */
public class ActList {
    private static ActList sActList;
    private static Integer sOrder;
    private ArrayList<Act> mActs;

    private ActList(){
        mActs = new ArrayList<Act>();
        sOrder = -1;
        addAct(new Act("A", 10));
        addAct(new Act("B", 5));
        addAct(new Act("C", 8));
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
            return mActs.get(sOrder);
        else {
            sOrder = -1;
            return new Act("Finish", 0);
        }
    }

    public Act initAct(){
        sOrder = 0;
        return mActs.get(sOrder);
    }

    public int getProgress(){
        float tmp = (float)sOrder / mActs.size();
        if (tmp == 0)
            return 0;
        else if (tmp == 1)
            return 3;
        else if (tmp < 0.5)
            return 1;
        else
            return 2;
    }

    public ArrayList<Act> getActs(){
        return mActs;
    }

}
