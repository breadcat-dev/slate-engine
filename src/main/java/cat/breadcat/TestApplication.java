package cat.breadcat;


import cat.breadcat.engine.Application;
import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.graphics.mesh.Mesh;
import cat.breadcat.engine.graphics.mesh.Renderable;
import cat.breadcat.engine.graphics.renderer.Renderer;
import cat.breadcat.math.vectors.Vector3f;


public final class TestApplication extends Application
{
    // ===== Fields =====

    private Mesh squareMesh;
    private Renderable square;

    private int i;

    // ===== Constructors =====

    public TestApplication(ApplicationConfig config)
    {
        super(config);
    }

    // ===== Overrides =====

    @Override
    protected void init()
    {
        squareMesh = Mesh.create(new float[]{
                -0.5f, 0.5f, 0,
                -0.5f, -0.5f, 0,
                0.5f, -0.5f, 0,

                -0.5f, 0.5f, 0,
                0.5f, 0.5f, 0,
                0.5f, -0.5f, 0
        });

        square = Renderable.of(squareMesh);

        i = 0;
    }

    @Override
    protected void update(float dt)
    {
        if(i == 360)
            i = 0;

        //square.transform().setRotation(Quaternionf.fromAxisAngle(Vector3f.unitY(), (float)Math.toRadians(i++)));
        square.transform().setPosition(Vector3f.of(2, 0, 500));
    }

    @Override
    protected void render(Renderer renderer)
    {
        renderer.render(square);
    }

    @Override
    protected void shutdown()
    {
        squareMesh.close();
    }
}
