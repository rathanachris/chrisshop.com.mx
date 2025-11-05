package com.ai.controller.service;

public class SystemStatus {
    public double cpuUsage;
    public double memoryUsage;

    public SystemStatus(double cpuUsage, double memoryUsage) {
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
    }
}
