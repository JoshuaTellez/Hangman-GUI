/***************************************************************
* File: Main.java
* Author: Joshua Tellez
* Class: CS 245
*
* Assignment: Quarter Project v1.3
* Date last modified: 9/2/15
*
* Purpose: Hangman game with GUI. Has title panel, menu panel, hangman panel, color
* game panel, high scores panel and credits panel. Basic Hangman layout user is given six
* tries before game ends and has option to skip the game. Once hangman game is finished
* color game starts where user must select the correct color of text associated with the given
* string. After color game, a sudoku game will start where player must correctly fill the board
* or quit to end the game. If user beats any of the high scores, option of saving the high score is prompted.
*
****************************************************************/ 
package QuarterProject;

import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame frame = new MyFrame();
                frame.play();
            }
        });
    }
}
