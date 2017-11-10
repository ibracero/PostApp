package com.ibracero.postapp.presentation.model.mapper;

import com.ibracero.postapp.BaseUnitTest;
import com.ibracero.postapp.Constants;
import com.ibracero.postapp.domain.model.PostModel;
import com.ibracero.postapp.domain.model.UserModel;
import com.ibracero.postapp.presentation.model.PostDetailViewModel;
import com.ibracero.postapp.presentation.model.PostItemViewModel;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class PostViewMapperTest extends BaseUnitTest {

    private PostItemViewMapper mPostViewMapper;

    @Override
    protected void setUp() {
        mPostViewMapper = new PostItemViewMapper();
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

        PostItemViewModel postItemViewModel = mPostViewMapper.map(postModel);

        assertEquals(postItemViewModel.getId(), postModel.getId());
        assertEquals(postItemViewModel.getTitle(), postModel.getTitle());
        assertEquals(postItemViewModel.getWriterImage(), Constants.IMAGE_GENERATOR_URL + postModel.getWriter().getEmail());
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

        PostItemViewModel mapped = mPostViewMapper.map(postModel);

        assertEquals(0, mapped.getId());
        assertEquals("", mapped.getTitle());
        assertEquals("", mapped.getWriterImage());
    }
}