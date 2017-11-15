package com.ibracero.postapp.domain.use_case.posts;

import com.ibracero.postapp.domain.exception.GeneralWebServiceException;
import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.repository.CommentRepository;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetPostCommentsUseCaseTest {

    private GetPostCommentsUseCase mGetPostCommentsUseCase;

    private GeneralWebServiceException mAnyException;

    @Mock
    CommentRepository mCommentRepositoryMock;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }


    @Before
    public void setUp() throws Exception {

        mAnyException = new GeneralWebServiceException("error", 500);

        mGetPostCommentsUseCase = new GetPostCommentsUseCase(
                Schedulers.io(),
                AndroidSchedulers.mainThread(),
                mCommentRepositoryMock);
    }

    @Test
    public void shouldFilterCommentsByPostId() {

        int postId = 1;

        Single<List<CommentModel>> commentModelListSingle = Single.just(getAnyCommentList());

        when(mCommentRepositoryMock.getComments()).thenReturn(commentModelListSingle);

        TestObserver<List<CommentModel>> testObserver = TestObserver.create();
        mGetPostCommentsUseCase.setPostId(postId).execute(testObserver);
        testObserver.awaitTerminalEvent();
        testObserver.assertValue(commentModels -> commentModels.size() == 1);
        testObserver.assertComplete();
    }

    @Test
    public void shouldNotifyErrorOnGetCommentListError() {

        int postId = 1;

        Single<List<CommentModel>> commentModelListSingle = Single.error(mAnyException);

        when(mCommentRepositoryMock.getComments()).thenReturn(commentModelListSingle);

        TestObserver<List<CommentModel>> testObserver = TestObserver.create();
        mGetPostCommentsUseCase.setPostId(postId).execute(testObserver);
        testObserver.awaitTerminalEvent();
        testObserver.assertError(mAnyException);
    }

    private List<CommentModel> getAnyCommentList() {
        List<CommentModel> commentModels = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            commentModels.add(new CommentModel.Builder()
                    .postId(i)
                    .body("body " + i)
                    .email("email " + i)
                    .name("name " + i)
                    .build());
        }

        return commentModels;
    }

}