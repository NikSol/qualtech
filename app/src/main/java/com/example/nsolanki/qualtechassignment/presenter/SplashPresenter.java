package com.example.nsolanki.qualtechassignment.presenter;

import com.example.nsolanki.qualtechassignment.contract.ISplashContract;

public class SplashPresenter extends BasePresenter<ISplashContract.ISplashView> implements ISplashContract.ISplashPresenter {

    private static long sleep_time = 5000;

    public SplashPresenter() {
    }

    @Override
    public void callIntentLauncher() {
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }


    private class IntentLauncher extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            SplashPresenter.this.view.navigateToListing();
        }
    }
}
