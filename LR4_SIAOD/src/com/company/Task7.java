package com.company;

//Дан файл из целых чисел. Используя дек, за один просмотр файла напечатать
//сначала все отрицательные числа, затем все положительные числа, сохраняя
//исходный порядок в каждой группе
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Task7 {
        public static void main(String[] args) {
            try {
                File file = new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\text7.txt");
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = String.valueOf(reader.readLine());
                Chain1(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void Chain1(String line) {
            Deque<Integer> chain = new ArrayDeque<>();
            String[] strArr = line.split(" ");
            int[] numArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                numArr[i] = Integer.parseInt(strArr[i]);
            }
            for (int i = 0; i < numArr.length; i++) {
                if(numArr[i] < 0) {
                    chain.addLast(numArr[i]);
                }
            }
            for (int i = 0; i < numArr.length; i++) {
                if(numArr[i] > 0) {
                    chain.addLast(numArr[i]);
                }
            }
            System.out.println(chain);
        }
}
