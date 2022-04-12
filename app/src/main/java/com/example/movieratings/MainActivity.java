package com.example.movieratings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private Fragment fragment =null;
    public static final String FRAG_TAG_POPULAR="frag-popular" ;
    public static final String FRAG_TAG_TOPRATED="frag-toprated" ;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragmentManager=getSupportFragmentManager();
        loadPopularMoviesFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.popular:
                loadPopularMoviesFragment();
                return true;
            case R.id.top_rated:
                loadTopRatedFragment();
                return true;
            case R.id.setting:
                Toast.makeText(this,"Settings", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void loadPopularMoviesFragment() {
        fragment=fragmentManager.findFragmentByTag(FRAG_TAG_POPULAR);
        if(fragment!=null)
            fragmentManager.beginTransaction().show(fragment).commit();
        else
        {
            fragmentManager.beginTransaction().add(R.id.fragment_container,new MovieFragment(),FRAG_TAG_POPULAR).commit();
        }
        //hide rest fragments if they exist
        hideFragments(FRAG_TAG_TOPRATED);
    }
    private void loadTopRatedFragment()
    {
        fragment=fragmentManager.findFragmentByTag(FRAG_TAG_TOPRATED);
        if(fragment!=null)
            fragmentManager.beginTransaction().show(fragment).commit();
        else
        {
            fragmentManager.beginTransaction().add(R.id.fragment_container,new MovieFragment(),FRAG_TAG_TOPRATED).commit();
        }
        hideFragments(FRAG_TAG_POPULAR);
    }

    private void hideFragments(String... tags) {
        for(String tag : tags){
            fragment=fragmentManager.findFragmentByTag(tag);
            if(fragment!=null)
                fragmentManager.beginTransaction().hide(fragment).commit();
        }
    }
}