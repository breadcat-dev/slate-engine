package cat.breadcat.engine.graphics.mesh;


import cat.breadcat.engine.graphics.Transform;

import java.util.Objects;


public final class Renderable
{
    // ===== Fields =====

    private final Transform transform;
    private final Mesh mesh;

    // ===== Constructors =====

    private Renderable(Transform transform, Mesh mesh)
    {
        Objects.requireNonNull(transform, "transform");
        Objects.requireNonNull(mesh, "mesh");

        this.transform = transform;
        this.mesh = mesh;
    }

    // ===== Factories =====

    public static Renderable of(Mesh mesh)
    {
        return new Renderable(Transform.zero(), mesh);
    }

    public static Renderable of(Transform transform, Mesh mesh)
    {
        return new Renderable(transform, mesh);
    }

    // ===== Getters =====

    public Transform transform()
    {
        return transform;
    }

    public Mesh mesh()
    {
        return mesh;
    }
}
