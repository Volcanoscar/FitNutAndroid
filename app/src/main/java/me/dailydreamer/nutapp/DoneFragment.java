package me.dailydreamer.nutapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by lixc1 on 2015/8/9.
 */
public class DoneFragment extends Fragment {
    private Button finishButton;
    private ImageView ledImageView;
    private final int[] resId = {R.drawable.wkotdone0, R.drawable.wkotdone1, R.drawable.wkotdone3, R.drawable.wkotdone5};
    public final int[] ledResId = {R.drawable.led0, R.drawable.led1, R.drawable.led2, R.drawable.led3, R.drawable.led4, R.drawable.led5, R.drawable.led6, R.drawable.led7, R.drawable.led8, R.drawable.led9, R.drawable.led10, R.drawable.led11, R.drawable.led12};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_done, parent, false);

        int tmp = ActList.get().getNutProgress();
        v.setBackground(getResources().getDrawable(resId[tmp]));

        finishButton = (Button)v.findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        ledImageView = (ImageView)v.findViewById(R.id.ledImageView);
        int i = ActList.get().getLedProgress();
        ledImageView.setImageResource(ledResId[i]);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
