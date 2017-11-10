package com.ibracero.postapp.data.datasources.network.model.mapper;

import com.ibracero.postapp.BaseUnitTest;
import com.ibracero.postapp.data.datasources.network.model.ApiUser;
import com.ibracero.postapp.domain.model.UserModel;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserMapperTest extends BaseUnitTest {

    private UserMapper mUserMapper;

    @Override
    protected void setUp() {
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