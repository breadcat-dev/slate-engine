package cat.breadcat.engine;


import static org.lwjgl.glfw.GLFW.*;


public final class Timer
{
    // ===== Fields =====

    private double last;
    private double delta;

    // ===== Constructor =====

    private Timer()
    {
        this.last = 0;
        this.delta = 0;
    }

    // ===== Factories =====

    public static Timer create()
    {
        return new Timer();
    }

    // ===== Lifecycle =====

    public void update()
    {
        double current = glfwGetTime();

        delta = current - last;
        last = current;
    }

    // ===== Getters =====

    public double deltaTime()
    {
        return delta;
    }
}