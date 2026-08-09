package cat.breadcat.engine.graphics.buffer;


import static org.lwjgl.opengl.GL30.*;


public final class VertexArray
{
    // ===== Fields =====

    private final int handle;

    // ===== Constructors =====

    private VertexArray(int handle)
    {
        this.handle = handle;
    }

    // ===== Factories =====

    public static VertexArray create()
    {
        return new VertexArray(glGenVertexArrays());
    }

    // ===== Attributes =====

    public void attribute(
            int index, int size, int type,
            boolean normalized, int stride,
            long offset
    )
    {
        glVertexAttribPointer(
                index,
                size,
                type,
                normalized,
                stride,
                offset
        );
        glEnableVertexAttribArray(index);
    }

    // ===== Binding =====

    public void bind()
    {
        glBindVertexArray(handle);
    }

    public void unbind()
    {
        glBindVertexArray(0);
    }

    // ===== Lifecycle =====

    public void close()
    {
        glDeleteVertexArrays(handle);
    }
}
