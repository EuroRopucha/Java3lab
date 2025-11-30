package org.example.CPU;

import java.util.*;

public class Program implements Iterable<Command> {
    private final List<Command> commands = new ArrayList<>();

    public void add(Command c) {
        commands.add(c);
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    // 1. Самая популярная инструкция
    public typeCommand mostPopularInstruction() {
        Map<typeCommand, Integer> freq = new HashMap<>();
        for (Command c : commands) {
            freq.put(c.getCommand(), freq.getOrDefault(c.getCommand(), 0) + 1);
        }
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // 2. Диапазон используемых адресов памяти
    public int[] memoryRange() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Command c : commands) {
            if (c.getArg1() != null && c.getArg1().matches("\\d+")) {
                int addr = Integer.parseInt(c.getArg1());
                min = Math.min(min, addr);
                max = Math.max(max, addr);
            }
            if (c.getArg2() != null && c.getArg2().matches("\\d+")) {
                int addr = Integer.parseInt(c.getArg2());
                min = Math.min(min, addr);
                max = Math.max(max, addr);
            }
        }
        if (min == Integer.MAX_VALUE) return new int[]{};
        return new int[]{min, max};
    }

    // 3. Список инструкций по частоте
    public List<Map.Entry<typeCommand, Integer>> instructionsByFrequency() {
        Map<typeCommand, Integer> freq = new HashMap<>();
        for (Command c : commands) {
            freq.put(c.getCommand(), freq.getOrDefault(c.getCommand(), 0) + 1);
        }
        List<Map.Entry<typeCommand, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue())); // по убыванию
        return list;
    }
}

