package me.dailydreamer.nutapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lixc1 on 2015/8/9.
 */
public class PlanFragment extends ListFragment {
    private Button startButton;
    private CallBacks mActivity;
    private ArrayList<Act> mActs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActs = ActList.get().getActs();
        ActAdapter adapter = new ActAdapter(mActs);
        setListAdapter(adapter);

        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_plan, parent, false);

        startButton = (Button)v.findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.setCountFragment();
            }
        });

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
    public void onListItemClick(ListView l, View v, int position, long id) {
        Act act = ((ActAdapter)getListAdapter()).getItem(position);
        //TODO
    }

    private class ActAdapter extends ArrayAdapter<Act> {

        public ActAdapter(ArrayList<Act> acts){
            super(getActivity(), 0, acts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = getActivity().getLayoutInflater().inflate(R.layout.listitem_act, null);
            final Act act = getItem(position);

            TextView nameTextView = (TextView)convertView.findViewById(R.id.nameTextView);
            TextView weightTextView = (TextView)convertView.findViewById(R.id.weightTextView);
            EditText numTextView = (EditText)convertView.findViewById(R.id.numTextView);

            nameTextView.setText(act.getmName());
            weightTextView.setText(act.getmWeight().toString());
            numTextView.setText(act.getmNum().toString());

    /*        numTextView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    act.setmNum(Integer.parseInt(editable.toString()));
                }
            }); */

            return convertView;
        }

    }

    public interface CallBacks{
        void setCountFragment();
    }
}
