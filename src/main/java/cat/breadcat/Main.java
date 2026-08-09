package cat.breadcat;

import cat.breadcat.engine.graphics.Color;
import cat.breadcat.engine.config.ApplicationConfig;
import cat.breadcat.engine.config.RendererConfig;
import cat.breadcat.engine.config.WindowConfig;
import org.lwjgl.glfw.GLFWErrorCallback;

public class Main
{
    public static void main(String[] args)
    {
        GLFWErrorCallback.createPrint(System.err).set();

        ApplicationConfig config = ApplicationConfig.builder()
                .window(WindowConfig.builder()
                        .title("Slate Engine")
                        .size(1280, 720)
                        .resizable(false)
                        .build()
                )
                .renderer(RendererConfig.builder()
                        .clearColor(Color.rgb8(45, 45, 45))
                        .build()
                )
                .build();

        TestApplication app = new TestApplication(config);
        app.run();
    }
}