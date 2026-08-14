package cat.breadcat.engine.graphics.renderer;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL20.*;

import cat.breadcat.engine.graphics.Color;
import cat.breadcat.engine.config.RendererConfig;
import cat.breadcat.engine.graphics.Transform;
import cat.breadcat.engine.graphics.camera.Camera;
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

                layout(location = 0) in vec3 pos;

                uniform mat4 uModel;
                uniform mat4 uView;
                uniform mat4 uPerspective;

                void main()
                {
                    gl_Position = uPerspective * uView * uModel * vec4(pos, 1.0);
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

    private static final Camera TEST_CAMERA = Camera.create();

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

        glEnable(GL_DEPTH_TEST);
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
        basicShader.set("uPerspective", Matrix4f.perspective(
                TEST_CAMERA.getFieldOfView(),
                1280.0f / 720.0f,
                TEST_CAMERA.getNearPlane(),
                TEST_CAMERA.getFarPlane()
        ));
        basicShader.set("uView", TEST_CAMERA.transform().toMatrix().inverse());
        basicShader.set("uModel", transform.toMatrix());
        basicShader.set("uColor", Color.rgb8(200, 0, 255).vec4());
        mesh.bind();

        glDrawArrays(GL_TRIANGLES, 0, mesh.vertexCount());

        mesh.unbind();
        basicShader.unbind();
    }

    @Override
    public void clear()
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    // ===== Lifecycle =====

    @Override
    public void close()
    {
        basicShader.close();
    }
}
