package com.da.engine;

import com.da.model.DataModel;
import com.da.model.Movie;
import com.da.model.User;
import com.da.util.DataLoader;
import com.da.util.RecommenderAppTest;

import java.util.Map;
import java.util.Scanner;

/**
 * Project: recommender
 * RecommenderApp is the main application that manages movie and user data
 * and provides a command-line interface for interacting with the RecommendationEngine.
 */
public class RecommenderApp {

    // File paths for data files
    public static final String FILE_PATH_MOVIES = "../data/movies.csv";
    public static final String FILE_PATH_USERS = "../data/users.csv";
    public static final String FILE_PATH_RATINGS = "../data/ratings.csv";

    private final DataLoader dataLoader;
    private final RecommendationEngine recommendationEngine;
    private final DataModel dataModel;

    /**
     * Constructor to initialize the RecommenderApp with dependencies.
     *
     * @param dataLoader           DataLoader for loading data.
     * @param recommendationEngine RecommendationEngine for generating recommendations.
     * @param dataModel            DataModel to store application data.
     */
    public RecommenderApp(DataLoader dataLoader, RecommendationEngine recommendationEngine, DataModel dataModel) {
        this.dataLoader = dataLoader;
        this.recommendationEngine = recommendationEngine;
        this.dataModel = dataModel;
    }

    /**
     * Main method to start the application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        RecommenderApp app = setUpRecommenderApp();

        if (args.length > 0) {
            // If there is a command line argument, then we use the test framework
            for (int i = 1; i < 24; i++) {
                RecommenderAppTest test = new RecommenderAppTest(app);
                test.test("testdata/input/testcase" + i + ".in");

                // Makes sure everything is reset for the next test case
                app=setUpRecommenderApp();
            }
            // Otherwise run as a cmd program
        } else {
            app.run();
        }

    }

    /**
     * Creates all necessary objects and wire them together
     * @return RecommederApp instance to be used
     */
    private static RecommenderApp setUpRecommenderApp(){
        DataModel dataModel = new DataModel();
        DataLoader dataLoader = new DataLoader(dataModel);
        RecommendationEngine recommendationEngine = new RecommendationEngine(dataModel);
        RecommenderApp app = new RecommenderApp(dataLoader, recommendationEngine, dataModel);

        // Load data from files
        app.dataLoader.loadData(RecommenderApp.FILE_PATH_MOVIES, RecommenderApp.FILE_PATH_USERS,
                RecommenderApp.FILE_PATH_RATINGS);
        return app;
    }

    /**
     * Main loop to handle user input and commands.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions: addMovie, addUser, deleteUser, addRating, " +
                    "changeRating, deleteRating, getRecommendation, showUsers, showMovies, showAllRatings, " +
                    "showUserRatings, showMovieRatings exit ");
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "addmovie":
                    addMovie();
                    break;
                case "adduser":
                    addUser();
                    break;
                case "deleteuser":
                    deleteUser();
                    break;
                case "addrating":
                    addRating();
                    break;
                case "changerating":
                    changeRating();
                    break;
                case "deleterating":
                    deleteRating();
                    break;
                case "showusers":
                    System.out.println(showUsers());
                    break;
                case "showmovies":
                    System.out.println(showMovies());
                    break;
                case "showallratings":
                    System.out.println(showAllRatings());
                    break;
                case "showuserratings":
                    System.out.println(showUserRatings());
                    break;
                case "showmovieratings":
                    System.out.println(showMovieRatings());
                    break;
                case "getrecommendation":
                    System.out.println(getRecommendation());
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command.");
            }

        }


    }

    /**
     * Adds a new movie to the data model. In case the movie already exists (same title, same year, same genre)
     * the cmd-user is informed.
     */
    public void addMovie() {
        Scanner scanner = new Scanner(System.in);
        Movie movie = handleMovieInput(scanner);
        //TODO finish method
    }

