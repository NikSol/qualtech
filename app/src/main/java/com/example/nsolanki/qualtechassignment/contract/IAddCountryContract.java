package com.example.nsolanki.qualtechassignment.contract;


import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

public interface IAddCountryContract {
    interface IAddCountryView extends IBaseContract.IBaseView{
        CountriesDataEntity provideDataToAdd();
        void showError(String errorMessage);
        void navigateBackToListing();
        String provideAddErrorString();
    }

    interface IAddCountryPresenter extends IBaseContract.IBasePresenter{
        void handleAddButtonClick(QualtechDBManager dbManager);
    }
}
