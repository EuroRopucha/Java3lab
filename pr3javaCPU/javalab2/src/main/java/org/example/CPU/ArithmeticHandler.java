package org.example.CPU;

public class ArithmeticHandler extends InstructionHandler{

    @Override
    public void run(Command command, Cpu cpu) throws CpuException {
        switch (command.getCommand()) {
            case add: {
                int a = cpu.getRegister("a");
                int b = cpu.getRegister("b");
                cpu.setRegister("d", a + b);
                break;
            }
            case sub: {
                int a = cpu.getRegister("a");
                int b = cpu.getRegister("b");
                cpu.setRegister("d", a - b);
                break;
            }
            case mult: {
                int a = cpu.getRegister("a");
                int b = cpu.getRegister("b");
                cpu.setRegister("d", a * b);
                break;
            }
            case div: {
                int a = cpu.getRegister("a");
                int b = cpu.getRegister("b");
                if (b == 0) throw new CpuException("Деление на ноль");
                cpu.setRegister("d", a / b);
                break;
            }
            default:
                super.run(command, cpu);
        }
    }
}
