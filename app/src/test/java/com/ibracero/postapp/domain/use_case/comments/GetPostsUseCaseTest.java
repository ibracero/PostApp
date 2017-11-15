package com.ibracero.postapp.domain.use_case.comments;

import com.ibracero.postapp.domain.exception.GeneralWebServiceException;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.domain.repository.PostRepository;
import com.ibracero.postapp.domain.repository.UserRepository;

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
public class GetPostsUseCaseTest {

    private GetPostsUseCase mGetPostsUseCase;

    private GeneralWebServiceException mAnyException;

    @Mock
    PostRepository mPostRepositoryMock;

    @Mock
    UserRepository mUserRepositoryMock;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @Before
    public void setup() {

        mAnyException = new GeneralWebServiceException("error", 500);

        mGetPostsUseCase = new GetPostsUseCase(
                Schedulers.io(),
                AndroidSchedulers.mainThread(),
                mPostRepositoryMock,
                mUserRepositoryMock);

    }

    @Test
    public void shouldZipPostsWithUsers() {

        Single<List<PostModel>> postModelListSingle = Single.just(getAnyPostModelList());
        Single<List<UserModel>> userModelListSingle = Single.just(getAnyUserList());

        when(mPostRepositoryMock.getPosts()).thenReturn(postModelListSingle);
        when(mUserRepositoryMock.getUsers()).thenReturn(userModelListSingle);

        TestObserver<List<PostModel>> testObserver = TestObserver.create();
        mGetPostsUseCase.execute(testObserver);
        testObserver.awaitTerminalEvent();
        testObserver.assertValue(getAnyZipUserAndPostModels());
        testObserver.assertComplete();
    }

    @Test
    public void shouldNotifyErrorOnGetPostListError() {

        Single<List<PostModel>> postModelListSingle = Single.error(mAnyException);
        Single<List<UserModel>> userModelListSingle = Single.just(getAnyUserList());

        when(mPostRepositoryMock.getPosts()).thenReturn(postModelListSingle);
        when(mUserRepositoryMock.getUsers()).thenReturn(userModelListSingle);

        TestObserver<List<PostModel>> testObserver = TestObserver.create();
        mGetPostsUseCase.execute(testObserver);
        testObserver.awaitTerminalEvent();
        testObserver.assertError(mAnyException);
    }

    @Test
    public void shouldNotifyErrorOnGetUserListError() {

        Single<List<PostModel>> postModelListSingle = Single.just(getAnyPostModelList());
        Single<List<UserModel>> userModelListSingle = Single.error(mAnyException);

        when(mPostRepositoryMock.getPosts()).thenReturn(postModelListSingle);
        when(mUserRepositoryMock.getUsers()).thenReturn(userModelListSingle);

        TestObserver<List<PostModel>> testObserver = TestObserver.create();
        mGetPostsUseCase.execute(testObserver);
        testObserver.awaitTerminalEvent();
        testObserver.assertError(mAnyException);
    }

    public List<PostModel> getAnyPostModelList() {

        List<PostModel> postsMock = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            postsMock.add(new PostModel.Builder()
                    .id(i)
                    .title("title " + i)
                    .userId(0)
                    .build());
        }

        return postsMock;
    }

    public List<UserModel> getAnyUserList() {

        List<UserModel> usersMock = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            usersMock.add(new UserModel.Builder()
                    .id(i)
                    .username("username " + i)
                    .email("email " + i)
                    .build());
        }

        return usersMock;
    }

    public List<PostModel> getAnyZipUserAndPostModels() {

        List<PostModel> anyPostModelList = getAnyPostModelList();

        for (PostModel postModel : anyPostModelList) {
            for (UserModel userModel : getAnyUserList()) {
                postModel.setWriter(userModel);
            }
        }

        return anyPostModelList;
    }


}