package cat.breadcat.engine;


import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.graphics.renderer.Renderer;


public class Application
{
    // ===== Fields =====

    private static Application instance;
    private final Engine engine;

    // ===== Constructors =====

    public Application(ApplicationConfig config)
    {
        if(instance != null)
            throw new IllegalStateException("An Application already exists");
        instance = this;

        this.engine = Engine.create(config);
    }

    // ===== Lifecycle =====

    public final void run()
    {
        try
        {
            init();

            while(!engine.shouldClose())
            {
                float dt = engine.beginFrame();

                update(dt);
                render(engine.renderer());

                engine.endFrame();
            }
        }
        finally
        {
            try
            {
                shutdown();
            }
            finally
            {
                engine.shutdown();
            }
        }
    }

    // ===== Abstract =====

    protected void init()
    {
    }

    protected void update(float dt)
    {
    }

    protected void render(Renderer renderer)
    {
    }

    protected void shutdown()
    {
    }
}
