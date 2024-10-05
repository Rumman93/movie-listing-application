package service;

import domain.model.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */
public class MovieService {

    private List<Movie> movieList = new ArrayList<>();

    public void addNewMovie(Movie movie) {
        movieList.add(movie);
    }

    public Movie getMovieInformation(String title) {

        return movieList.stream()
                .filter(e -> e.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

    }

    public List<Movie> searchMovies(String keyword) {

        return movieList.stream()
                .filter(movie -> matchesKeyword(movie, keyword))
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());

    }


    private boolean matchesKeyword(Movie movie,
                                   String keyword) {

        String formattedKeyword = keyword.toLowerCase();

        return movie.getTitle().toLowerCase().contains(formattedKeyword) ||
                movie.getCast().toLowerCase().contains(formattedKeyword) ||
                movie.getCategory().toLowerCase().contains(formattedKeyword);
    }
}
