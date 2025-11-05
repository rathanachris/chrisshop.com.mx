package com.ai.controller;

import java.util.Random;

public class AIController {

    private final SystemMonitor monitor = new SystemMonitor();
    private final DecisionEngine engine = new DecisionEngine();
    private final ActionExecutor executor = new ActionExecutor();

    public void start() {
        System.out.println("🚀 AI Controller System started...");
        while (true) {
            // 1. ត្រួតពិនិត្យស្ថានភាព
            SystemStatus status = monitor.checkSystem();

            // 2. ប្រើ AI Logic ដើម្បីសម្រេចចិត្ត
            String action = engine.decide(status);

            // 3. ប្រតិបត្តិសកម្មភាពស្វ័យប្រវត្តិ
            executor.execute(action);

            try {
                Thread.sleep(5000); // សម្រាក 5 វិនាទី
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AIController().start();
    }
}

// ===========================
class SystemMonitor {
    public SystemStatus checkSystem() {
        Random r = new Random();
        double cpu = r.nextDouble() * 100;
        double mem = r.nextDouble() * 100;
        System.out.println("📊 CPU=" + cpu + "% | MEM=" + mem + "%");
        return new SystemStatus(cpu, mem);
    }
}

// ===========================
class DecisionEngine {
    public String decide(SystemStatus status) {
        if (status.cpuUsage > 80 || status.memoryUsage > 85) {
            return "RESTART_SERVICE";
        } else if (status.cpuUsage < 20 && status.memoryUsage < 30) {
            return "IDLE_MODE";
        } else {
            return "NORMAL";
        }
    }
}

// ===========================
class ActionExecutor {
    public void execute(String action) {
        switch (action) {
            case "RESTART_SERVICE":
                System.out.println("⚙️ Restarting service...");
                break;
            case "IDLE_MODE":
                System.out.println("💤 System idle mode...");
                break;
            default:
                System.out.println("✅ System running normally.");
        }
    }
}

// ===========================
class SystemStatus {
    double cpuUsage;
    double memoryUsage;

    public SystemStatus(double cpuUsage, double memoryUsage) {
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
    }
}
