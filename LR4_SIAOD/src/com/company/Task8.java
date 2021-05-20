package com.company;

//Дан текстовый файл. Используя стек, сформировать новый текстовый файл,
//содержащий строки исходного файла, записанные в обратном порядке: первая
//строка становится последней, вторая – предпоследней и т.д
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Task8 {

        public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
            PrintWriter writer = new PrintWriter("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\textout.txt", "UTF-8");
            Stack<String>list = new Stack<>();
            try (Scanner scan = new Scanner(new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\text8.txt"))) {
                while (scan.hasNextLine()) {
                    list.push(scan.nextLine());
                }
                while(!list.empty()) {
                    String out = list.pop();
                    writer.println(out);
                }
                System.out.println("Выполнено!");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

}
