package cat.breadcat;


import cat.breadcat.engine.Application;
import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.graphics.mesh.Mesh;
import cat.breadcat.engine.graphics.renderer.Renderer;


public final class TestApplication extends Application
{
    // ===== Fields =====

    private Mesh cross1;
    private Mesh cross2;
    private Mesh cross3;
    private Mesh cross4;

    // ===== Constructors =====

    public TestApplication(ApplicationConfig config)
    {
        super(config);
    }

    // ===== Overrides =====

    @Override
    protected void init()
    {
        cross1 = Mesh.create(new float[]{
                -0.1f,  0.9f,
                -0.1f, -0.9f,
                 0.1f, -0.9f
        });
        cross2 = Mesh.create(new float[]{
                -0.1f,  0.9f,
                 0.1f,  0.9f,
                 0.1f, -0.9f
        });
        cross3 = Mesh.create(new float[]{
                -0.3f,  0.5f,
                -0.3f,  0.2f,
                 0.3f,  0.2f
        });
        cross4 = Mesh.create(new float[]{
                -0.3f,  0.5f,
                 0.3f,  0.5f,
                 0.3f,  0.2f
        });
    }

    @Override
    protected void update(float dt)
    {

    }

    @Override
    protected void render(Renderer renderer)
    {
        renderer.render(cross1);
        renderer.render(cross2);
        renderer.render(cross3);
        renderer.render(cross4);
    }

    @Override
    protected void shutdown()
    {
        cross1.close();
        cross2.close();
        cross3.close();
        cross4.close();
    }
}
