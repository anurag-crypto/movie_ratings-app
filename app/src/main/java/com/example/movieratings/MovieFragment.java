package com.example.movieratings;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

    public MovieFragment() {
    }
    public static MovieFragment newInstance(){ return new MovieFragment();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        inflateView(view);
        return view;
    }

    private void inflateView(@NonNull View view) {

        List<movie> movies=new ArrayList<movie>();
        movies.add(new movie("Thor:Ragnarok", Float.parseFloat("5.9")));
        movies.add(new movie("Thor:Ragnarok", Float.parseFloat("5.9")));
        movies.add(new movie("Thor:Ragnarok", Float.parseFloat("5.9")));
        movies.add(new movie("Thor:Ragnarok", Float.parseFloat("5.9")));
        movies.add(new movie("Thor:Ragnarok", Float.parseFloat("5.9")));
        MovieAdapter adapter=new MovieAdapter(movies);
        RecyclerView recyclerView=view.findViewById(R.id.rv_movie);
        recyclerView.setAdapter(adapter);



    }
}
