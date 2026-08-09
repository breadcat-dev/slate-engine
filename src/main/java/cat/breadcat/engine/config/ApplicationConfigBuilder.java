package cat.breadcat.engine.config;


public final class ApplicationConfigBuilder
{
    // ===== Fields =====

    private WindowConfig window;
    private RendererConfig renderer;

    // ===== Constructors =====

    ApplicationConfigBuilder()
    {
        ApplicationConfig defaults = ApplicationConfig.defaults();

        this.window = defaults.window();
        this.renderer = defaults.renderer();
    }

    // ===== Configuration =====

    public ApplicationConfigBuilder window(WindowConfig window)
    {
        this.window = window;

        return this;
    }

    public ApplicationConfigBuilder renderer(RendererConfig renderer)
    {
        this.renderer = renderer;

        return this;
    }

    // ===== Building =====

    public ApplicationConfig build()
    {
        return new ApplicationConfig(window, renderer);
    }
}
