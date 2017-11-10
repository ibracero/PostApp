package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.posts.GetPostsUseCase;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.model.mapper.PostItemViewMapper;
import com.ibracero.postapp.presentation.navigator.PostListNavigator;
import com.ibracero.postapp.presentation.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

@PerActivity
public class PostListPresenter extends BasePresenter<PostListViewInterface> {

    private final PostListNavigator mNavigator;
    private final GetPostsUseCase mGetPostsUseCase;
    private PostListViewInterface mView;
    private final PostItemViewMapper mPostViewMapper;
    private List<PostModel> mPostList;

    @Inject
    public PostListPresenter(PostListNavigator navigator,
                             GetPostsUseCase getPostsUseCase,
                             PostItemViewMapper postViewMapper) {
        mNavigator = navigator;
        mGetPostsUseCase = getPostsUseCase;
        mPostViewMapper = postViewMapper;
    }

    @Override
    public void setView(PostListViewInterface view) {
        mView = view;
    }

    @Override
    public void onStart() {
        getPosts();
    }

    private void getPosts() {
        mView.showLoading();
        mGetPostsUseCase.execute(new PostListSubscriber());
    }

    public void onPostClicked(int id) {
        mNavigator.navigateToDetail(getSelectedItemFromPostList(id));
    }

    private PostModel getSelectedItemFromPostList(int id) {
        for (PostModel postModel : mPostList) {
            if (postModel.getId() == id) {
                return postModel;
            }
        }
        return null;
    }

    @Override
    public void onDestroy() {
        mGetPostsUseCase.dispose();
    }

    public class PostListSubscriber extends DisposableSingleObserver<List<PostModel>> {

        @Override
        public void onSuccess(List<PostModel> posts) {

            mPostList = posts;

            mView.hideLoading();
            if (posts.size() > 0) {
                mView.hideEmptyView();
                mView.showPosts(mPostViewMapper.map(posts));
            } else {
                mView.showEmptyView();
            }
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.showEmptyView();
            mView.showErrorMessage(e.getMessage());
        }
    }
}
