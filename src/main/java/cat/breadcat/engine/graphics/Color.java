package cat.breadcat.engine.graphics;


import cat.breadcat.math.vectors.Vector3f;
import cat.breadcat.math.vectors.Vector4f;


public final class Color
{
    // ===== Fields =====

    private final float red;
    private final float green;
    private final float blue;
    private final float alpha;

    // ===== Constructors =====

    private Color(float red, float green, float blue, float alpha)
    {
        if(
                red < 0.0f || red > 1.0f ||
                green < 0.0f || green > 1.0f ||
                blue < 0.0f || blue > 1.0f ||
                alpha < 0.0f || alpha > 1.0f
        )
            throw new IllegalArgumentException("RGBA channels must be from 0 to 1");

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    // ===== Factories =====

    public static Color rgb(float red, float green, float blue)
    {
        return new Color(red, green, blue, 1.0f);
    }

    public static Color rgba(float red, float green, float blue, float alpha)
    {
        return new Color(red, green, blue, alpha);
    }

    public static Color rgb8(int red, int green, int blue)
    {
        return new Color(
                red / 255.0f,
                green / 255.0f,
                blue / 255.0f,
                1.0f
        );
    }

    public static Color rgba8(int red, int green, int blue, int alpha)
    {
        return new Color(
                red / 255.0f,
                green / 255.0f,
                blue / 255.0f,
                alpha / 255.0f
        );
    }

    // ===== Getters =====

    public Vector4f vec4()
    {
        return Vector4f.of(red, green, blue, alpha);
    }

    public Vector3f vec3()
    {
        return Vector3f.of(red, green, blue);
    }

    public float red()
    {
        return red;
    }

    public float green()
    {
        return green;
    }

    public float blue()
    {
        return blue;
    }

    public float alpha()
    {
        return alpha;
    }
}
