package org.example.CPU;

public class UtilityHandler extends InstructionHandler {

    @Override
    public void run(Command command, Cpu cpu) throws CpuException {
        switch (command.getCommand()) {
            case print: {
                System.out.println("Регистр [a] = " + cpu.getRegister("a"));
                System.out.println("Регистр [b] = " + cpu.getRegister("b"));
                System.out.println("Регистр [c] = " + cpu.getRegister("c"));
                System.out.println("Регистр [d] = " + cpu.getRegister("d"));
                break;
            }
            case mv: {
                // Пример: new Command("mv", "a", "b") a=b
                String a = command.getArg1();
                String b = command.getArg2();

                if (a == null || b == null)
                    throw new CpuException("Команда mv требует два регистра");

                int value = cpu.getRegister(b);
                cpu.setRegister(a, value);
                break;
            }
            default:
                super.run(command, cpu);
        }
    }
}
