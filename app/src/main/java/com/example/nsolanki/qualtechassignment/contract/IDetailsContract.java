package com.example.nsolanki.qualtechassignment.contract;


import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

public interface IDetailsContract {
    interface IDetailsView extends IBaseContract.IBaseView{
        CountriesDataEntity provideDataForUpdate();
        void navigateBackToListing();
        void showError(String errorMessage);
        String provideUpdateErrorString();
        String provideDeleteErrorString();
    }

    interface IDetailsPresenter extends IBaseContract.IBasePresenter{
        void handleUpdateButtonClick(QualtechDBManager qualtechDBManager);
        void handleDeleteButtonClick(QualtechDBManager qualtechDBManager);
    }
}
