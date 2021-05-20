package com.company;

//Дан файл из символов. Используя стек, за один просмотр файла напечатать
//сначала все цифры, затем все буквы, и, наконец, все остальные символы, сохраняя
//исходный порядок в каждой группе символов
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Task6 {
        public static void main(String[] args) {
            try {
                File file = new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\text6.txt");
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = String.valueOf(reader.readLine());
                Chain(line);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        public static void Chain(String line) {
            Stack<Character> chain = new Stack<>();
            for(int i = 0; i < line.length(); i++) {
                if(Character.isDigit(line.charAt(i))) { //определяет, является ли указанное значение типа char цифрой
                    chain.push(line.charAt(i));
                }
            }
            for(int i = 0; i < line.length(); i++) {
                if(Character.isLetter(line.charAt(i))) {
                    chain.push(line.charAt(i));
                }
            }
            for(int i = 0; i < line.length(); i++) {
                if(!Character.isDigit(line.charAt(i)) && !Character.isLetter(line.charAt(i)) ) {
                    chain.push(line.charAt(i));
                }
            }
            System.out.println(chain);
        }
    }

