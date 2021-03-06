package me.dailydreamer.nutapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    private ImageView ledImageView;
    public final int[] ledResId = {R.drawable.led0, R.drawable.led1, R.drawable.led2, R.drawable.led3, R.drawable.led4, R.drawable.led5, R.drawable.led6, R.drawable.led7, R.drawable.led8, R.drawable.led9, R.drawable.led10, R.drawable.led11, R.drawable.led12};

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
        ledImageView = (ImageView) v.findViewById(R.id.ledImageView);
        ledImageView.setImageResource(R.drawable.led0);
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

    @Override
    public void onResume() {
        super.onResume();
        updateAct();
    }

    public void displayData(String data) {
        returnText.setText(data);
    }

    public void updateAct(){
        Act act = ActList.get().getmAct();
        if (act.getmName().equals("Finish"))
            mActivity.goFinish();
        actNameText.setText(act.getmName());
        weightText.setText(act.getmWeight().toString() + "Kg");
        returnText.setText(ActList.get().getmCount());

        int i = ActList.get().getLedProgress();
        ledImageView.setImageResource(ledResId[i]);
    }

    public interface CallBacks{
        void goFinish();
    }
}
