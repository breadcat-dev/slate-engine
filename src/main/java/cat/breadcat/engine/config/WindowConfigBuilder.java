package cat.breadcat.engine.config;


public final class WindowConfigBuilder
{
    // ===== Fields =====

    private String title;
    private int width;
    private int height;
    private boolean decorated;
    private boolean resizable;

    // ===== Constructors =====

    WindowConfigBuilder()
    {
        WindowConfig defaults = WindowConfig.defaults();

        this.title = defaults.title();
        this.width = defaults.width();
        this.height = defaults.height();
        this.decorated = defaults.decorated();
        this.resizable = defaults.resizable();
    }

    // ===== Configuration =====

    public WindowConfigBuilder title(String title)
    {
        this.title = title;

        return this;
    }

    public WindowConfigBuilder size(int width, int height)
    {
        this.width = width;
        this.height = height;

        return this;
    }

    public WindowConfigBuilder decorated(boolean decorated)
    {
        this.decorated = decorated;

        return this;
    }

    public WindowConfigBuilder resizable(boolean resizable)
    {
        this.resizable = resizable;

        return this;
    }

    // ===== Building =====

    public WindowConfig build()
    {
        return new WindowConfig(title, width, height, decorated, resizable);
    }
}
