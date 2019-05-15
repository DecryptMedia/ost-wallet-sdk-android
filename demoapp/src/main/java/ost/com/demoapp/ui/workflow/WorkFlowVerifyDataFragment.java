/*
 * Copyright 2019 OST.com Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package ost.com.demoapp.ui.workflow;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ost.walletsdk.workflows.interfaces.OstVerifyDataInterface;

import ost.com.demoapp.R;
import ost.com.demoapp.ui.BaseFragment;
import ost.com.demoapp.uicomponents.AppBar;
import ost.com.demoapp.uicomponents.OstTextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkFlowVerifyDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkFlowVerifyDataFragment extends BaseFragment {

    private OstVerifyDataInterface mOstVerifyDataInterface;
    private String mDataToVerify;

    public WorkFlowVerifyDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WorkFlowVerifyDataFragment.
     */
    public static WorkFlowVerifyDataFragment newInstance() {
        WorkFlowVerifyDataFragment fragment = new WorkFlowVerifyDataFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected void onCreateViewDelegate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_work_flow_verify_data, container, true);

        ((OstTextView)viewGroup.findViewById(R.id.ptv_data)).setText(getSubHeading());
        ((Button)viewGroup.findViewById(R.id.pbtn_verified)).setText(getPositiveButtonText());
        viewGroup.findViewById(R.id.pbtn_verified).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOstVerifyDataInterface.dataVerified();
                showProgress(true);
            }
        });
        viewGroup.findViewById(R.id.pbtn_deny).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        ((OstTextView)viewGroup.findViewById(R.id.lbl_verify_data_heading)).setText(getVerifyDataHeading());

        ((OstTextView)viewGroup.findViewById(R.id.atv_verify_data)).setText(getVerifyData());

        AppBar appBar = AppBar.newInstance(getContext(), getTitle(), true);
        setUpAppBar(viewGroup, appBar);
    }

    String getVerifyData() {
        return mDataToVerify;
    }

    String getVerifyDataHeading() {
        return "Data";
    }

    String getPositiveButtonText() {
        return "Authorize";
    }

    String getSubHeading() {
        return "You’ve a authorization request";
    }

    String getTitle() {
        return "Verify Data";
    }

    @Override
    public void goBack() {
        mOstVerifyDataInterface.cancelFlow();
        super.goBack();
    }

    public void setDataToVerify(String mDataToVerfiy) {
        this.mDataToVerify = mDataToVerfiy;
    }

    public void setVerifyDataCallback(OstVerifyDataInterface ostVerifyDataInterface) {
        mOstVerifyDataInterface = ostVerifyDataInterface;
    }
}
