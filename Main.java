package com.company;

// Updated: Sun 21 Jan 2018 13:33 PT

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game myGame = new Game();
        Scanner scanner = new Scanner(System.in);
        myGame.setNumberOfMovies();
        myGame.setMovie();
        System.out.println();
        System.out.println();
        System.out.println("Guess the movie!");
        System.out.println("----------------");
        System.out.println();
        System.out.println();
        System.out.println(myGame.getMovie());
        myGame.setMovieGuessBlanks();
        System.out.println("Please enter a letter:");
        char letter = scanner.next().charAt(0);
        System.out.println(letter);
        myGame.setMovieGuess(letter);
        System.out.println(myGame.getMovieGuess());

        /*

        String name = scanner.nextLine();
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old");

        */
    }
}
