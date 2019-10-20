package com.moringaschool.outingapi2;

import android.content.Context;
import android.widget.ArrayAdapter;
public class ApiArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mEvents;


    public ApiArrayAdapter(Context mContext, int resource, String[] mEvents) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mEvents = mEvents;

    }
    @Override
    public Object getItem(int position) {
        String event = mEvents[position];
        return event;
    }

    @Override
    public int getCount() {
        return mEvents.length;
    }
}