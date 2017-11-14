package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.data.datasources.network.model.ApiComment;
import com.ibracero.postapp.domain.model.CommentModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CommentMapperTest {

    private CommentMapper mCommentMapper;

    @Before
    public void setup() {
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