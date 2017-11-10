package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.BaseUnitTest;
import com.ibracero.postapp.domain.exception.GeneralWebServiceException;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.posts.GetPostsUseCase;
import com.ibracero.postapp.presentation.model.mapper.PostItemViewMapper;
import com.ibracero.postapp.presentation.navigator.PostListNavigator;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class PostListPresenterTest extends BaseUnitTest {

    private PostListPresenter mPresenter;

    @Mock
    private PostListNavigator mNavigatorMock;

    @Mock
    private GetPostsUseCase mGetPostsUseCase;

    @Mock
    private PostItemViewMapper mPostViewMapper;

    @Mock
    private PostListViewInterface mViewMock;

    private List<PostModel> mAnyPostList;

    @Override
    protected void setUp() {

        mAnyPostList = getAnyPostList();

        mPresenter = new PostListPresenter(mNavigatorMock,
                mGetPostsUseCase,
                mPostViewMapper);

        mPresenter.setView(mViewMock);
    }

    @Test
    public void shouldGetPostsOnStart() {
        mPresenter.onStart();

        verify(mViewMock).showLoading();
        verify(mGetPostsUseCase).execute(any(PostListPresenter.PostListSubscriber.class));
    }

    @Test
    public void shouldShowPostsOnGetPostsSuccessAndGreaterThanZero() {

        doAnswer(invocation -> {
            ((PostListPresenter.PostListSubscriber) invocation.getArguments()[0])
                    .onSuccess(mAnyPostList);
            return null;
        }).when(mGetPostsUseCase).execute(any(PostListPresenter.PostListSubscriber.class));

        mPresenter.onStart();
        verify(mViewMock).hideLoading();
        verify(mViewMock).hideEmptyView();
        verify(mPostViewMapper).map(mAnyPostList);
        verify(mViewMock).showPosts(anyList());
    }

    @Test
    public void shouldShowPostsOnGetPostsSuccessAndEqualsToZero() {

        doAnswer(invocation -> {
            ((PostListPresenter.PostListSubscriber) invocation.getArguments()[0])
                    .onSuccess(new ArrayList<>());
            return null;
        }).when(mGetPostsUseCase).execute(any(PostListPresenter.PostListSubscriber.class));

        mPresenter.onStart();
        verify(mViewMock).hideLoading();
        verify(mViewMock).showEmptyView();
    }

    @Test
    public void shouldShowErrorMessageOnGetPostsError() {

        doAnswer(invocation -> {
            ((PostListPresenter.PostListSubscriber) invocation.getArguments()[0])
                    .onError(new GeneralWebServiceException("error", 500));
            return null;
        }).when(mGetPostsUseCase).execute(any(PostListPresenter.PostListSubscriber.class));

        mPresenter.onStart();
        verify(mViewMock).hideLoading();
        verify(mViewMock).showEmptyView();
        verify(mViewMock).showErrorMessage("error");
    }

    @Test
    public void shouldDisposeUseCasesOnDestroy() {
        mPresenter.onDestroy();

        verify(mGetPostsUseCase).dispose();
    }

    private List<PostModel> getAnyPostList() {
        List<PostModel> posts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            posts.add(new PostModel.Builder()
                    .id(i)
                    .userId(i * 11)
                    .title("anyTitle" + i)
                    .body("anyBody" + i)
                    .build());
        }

        return posts;
    }

}