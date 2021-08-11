package com.example.cs2410_finalproject_sudokuapp.models;

public class Game {
    public int[][] completedBoard;
    public int[][] currentBoard;
    public enum State {
        PLAY,
        WON
    }
}
