package cat.breadcat.engine.graphics.renderer;


import cat.breadcat.engine.graphics.mesh.Mesh;


public interface Renderer
{
    void render(Mesh mesh);
    void clear();
    void close();
}
