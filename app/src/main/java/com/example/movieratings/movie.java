package com.example.movieratings;
import lombok.Data;
@Data
public class movie {
    String title;
    float votes;
    public movie(String title, float votes){
        this.title=title;
        this.votes=votes;

    }

    public String getTitle() {
        return title;
    }

    public float getVotes() {
        return votes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVotes(float votes) {
        this.votes = votes;
    }
}
