package com.ibracero.postapp.presentation.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.babylonhealth.babylonpost.R;
import com.bumptech.glide.Glide;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.presentation.di.components.ActivityComponent;
import com.ibracero.postapp.presentation.model.PostDetailViewModel;
import com.ibracero.postapp.presentation.ui.base.BaseFragment;
import com.ibracero.postapp.presentation.ui.error.ErrorNotificator;

import javax.inject.Inject;

import butterknife.BindView;

public class PostDetailFragment extends BaseFragment implements PostDetailViewInterface {

    private static final String EXTRA_POST = "extra_post";

    @BindView(R.id.tv_post_title)
    TextView mPostTitle;

    @BindView(R.id.tv_post_body)
    TextView mPostBody;

    @BindView(R.id.tv_writer_name)
    TextView mWriterName;

    @BindView(R.id.iv_writer_image)
    ImageView mWriterImage;

    @BindView(R.id.tv_comment_number)
    TextView mCommentCounter;

    @BindView(R.id.fl_comment_counter_container)
    FrameLayout mFlCommentContainer;

    @Inject
    PostDetailPresenter mPresenter;

    @Inject
    ErrorNotificator mErrorNotificator;

    public static PostDetailFragment newInstance(PostModel post) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_POST, post);
        PostDetailFragment fragment = new PostDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_post_detail;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.getComponent(ActivityComponent.class).inject(this);

        mPresenter.setView(this);
        mPresenter.setPostModel(getPostDetailViewArgument());
        mPresenter.onStart();
    }

    @Override
    public void showPostInfo(PostDetailViewModel post) {
        mPostTitle.setText(post.getPostTitle());
        mPostBody.setText(post.getPostBody());
        mWriterName.setText(post.getWriterName());
        mCommentCounter.setText(String.valueOf(post.getCommentCounter()));
        Glide.with(this).load(post.getWriterImageUrl()).into(mWriterImage);
    }

    @Override
    public void showGetPostInfoFailed(String message) {
        mErrorNotificator.showMessage(message);
    }

    @Override
    public void showCommentCounter() {
        mFlCommentContainer.setVisibility(View.VISIBLE);
    }

    private PostModel getPostDetailViewArgument() {
        return getArguments() != null ? getArguments().getParcelable(EXTRA_POST) : null;
    }
}
