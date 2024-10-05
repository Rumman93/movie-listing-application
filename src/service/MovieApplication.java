package service;

/**
 * Author :  Ahmmed Jubayer Rumman
 * Created at : 05 Oct 2024
 */

import domain.enums.ShowOptionEnum;
import domain.model.Movie;
import domain.model.User;

import java.math.BigDecimal;
import java.util.*;

public class MovieApplication {
    private MovieService movieService = new MovieService();
    private UserService userService = new UserService();
    private User currentUser;

    public void start() {

        initializeMovies();

        Scanner scanner = new Scanner(System.in);

        registerUserWithEmail(scanner);

        boolean running = true;

        while (running) {

            showMenu();

            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                option = 9;
            }

            switch (option) {

                case 1 -> searchMovies(scanner);

                case 2 -> viewMovieDetails(scanner);

                case 3 -> addToFavorites(scanner);

                case 4 -> removeFromFavorites(scanner);

                case 5 -> viewFavorites();

                case 6 -> searchFavorites(scanner);

                case 7 -> viewPersonalDetails();

                case 8 -> running = false;

                default -> System.out.println("Please Choose Valid Option !!");

            }
        }

        System.out.println("Thank you for using the Movie Listing Application!");

        scanner.close();
    }

    private void registerUserWithEmail(Scanner scanner) {

        String email;

        while (true) {

            System.out.println("Enter your email to register:");
            email = scanner.nextLine();

            if (userService.isValidEmailFormat(email)) {

                currentUser = userService.registerUser(email);
                System.out.println("Welcome, " + currentUser.getEmail() + "!");
                break;

            } else {
                System.out.println("Invalid email format. Please try again.");
            }

        }
    }

    private void showMenu() {

        for (ShowOptionEnum option : ShowOptionEnum.values()) {
            System.out.println(option.getText());
        }

        System.out.print("Choose an option: ");

    }


    private void searchMovies(Scanner scanner) {

        System.out.print("Enter search keyword (title/cast/category): ");

        String keyword = scanner.nextLine();
        List<Movie> movies = movieService.searchMovies(keyword);

        if (movies.isEmpty()) {
            System.out.println("No movies found.");
        } else {
            movies.forEach(System.out::println);
        }
    }

    private void viewMovieDetails(Scanner scanner) {

        System.out.print("Enter movie title to view details: ");

        String title = scanner.nextLine();
        Movie movie = movieService.getMovieInformation(title);

        if (Objects.nonNull(movie)) {
            System.out.println(movie);
        } else {
            System.out.println("Movie not found.");
        }
    }

    private void addToFavorites(Scanner scanner) {

        System.out.print("Enter movie title to add to favorites: ");

        String title = scanner.nextLine();
        Movie movie = movieService.getMovieInformation(title);

        if (Objects.nonNull(movie)) {

            if (isMovieAlreadyInFavorites(movie)) {
                System.out.println("Movie already added to favorite list earlier");
            } else {
                currentUser.addToFavoriteList(movie);
                System.out.println("Movie added to favorites.");
            }

        } else {
            System.out.println("Movie not found.");
        }
    }

    private boolean isMovieAlreadyInFavorites(Movie movie) {
        return currentUser.getFavoriteList().contains(movie);
    }


    private void removeFromFavorites(Scanner scanner) {

        System.out.print("Enter movie title to remove from favorites: ");
        String title = scanner.nextLine();

        Movie movie = movieService.getMovieInformation(title);

        if (Objects.nonNull(movie) && currentUser.getFavoriteList().contains(movie)) {

            currentUser.removeFromFavoriteList(movie);
            System.out.println("Movie removed from favorites.");

        } else {
            System.out.println("Movie not found in favorites.");
        }

    }

    private void viewFavorites() {

        Set<Movie> favoriteList = currentUser.getFavoriteList();

        if (Objects.isNull(favoriteList) || favoriteList.isEmpty()) {
            System.out.println("You have no favorite movies yet. Start adding some!");
        } else {
            currentUser.getFavoriteList().forEach(System.out::println);
        }

    }

    private void searchFavorites(Scanner scanner) {

        System.out.print("Enter search keyword (title/cast/category) in favorites: ");
        String keyword = scanner.nextLine();

        List<Movie> filteredFavorites = filterFavorites(keyword);

        if (filteredFavorites.isEmpty()) {
            System.out.println("No favorites found matching the keyword: " + keyword);
        } else {
            filteredFavorites.forEach(System.out::println);
        }
    }


    private List<Movie> filterFavorites(String keyword) {

        Set<Movie> favoriteList = currentUser.getFavoriteList();

        if (Objects.isNull(favoriteList) || favoriteList.isEmpty()) {
            return Collections.emptyList();
        }

        return favoriteList.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        m.getCast().toLowerCase().contains(keyword.toLowerCase()) ||
                        m.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }


    private void viewPersonalDetails() {

        System.out.println("User: " + currentUser.getEmail());

    }

    private void initializeMovies() {
        movieService.addNewMovie(new Movie(BigDecimal.valueOf(160000000), "Leonardo DiCaprio", "Action", "2010", "Inception"));
        movieService.addNewMovie(new Movie(BigDecimal.valueOf(190000000), "Adam Sandler", "Sci Fi", "2024", "Spaceman"));
        movieService.addNewMovie(new Movie(BigDecimal.valueOf(180000000), "Vijay Deverakonda", "Action", "2024", "The Family Star"));
    }

}

