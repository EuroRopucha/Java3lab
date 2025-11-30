package org.example.CPU;

class Cpu implements ICpu {

    int[] memory = new int[1024];
    int a =0;
    int b=0;
    int c=0;
    int d=0;

    InstructionHandler handler = new InstructionHandler();

    public InstructionHandler getHandler() {
        return handler;
    }

    public int getRegister(String name) throws CpuException {
        switch (name) {
            case "a" : return a;
            case "b" : return b;
            case "c" : return c;
            case "d" : return d;
            default :  throw new CpuException("Нет регистра: " + name);
        }
    }
    public void setRegister(String name, int value) throws CpuException {
        switch (name) {
            case "a" : a = value; break;
            case "b" : b = value; break;
            case "c" : c = value; break;
            case "d" : d = value; break;
            default : throw new CpuException("Нет регистра: " + name);
        }
    }
    public int[] getMemory() {
        return memory;
    }

    @Override
    public void exec(Command command) throws CpuException {
        handler.run(command, this);
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
