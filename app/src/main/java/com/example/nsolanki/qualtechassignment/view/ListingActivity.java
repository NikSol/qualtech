package com.example.nsolanki.qualtechassignment.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.nsolanki.qualtechassignment.R;
import com.example.nsolanki.qualtechassignment.contract.IListingContract.IListingView;
import com.example.nsolanki.qualtechassignment.database.QualtechDBManager;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;
import com.example.nsolanki.qualtechassignment.presenter.ListingPresenter;

import java.util.List;

import static com.example.nsolanki.qualtechassignment.view.ViewConstants.COUNTRY_SELECTED;

public class ListingActivity extends AppCompatActivity implements IListingView, IListingCellInteractor {

    private static final String TAG = ListingActivity.class.getSimpleName();
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private List<CountriesDataEntity> mCountriesDataEntityList;
    private QualtechDBManager mQualtechDBManager;

    private ListingPresenter mListingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListingPresenter = new ListingPresenter();
        mQualtechDBManager = QualtechDBManager.getInstance(this);
        setContentView(R.layout.activity_listing);
        findViewsById();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgressBar.setVisibility(View.VISIBLE);
        mListingPresenter.bind(this);
        mListingPresenter.fetchDataFromServerOrDatabase(mQualtechDBManager);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mListingPresenter.unbind();
    }

    @Override
    public void showProgressBar() {
        if (mProgressBar != null) mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            mListingPresenter.handleAddMenuItemClicked();
        }
        return super.onOptionsItemSelected(item);
    }

    private void findViewsById() {
        mRecyclerView = findViewById(R.id.listing_recyclerView);
        mProgressBar = findViewById(R.id.listing_pb);
    }

    @Override
    public void receiveCountriesList(List<CountriesDataEntity> countriesDataEntityList) {
        mCountriesDataEntityList = countriesDataEntityList;
        setDataToRecyclerView();
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToDetails(CountriesDataEntity countriesDataEntity) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(COUNTRY_SELECTED, countriesDataEntity);
        startActivity(intent);
    }


    @Override
    public CountriesDataEntity provideDataForPosition(int position) {
        return mCountriesDataEntityList.get(position);
    }

    @Override
    public void navigateToAdd() {
        Intent intent = new Intent(this, AddCountryActivity.class);
        startActivity(intent);
    }

    private void setDataToRecyclerView() {
        if (mCountriesDataEntityList == null || mCountriesDataEntityList.isEmpty())
            return;
        ListingAdapter adapter = new ListingAdapter(this, mCountriesDataEntityList, this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void cellClicked(int position) {
        mListingPresenter.handleCellClicked(position);
    }
}
