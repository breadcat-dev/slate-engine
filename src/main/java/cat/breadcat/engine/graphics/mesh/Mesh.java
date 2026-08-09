package cat.breadcat.engine.graphics.mesh;


import static org.lwjgl.opengl.GL20.*;

import cat.breadcat.engine.graphics.buffer.VertexArray;
import cat.breadcat.engine.graphics.buffer.VertexBuffer;


public final class Mesh
{
    // ===== Fields =====

    private final VertexBuffer vbo;
    private final VertexArray vao;
    private final int vertexCount;

    // ===== Constructors =====

    private Mesh(VertexBuffer vbo, VertexArray vao, int vertexCount)
    {
        this.vbo = vbo;
        this.vao = vao;
        this.vertexCount = vertexCount;
    }

    // ===== Factories =====

    public static Mesh create(float[] vertices)
    {
        if(vertices.length % 2 != 0)
            throw new IllegalArgumentException("Vertices must be in a pair of 2");

        VertexBuffer vbo = VertexBuffer.create();
        VertexArray vao = VertexArray.create();

        vbo.bind();
        vao.bind();

        vbo.upload(vertices);
        vao.attribute(
                0,
                2,
                GL_FLOAT,
                false,
                2 * Float.BYTES,
                0
        );

        vbo.unbind();
        vao.unbind();

        return new Mesh(vbo, vao, vertices.length / 2);
    }

    // ===== Binding =====

    public void bind()
    {
        vao.bind();
    }

    public void unbind()
    {
        vao.unbind();
    }

    // ===== Getters =====

    public int vertexCount()
    {
        return vertexCount;
    }

    // ===== Lifecycle =====

    public void close()
    {
        vbo.close();
        vao.close();
    }
}