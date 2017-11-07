package com.ibracero.postapp.presentation.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibracero.postapp.presentation.di.qualifiers.HasComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int layoutRes = getFragmentLayout();
        if (layoutRes == 0) {
            throw new IllegalArgumentException(
                    "getLayoutRes() returned 0, which is not allowed. "
                            + "If you don't want to use getLayoutRes() but implement your own view for this "
                            + "fragment manually, then you have to override onCreateView();");
        } else {
            return inflater.inflate(layoutRes, container, false);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    /**
     * Specify the layout of the fragment to be inflated in the {@link BaseFragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    protected abstract int getFragmentLayout();

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    @Override
    public void showLoading() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).hideLoading();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideLoading();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}



