package com.ibracero.postapp.domain.repository;

import com.ibracero.postapp.domain.model.PostModel;

import java.util.List;

import io.reactivex.Single;

public interface PostRepository {

    Single<List<PostModel>> getPosts();
}
