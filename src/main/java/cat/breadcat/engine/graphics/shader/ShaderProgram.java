package cat.breadcat.engine.graphics.shader;


import cat.breadcat.math.matrices.Matrix4f;
import cat.breadcat.math.vectors.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.lwjgl.opengl.GL20.*;


public final class ShaderProgram
{
    // ===== Fields =====

    private final Map<String, Integer> uniformCache = new HashMap<>();
    private final int programId;

    // ===== Constructors =====

    private ShaderProgram(int programId)
    {
        this.programId = programId;
    }

    // ===== Factories =====

    public static ShaderProgram create(String vertexSource, String fragmentSource)
    {
        Objects.requireNonNull(vertexSource, "vertexSource");
        Objects.requireNonNull(fragmentSource, "fragmentSource");

        int vertex = compile(GL_VERTEX_SHADER, vertexSource);
        int fragment = compile(GL_FRAGMENT_SHADER, fragmentSource);
        int programId = glCreateProgram();
        link(programId, vertex, fragment);
        glDeleteShader(vertex);
        glDeleteShader(fragment);

        return new ShaderProgram(programId);
    }

    // ===== Uniforms =====

    public void set(String name, int value)
    {
        glUniform1i(findUniform(name), value);
    }

    public void set(String name, float value)
    {
        glUniform1f(findUniform(name), value);
    }

    public void set(String name, Vector4f value)
    {
        Objects.requireNonNull(value, "value");

        glUniform4f(
                findUniform(name),
                value.x(),
                value.y(),
                value.z(),
                value.w()
        );
    }

    public void set(String name, Matrix4f value)
    {
        Objects.requireNonNull(value, "value");

        glUniformMatrix4fv(
                findUniform(name),
                true,
                new float[]{
                        value.m00(), value.m01(), value.m02(), value.m03(),
                        value.m10(), value.m11(), value.m12(), value.m13(),
                        value.m20(), value.m21(), value.m22(), value.m23(),
                        value.m30(), value.m31(), value.m32(), value.m33()
                }
        );
    }


    private int findUniform(String name)
    {
        Objects.requireNonNull(name, "name");

        return uniformCache.computeIfAbsent(
                name,
                uncached ->
                {
                    int location = glGetUniformLocation(programId, uncached);

                    if(location == -1)
                        throw new IllegalArgumentException("Unknown uniform: " + uncached);

                    return location;
                }
        );
    }

    // ===== Compiling =====

    private static void link(int programId, int vertex, int fragment)
    {
        glAttachShader(programId, vertex);
        glAttachShader(programId, fragment);
        glLinkProgram(programId);

        if(glGetProgrami(programId, GL_LINK_STATUS) == GL_FALSE)
        {
            String log = glGetProgramInfoLog(programId);

            glDeleteProgram(programId);
            glDeleteShader(vertex);
            glDeleteShader(fragment);

            throw new IllegalStateException("Failed to link shaders: " + log);
        }
    }

    private static int compile(int type, String source)
    {
        int shader = glCreateShader(type);
        glShaderSource(shader, source);
        glCompileShader(shader);

        if(glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE)
        {
            String log = glGetShaderInfoLog(shader);

            glDeleteShader(shader);

            throw new IllegalStateException("Failed to compile shader: " + log);
        }

        return shader;
    }

    // ===== Binding =====

    public void bind()
    {
        glUseProgram(programId);
    }

    public void unbind()
    {
        glUseProgram(0);
    }

    // ===== Lifecycle =====

    public void close()
    {
        glDeleteProgram(programId);
    }
}

