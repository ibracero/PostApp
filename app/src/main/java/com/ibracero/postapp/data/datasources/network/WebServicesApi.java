package com.ibracero.postapp.data.datasources.network;

import com.ibracero.postapp.data.datasources.network.model.ApiPost;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesApi {

    @GET("posts")
    Single<List<ApiPost>> getPosts();

    @GET("post/{id}")
    Single<ApiPost> getSinglePost(@Path("id") int postId);

}
