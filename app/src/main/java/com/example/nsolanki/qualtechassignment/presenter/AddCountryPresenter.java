package com.example.nsolanki.qualtechassignment.presenter;


import com.example.nsolanki.qualtechassignment.contract.IAddCountryContract;
import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

import java.util.ArrayList;
import java.util.List;

public class AddCountryPresenter extends BasePresenter<IAddCountryContract.IAddCountryView> implements IAddCountryContract.IAddCountryPresenter {

    @Override
    public void handleAddButtonClick(QualtechDBManager dbManager) {
        if (view == null) {
            return;
        }
        CountriesDataEntity countriesDataEntity = view.provideDataToAdd();
        if (dbManager == null || countriesDataEntity == null || countriesDataEntity.isDataEmpty()) {
            view.showError(view.provideAddErrorString());
            return;
        }
        List<CountriesDataEntity> countriesDataEntityList = new ArrayList<>();
        countriesDataEntityList.add(countriesDataEntity);
        long rowId = dbManager.insertCountriesListEntityIntoDB(countriesDataEntityList);
        if (rowId > 0) {
            view.navigateBackToListing();
        } else {
            view.showError(view.provideAddErrorString());
        }
    }
}
