package com.myowndev.main;

/**
 * Created by Iwanp on 21.11.2016.
 */
public class VarContainer {

    public static int runCounter = 0;


    public static int[][] input = new int[3][5];; // Входная информация

    // на всякий аварийный случай, если надо будет инициализировать. Инициализатор:
    public VarContainer() {
        init();
    }
    public void init() {
        input = new int[3][5];
        // нужно ли заполнить массив?
    }
}




























































