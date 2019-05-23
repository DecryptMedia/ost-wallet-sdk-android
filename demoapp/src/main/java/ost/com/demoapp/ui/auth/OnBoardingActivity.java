/*
 * Copyright 2019 OST.com Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package ost.com.demoapp.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import ost.com.demoapp.AppProvider;
import ost.com.demoapp.R;
import ost.com.demoapp.ui.BaseActivity;
import ost.com.demoapp.ui.dashboard.DashboardActivity;
import ost.com.demoapp.ui.qrscanner.QRScannerFragment;
import ost.com.demoapp.util.FragmentUtils;
import ost.com.demoapp.util.KeyBoard;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class OnBoardingActivity extends BaseActivity implements
        OnBoardingView,
        IntroFragment.OnFragmentInteractionListener,
        CreateAccountFragment.OnFragmentInteractionListener,
        QRScannerFragment.OnFragmentInteractionListener {

    private static final String CREATE_ACCOUNT_TAG = "ca_tag";
    private static final String LOG_TAG = "OstOnBoardingActivity";
    OnBoardingPresenter mOnBoardingPresenter = OnBoardingPresenter.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_onboarding);

        mOnBoardingPresenter.attachView(this);

        if (null != AppProvider.get().getCurrentEconomy() ) {
            mOnBoardingPresenter.checkLoggedInUser();
        }

        FragmentUtils.clearBackStackAndAddFragment(R.id.layout_container,
                IntroFragment.newInstance(),
                this);
    }

    @Override
    public void launchCreateAccountView() {
        FragmentUtils.addFragment(R.id.layout_container,
                CreateAccountFragment.newInstance(true),
                this, CREATE_ACCOUNT_TAG);
        mOnBoardingPresenter.assertEconomy();
    }

    @Override
    public void launchLoginView() {
        FragmentUtils.addFragment(R.id.layout_container,
                CreateAccountFragment.newInstance(false),
                this, CREATE_ACCOUNT_TAG);
        mOnBoardingPresenter.assertEconomy();
    }

    @Override
    public void goBack() {
        if (this.getSupportFragmentManager().getBackStackEntryCount() > 1) {
            FragmentUtils.goBack(this);
        } else {
            KeyBoard.hideKeyboard(OnBoardingActivity.this);
            super.goBack();
        }
    }

    @Override
    public void createAccount(String economy, String userName, String password) {
        mOnBoardingPresenter.createAccount(userName, password);
    }

    @Override
    public void logIn(String economy, String userName, String password) {
        mOnBoardingPresenter.logIn(userName, password);
    }

    @Override
    public void scanForEconomy() {
        if (!(FragmentUtils.getTopFragment(this, R.id.layout_container) instanceof QRScannerFragment)) {
            FragmentUtils.addFragment(R.id.layout_container,
                    QRScannerFragment.newInstance("Select your Economy", getResources().getString(R.string.qr_sub_heading_economy_scan)),
                    this);
        }
    }

    @Override
    public void showUsernameError(String errorString) {
        ((CreateAccountFragment) FragmentUtils.getTopFragment(this, R.id.layout_container)).showUserNameError(errorString);
    }

    @Override
    public void showPasswordError(String errorString) {
        ((CreateAccountFragment) FragmentUtils.getTopFragment(this, R.id.layout_container)).showPasswordError(errorString);
    }

    @Override
    public void refreshToken() {
        if (FragmentUtils.getFragmentByTag(this, CREATE_ACCOUNT_TAG) instanceof CreateAccountFragment) {
            ((CreateAccountFragment) FragmentUtils.getFragmentByTag(this, CREATE_ACCOUNT_TAG)).updateToken();
        }
    }

    @Override
    public void goToDashBoard() {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
        animateActivityChangingToRight();
        finish();
    }

    @Override
    public void onResultString(Intent resultString) {
        if (resultString != null && resultString.getData() != null) {
            String returnedResult = resultString.getData().toString();
            try {
                Log.w(LOG_TAG, returnedResult);
                mOnBoardingPresenter.onScanEconomyResult(returnedResult);
            } catch (Exception e) {
                showToastMessage("QR Reading failed.. Try Again", false);
                Log.e(LOG_TAG, "JSONException while parsing");
            }
        }
    }

    @Override
    protected View getRootView() {
        return findViewById(R.id.layout_holder);
    }
}