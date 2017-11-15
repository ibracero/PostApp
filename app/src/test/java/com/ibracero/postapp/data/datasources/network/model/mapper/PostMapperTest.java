package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.data.datasources.network.model.ApiPost;
import com.ibracero.postapp.domain.model.PostModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PostMapperTest {

    private PostMapper mPostMapper;


    @Before
    public void setup() {
        mPostMapper = new PostMapper();
    }

    @Test
    public void shouldMap() {

        ApiPost apiPost = new ApiPost.Builder()
                .id(1)
                .body("body")
                .title("title")
                .userId(10)
                .build();

        PostModel mapped = mPostMapper.map(apiPost);

        assertEquals(apiPost.getId(), mapped.getId());
        assertEquals(apiPost.getBody(), mapped.getBody());
        assertEquals(apiPost.getUserId(), mapped.getUserId());
        assertEquals(apiPost.getTitle(), mapped.getTitle());
    }

    @Test
    public void shouldMapWithNullValues() {

        ApiPost apiPost = new ApiPost.Builder()
                .id(0)
                .body(null)
                .title(null)
                .userId(0)
                .build();

        PostModel mapped = mPostMapper.map(apiPost);

        assertEquals(apiPost.getId(), mapped.getId());
        assertEquals(apiPost.getBody(), mapped.getBody());
        assertEquals(apiPost.getUserId(), mapped.getUserId());
        assertEquals(apiPost.getTitle(), mapped.getTitle());
    }
}