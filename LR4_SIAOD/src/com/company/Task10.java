package com.company;

//Дан текстовый файл. В текстовом файле записана формула следующего вида:
//<Формула> ::= <Цифра> | M(<Формула>,<Формула>) | N(Формула>,<Формула>)
//< Цифра > ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
//где буквами обозначены функции:
//M – определение максимума, N – определение минимума.
//Используя стек, вычислить значение заданного выражения.
import java.util.Stack;

public class Task10 {
    public static Stack<String> slov = new Stack<>();
    public static int first=-1;
    public static int second=-1;
    public static int top=-1;

    public static void zapoln(String [] s) {
        for (String value : s) {
            slov.push(value);
        }
    }

    public static void start() {
        String d;
        int l=slov .size();
        for (int i = 0; i <l; i++) {
            d=slov .pop();

            if(first==-1&&(d.equals("0")||d.equals("1")||d.equals("2")||d.equals("3")||d.equals("4")||d.equals("5")||d.equals("6")||d.equals("7")||d.equals("8")||d.equals("9")))
            {
                first=Integer.parseInt(d);
                continue;
            }

            if(second==-1&&(d.equals("0")||d.equals("1")||d.equals("2")||d.equals("3")||d.equals("4")||d.equals("5")||d.equals("6")||d.equals("7")||d.equals("8")||d.equals("9")))
            {
                second=Integer.parseInt(d);
                continue;
            }

            if(d.equals("m")&&first!=-1&&second!=-1){
                top=Math.min(first,second);
                first=-1;
                second=-1;
                continue;
            }

            if(d.equals("m")&&first!=-1){
                top=Math.min(first,top);
                first=-1;
                continue;
            }

            if(d.equals("M")&&first!=-1&&second!=-1){
                top=Math.max(first,second);
                first=-1;
                second=-1;
                continue;
            }

            if(d.equals("M")&&first!=-1){
                top=Math.max(first,top);
                first=-1;
            }
        }
    }

    public static void main(String[] args) {
        zapoln(new String[]{"M", "(", "5", ",", "m", "(", "6", ",", "8", ")", ")"});
        start();
        System.out.println(top);
    }
}
