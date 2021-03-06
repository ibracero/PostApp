package com.ibracero.postapp.presentation.ui.post_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibracero.postapp.R;
import com.bumptech.glide.Glide;
import com.ibracero.postapp.presentation.model.PostItemViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<PostItemViewModel> mDataset;
    private final PostListPresenter mPresenter;

    @Inject
    public PostAdapter(PostListPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bind(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setDataset(List<PostItemViewModel> postViewModels) {
        mDataset = postViewModels;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_post_title)
        TextView mTvPostTitle;

        @BindView(R.id.iv_writer_image)
        ImageView mIvWriterImage;

        PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(PostItemViewModel model) {
            mTvPostTitle.setText(model.getTitle());
            mTvPostTitle.setOnClickListener(v -> mPresenter.onPostClicked(model.getId()));
            Glide.with(itemView.getContext()).load(model.getWriterImage()).into(mIvWriterImage);
        }
    }
}
