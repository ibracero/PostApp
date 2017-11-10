package com.ibracero.postapp.data.datasources.network;

import com.ibracero.postapp.data.datasources.network.model.ApiComment;
import com.ibracero.postapp.data.datasources.network.model.ApiPost;
import com.ibracero.postapp.data.datasources.network.model.ApiUser;
import com.ibracero.postapp.domain.model.PostModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesApi {

    @GET("posts")
    Single<List<ApiPost>> getPosts();

    @GET("comments")
    Single<List<ApiComment>> getComments();

    @GET("users")
    Single<List<ApiUser>> getUsers();

    @GET("posts/{postId}")
    Single<PostModel> getPostInfo(@Path("postId") int postId);
}
