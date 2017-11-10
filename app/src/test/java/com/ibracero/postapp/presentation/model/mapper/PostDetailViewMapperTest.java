package com.ibracero.postapp.presentation.model.mapper;

import com.ibracero.postapp.BaseUnitTest;
import com.ibracero.postapp.Constants;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.presentation.model.PostDetailViewModel;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class PostDetailViewMapperTest extends BaseUnitTest {

    private PostDetailViewMapper mPostDetailViewMapper;

    @Override
    protected void setUp() {
        mPostDetailViewMapper = new PostDetailViewMapper();
    }

    @Test
    public void shouldMap() {

        PostModel postModel = new PostModel.Builder()
                .id(1)
                .userId(10)
                .title("title")
                .body("body")
                .comments(new ArrayList<>())
                .writer(new UserModel.Builder()
                        .username("username")
                        .email("email")
                        .build())
                .build();

        PostDetailViewModel mapped = mPostDetailViewMapper.map(postModel);

        assertEquals(postModel.getTitle(), mapped.getPostTitle());
        assertEquals(postModel.getBody(), mapped.getPostBody());
        assertEquals(postModel.getWriter().getUsername(), mapped.getWriterName());
        assertEquals(Constants.IMAGE_GENERATOR_URL + postModel.getWriter().getEmail(), mapped.getWriterImageUrl());
        assertEquals(String.valueOf(postModel.getComments().size()), mapped.getCommentCounter());
    }

    @Test
    public void shouldMapWithNullValues() {

        PostModel postModel = new PostModel.Builder()
                .id(0)
                .userId(0)
                .title(null)
                .body(null)
                .comments(null)
                .writer(null)
                .build();

        PostDetailViewModel mapped = mPostDetailViewMapper.map(postModel);

        assertEquals("", mapped.getPostTitle());
        assertEquals("", mapped.getPostBody());
        assertEquals("", mapped.getWriterName());
        assertEquals("", mapped.getWriterImageUrl());
        assertEquals("", mapped.getCommentCounter());
    }
}