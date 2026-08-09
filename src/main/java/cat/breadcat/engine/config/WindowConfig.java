package cat.breadcat.engine.config;


import java.util.Objects;


public final class WindowConfig
{
    // ===== Fields =====

    private final String title;
    private final int width;
    private final int height;
    private final boolean decorated;
    private final boolean resizable;

    // ===== Constructors =====

    WindowConfig(String title, int width, int height, boolean decorated, boolean resizable)
    {
        Objects.requireNonNull(title, "title");
        if(title.isBlank())
            throw new IllegalArgumentException("Title must not be blank");
        if(width <= 0)
            throw new IllegalArgumentException("Width must be positive");
        if(height <= 0)
            throw new IllegalArgumentException("Height must be positive");

        this.title = title;
        this.width = width;
        this.height = height;
        this.decorated = decorated;
        this.resizable = resizable;
    }

    // ===== Factories =====

    public static WindowConfigBuilder builder()
    {
        return new WindowConfigBuilder();
    }

    public static WindowConfig defaults()
    {
        return new WindowConfig(
                "Application",
                640,
                480,
                true,
                true
        );
    }

    // ===== Getters =====

    public String title()
    {
        return title;
    }

    public int width()
    {
        return width;
    }

    public int height()
    {
        return height;
    }

    public boolean decorated()
    {
        return decorated;
    }

    public boolean resizable()
    {
        return resizable;
    }
}