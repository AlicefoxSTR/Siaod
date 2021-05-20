package com.company;

//Дан текстовый файл с программой на алгоритмическом языке. За один просмотр
//файла проверить баланс круглых скобок в тексте, используя стек
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Task4 {
        public static void testBrackets(String str) {
            Stack<Character> left_brackets = new Stack<>();
            Stack<Character> right_brackets = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == ')') {
                    right_brackets.push(c);
                } else if (c == '(') {
                    left_brackets.push(c);
                }
            }
            while (!left_brackets.empty() && !right_brackets.empty()) {
                char left = left_brackets.peek();
                char right = right_brackets.peek();
                if (left == '(' && right == ')') {
                    left_brackets.pop(); //вытаскиваем
                    right_brackets.pop();
                } else
                    break;
            }
            if (left_brackets.empty() && right_brackets.empty())
                System.out.println("OK");
            else
                System.out.println("FAIL");
        }

        public static void main(String[] args) {
            try {
                File file = new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\text4.txt");
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                StringBuilder line = new StringBuilder(reader.readLine());
                String tempLine = "";
                boolean bool = true;
                while (bool) {
                    line.append(tempLine);
                    tempLine = reader.readLine();
                    if (tempLine == null)
                        bool = false;
                }
                System.out.println("Получившаяся строка: " + line);
                System.out.print("Проверка: ");
                testBrackets(line.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
