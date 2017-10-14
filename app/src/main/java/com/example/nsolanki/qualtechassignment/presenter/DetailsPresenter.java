package com.example.nsolanki.qualtechassignment.presenter;


import com.example.nsolanki.qualtechassignment.contract.IDetailsContract;
import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

public class DetailsPresenter extends BasePresenter<IDetailsContract.IDetailsView> implements IDetailsContract.IDetailsPresenter {
    @Override
    public void handleUpdateButtonClick(QualtechDBManager qualtechDBManager) {
        if (view == null)
            return;
        CountriesDataEntity countriesDataEntity = view.provideDataForUpdate();
        if (qualtechDBManager == null || countriesDataEntity == null || countriesDataEntity.isDataEmpty())
            return;
        long rowId = qualtechDBManager.updateCountryDataEntry(countriesDataEntity);
        if (rowId > 0) {
            view.navigateBackToListing();
        } else {
            view.showError(view.provideUpdateErrorString());
        }
    }

    @Override
    public void handleDeleteButtonClick(QualtechDBManager qualtechDBManager) {
        if (view == null)
            return;
        CountriesDataEntity countriesDataEntity = view.provideDataForUpdate();
        if (qualtechDBManager == null || countriesDataEntity == null || countriesDataEntity.isDataEmpty())
            return;
        int count = qualtechDBManager.deleteCountryEntry(countriesDataEntity.getCountryId());
        if (count > 0) {
            view.navigateBackToListing();
        } else {
            view.showError(view.provideUpdateErrorString());
        }
    }
}
