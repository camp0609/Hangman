/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author collincampbell
 */
public class UserInterface {
    private Scanner reader = new Scanner(System.in);
    private Logic game;
    
    
    public void run() {
        System.out.println("Welcome to Hangaman!\n"
                +"Player 1 input secret word, no pearking player 2!");
        game = new Logic(reader.nextLine());
        game.display();
        while (true) {
            game.printLives();
            
            while (true) {   
                game.inputGuess();
                System.out.print("\n");
                if (!game.oneLetter()) {
                    game.checkWord();
                    break;
                } else {
                    if (game.checkChar()) {
                        break;
                    }
                } 
            }
            if (game.oneLetter()) {
                game.checkLetter();
            }
            
            if (game.playerWins()) {
                System.out.println("You win!");
                break;
            }
            if (game.totalLeft() < 0) {
                System.out.println("You Lose!");
                break;
            }
            game.usedLetters();
        }
    }
    
    
    
    
    
    
}
