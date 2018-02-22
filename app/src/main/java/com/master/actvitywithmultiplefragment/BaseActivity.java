package com.master.actvitywithmultiplefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


public class BaseActivity extends AppCompatActivity {
    public String mTagName = "";

    //Keeps the screen on
    protected void keepScreenOn() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    //Removes the flags set to keep the screen on
    protected void clearScreenOnFlag() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * Fragement  navigation method
     *
     * @param tagName        : identifying the fragment with tagname
     * @param fragment       ; navigate to screen
     * @param addToBackStack : adding the the backstack
     * @param style          : animation style
     */
    public void fragmentTransaction(String tagName, Fragment fragment, boolean addToBackStack, int style) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mTagName = tagName;
            switch (style) {
                case 1:
                    transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    transaction.replace(R.id.container_body, fragment, tagName);
                    break;

                case 2:
                    transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    transaction.replace(R.id.container_body, fragment, tagName);
                    break;
                default:
                    transaction.replace(R.id.container_body, fragment, tagName);
                    break;
            }
            if (addToBackStack) {
                transaction.addToBackStack(tagName);
            }
            transaction.commit();
        }
    }
}
