package com.company;

//Даны три стержня и n дисков различного размера. Диски можно надевать на
//стержни, образуя из них башни. Перенести n дисков со стержня А на стержень С,
//сохранив их первоначальный порядок. При переносе дисков необходимо соблюдать
//следующие правила:
//- на каждом шаге со стержня на стержень переносить только один диск;
//- диск нельзя помещать на диск меньшего размера;
//- для промежуточного хранения можно использовать стержень В.
//Реализовать алгоритм, используя три стека вместо стержней А, В, С. Информация
//о дисках хранится в исходном файле.

public class Task3 {
    //Структура для представления стека
    static class Stack {
        int capacity; //отвечает за емкость
        int top;
        int[] array;
}
    //Создание стека заданной емкости
    Stack createStack(int capacity) {
        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.array = new int[capacity];
        return stack;
    }

    //Стек заполнен, если вершина равна stack.capacity - 1
    boolean Full(Stack stack) {
        return (stack.top == stack.capacity - 1);
    }

    // Стек пуст, если вершина равна -1
    boolean Empty(Stack stack) {
        return (stack.top == -1);
    }

    // Функция для добавления элемента в стек, что увеличивает вершину на 1
    void push(Stack stack, int item) {
        if (Full(stack))
            return;
        stack.array[++stack.top] = item;
    }

    // Функция для удаления элемента из стека, что уменьшает вершину на 1
    int pop(Stack stack) {
        if (Empty(stack))
            return Integer.MIN_VALUE;
        return stack.array[stack.top--];
    }

    // Функция для реализации движения между стержнями
    void moveDiscs (Stack src, Stack dest, char s, char d) {
        int rod1 = pop(src);
        int rod2 = pop(dest);
        // Когда стержень 1 пуст
        if (rod1 == Integer.MIN_VALUE) {
            push(src, rod2);
            motionDisplay(d, s, rod2);
        }
        // Когда стержень 2 пуст
        else if (rod2 == Integer.MIN_VALUE) {
            push(dest, rod1);
            motionDisplay(s, d, rod1);
        }
        // Когда верхний диск стержня 1> верхний диск стержня 2
        else if (rod1 > rod2) {
            push(src, rod1);
            push(src, rod2);
            motionDisplay(d, s, rod2);
        }
        // Когда верхний диск стержня 1 <верхний диск стержня 2
        else {
            push(dest, rod2);
            push(dest, rod1);
            motionDisplay(s, d, rod1);
        }
    }

    // Функция для отображения движения дисков
    void motionDisplay(char fromPeg, char toPeg, int disk) {
        System.out.println("Move the disk " + disk +
                " from " + fromPeg + " to " + toPeg);
    }

    // Функция для реализации загадки
    void tohIterative(int num_of_disks, Stack
            src, Stack aux, Stack dest) {
        int i, total_num_of_moves;
        char s = '1', d = '3', a = '2';
        // Если количество дисков четное, то чередуем
        // стержень назначения и вспомогательный стержень
        if (num_of_disks % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);
        // Большие диски будут вставлены первыми
        for (i = num_of_disks; i >= 1; i--)
            push(src, i);
        for (i = 1; i <= total_num_of_moves; i++) {
            if (i % 3 == 1)
                moveDiscs(src, dest, s, d);
            else if (i % 3 == 2)
                moveDiscs(src, aux, s, a);
            else if (i % 3 == 0)
                moveDiscs(aux, dest, a, d);
        }
    }

    // Программа драйвера для проверки вышеуказанных функций
    public static void main(String[] args) {
        // Ввод: количество дисков
        int num_of_disks = 3;
        Task3 ob = new Task3();
        Stack src, dest, aux;
        // Создаем три стека размером num_of_disks
        src = ob.createStack(num_of_disks);
        dest = ob.createStack(num_of_disks);
        aux = ob.createStack(num_of_disks);
        ob.tohIterative(num_of_disks, src, aux, dest);
    }
}

