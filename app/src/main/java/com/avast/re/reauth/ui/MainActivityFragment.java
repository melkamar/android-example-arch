package com.avast.re.reauth.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avast.re.reauth.R;
import com.avast.re.reauth.model.User;
import com.avast.re.reauth.databinding.FragmentMainBinding;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends DaggerFragment {
    private UserViewModel viewModel;
    public static int UID = 666;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    FragmentMainBinding binding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        viewModel.init(UID);
        binding.setViewmodel(viewModel);

        getActivity().findViewById(R.id.fab).setOnClickListener(v -> {
            User tmpUser = viewModel.getUser().getValue();
            tmpUser.setNumber(tmpUser.getNumber()+1);
            if (tmpUser!=null) viewModel.saveUser(tmpUser);
        });
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }
}
