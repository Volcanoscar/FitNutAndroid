package me.dailydreamer.nutapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 心成 on 2015/7/28.
 */
public class CountFragment extends Fragment{

    private CallBacks mActivity;
    private TextView returnText;
    private TextView actNameText;
    private TextView weightText;
    private Button goFinishButton;
    private Act mAct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_count, parent, false);

        returnText = (TextView) v.findViewById(R.id.returnText);
        actNameText = (TextView) v.findViewById(R.id.actNameText);
        weightText = (TextView) v.findViewById(R.id.actWeightText);
        goFinishButton = (Button) v.findViewById(R.id.goFinishButton);
        goFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.goFinish();
            }
        });
        initAct();
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (CallBacks)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    public void handleData(String data){
        if (data != null){
            displayData(data);
            if (data.equals("Finish")){
                changeAct();
            }
        }
    }

    private void displayData(String data) {
        returnText.setText(data);
    }

    private void initAct(){
        mAct = ActList.get().initAct();
        mActivity.sendMessage("N" + mAct.getmNum().toString() + "D");
        actNameText.setText(mAct.getmName());
        weightText.setText(mAct.getmWeight().toString());

    }

    private void changeAct(){
        mAct = ActList.get().getNextAct();
        if (mAct.getmName().equals("Finish")){
            mActivity.goFinish();
        }else {
            mActivity.sendMessage("N" + mAct.getmNum().toString() + "D");
            actNameText.setText(mAct.getmName());
            weightText.setText(mAct.getmWeight().toString());
        }
    }

    public interface CallBacks{
        void sendMessage(String str);
        void goFinish();
    }
}
