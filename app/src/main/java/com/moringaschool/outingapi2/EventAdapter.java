/*
package com.moringaschool.outingapi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<Business> mEvents;

    private Context mContext;

    public EventAdapter(Context context, List<Business> events) {
        mContext = context;
        mEvents = events;
    }
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_each, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(EventAdapter.EventViewHolder holder, int position) {
        holder.bindRestaurant(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }
    public class EventViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.eventImageView) ImageView mEventImageView;
        @BindView(R.id.eventNameTextView) TextView mEventNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Business event) {
            Picasso.get().load(event.getImageUrl()).into(mEventImageView);
            mEventNameTextView.setText(event.getName());
            mCategoryTextView.setText(event.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + event.getRating() + "/5");
        }

    }
}
*/
