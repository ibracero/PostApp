package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.domain.model.Post;
import com.ibracero.postapp.domain.use_case.posts.GetPostsUseCase;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
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

    @Inject
    public PostListPresenter(PostListNavigator navigator,
                             GetPostsUseCase getPostsUseCase) {
        mNavigator = navigator;
        mGetPostsUseCase = getPostsUseCase;
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

    public void onPostClicked() {
        mNavigator.navigateToDetail(1);
    }

    @Override
    public void onDestroy() {
        mGetPostsUseCase.dispose();
    }

    public class PostListSubscriber extends DisposableSingleObserver<List<Post>> {

        @Override
        public void onSuccess(List<Post> posts) {
            mView.hideLoading();
            mView.showPosts(posts);
        }

        @Override
        public void onError(Throwable e) {
            mView.showErrorMessage(e.getMessage());
        }
    }
}
