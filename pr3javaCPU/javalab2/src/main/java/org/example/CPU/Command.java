package org.example.CPU;

public class Command {
    String name;
    typeCommand command;
    String arg1;
    String arg2;

    public Command(typeCommand command, String arg1, String arg2) {
        this.command = command;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.name = command.name() + " " + arg1 + " " + arg2;
    }
    public Command(String command, String arg1, String arg2) {
        this.command = typeCommand.valueOf(command);
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.name = typeCommand.valueOf(command).name() + " " + arg1 + " " + arg2;
    }

    public Command(String name) throws CpuException {
        this.name = name;

        String[] parts = name.split(" ");
        if (parts.length < 1 || parts.length > 3)
            throw new CpuException("Неверный формат команды: " + name);

        command = typeCommand.valueOf(parts[0]);

        if (parts.length >= 2) arg1 = parts[1];
        if (parts.length == 3) arg2 = parts[2];

        switch (command) {
            case add:
            case sub:
            case mult:
            case div:
            case print:
                if (parts.length != 1)
                    throw new CpuException("Команда " + command + " не должна иметь аргументы");
                break;
            case ld:
            case st:
            case mv:
            case init:
                if (parts.length != 3)
                    throw new CpuException("Команда " + command + " требует два аргумента");
                break;
            default:
                throw new CpuException("Неизвестная команда: " + command);
        }
    }

    public String getName() {
        return name;
    }
    public typeCommand getCommand() {
        return command;
    }
    public String getArg1() {
        return arg1;
    }
    public String getArg2() {
        return arg2;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", command=" + command +
                ", arg1='" + arg1 + '\'' +
                ", arg2='" + arg2 + '\'' +
                '}';
    }
}
