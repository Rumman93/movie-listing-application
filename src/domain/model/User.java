package domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */
public class User {

    private String email;
    private Set<Movie> favoriteList = new HashSet<>();

    public User(String email, Set<Movie> favoriteList) {
        this.email = email;
        this.favoriteList = favoriteList;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Movie> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(Set<Movie> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public void addToFavoriteList(Movie movie) {
        favoriteList.add(movie);
    }

    public void removeFromFavoriteList(Movie movie) {
        favoriteList.remove(movie);
    }
}
