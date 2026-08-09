package cat.breadcat;


import cat.breadcat.engine.Application;
import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.graphics.mesh.Mesh;
import cat.breadcat.engine.graphics.renderer.Renderer;


public final class TestApplication extends Application
{
    // ===== Fields =====

    private Mesh square1;
    private Mesh square2;

    // ===== Constructors =====

    public TestApplication(ApplicationConfig config)
    {
        super(config);
    }

    // ===== Overrides =====

    @Override
    protected void init()
    {
        square1 = Mesh.create(new float[]{
                -0.5f,  0.5f,
                -0.5f, -0.5f,
                 0.5f, -0.5f
        });
        square2 = Mesh.create(new float[]{
                -0.5f,  0.5f,
                 0.5f,  0.5f,
                 0.5f, -0.5f
        });
    }

    @Override
    protected void update(float dt)
    {

    }

    @Override
    protected void render(Renderer renderer)
    {
        renderer.render(square1);
        renderer.render(square2);
    }

    @Override
    protected void shutdown()
    {

    }
}
