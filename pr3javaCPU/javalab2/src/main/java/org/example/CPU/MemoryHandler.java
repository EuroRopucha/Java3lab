package org.example.CPU;

public class MemoryHandler extends InstructionHandler{

    @Override
    public void run(Command command, Cpu cpu) throws CpuException {
        switch (command.getCommand()) {
            case init : {
                // Пример: new Command("init 10 20"),
                //         new Command("init" ,"11", "25"),
                String addressText = command.getArg1();
                String valueText = command.getArg2();

                if (addressText == null || valueText == null)
                    throw new CpuException("Команда init требует два аргумента");

                int address = Integer.parseInt(addressText);
                int value = Integer.parseInt(valueText);

                if (address < 0 || address >= cpu.getMemory().length)
                    throw new CpuException("Неверный адрес: " + address);

                cpu.getMemory()[address] = value;
                break;
            }
            case ld : {
                // Пример: new Command("ld", "a" ,"10"),
                String reg = command.getArg1();
                String addressText = command.getArg2();

                if (reg == null || addressText == null)
                    throw new CpuException("Команда ld требует два аргумента");

                int address = Integer.parseInt(addressText);

                if (address < 0 || address >= cpu.getMemory().length)
                    throw new CpuException("Неверный адрес: " + address);

                cpu.setRegister(reg, cpu.getMemory()[address]);
                break;
            }
            case st : {
                // Пример: new Command("st", "10" ,"a"),
                String reg = command.getArg2();
                String addressText = command.getArg1();

                if (reg == null || addressText == null)
                    throw new CpuException("Команда st требует два аргумента");

                int address = Integer.parseInt(addressText);

                if (address < 0 || address >= cpu.getMemory().length)
                    throw new CpuException("Неверный адрес: " + address);

                cpu.getMemory()[address] = cpu.getRegister(reg);
                break;
            }
            default : super.run(command, cpu);
        }
    }
}
