package cat.breadcat;


import cat.breadcat.engine.Application;
import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.graphics.mesh.Mesh;
import cat.breadcat.engine.graphics.mesh.Renderable;
import cat.breadcat.engine.graphics.renderer.Renderer;
import cat.breadcat.math.quaternions.Quaternionf;
import cat.breadcat.math.vectors.Vector3f;


public final class TestApplication extends Application
{
    // ===== Fields =====

    private Mesh squareMesh;
    private Renderable square1;
    private Renderable square2;

    private int i;
    private int j;
    private boolean jReverse = false;

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
                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,

                -0.5f, 0.5f, 0.5f,
                0.5f, 0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,


                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,

                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,


                -0.5f, 0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, 0.5f,

                -0.5f, 0.5f, -0.5f,
                -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f,


                0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, 0.5f,

                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, 0.5f,
                0.5f, -0.5f, 0.5f,


                -0.5f, 0.5f, 0.5f,
                -0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,

                -0.5f, 0.5f, 0.5f,
                0.5f, 0.5f, -0.5f,
                0.5f, 0.5f, -0.5f,


                -0.5f, -0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,

                -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, -0.5f,
                0.5f, -0.5f, -0.5f,
        });

        square1 = Renderable.of(squareMesh);
        square2 = Renderable.of(squareMesh);

        i = 0;
        j = 0;
    }

    @Override
    protected void update(float dt)
    {
        if(i == 360)
            i = 0;
        i++;
        if(j == 500 || j == -500)
            jReverse = !jReverse;
        if(jReverse)
            j--;
        else
            j++;

        square1.transform().setRotation(Quaternionf.fromAxisAngle(Vector3f.unitX(), (float)Math.toRadians(i)));
        square1.transform().setRotation(Quaternionf.fromAxisAngle(Vector3f.unitY(), (float)Math.toRadians(i)));
        square2.transform().setRotation(Quaternionf.fromAxisAngle(Vector3f.unitX(), (float)Math.toRadians(i)));
        square2.transform().setRotation(Quaternionf.fromAxisAngle(Vector3f.unitY(), (float)Math.toRadians(i)));
        //square.transform().setRotation(Quaternionf.fromAxisAngle(Vector3f.unitY(), (float)Math.toRadians(100)));
        square2.transform().setPosition(Vector3f.of(-2, j / -100.0f, -2));
        square1.transform().setPosition(Vector3f.of(5, j / 100.0f, -5));
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
        squareMesh.close();
    }
}
