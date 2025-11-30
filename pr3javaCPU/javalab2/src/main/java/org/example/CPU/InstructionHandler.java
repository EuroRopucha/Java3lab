package org.example.CPU;

public class InstructionHandler {
    InstructionHandler next;

    void run(Command command, Cpu cpu) throws CpuException {
        if(next != null){
            next.run(command, cpu);
        }
        else{
            throw new CpuException("Неизвестная команда: " + command.getCommand());
        }
    }
    InstructionHandler add(InstructionHandler next){
        this.next = next;
        return next;
    }
}


