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

            // Вывод всех команд
            System.out.println("=== Список команд ===");
            for (Command c : prog) {
                System.out.println(c);
            }

            // Анализ программы
            System.out.println("Самая популярная инструкция: " + prog.mostPopularInstruction());
            System.out.println("Диапазон памяти: " + Arrays.toString(prog.memoryRange()));
            System.out.println("Инструкции по частоте:");
            for (Map.Entry<typeCommand, Integer> entry : prog.instructionsByFrequency()) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
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


/*
package org.example;

import org.example.CPU.*;

public class App
{
    public static void main( String[] args )
    {
        ICpu cpu = BCpu.build();

        try {
            cpu.exec(new Command("init 10 20"));
            cpu.exec(new Command("init" ,"11", "25"));
            cpu.exec(new Command("ld", "a" ,"10"));
            cpu.exec(new Command("ld", "b" ,"11"));
            cpu.exec(new Command("add"));
            cpu.exec(new Command("print"));

        } catch (CpuException e) {
            System.out.println(e.getMessage());
        }
    }
}


 */