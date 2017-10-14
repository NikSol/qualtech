package com.example.nsolanki.qualtechassignment.contract;


import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

import java.util.List;

public interface IListingContract {
    interface IListingView extends IBaseContract.IBaseView {
        void receiveCountriesList(List<CountriesDataEntity> countriesDataEntityList);

        void navigateToDetails(CountriesDataEntity countriesDataEntity);

        CountriesDataEntity provideDataForPosition(int position);

        void navigateToAdd();

        void showProgressBar();
    }


    interface IListingPresenter extends IBaseContract.IBasePresenter {

        void handleCellClicked(int position);

        void handleAddMenuItemClicked();

        void fetchDataFromServerOrDatabase(QualtechDBManager qualtechDBManager);
    }
}
