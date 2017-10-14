package com.example.nsolanki.qualtechassignment.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nsolanki.qualtechassignment.R;
import com.example.nsolanki.qualtechassignment.model.entity.CountriesDataEntity;

import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingViewHolder> {

    private List<CountriesDataEntity> mCountriesDataEntityList;
    private Context mContext;
    private IListingCellInteractor mInteractor;

    public ListingAdapter(Context context, List<CountriesDataEntity> countriesDataEntityList, IListingCellInteractor interactor) {
        mContext = context;
        mCountriesDataEntityList = countriesDataEntityList;
        this.mInteractor = interactor;
    }

    @Override
    public ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_cell_view, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, final int position) {
        holder.mCountryNameTextView.setText(mContext.getString(R.string.label_country) + mCountriesDataEntityList.get(position).getCountryName());
        holder.mCapitalTextView.setText(mContext.getString(R.string.label_capital) + mCountriesDataEntityList.get(position).getCapital());
        holder.mRegionTextView.setText(mContext.getString(R.string.label_region) + mCountriesDataEntityList.get(position).getRegion());
        if (mCountriesDataEntityList.get(position).getCurrenciesDataEntityList() != null && mCountriesDataEntityList.get(position).getCurrenciesDataEntityList().size() > 0)
            holder.mCurrencyTextView.setText(mContext.getString(R.string.label_currency) + mCountriesDataEntityList.get(position).getCurrenciesDataEntityList().get(0).getCurrencyName());
        else
            holder.mCurrencyTextView.setVisibility(View.GONE);
        if (mCountriesDataEntityList.get(position).getLanguagesDataEntityList() != null && mCountriesDataEntityList.get(position).getLanguagesDataEntityList().size() > 0)
            holder.mLanguageTextView.setText(mContext.getString(R.string.label_language) + mCountriesDataEntityList.get(position).getLanguagesDataEntityList().get(0).getLanguages());
        else
            holder.mLanguageTextView.setVisibility(View.GONE);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListingAdapter.this.mInteractor.cellClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCountriesDataEntityList != null ? mCountriesDataEntityList.size() : 0;
    }


    class ListingViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        TextView mCountryNameTextView, mCapitalTextView, mRegionTextView, mCurrencyTextView, mLanguageTextView;

        ListingViewHolder(View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.view_listing_cell_card_root);
            mCountryNameTextView = itemView.findViewById(R.id.countryTv);
            mCapitalTextView = itemView.findViewById(R.id.capitalTv);
            mRegionTextView = itemView.findViewById(R.id.regionTv);
            mCurrencyTextView = itemView.findViewById(R.id.currencyTv);
            mLanguageTextView = itemView.findViewById(R.id.languageTv);
        }
    }

}
