package com.company;

//Дан текстовый файл. Используя стек, проверить, является ли содержимое
//текстового файла правильной записью формулы вида:
//< Формула > ::= < Терм > | < Терм > + < Формула > | < Терм > - < Формула >
//< Терм > ::= < Имя > | (< Формула >)
//< Имя > ::= x | y | z
import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class Task11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\text11.txt")));
        Stack<Character> st = new Stack<>();
        Stack<Character> letter = new Stack<Character>();
        Stack<Character> symbols = new Stack<Character>();
        int open = 0,close = 0;
        int i = 0;
        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }
        for (char r : st) {
            if (Character.isAlphabetic(r)) {
                letter.push(r);
            }
        }
        for (char r : st) {
            if (!(Character.isDigit(r) || Character.isAlphabetic(r))) {
                symbols.push(r);
            }
        }
        int kol = 0;
        while (symbols.size() != 0) { //колво на 1 больше чем символы
            char s = symbols.pop();
            switch (s) {
                case ('+'):
                case ('-'):
                    kol++;
                    break;
                case ('('):
                    open++;
                    break;
                case (')'):
                    close++;
                    break;
            }
        }

        int w = 0;
        while (letter.size() != 0) {
            char s = letter.pop();
            switch (s) {
                case ('x'):
                case ('y'):
                case ('z'):
                    w++;
                    break;
            }
        }

        if ((close==open) && (w-1 == kol))
            System.out.println("Формула имеет правильный вид");
        else
            System.out.println("Формула имеет не правильный вид");
    }
}
