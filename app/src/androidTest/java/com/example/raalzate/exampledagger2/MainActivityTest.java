package com.example.raalzate.exampledagger2;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.raalzate.exampledagger2.model.RepositoryPOJO;
import com.example.raalzate.exampledagger2.view.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
/**
 * Created by raul-alzate on 13/06/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivity =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){

        final ArrayList<RepositoryPOJO> repositoryPOJOs = new ArrayList<>();

        RepositoryPOJO repositoryPOJO1 = new RepositoryPOJO();
        repositoryPOJO1.setName("airtravel");
        repositoryPOJOs.add(repositoryPOJO1);

        RepositoryPOJO repositoryPOJO2 = new RepositoryPOJO();
        repositoryPOJO2.setName("android");
        repositoryPOJOs.add(repositoryPOJO2);


        mActivity.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActivity.getActivity().setDataAdapter(repositoryPOJOs);
            }
        });

    }

    @Test
    public void check_firstItem() {
        onView(withRecyclerView(R.id.list_repositories).atPosition(0))
                .check(matches(hasDescendant(withText("airtravel"))));
    }

    @Test
    public void checkClick_secondItem() {
        onView(withRecyclerView(R.id.list_repositories).atPosition(1))
                .perform(click());
        onView(allOf(withId(android.support.design.R.id.snackbar_text),
                withText("android")))
                .check(matches(isDisplayed()));

    }

    // Convenience helper
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }



}
