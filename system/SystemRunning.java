package system;

public class SystemRunning {
    private static boolean isRunning;

    public SystemRunning() {
        isRunning = true;
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void setRunning(boolean isRunning) {
        SystemRunning.isRunning = isRunning;
    }
}
