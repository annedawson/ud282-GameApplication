package com.company;

// Updated: Sun 21 Jan 2018 13:33 PT

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// String methods:
// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

public class Game {
    Scanner scanner = new Scanner(System.in);

    // Fields:
    private String[] movieList; // equivalent to private String movieList[];
    private int numberOfMovies;
    private String movie;
    private String movieGuess;
    private File file = new File("movies.txt");

    // Constructor:
    Game() {
        numberOfMovies = 0;

    }

    // Methods:
    public void setNumberOfMovies() {
        try {
            File file = new File("movies.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                numberOfMovies++;
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void setMovie() {
        try

        {
            Scanner fileScanner = new Scanner(file);
            int i = 0;
            movieList = new String[numberOfMovies];
            while (fileScanner.hasNextLine()) {
                movieList[i] = fileScanner.nextLine();
                i++;
            }
            for (i = 0; i < movieList.length; i++) {
                //System.out.println(movieList[i]);
            }
            double randomNumber = Math.random();  // gets a random number between 0 and almost 1
            //System.out.println(randomNumber);
            randomNumber = randomNumber * numberOfMovies; // gets a random number between 0 and almost mumberOfMovies
            //System.out.println(randomNumber);
            int randomInt = (int) randomNumber;
            //System.out.println(randomInt);
            //System.out.println(movieList[randomInt]);
            movie = movieList[randomInt];
        } catch (
                IOException e)

        {
            System.out.println(e);
        }

    }

    public String getMovie() {
        return this.movie;
    }

    public void setMovieGuessBlanks() {
        this.movieGuess = this.movie.replaceAll(".", "_"); // "." is a regular expression meaning any character
        System.out.println(this.movieGuess);
    }

    public void setMovieGuess(char theLetter) {
        int n = 0;
        while ( this.movie.indexOf(theLetter) != -1 ) {
            this.movieGuess.replace(this.movie.charAt(this.movie.indexOf(theLetter)), theLetter);
        }
        /*
        HERE!! The above doesn't work ! infinite loop!
        */
        System.out.println("In the setMovieGuess method");
    }

    public String getMovieGuess() {
        return this.movieGuess;
    }


}
