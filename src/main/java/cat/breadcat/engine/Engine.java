package cat.breadcat.engine;


import static org.lwjgl.glfw.GLFW.*;

import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.graphics.renderer.OpenGLRenderer;
import cat.breadcat.engine.graphics.renderer.Renderer;
import cat.breadcat.engine.window.Window;


public final class Engine
{
    // ===== Fields =====

    private final Window window;
    private final Renderer renderer;
    private final Timer timer;

    // ===== Constructors =====

    private Engine(ApplicationConfig config)
    {
        this.window = Window.create(config.window());
        this.renderer = OpenGLRenderer.create(config.renderer());
        this.timer = Timer.create();
    }

    // ===== Factories =====

    public static Engine create(ApplicationConfig config)
    {
        if(!glfwInit())
            throw new IllegalStateException("Failed to initialize GLFW");

        return new Engine(config);
    }

    // ===== Lifecycle =====

    public float beginFrame()
    {
        window.pollEvents();
        timer.update();

        renderer.clear();

        return (float)timer.deltaTime();
    }

    public void endFrame()
    {
        window.swapBuffers();
    }

    public void shutdown()
    {
        renderer.close();
        window.close();
        glfwTerminate();
    }

    // ===== Queries =====

    public boolean shouldClose()
    {
        return window.shouldClose();
    }

    // ===== Getters =====

    public Window window()
    {
        return window;
    }

    public Renderer renderer()
    {
        return renderer;
    }
}
