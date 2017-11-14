package com.ibracero.postapp.presentation.ui.detail;

import com.ibracero.postapp.domain.exception.GeneralWebServiceException;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.use_case.posts.GetPostCommentsUseCase;
import com.ibracero.postapp.presentation.model.mapper.PostDetailViewMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostDetailPresenterTest {

    private PostDetailPresenter mPresenter;

    @Mock
    private GetPostCommentsUseCase mGetPostCommentsUseCaseMock;

    @Mock
    private PostDetailViewMapper mPostDetailViewMapperMock;

    @Mock
    private PostDetailViewInterface mViewMock;

    private PostModel mAnyPost;

    @Before
    public void setup() {

        when(mGetPostCommentsUseCaseMock.setPostId(anyInt())).thenReturn(mGetPostCommentsUseCaseMock);

        mPresenter = new PostDetailPresenter(mGetPostCommentsUseCaseMock,
                mPostDetailViewMapperMock);

        mPresenter.setView(mViewMock);
        mPresenter.setPostModel(mAnyPost = getAnyPost());
    }


    @Test
    public void shouldShowPostInfoOnStart() {
        mPresenter.onStart();
        verify(mPostDetailViewMapperMock).map(any(PostModel.class));
        verify(mViewMock, atLeastOnce()).showPostInfo(any());
    }

    @Test
    public void shouldGetPostCommentsOnStart() {
        mPresenter.onStart();
        verify(mGetPostCommentsUseCaseMock).setPostId(mAnyPost.getId());
        verify(mGetPostCommentsUseCaseMock).execute(any(PostDetailPresenter.GetPostCommentSubscriber.class));
        verifyNoMoreInteractions(mGetPostCommentsUseCaseMock);
    }

    @Test
    public void shouldUpdateCommentCounterOnGetCommentsSuccess() {

        doAnswer(invocation -> {
                    ((PostDetailPresenter.GetPostCommentSubscriber) invocation.getArguments()[0])
                            .onSuccess(new ArrayList<>());
                    return null;
                }
        ).when(mGetPostCommentsUseCaseMock).execute(any(PostDetailPresenter.GetPostCommentSubscriber.class));

        mPresenter.onStart();
        verify(mViewMock).showCommentCounter();
        verify(mViewMock, atLeastOnce()).showPostInfo(any());
    }

    @Test
    public void shouldShowErrorOnGetCommentsError() {

        doAnswer(invocation -> {
                    ((PostDetailPresenter.GetPostCommentSubscriber) invocation.getArguments()[0])
                            .onError(new GeneralWebServiceException("error", 500));
                    return null;
                }
        ).when(mGetPostCommentsUseCaseMock).execute(any(PostDetailPresenter.GetPostCommentSubscriber.class));

        mPresenter.onStart();
        verify(mViewMock).showGetPostInfoFailed("error");
    }

    @Test
    public void shouldDisposeUseCasesOnDestroy() {
        mPresenter.onDestroy();
        verify(mGetPostCommentsUseCaseMock).dispose();
        verifyNoMoreInteractions(mGetPostCommentsUseCaseMock);
    }

    private PostModel getAnyPost() {
        return new PostModel.Builder()
                .id(1)
                .userId(10)
                .title("title")
                .body("body")
                .build();
    }

}