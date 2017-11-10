package com.ibracero.postapp.presentation.ui.detail;

import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.posts.GetPostCommentsUseCase;
import com.ibracero.postapp.presentation.di.qualifiers.PerActivity;
import com.ibracero.postapp.presentation.model.mapper.PostDetailViewMapper;
import com.ibracero.postapp.presentation.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

@PerActivity
public class PostDetailPresenter extends BasePresenter<PostDetailViewInterface> {

    private final GetPostCommentsUseCase mGetPostInfoUseCase;
    private final PostDetailViewMapper mPostDetailViewMapper;
    private PostDetailViewInterface mView;
    private PostModel mPost;

    @Inject
    public PostDetailPresenter(GetPostCommentsUseCase getPostCommentsUseCase,
                               PostDetailViewMapper postDetailViewMapper) {
        mGetPostInfoUseCase = getPostCommentsUseCase;
        mPostDetailViewMapper = postDetailViewMapper;
    }

    @Override
    public void setView(PostDetailViewInterface view) {
        mView = view;
    }

    public void setPostModel(PostModel post) {
        mPost = post;
    }

    @Override
    public void onStart() {
        mView.showPostInfo(mPostDetailViewMapper.map(mPost));
        getPostComments();
    }

    private void getPostComments() {
        mGetPostInfoUseCase.setPostId(mPost.getId()).execute(new GetPostCommentSubscriber());
    }

    @Override
    public void onDestroy() {
        mGetPostInfoUseCase.dispose();
    }

    public class GetPostCommentSubscriber extends DisposableSingleObserver<List<CommentModel>> {

        @Override
        public void onSuccess(List<CommentModel> commentModels) {
            mPost.setComments(commentModels);
            mView.showCommentCounter();
            mView.showPostInfo(mPostDetailViewMapper.map(mPost));
        }

        @Override
        public void onError(Throwable e) {
            mView.showGetPostInfoFailed(e.getMessage());
        }
    }
}
