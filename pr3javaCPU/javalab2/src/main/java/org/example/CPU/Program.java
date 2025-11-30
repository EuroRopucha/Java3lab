package org.example.CPU;

import java.util.*;

public class Program implements Iterable<Command> {
    ArrayList<Command> commands = new ArrayList<>();

    public void add(Command c) {
        commands.add(c);
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    // самая популярная инструкция
    public typeCommand mostPopularInstruction() {
        HashMap<typeCommand, Integer> freq = new HashMap<>();

        for (Command c : commands) {
            freq.put(c.getCommand(), freq.getOrDefault(c.getCommand(), 0) + 1);
        }
        typeCommand mostPopular = null;
        int maxCount = 0;

        // freq.keySet() возвращает множество всех ключей
        for (typeCommand command : freq.keySet()) {
            int count = freq.get(command);
            if (count > maxCount) {
                maxCount = count;
                mostPopular = command;
            }
        }
        return mostPopular;
    }

    // диапазон адресов памяти
    public int[] memoryRange() {
        int min = -1;
        int max = -1;
        for (Command c : commands) {
            if (c.getCommand() == typeCommand.init) {
                String arg1 = c.getArg1();
                int addr = Integer.parseInt(arg1);

                if (min == -1 || addr <= min) min = addr;
                if (max == -1 || addr >= max) max = addr;
            }
        }
        // если не нашли ни одного адреса возвращаем пустой массив
        if (min == -1) return new int[]{};
        return new int[]{min, max};
    }

    // список инструкций по частоте
    public List<String> instructionsByFrequency() {
        HashMap<typeCommand, Integer> freq = new HashMap<>();

        for (Command c : commands) {
            freq.put(c.getCommand(), freq.getOrDefault(c.getCommand(), 0) + 1);
        }

        ArrayList<String> result = new ArrayList<>();

        while (!freq.isEmpty()) {
            typeCommand mostPopular = null;
            int maxCount = 0;

            for (typeCommand command : freq.keySet()) {
                int count = freq.get(command);
                if (count > maxCount) {
                    maxCount = count;
                    mostPopular = command;
                }
            }
            result.add(mostPopular + " = " + maxCount);
            freq.remove(mostPopular);
        }
        return result;
    }
}

