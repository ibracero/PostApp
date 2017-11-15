package com.ibracero.postapp.domain.repository;

import com.ibracero.postapp.domain.model.UserModel;

import java.util.List;

import io.reactivex.Single;

public interface UserRepository {

    Single<List<UserModel>> getUsers();

}
