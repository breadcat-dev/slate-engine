package cat.breadcat.engine.graphics.buffer;


import static org.lwjgl.opengl.GL15C.*;

import java.util.Objects;


public final class VertexBuffer
{
    // ===== Fields =====

    private final int handle;

    // ===== Constructors =====

    private VertexBuffer(int handle)
    {
        this.handle = handle;
    }

    // ===== Factories =====

    public static VertexBuffer create()
    {
        return new VertexBuffer(glGenBuffers());
    }

    // ===== Buffer =====

    public void upload(float[] vertices)
    {
        Objects.requireNonNull(vertices, "vertices");
        if(vertices.length == 0)
            throw new IllegalArgumentException("Vertex data must not be empty");

        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);
    }

    // ===== Binding =====

    public void bind()
    {
        glBindBuffer(GL_ARRAY_BUFFER, handle);
    }

    public void unbind()
    {
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }

    // ===== Life Cycle =====

    public void close()
    {
        glDeleteBuffers(handle);
    }
}