    /**
     * Prompts the user for input to create a new movie object by collecting the title, year, and genre.
     * <p>
     * This method interacts with the user through the console, requesting a comma-separated input for the
     * movie's title, release year, and genre. It validates the input format, ensuring the correct number of
     * parts and valid data types. If the input is invalid, the user is prompted to re-enter the details until
     * valid input is provided.
     *
     * @param scanner Scanner to read the user input from the command line or test case
     * @return a Movie object created using the user-provided data
     * @throws IllegalArgumentException if the input format is invalid or if year parsing fails, although exceptions
     *                                  are caught and handled within the method to allow the user to re-enter input.
     */
    public Movie handleMovieInput(Scanner scanner) {
        System.out.println("Add the following information about the movie: title, year, and genre (separated " +
                "by a comma)");

        while (true) {
            try {
                String input = scanner.nextLine();
                String[] parts = parseInput(input, 3, "Invalid format. Provide title, " +
                        "year, and genre.");
                String title = parts[0];
                int year = Integer.parseInt(parts[1]);
                String genre = parts[2];

                return new Movie(dataModel.getMovies().size() + 1, title, year, genre);
            } catch (NumberFormatException e) {
                System.out.println("The year must be an integer value. Add the following information about the movie: " +
                        "title, year, and genre (separated by a comma) ");
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Parses and validates the input string by splitting it into parts and checking their count.
     * <p>
     * This method splits the provided input string into an array of substrings using a comma (`,`) as the delimiter.
     * It then trims any leading or trailing whitespace from each substring and validates that the number of resulting
     * parts matches the expected number. If the validation fails, an {@link IllegalArgumentException} is thrown with
     * the provided error message.
     *
     * @param input         the input string to parse, expected to contain comma-separated values
     * @param expectedParts the exact number of parts the input is expected to have after splitting
     * @param errorMessage  the error message to include in the exception if validation fails
     * @return an array of trimmed substrings resulting from splitting the input string
     * @throws IllegalArgumentException if the number of parts does not match {@code expectedParts}
     */
    private String[] parseInput(String input, int expectedParts, String errorMessage) {
        String[] parts = input.split(",");
        if (parts.length != expectedParts) {
            throw new IllegalArgumentException(errorMessage);
        }
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }

    /**
     * Adds a new user to the data model. In case a user with the same name already exists, the
     * cmd-user is informed.
     */
    public void addUser() {
        System.out.println("Add the following information about the user: user name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        // TODO finish method
    }

    /**
     * Deletes a user from the data model. In case the user does not exist, the cmd-user is informed.
     */
    public void deleteUser() {
        System.out.println("Add the following information about the user: user name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        //TODO finish method
    }

    /**
     * Adds a rating for a movie by a user.
     */
    public void addRating() {
        //TODO implement method
        System.out.println("Add the following information about the user: user name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();

        Movie movie = handleMovieInput(scanner);

        System.out.println("Add the rating for user " + name + " for movie " + movie + " as an integer value:");
        System.out.println("\t-5: HATED_IT;\n" +
                "\t-3: DIDNT_LIKE_IT;\n" +
                "\t 1: OK;\n" +
                "\t 3: LIKED_IT;\n" +
                "\t 5: REALLY_LIKED_IT");
        
    }

    /**
     * Changes an existing rating for a movie by a user.
     */
    public void changeRating() {
        //TODO implement method
        System.out.println("Add the following information about the user: user name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();

        Movie movie = handleMovieInput(scanner);

        System.out.println("Add the rating for user " + name + " for movie " + movie + " as an integer value:");
        System.out.println("\t-5: HATED_IT;\n" +
                "\t-3: DIDNT_LIKE_IT;\n" +
                "\t 1: OK;\n" +
                "\t 3: LIKED_IT;\n" +
                "\t 5: REALLY_LIKED_IT");
    }

    /**
     * Deletes an existing rating for a movie by a user.
     */
    public void deleteRating() {
        //TODO implement method
        System.out.println("Add the following information about the user: user name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();

        Movie movie = handleMovieInput(scanner);
    }

    /**
     * Generates movie recommendations for a user.
     *
     * @return A string representation of the recommendations so that the most recommended movies are contained
     * in the beginning of the list.
     */
    public String getRecommendation() {
        System.out.println("Add the following information about the user: user name");
        StringBuilder resultStringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        User user;
        while (true) {
            user = dataModel.returnUserByName(userName);
            if (user == null) {
                System.out.println(" User " + userName + " does not exist in library.");
                userName = scanner.nextLine();
            } else {
                break;
            }
        }


        Object recommendations = this.recommendationEngine.recommendMovie(user);
        // TODO finish method

        return resultStringBuilder.toString();
    }



    /**
     * Displays all users.
     *
     * @return A string representation of all users.
     */
    public String showUsers() {
        StringBuilder result = new StringBuilder();
        result.append("All Users:").append("\n");
        for (Map.Entry<Integer, User> entry : dataModel.getUsers().entrySet()) {
            User user = entry.getValue();
            result.append(user.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Displays all movies.
     *
     * @return A string representation of all movies.
     */
    public String showMovies() {
        StringBuilder result = new StringBuilder();
        result.append("All Movies:").append("\n");
        for (Map.Entry<Integer, Movie> entry : dataModel.getMovies().entrySet()) {
            Movie movie = entry.getValue();
            result.append(movie.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Displays all ratings.
     *
     * @return A string representation of all ratings (see testcases for format).
     */
    public String showAllRatings() {
        StringBuilder result = new StringBuilder();
        result.append("All Ratings:").append("\n");

        //TODO finish method
        return result.toString();
    }

    /**
     * Displays all ratings by a specific user.
     *
     * @return A string representation of the user's ratings (see testcases for format).
     */
    public String showUserRatings() {
        System.out.println("Add the following information about the user: user name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        StringBuilder result = new StringBuilder();

        //TODO finish method
        return result.toString();
    }

    /**
     * Displays all ratings for a specific movie.
     *
     * @return A string representation of the movie's ratings (see testcases for format).
     */
    public String showMovieRatings() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        Movie movie = handleMovieInput(scanner);

        //TODO finish method
        return result.toString();
    }
}
