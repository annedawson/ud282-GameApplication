package com.company;

// Updated: Thu 25 Jan 2018 13:43 PT

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
        this.movieGuess = this.movie.replaceAll(".", "_"); // "." is a regular expression meaning any character
        System.out.println(this.movieGuess);
    }

    public void setMovieGuess(char theLetter) {

        //System.out.println(this.movie.indexOf(theLetter));
        int i = this.movie.indexOf(theLetter);
        char[] charArrayMovieGuess;
        char[] charArrayLettersGuessed;

        while (i != -1) {
            System.out.println("Index of the letter is: " + i);
            //System.out.println(this.movie.charAt(i));
            //String result = "Test";
            //result = result.replace('e','X');
            //System.out.println("result" + result);

            charArrayMovieGuess = movieGuess.toCharArray();
            charArrayMovieGuess[i] = theLetter;
            charArrayLettersGuessed = movie.toCharArray();
            charArrayLettersGuessed[i] = '*';
            String movieLettersGuessed = new String(charArrayLettersGuessed);
            // String movieGuess = new String(charArrayMovieGuess);
            // don't do the above because
            // it makes a local variable with same name as the instance variable, when I really wanted
            // to assign a value to the instance variable!
            movieGuess = new String(charArrayMovieGuess);
            //System.out.println(result);
            //movieGuess = result;
            //movieGuess = movieGuess.replace(movieGuess.charAt(1),'Z');
            System.out.println(movieGuess);
            System.out.println(movieLettersGuessed);
        /*
        if ( this.movie.indexOf(theLetter) != -1 ) {
            System.out.println("Now in if part...");
            System.out.println(this.movie.charAt(this.movie.indexOf(theLetter)));
            this.movieGuess = this.movieGuess.replace(this.movie.charAt(i), theLetter);
            System.out.println(this.movieGuess);
        }
        */
            i = movieLettersGuessed.indexOf(theLetter);
            System.out.println("Leaving the setMovieGuess method");
        }
    }

    public String getMovieGuess() {
        return this.movieGuess;
    }


}
