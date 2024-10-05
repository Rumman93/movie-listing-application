package service;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */

import domain.model.Movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class MovieServiceTest {

    private static MovieService movieService;
    private static final String TEST_TITLE = "The Family Star";
    private static final String TEST_CAST = "Vijay Deverakonda";
    private static final String TEST_CATEGORY = "Action";

    public static void main(String[] args) {

        movieService = new MovieService();

        testAddNewMovie();

        testGetMovieInformation();

        testSearchMoviesByTitle();

        testSearchMoviesByCast();

        testSearchMoviesByCategory();

    }

    public static void testAddNewMovie() {

        Movie movie = new Movie();

        movie.setTitle(TEST_TITLE);
        movie.setCast(TEST_CAST);
        movie.setCategory(TEST_CATEGORY);
        movie.setReleaseDate("2024");
        movie.setBudget(BigDecimal.valueOf(500000000));

        movieService.addNewMovie(movie);

        String message = Objects.nonNull(movieService.getMovieInformation(TEST_TITLE))
                ? "testAddNewMovie PASSED"
                : "testAddNewMovie FAILED: Movie should not be null after adding";

        System.out.println(message);
    }

    public static void testGetMovieInformation() {

        Movie movie = movieService.getMovieInformation(TEST_TITLE);

        String message = Objects.nonNull(movie) && TEST_TITLE.equals(movie.getTitle())
                ? "testGetMovieInformation PASSED"
                : "testGetMovieInformation FAILED: Movie should not be null and title should be " + TEST_TITLE;

        System.out.println(message);
    }

    public static void testSearchMoviesByTitle() {

        List<Movie> results = movieService.searchMovies("The Family Star");

        String message = !results.isEmpty() && results.get(0).getTitle().equals(TEST_TITLE)
                ? "testSearchMoviesByTitle PASSED"
                : "testSearchMoviesByTitle FAILED: Should find the movie with title " + TEST_TITLE;

        System.out.println(message);
    }

    public static void testSearchMoviesByCast() {

        List<Movie> results = movieService.searchMovies("vijay");

        String message = !results.isEmpty() && results.get(0).getCast().equals(TEST_CAST)
                ? "testSearchMoviesByCast PASSED"
                : "testSearchMoviesByCast FAILED: Should find the movie with cast " + TEST_CAST;

        System.out.println(message);
    }

    public static void testSearchMoviesByCategory() {

        List<Movie> results = movieService.searchMovies("action");

        String message = !results.isEmpty() && results.get(0).getCategory().equals(TEST_CATEGORY)
                ? "testSearchMoviesByCategory PASSED"
                : "testSearchMoviesByCategory FAILED: Should find the movie with category " + TEST_CATEGORY;

        System.out.println(message);
    }
}

