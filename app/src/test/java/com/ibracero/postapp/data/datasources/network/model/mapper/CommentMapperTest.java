package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.BaseUnitTest;
import com.ibracero.postapp.data.datasources.network.model.ApiComment;
import com.ibracero.postapp.domain.model.CommentModel;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CommentMapperTest extends BaseUnitTest {

    private CommentMapper mCommentMapper;

    @Override
    protected void setUp() {
        mCommentMapper = new CommentMapper();
    }

    @Test
    public void shouldMap() {

        ApiComment apiComment = new ApiComment.Builder()
                .postId(1)
                .email("email")
                .name("name")
                .body("body")
                .build();

        CommentModel mapped = mCommentMapper.map(apiComment);

        assertEquals(apiComment.getPostId(), mapped.getPostId());
        assertEquals(apiComment.getName(), mapped.getName());
        assertEquals(apiComment.getEmail(), mapped.getEmail());
        assertEquals(apiComment.getBody(), mapped.getBody());
    }

    @Test
    public void shouldMapWithNullValues() {

        ApiComment apiComment = new ApiComment.Builder()
                .postId(0)
                .email(null)
                .name(null)
                .body(null)
                .build();

        CommentModel mapped = mCommentMapper.map(apiComment);

        assertEquals(apiComment.getPostId(), mapped.getPostId());
        assertEquals(apiComment.getName(), mapped.getName());
        assertEquals(apiComment.getEmail(), mapped.getEmail());
        assertEquals(apiComment.getBody(), mapped.getBody());
    }
}