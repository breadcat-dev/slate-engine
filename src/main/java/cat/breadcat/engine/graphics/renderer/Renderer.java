package cat.breadcat.engine.graphics.renderer;


import cat.breadcat.engine.graphics.mesh.Renderable;


public interface Renderer
{
    void render(Renderable renderable);
    void clear();
    void close();
}
