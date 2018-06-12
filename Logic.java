/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author collincampbell
 */
public class Logic {
    private String word;
    private int totalLives = 6;
    StringBuilder sb = new StringBuilder(); // to display how much of the word has been solves so far
    StringBuilder usedChars = new StringBuilder(); // keep track of letters that have been used already
    private ArrayList<Integer> lettersIndex = new ArrayList<Integer>();
    private ArrayList<Character> lettersList = new ArrayList<Character>();
    Scanner reader = new Scanner(System.in);
    private String guess;
    private char a;
    
    public Logic(String word) { //the secret word is initially seen as a series of _ in place of unsolved letters.
        this.word = word;
        for (int i = 0; i < word.length(); i++) {
            sb.append("_");
        }
        
        
    }
    
    public void display() { // show player how many lettrs are still unkown
        System.out.println(sb);
    }
    
    public void printLives() {
        System.out.println("You have " + totalLives + " lives left.");
    }
    
    public int totalLeft() {
        return totalLives;
    }
    
    
    public void checkWord() {  // used if player guesses a word instead of single letter
        if (word.equals(guess)) {
            sb.replace(0, guess.length() - 1, word);
        } else {
            totalLives--;
            System.out.println("The word is not " + guess);
            display();
        }
    }
    
    public boolean checkChar() { // check if char has already been used
        if (usedChars.toString().indexOf(a) < 0) {
            usedChars.append(a + " ");
            return true;
        } else {
            System.out.println("You already used that letter.");
            return false;
        }
    }
    
    public void usedLetters() {
        System.out.println("used letters " + usedChars.toString()); 
    }
    
    public boolean oneLetter() {
        return guess.length() == 1;
    }
    
    public void inputGuess() { // get guess input from user
        System.out.println("Guess a letter");
        guess =  reader.nextLine();
        a = guess.charAt(0);
    }
    
    public String getGuess() { // method to get the last guess made by user 
        return guess;
    }
    
    public boolean playerWins() {
        return word.equals(sb.toString());
    }
    
    public void checkLetter() {
        lettersIndex.clear();
        if (word.indexOf(a) < 0) {
            System.out.println("The word does not contain " + a);
            totalLives--;
            display();
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == a) {
                    lettersIndex.add(i); 
                    
                }
            }
            for (Integer letter : lettersIndex) {
                sb.setCharAt(letter, a);
            }
            display();
        }
    }
    
}
