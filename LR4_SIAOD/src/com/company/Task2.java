package com.company;

//Дек содержит последовательность символов для шифровки сообщений. Дан
//текстовый файл, содержащий зашифрованное сообщение. Пользуясь деком,
//расшифровать текст. Известно, что при шифровке каждый символ сообщения
//заменялся следующим за ним в деке по часовой стрелке через один
import java.io.*;

public class Task2 {
    private final static char[] DEK = {'a', 'b', 'g', 'u', 'i', 'o', 'e', 't', 'n', 's', 'h', 'v', 'c', 'y'};

     public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\text2.txt")));
         BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\Королева\\Desktop\\Siaod_Strukova\\LR4\\DEK_README.txt")));
         int i;
         while ((i = reader.read()) != -1) {
             char ch = (char) i;
             writer.append(switchLetter(ch));
             writer.flush();
         }
         reader.close();
         writer.close();
     }

     private static char switchLetter(char ch) {
         char outchar = '0';
         for (int i = 2; i < DEK.length; i++) {
             char c = DEK[i];
             if (c == ch) {
                 outchar = DEK[i - 2]; //меняем через один
                 break;
             }
         }
         if (outchar == '0')
             outchar = ch;
         return outchar;
     }
}

