package com.company;

// updated: Fri Jan 19 9:50 PT

public class Main {

    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.setNumberOfMovies();
        myGame.setMovie();
        System.out.println(myGame.getMovie());
    }
}
