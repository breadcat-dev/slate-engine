package cat.breadcat.engine.config;


import cat.breadcat.engine.Application;

import java.util.Objects;


public final class ApplicationConfig
{
    // ===== Fields =====

    private final WindowConfig window;
    private final RendererConfig renderer;

    // ===== Constructors =====

    ApplicationConfig(WindowConfig window, RendererConfig renderer)
    {
        Objects.requireNonNull(window, "window");
        Objects.requireNonNull(renderer, "renderer");

        this.window = window;
        this.renderer = renderer;
    }

    // ===== Factories =====

    public static ApplicationConfigBuilder builder()
    {
        return new ApplicationConfigBuilder();
    }

    public static ApplicationConfig defaults()
    {
        return new ApplicationConfig(WindowConfig.defaults(), RendererConfig.defaults());
    }

    // ===== Getters =====

    public WindowConfig window()
    {
        return window;
    }

    public RendererConfig renderer()
    {
        return renderer;
    }
}