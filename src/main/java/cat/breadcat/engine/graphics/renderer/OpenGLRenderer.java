package cat.breadcat.engine.graphics.renderer;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL20.*;

import cat.breadcat.engine.graphics.Color;
import cat.breadcat.engine.config.RendererConfig;
import cat.breadcat.engine.graphics.Transform;
import cat.breadcat.engine.graphics.mesh.Mesh;
import cat.breadcat.engine.graphics.mesh.Renderable;
import cat.breadcat.engine.graphics.shader.ShaderProgram;
import cat.breadcat.math.matrices.Matrix4f;

import java.util.Objects;


public final class OpenGLRenderer implements Renderer
{
    // ===== Constants =====

    private static final String BASIC_VERTEX_SHADER =
                """
                #version 330 core

                layout(location = 0) in vec2 pos;

                uniform mat4 uModel;

                void main()
                {
                    gl_Position = uModel * vec4(pos, 0.0, 1.0);
                }
                """;
    private static final String BASIC_FRAGMENT_SHADER =
                """
                #version 330 core

                uniform vec4 uColor;

                out vec4 fragColor;

                void main()
                {
                    fragColor = uColor;
                }
                """;

    // ===== Fields =====

    private final RendererConfig config;
    private final ShaderProgram basicShader;

    // ===== Constructors =====

    private OpenGLRenderer(RendererConfig config)
    {
        this.config = config;
        this.basicShader = ShaderProgram.create(
                BASIC_VERTEX_SHADER,
                BASIC_FRAGMENT_SHADER
        );
    }

    // ===== Factories =====

    public static OpenGLRenderer create(RendererConfig config)
    {
        Objects.requireNonNull(config, "config");

        if(config.vsync())
            glfwSwapInterval(1);
        Color clearColor = config.clearColor();
        glClearColor(clearColor.red(), clearColor.green(), clearColor.blue(), clearColor.alpha());

        return new OpenGLRenderer(config);
    }

    // ===== Rendering =====

    @Override
    public void render(Renderable renderable)
    {
        Objects.requireNonNull(renderable, "renderable");

        Transform transform = renderable.transform();
        Mesh mesh = renderable.mesh();

        basicShader.bind();
        basicShader.set("uModel", transform.toMatrix());
        basicShader.set("uColor", Color.rgb8(255, 200, 45).vec4());
        mesh.bind();

        glDrawArrays(GL_TRIANGLES, 0, mesh.vertexCount());

        mesh.unbind();
        basicShader.unbind();
    }

    @Override
    public void clear()
    {
        glClear(GL_COLOR_BUFFER_BIT);
    }

    // ===== Lifecycle =====

    @Override
    public void close()
    {
        basicShader.close();
    }
}
