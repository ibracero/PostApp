package com.ibracero.postapp.domain.repository;

import com.ibracero.postapp.domain.model.CommentModel;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;

import java.util.List;

import io.reactivex.Single;

public interface PostRepository {

    Single<List<PostModel>> getPosts();

    Single<List<CommentModel>> getComments();

    Single<List<UserModel>> getUsers();

    Single<PostModel> getPostInfo(int postId);

}
