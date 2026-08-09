package cat.breadcat.engine.config;


import cat.breadcat.engine.graphics.Color;


public final class RendererConfig
{
    // ===== Fields =====

    private final Color clearColor;
    private final boolean vsync;

    // ===== Constructors =====

    RendererConfig(Color clearColor, boolean vsync)
    {
        this.clearColor = clearColor;
        this.vsync = vsync;
    }

    // ===== Factories =====

    public static RendererConfigBuilder builder()
    {
        return new RendererConfigBuilder();
    }

    public static RendererConfig defaults()
    {
        return new RendererConfig(
                Color.rgb8(255, 255, 255),
                true
        );
    }

    // ===== Getters =====

    public Color clearColor()
    {
        return clearColor;
    }

    public boolean vsync()
    {
        return vsync;
    }
}