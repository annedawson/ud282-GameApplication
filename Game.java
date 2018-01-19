package com.company;

// updated: Fri Jan 19 9:50 PT

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);

    // Fields:
    private String[] movieList;
    private int numberOfMovies;
    private String movie;
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



        /*

        System.out.println(numberOfMovies);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old");

        */


}
