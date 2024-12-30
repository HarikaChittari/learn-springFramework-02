package com.demo.learn_spring;

import com.demo.learn_spring.game.GameRunner;
import com.demo.learn_spring.game.PacManGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {
        var game = new PacManGame(); //1. Object creation
        //var game = new SuperContraGame();
        var gameRunner = new GameRunner(game); //2. Object creation of game runner and wiring of dependencies
        //Game Runner class need a game to run the class - so here game is a dependency of Game Runner
        gameRunner.run();
    }
}
