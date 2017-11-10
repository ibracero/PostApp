package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.BaseUnitTest;
import com.ibracero.postapp.data.datasources.network.model.ApiPost;
import com.ibracero.postapp.domain.model.PostModel;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PostMapperTest extends BaseUnitTest {

    private PostMapper mPostMapper;

    @Override
    protected void setUp() {
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