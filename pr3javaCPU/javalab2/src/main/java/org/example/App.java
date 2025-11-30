package org.example;

import org.example.CPU.*;
import java.util.*;

public class App {
    public static void main(String[] args) {

        ICpu cpu = BCpu.build();

        try {
            Program prog = new Program();
            prog.add(new Command("init 10 20"));
            prog.add(new Command("init", "11", "25"));
            prog.add(new Command("ld", "a", "10"));
            prog.add(new Command("ld", "b", "11"));
            prog.add(new Command("add"));
            prog.add(new Command("print"));

            // вывод всех команд
            System.out.println("Список команд");
            for (Command c : prog) {
                System.out.println(c);
            }

            System.out.println("Самая популярная инструкция: " + prog.mostPopularInstruction());
            System.out.println("Диапазон памяти: " + Arrays.toString(prog.memoryRange()));
            System.out.println("Инструкции по частоте:");
            System.out.println("Инструкции по частоте:");
            for (String s : prog.instructionsByFrequency()) {
                System.out.println(s);
            }

            // Исполнение программы вручную
            for (Command c : prog) {
                cpu.exec(c);
            }

        } catch (CpuException e) {
            System.out.println(e.getMessage());
        }
    }
}