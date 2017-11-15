package com.ibracero.postapp.domain.repository;

import com.ibracero.postapp.domain.model.CommentModel;

import java.util.List;

import io.reactivex.Single;

public interface CommentRepository {

    Single<List<CommentModel>> getComments();
}
