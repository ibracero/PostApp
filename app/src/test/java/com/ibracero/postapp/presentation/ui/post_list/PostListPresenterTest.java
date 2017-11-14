package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.domain.exception.GeneralWebServiceException;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.comments.GetPostsUseCase;
import com.ibracero.postapp.presentation.model.mapper.PostItemViewMapper;
import com.ibracero.postapp.presentation.navigator.Navigator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostListPresenterTest {

    private PostListPresenter mPresenter;

    @Mock
    private Navigator mNavigatorMock;

    @Mock
    private GetPostsUseCase mGetPostsUseCase;

    @Mock
    private PostItemViewMapper mPostViewMapper;

    @Mock
    private PostListViewInterface mViewMock;

    private List<PostModel> mAnyPostList;

    @Before
    public void setup() {

        mAnyPostList = getAnyPostList();

        mPresenter = new PostListPresenter(mNavigatorMock,
                mGetPostsUseCase,
                mPostViewMapper);

        mPresenter.attachView(mViewMock);
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