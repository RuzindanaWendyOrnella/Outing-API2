package com.moringaschool.outingapi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.moringaschool.outingapi2.models.Event;
import com.moringaschool.outingapi2.models.YelpSearchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {
    private static final String TAG = ApiActivity.class.getSimpleName();

    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String event = ((TextView)view).getText().toString();
                Toast.makeText(ApiActivity.this, event, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the events near: " + location);
        System.out.println(location);
        YelpApi client = YelpClient.getClient();

        Call<YelpSearchResponse> call = client.getEvents(location);

        call.enqueue(new Callback<YelpSearchResponse>() {
            @Override
            public void onResponse(Call<YelpSearchResponse> call, Response<YelpSearchResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Event> eventsList = response.body().getEvents();
                    String[] events = new String[eventsList.size()];


                    for (int i = 0; i < events.length; i++){
                        events[i] = eventsList.get(i).getName();
                    }



                    ArrayAdapter adapter
                            = new ApiArrayAdapter(ApiActivity.this, android.R.layout.simple_list_item_1, events);
                    mListView.setAdapter(adapter);
                    System.out.println(eventsList);

                    showEvents();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<YelpSearchResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showEvents() {
        mListView.setVisibility(View.VISIBLE);
        mLocationTextView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}