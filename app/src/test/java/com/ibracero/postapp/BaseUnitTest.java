package com.ibracero.postapp;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public abstract class BaseUnitTest {

    @Before
    public final void setup() {
        initializeMocks();
        setUp();
    }

    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    protected abstract void setUp();

}