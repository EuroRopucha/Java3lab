package org.example.CPU;

public interface ICpu {
    void exec(Command command) throws CpuException;
}
