package com.ibracero.postapp.domain.repository;

import com.ibracero.postapp.domain.model.Post;

import java.util.List;

import io.reactivex.Single;

public interface PostRepository {

    Single<List<Post>> getPosts();
}
