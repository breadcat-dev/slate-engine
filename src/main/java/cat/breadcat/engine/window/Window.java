package cat.breadcat.engine.window;


import cat.breadcat.engine.config.WindowConfig;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

import java.util.Objects;


public final class Window
{
    // ===== Fields =====

    private final WindowConfig config;
    private final long handle;

    // ===== Constructors =====

    private Window(WindowConfig config, long handle)
    {
        this.config = config;
        this.handle = handle;
    }

    // ===== Factories =====

    public static Window create(WindowConfig config)
    {
        Objects.requireNonNull(config, "config");

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_DECORATED, toGLFWBoolean(config.decorated()));
        glfwWindowHint(GLFW_RESIZABLE, toGLFWBoolean(config.resizable()));

        long handle = glfwCreateWindow(
                config.width(),
                config.height(),
                config.title(),
                0,
                0
        );
        if(handle == 0)
        {
            glfwTerminate();
            throw new IllegalStateException("Failed to create window");
        }

        glfwMakeContextCurrent(handle);
        GL.createCapabilities();

        return new Window(config, handle);
    }

    // ===== Lifecycle =====

    public void pollEvents()
    {
        glfwPollEvents();
    }

    public void swapBuffers()
    {
        glfwSwapBuffers(handle);
    }

    public void close()
    {
        glfwDestroyWindow(handle);
    }

    // ===== Queries =====

    public boolean shouldClose()
    {
        return glfwWindowShouldClose(handle);
    }

    // ===== Getters =====

    public int width()
    {
        return config.width();
    }

    public int height()
    {
        return config.height();
    }

    // ===== Helper =====

    private static int toGLFWBoolean(boolean bool)
    {
        return bool ? GLFW_TRUE : GLFW_FALSE;
    }
}
