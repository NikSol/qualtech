package com.example.nsolanki.qualtechassignment.presenter;

import android.util.Log;

import com.example.nsolanki.qualtechassignment.contract.IListingContract;
import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;
import com.example.nsolanki.qualtechassignment.network.CountriesAPI;
import com.example.nsolanki.qualtechassignment.network.NetworkClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingPresenter extends BasePresenter<IListingContract.IListingView> implements IListingContract.IListingPresenter {

    private static final String TAG = ListingPresenter.class.getSimpleName();
    private NetworkClient mNetworkClient;
    private QualtechDBManager qualtechDBManager;

    public ListingPresenter() {
        this.mNetworkClient = new NetworkClient();
    }

    @Override
    public void fetchDataFromServerOrDatabase(QualtechDBManager qualtechDBManager) {

        this.qualtechDBManager = qualtechDBManager;
        if (this.qualtechDBManager != null) {
            this.qualtechDBManager.openReadableDB();
            List<CountriesDataEntity> countriesDataEntitiesList = this.qualtechDBManager.getCountriesListFromCusror(-1);

            if (countriesDataEntitiesList != null) {
                if (countriesDataEntitiesList.size() > 0) {
                    view.receiveCountriesList(countriesDataEntitiesList);
                    this.qualtechDBManager.closeDB();
                    return;
                }
            } else {
                Log.e(TAG, "Inside -1 is null");
            }
        }

        Call<List<CountriesDataEntity>> countriesList = mNetworkClient.create(CountriesAPI.class).getCountriesList();
        countriesList.enqueue(new Callback<List<CountriesDataEntity>>() {
            @Override
            public void onResponse(Call<List<CountriesDataEntity>> call, Response<List<CountriesDataEntity>> response) {
                insertIntoDB(response.body());
            }

            @Override
            public void onFailure(Call<List<CountriesDataEntity>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void handleCellClicked(int position) {
        if (view == null)
            return;
        CountriesDataEntity countriesDataEntity = view.provideDataForPosition(position);
        if (countriesDataEntity == null)
            return;
        view.navigateToDetails(countriesDataEntity);
    }

    @Override
    public void handleAddMenuItemClicked() {
        if (view == null)
            return;
        view.navigateToAdd();
    }

    private void insertIntoDB(final List<CountriesDataEntity> value) {
        final long[] count = new long[1];
        Observable<List<CountriesDataEntity>> observable = Observable.create(new ObservableOnSubscribe<List<CountriesDataEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<CountriesDataEntity>> e) throws Exception {
                try {
                    count[0] = ListingPresenter.this.qualtechDBManager.insertCountriesListEntityIntoDB(value);
                    e.onComplete();
                } catch (Exception exception) {
                    e.onError(exception);
                }
            }
        });

        Observer<List<CountriesDataEntity>> myObsever = new Observer<List<CountriesDataEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSUbscribe");
            }

            @Override
            public void onNext(List<CountriesDataEntity> value) {
                Log.e(TAG, "onNext");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e(TAG, "onError ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete ");
                if (count[0] > 0) {
                    List<CountriesDataEntity> countriesDataEntitiesList = ListingPresenter.this.qualtechDBManager.getCountriesListFromCusror(-1);
                    if (countriesDataEntitiesList != null) {
                        if (countriesDataEntitiesList.size() > 0) {
                            view.receiveCountriesList(countriesDataEntitiesList);
                            ListingPresenter.this.qualtechDBManager.closeDB();
                        }
                    }
                }
            }
        };
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(myObsever);
    }
}
