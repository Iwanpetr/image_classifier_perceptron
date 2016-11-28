package com.myowndev.main;

import static com.myowndev.main.VarContainer.input;

/**
 * Created by Iwanp on 21.11.2016.
 */
public class Network {

    public int[][] mul; // Тут будем хранить отмасштабированные сигналы
    public int[][] weight; // Массив для хранения весов
    public int limit = 9; // Порог. Выбран экспериментально для быстрого обучения
    public int sum; // Тут сохраним сумму масштабированных сигналов

    public Network(int sizex, int sizey, int[][] inP) { // Задаем свойства при создании объекта
        weight = new int[sizex][sizey]; // Определяемся с размером массива (число входов)
        mul = new int[sizex][sizey];

        input = new int[sizex][sizey];
        input = inP; // Получаем входные данные
    }
    public void mul_w() {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 4; y++) { // Пробегаем по каждому аксону
                mul[x][y] = input[x][y] * weight[x][y]; // Умножаем его сигнал (0 или 1) на его собственный вес и сохраняем в массив.
            }
        }
    }
    public void Sum() {
        sum = 0;
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 4; y++) {
                sum += mul[x][y];
            }
        }
    }
    public boolean Rez() {
        if (sum >= limit)
            return true;
        else return false;
    }
    public void recognize() {
        this.mul_w();
        this.Sum();
        if (this.Rez()) {
            System.out.println(" - True,  Sum = " + (this.sum));
        } else {
            System.out.println(" - False, Sum = " + (this.sum));
        }
    }
    public void incW(int[][] inP) {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 4; y++) {
                this.weight[x][y] += inP[x][y];
            }
        }
    }
    public void decW(int[][] inP) {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 4; y++) {
                this.weight[x][y] -= inP[x][y];
            }
        }
    }
}






















































