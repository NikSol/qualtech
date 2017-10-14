package com.example.nsolanki.qualtechassignment.contract;


public interface ISplashContract {
    interface ISplashView extends IBaseContract.IBaseView{
        void navigateToListing();
    }

    interface ISplashPresenter extends IBaseContract.IBasePresenter{
        void callIntentLauncher();
    }
}
