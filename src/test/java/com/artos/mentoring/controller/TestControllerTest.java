package com.artos.mentoring.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjámin Árva on 2017. 07. 22..
 */
public class TestControllerTest {

    private int someInteger;
    private String someString;

    @Before
    public void setUp() throws Exception {
        someInteger = 10;
        someString = "Lorem Ipsum";
    }

    @Test
    public void index() throws Exception {
        Assert.assertEquals(10, someInteger);
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals("Lorem Ipsum", someString);
    }

}