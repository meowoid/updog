package com.wearwolves.updog.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wearwolves.updog.R;
import com.wearwolves.updog.model.TransitStop;
import com.wearwolves.updog.views.SeekArc;

/**
 * Created by ell on 1/10/15.
 */
public class StationFragment extends Fragment implements View.OnClickListener{
    private LinearLayout mSeekArc;
    private View mRootView;
    private TextView mStationName;
    private TextView mDestination1;
    private TextView mDestination2;
    private TextView mDestination3;
    private TextView mPreviousStationName;
    private TextView mNextStationName;
    private TransitStop mStop;

    public StationFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_station, container, false);

        final WatchViewStub stub = (WatchViewStub) mRootView.findViewById(R.id.wvs_station_fragment);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mSeekArc = (LinearLayout) mRootView.findViewById(R.id.seek_arc);
                mSeekArc.setVisibility(View.GONE);

                mStationName = (TextView) mRootView.findViewById(R.id.tv_name);
                mDestination1 = (TextView) mRootView.findViewById(R.id.tv_dest1);
                mDestination2 = (TextView) mRootView.findViewById(R.id.tv_dest2);
                mDestination3 = (TextView) mRootView.findViewById(R.id.tv_dest3);
                mPreviousStationName = (TextView) mRootView.findViewById(R.id.tv_previous_station);
                mNextStationName = (TextView) mRootView.findViewById(R.id.tv_next_station);

                if (mStop != null){
                    mStationName.setText(mStop.mParentStationName);

                    if (mStop.mLines != null && mStop.mLines.size() > 1){
                        mSeekArc.setVisibility(View.VISIBLE);
                    }else {
                        mSeekArc.setVisibility(View.GONE);
                    }
                }
            }
        });
        return mRootView;
    }

    public void setStop(TransitStop stop) {
        this.mStop = stop;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_redline:
                break;
            case R.id.iv_bline:
                break;
            case R.id.iv_cline:
                break;
            case R.id.iv_dline:
                break;
            case R.id.iv_eline:
                break;
        }
    }
}
