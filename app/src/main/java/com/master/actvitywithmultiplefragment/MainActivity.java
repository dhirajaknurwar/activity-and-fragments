package com.master.actvitywithmultiplefragment;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragmentOne();
    }

    private void showFragmentOne() {
        FragmentOne fragmentOne = new FragmentOne();
        fragmentTransaction(FragmentOne.class.getSimpleName(), fragmentOne, false, 1);
    }

}
