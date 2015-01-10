package com.wearwolves.updog;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wearwolves.updog.adapters.LineGridPagerAdapter;
import com.wearwolves.updog.model.TransitLine;
import com.wearwolves.updog.util.LinesUtil;
import com.wearwolves.updog.views.SeekArc;

import java.util.ArrayList;

public class LineActivity extends Activity {

    private GridViewPager mGridPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.wvs_line_activity);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                TransitLine line = LinesUtil.getSingleLine("redline");
                line.init(line.mStations);
                ArrayList<TransitLine> orange = new ArrayList<TransitLine>();
                orange.add(LinesUtil.getSingleLine("orangeline"));
                orange.add(line);
                line.mLookup.get("70077").mLines = orange;
                mGridPager = (GridViewPager) stub.findViewById(R.id.pager);
                mGridPager.setAdapter(new LineGridPagerAdapter(LineActivity.this, getFragmentManager(), line));
            }
        });
    }
}
