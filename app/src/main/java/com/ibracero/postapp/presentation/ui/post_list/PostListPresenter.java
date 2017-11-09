package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.posts.GetPostsUseCase;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.model.mapper.PostViewMapper;
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
    private final PostViewMapper mPostViewMapper;

    @Inject
    public PostListPresenter(PostListNavigator navigator,
                             GetPostsUseCase getPostsUseCase,
                             PostViewMapper postViewMapper) {
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
        mNavigator.navigateToDetail(id);
    }

    @Override
    public void onDestroy() {
        mGetPostsUseCase.dispose();
    }

    public class PostListSubscriber extends DisposableSingleObserver<List<PostModel>> {

        @Override
        public void onSuccess(List<PostModel> posts) {
            mView.hideLoading();
            mView.showPosts(mPostViewMapper.map(posts));
        }

        @Override
        public void onError(Throwable e) {
            mView.showErrorMessage(e.getMessage());
        }
    }
}
