package com.ibracero.postapp.domain.use_case.comments;

import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.domain.repository.PostRepository;
import com.ibracero.postapp.domain.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetPostsUseCaseTest {

    private GetPostsUseCase mGetPostsUseCase;

    @Mock
    Scheduler ioSchedulerMock;

    @Mock
    Scheduler mainThreadSchedulerMock;

    @Mock
    PostRepository mPostRepositoryMock;

    @Mock
    UserRepository mUserRepositoryMock;

    @Before
    public void setup() {
        mGetPostsUseCase = new GetPostsUseCase(ioSchedulerMock,
                mainThreadSchedulerMock,
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
    }

    public List<PostModel> getAnyPostModelList() {

        List<PostModel> postsMock = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
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

        for (int i = 0; i < 10; i++) {
            usersMock.add(new UserModel.Builder()
                    .id(i)
                    .username("username" + i)
                    .email("email" + i)
                    .build());
        }

        return usersMock;
    }


}