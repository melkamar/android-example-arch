package com.avast.re.reauth;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avast.re.reauth.wtf.AppDependency;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends DaggerFragment {
    private UserViewModel viewModel;
    public static int UID = 666;

    private TextView tv;

//    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    AppDependency dependency;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        viewModel.init(UID);
        viewModel.getUser().observe(this, user -> {
            if (tv != null) {
                tv.setText("Num: " + user.getNumber());
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        Logger.getLogger("x").info("onattach TEST: "+dependency.test());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tv = view.findViewById(R.id.user_tv);
        return view;
    }
}
