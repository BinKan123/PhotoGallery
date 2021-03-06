package com.kb.photoshow.Activity;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.kb.photoshow.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kanbi on 23/05/2018.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;


    @Before
    public void setUp() throws Exception {

        mainActivity = activityActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){
        View view = mainActivity.findViewById(R.id.recyclerview);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;

    }

}