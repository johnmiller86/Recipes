package com.jdm5908_bw.ist402.recipes;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Fragment mFragmentRecipeDirections, mFragmentRecipePhoto;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentRecipePhoto = new FragmentRecipePhoto();
        mFragmentRecipeDirections = new FragmentRecipeDirections();

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.fragmentContainer, mFragmentRecipePhoto);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    public void flipOver(View view){
        mFragmentTransaction = getFragmentManager().beginTransaction();

        mFragmentTransaction.setCustomAnimations(R.anim.rotate_in, R.anim.rotate_out);

        mFragmentTransaction.setCustomAnimations(R.anim.rotate_in, R.anim.rotate_out, R.anim.rotate_in, R.anim.rotate_out);

        if(mFragmentRecipePhoto.isVisible()){
            mFragmentTransaction.replace(R.id.fragmentContainer, mFragmentRecipeDirections);
        }else{
            mFragmentTransaction.replace(R.id.fragmentContainer, mFragmentRecipePhoto);
        }
        mFragmentTransaction.commit();
    }
}
