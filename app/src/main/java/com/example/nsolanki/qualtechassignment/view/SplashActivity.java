package com.example.nsolanki.qualtechassignment.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nsolanki.qualtechassignment.R;
import com.example.nsolanki.qualtechassignment.contract.ISplashContract;
import com.example.nsolanki.qualtechassignment.presenter.SplashPresenter;

public class SplashActivity extends AppCompatActivity implements ISplashContract.ISplashView {

    private String TAG = SplashActivity.class.getCanonicalName();

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashPresenter = new SplashPresenter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        splashPresenter.bind(this);
        splashPresenter.callIntentLauncher();
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashPresenter.unbind();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SplashActivity.this.finish();
    }

    @Override
    public void navigateToListing() {
        Intent i = new Intent(this, ListingActivity.class);
        startActivity(i);
    }

}
