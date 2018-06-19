package com.avast.re.reauth;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avast.re.reauth.databinding.FragmentMainBinding;
import com.avast.re.reauth.wtf.AppDependency;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends DaggerFragment {
    private UserViewModel viewModel;
    public static int UID = 666;

    private TextView tv;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    AppDependency dependency;

    FragmentMainBinding binding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        viewModel.init(UID);
        binding.setViewmodel(viewModel);

//        DataBindingUtil.setContentView(this, )
//        viewModel.getUser().observe(this, user -> {
//            Logger.getLogger(this.getClass().getName()).info("Observed: " + user);
//            if (tv != null) {
//                if (user != null) tv.setText("Num: " + user.getNumber());
//                else tv.setText("null user");
//            }
//        });

        getActivity().findViewById(R.id.fab).setOnClickListener(v -> {
            Logger.getLogger("x").info("fab click");
            User tmpUser = viewModel.getUser().getValue();
            tmpUser.setNumber(tmpUser.getNumber()+1);
            if (tmpUser!=null) viewModel.saveUser(tmpUser);
        });
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        Logger.getLogger("x").info("onattach TEST: " + dependency.test());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
//        View view = inflater.inflate(R.layout.fragment_main, container, false);

        View view = binding.getRoot();
        tv = view.findViewById(R.id.user_tv);

        binding.setLifecycleOwner(this);
        return view;
    }
}
