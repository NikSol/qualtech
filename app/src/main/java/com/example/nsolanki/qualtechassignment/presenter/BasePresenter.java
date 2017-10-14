package com.example.nsolanki.qualtechassignment.presenter;


import com.example.nsolanki.qualtechassignment.contract.IBaseContract;

public abstract class BasePresenter<V extends IBaseContract.IBaseView> {

    protected V view;

    public final void bind(V viewToBind) {
        this.view = viewToBind;
    }

    public final void unbind() {
        this.view = null;
    }

}
