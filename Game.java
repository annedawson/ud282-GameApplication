package com.company;

// Updated: Thu 1 Feb 2018 11:01 PT
// adding code to setMovieGuessBlanks() on Thu 1 Feb 2018 to show spaces in movieGuess

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
    private String movieLettersGuessed;
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
        // adding code to setMovieGuessBlanks() on Thu 1 Feb 2018 to show spaces in movieGuess
        char[] charArrayMovieGuess;
        char[] charArrayMovieCopy;
        int indexOfSpace;

        String movieCopy = this.movie;
        System.out.println("In the setMovieGuessBlanks() method\n\n");
        this.movieGuess = this.movie.replaceAll(".", "_"); // "." is a regular expression meaning any character
        System.out.println(this.movieGuess);
        System.out.println(movieCopy);
        indexOfSpace = movieCopy.indexOf(" ");
        System.out.println("Index of the space is: " + indexOfSpace);

        while (indexOfSpace != -1) {
            System.out.println("In while loop: Index of the space is: " + indexOfSpace);
            indexOfSpace = movieCopy.indexOf(" ");
            charArrayMovieGuess = movieGuess.toCharArray();
            charArrayMovieGuess[indexOfSpace] = ' ';
            charArrayMovieCopy = movieCopy.toCharArray();
            charArrayMovieCopy[indexOfSpace] = '#';
            movieCopy = new String(charArrayMovieCopy);
            movieGuess = new String(charArrayMovieGuess);
            indexOfSpace = movieCopy.indexOf(" ");

        }

        System.out.println("Leaving the setMovieGuessBlanks() method\n\n");

    }

    public void setMovieGuess(char theLetter, int n) {



        char[] charArrayMovieGuess;
        char[] charArrayLettersGuessed;

        int i;

        if (n == 10){
            movieLettersGuessed = movie;
        }

        i = movieLettersGuessed.indexOf(theLetter);

        while (i != -1) {

            System.out.println("Index of the letter is: " + i);
            charArrayMovieGuess = movieGuess.toCharArray();
            charArrayMovieGuess[i] = theLetter;
            charArrayLettersGuessed = movieLettersGuessed.toCharArray();
            charArrayLettersGuessed[i] = '*';
            movieLettersGuessed = new String(charArrayLettersGuessed);
            movieGuess = new String(charArrayMovieGuess);
            System.out.println("movieGuess: " + movieGuess);
            System.out.println("movieLettersGuessed: " + movieLettersGuessed);
            i = movieLettersGuessed.indexOf(theLetter);

        }
        System.out.println("Leaving the setMovieGuess method");
    }

    public String getMovieGuess() {
        return this.movieGuess;
    }


}
