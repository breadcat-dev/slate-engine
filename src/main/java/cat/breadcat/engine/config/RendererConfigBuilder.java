package cat.breadcat.engine.config;


import cat.breadcat.engine.Color;


public final class RendererConfigBuilder
{
    // ===== Fields =====

    private Color clearColor;
    private boolean vsync;

    // ===== Constructors =====

    RendererConfigBuilder()
    {
        RendererConfig defaults = RendererConfig.defaults();

        this.clearColor = defaults.clearColor();
        this.vsync = defaults.vsync();
    }

    // ===== Configuration =====

    public RendererConfigBuilder clearColor(Color clearColor)
    {
        this.clearColor = clearColor;

        return this;
    }

    public RendererConfigBuilder vsync(boolean vsync)
    {
        this.vsync = vsync;

        return this;
    }

    // ===== Building =====

    public RendererConfig build()
    {
        return new RendererConfig(
                clearColor,
                vsync
        );
    }
}
