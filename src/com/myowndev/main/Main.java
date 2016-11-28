package com.myowndev.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.myowndev.main.VarContainer.input;

/**
 * Created by Iwanp on 21.11.2016.
 */
public class Main {

    public static void main(String args[]) {new Main();}

    Network NW1 = new Network(3, 5, input); // Создаем экземпляр нашего нейрона

    //public Main(object sender, EventArgs e) {
    public Main() {
        try {

            readWeights();
            readImage();
            NW1.recognize();
            validation();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWeights() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("res/weights.txt"));
        String line;
        String[] s1;
        int k = 0;
        String tempStr = "";

        System.out.println("Weights:");
        while ((line = br.readLine()) != null) {
            s1 = line.split(" ");
            for (int i = 0; i < s1.length; i++) {
                if (k < 5) {
                    NW1.weight[i][k] = Integer.valueOf(s1[i]); // Назначаем каждой связи её записанный ранее вес
                    tempStr = tempStr + " " + NW1.weight[i][k]; // Выводим веса для наглядности
                }
            }
            System.out.println(tempStr);
            tempStr = "";
            k++;
        }
        br.close();
    }
    public void readImage() throws IOException {

        BufferedImage bi = ImageIO.read(Files.newInputStream(Paths.get("res/7.bmp")));
        String tempStr = "";

        System.out.println("The form is:");
        for (int y = 0; y <= 4; y++) {
            for (int x = 0; x <= 2; x++) {
                int n = (bi.getRGB(x, y));
                // Определяем, закрашен ли пиксель:
                if (n < -1) {
                    n = 1;
                } else {
                    n = 0;
                }
                //-
                tempStr = tempStr + " " + n;
                input[x][y] = n; // Присваиваем соответствующее значение каждой ячейке входных данных
            }
            System.out.println(tempStr);
            tempStr = "";
        }
    }
    public void validation() throws IOException {

        BufferedReader userInput_br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";

        System.out.println("Correct? (y/n)");
        userInput = userInput_br.readLine();
        if (userInput.equals("y")) {
            // appendix
        } else if (userInput.equals("n")) {
            if (NW1.Rez() == false)
                NW1.incW(input);
            else NW1.decW(input);
            // Запись:
            for (int y = 0; y <= 4; y++) {
                System.out.println(NW1.weight[0][y] + " " + NW1.weight[1][y] + " " + NW1.weight[2][y]);
            }
            /*string s = "";
            string[] s1 = new string[5];
            System.IO.File.Delete("weights.txt");
            FileStream FS = new FileStream("weights.txt", FileMode.OpenOrCreate);
            StreamWriter SW = new StreamWriter(FS);
            for (int y = 0; y <= 4; y++) {
                s = Convert.ToString(NW1.weight[0, y])+" " + Convert.ToString(NW1.weight[1, y])
                +" " + Convert.ToString(NW1.weight[2, y]);
                s1[y] = s;
                SW.WriteLine(s);
            }
            SW.Close();*/
        }
    }
}























































