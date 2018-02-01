package com.company;


// Updated: Thu 1 Feb 2018 11:01 PT
// adding code to setMovieGuessBlanks() on Thu 1 Feb 2018 to show spaces in movieGuess


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game myGame = new Game();
        Scanner scanner = new Scanner(System.in);
        int guessesLeft = 10;
        char letter;
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
        while (guessesLeft > 0) {
            System.out.println(myGame.getMovieGuess());
            System.out.println("Please enter a letter:");
            letter = scanner.next().charAt(0); // NB scanner will ignore leading white space, so you cannot input a space
                                               // using this method, so in this program I will display the space within
                                               // the movieGuess, e.g. Gone Girl as ____ ____
                                               // see my changes Thu 1st Feb 2018 in setMovieGuessBlanks()
                                               // so any spaces don't need to be guessed - just the non-white characters are guessed
            System.out.println(letter);
            myGame.setMovieGuess(letter,guessesLeft);
            System.out.println("Guesses left: " + --guessesLeft);
        }


        /*

        String name = scanner.nextLine();
        int age = scanner.nextInt();
        System.out.println("You are " + age + " years old");

        */
    }
}
