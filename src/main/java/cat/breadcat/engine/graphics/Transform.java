package cat.breadcat.engine.graphics;


import cat.breadcat.math.matrices.Matrix4f;
import cat.breadcat.math.quaternions.Quaternionf;
import cat.breadcat.math.vectors.Vector3f;

import java.util.Objects;


public final class Transform
{
    // ===== Fields =====

    private Vector3f position;
    private Quaternionf rotation;
    private Vector3f scale;

    // ===== Constructors =====

    private Transform(Vector3f position, Quaternionf rotation, Vector3f scale)
    {
        Objects.requireNonNull(position, "translation");
        Objects.requireNonNull(rotation, "rotation");
        Objects.requireNonNull(scale, "scale");

        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    // ===== Factories =====

    public static Transform of(Vector3f position, Quaternionf rotation, Vector3f scale)
    {
        return new Transform(position, rotation, scale);
    }

    public static Transform zero()
    {
        return new Transform(
                Vector3f.zero(),
                Quaternionf.identity(),
                Vector3f.one()
        );
    }

    // ===== Setters =====

    public void setPosition(Vector3f position)
    {
        Objects.requireNonNull(position, "position");

        this.position = position;
    }

    public void setRotation(Quaternionf rotation)
    {
        Objects.requireNonNull(rotation, "rotation");

        this.rotation = rotation;
    }

    public void setScale(Vector3f scale)
    {
        Objects.requireNonNull(scale, "scale");

        this.scale = scale;
    }

    // ===== Getters =====

    public Vector3f getPosition()
    {
        return position;
    }

    public Quaternionf getRotation()
    {
        return rotation;
    }

    public Vector3f getScale()
    {
        return scale;
    }

    public Matrix4f toMatrix()
    {
        Matrix4f position = Matrix4f.translation(this.position);
        Matrix4f rotation = Matrix4f.rotation(this.rotation);
        Matrix4f scale = Matrix4f.scale(this.scale);

        return position.multiply(rotation).multiply(scale);
    }
}
