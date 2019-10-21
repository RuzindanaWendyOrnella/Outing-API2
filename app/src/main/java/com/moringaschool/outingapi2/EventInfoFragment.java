package com.moringaschool.outingapi2;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.moringaschool.outingapi2.models.Event;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventInfoFragment extends Fragment {

    @BindView(R.id.restaurantImageView) ImageView mRestaurantImageView;

    @BindView(R.id.restaurantNameTextView) TextView mRestaurantNameTextView;

    @BindView(R.id.phoneTextView) TextView mPhoneLabel;

    @BindView(R.id.addressTextView) TextView mAddressLabel;

    @BindView(R.id.saveRestaurantButton) TextView mSaveRestaurantButton;


    private Event mEvent;

    public EventInfoFragment(){
        // Required empty public constructor
    }

    public static EventInfoFragment newInstance(Event event) {
        EventInfoFragment restaurantDetailFragment = new EventInfoFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", Parcels.wrap(event));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getArguments().getParcelable("event"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_info, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mEvent.getImageUrl()).into(mRestaurantImageView);



        mRestaurantNameTextView.setText(mEvent.getName());
        mPhoneLabel.setText(mEvent.getDescription());
        mAddressLabel.setText(mEvent.getLocation().toString());

        return view;
    }
}
