package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.data.datasources.network.model.ApiUser;
import com.ibracero.postapp.domain.model.UserModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

@RunWith(JUnit4.class)
public class UserMapperTest {

    private UserMapper mUserMapper;

    @Before
    public void setup() {
        mUserMapper = new UserMapper();
    }

    @Test
    public void shouldMap() {

        ApiUser apiUser = new ApiUser.Builder()
                .id(1)
                .username("username")
                .email("email")
                .build();

        UserModel mapped = mUserMapper.map(apiUser);

        assertEquals(apiUser.getId(), mapped.getId());
        assertEquals(apiUser.getEmail(), mapped.getEmail());
        assertEquals(apiUser.getUsername(), mapped.getUsername());
    }

    @Test
    public void shouldMapWithNullValues() {

        ApiUser apiUser = new ApiUser.Builder()
                .id(0)
                .username(null)
                .email(null)
                .build();

        UserModel mapped = mUserMapper.map(apiUser);

        assertEquals(apiUser.getId(), mapped.getId());
        assertEquals(apiUser.getEmail(), mapped.getEmail());
        assertEquals(apiUser.getUsername(), mapped.getUsername());
    }
}