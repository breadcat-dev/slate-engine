package cat.breadcat.engine.graphics.camera;


import cat.breadcat.engine.graphics.Transform;


public final class Camera
{
    // ===== Fields =====

    private final Transform transform;
    private float fieldOfView;
    private float nearPlane;
    private float farPlane;

    // ===== Constructors =====

    private Camera(Transform transform, float fieldOfView, float nearPlane, float farPlane)
    {
        this.transform = transform;
        this.fieldOfView = fieldOfView;
        this.nearPlane = nearPlane;
        this.farPlane = farPlane;
    }

    // ===== Factories ======

    public static Camera create(Transform transform, float fieldOfView, float nearPlane, float farPlane)
    {
        return new Camera(transform, fieldOfView, nearPlane, farPlane);
    }

    public static Camera create(float fieldOfView, float nearPlane, float farPlane)
    {
        return new Camera(Transform.zero(), fieldOfView, nearPlane, farPlane);
    }

    public static Camera create()
    {
        return new Camera(Transform.zero(), 90, 0.1f, 1000.0f);
    }

    // ===== Setters =====

    public void setFieldOfView(float fieldOfView)
    {
        this.fieldOfView = fieldOfView;
    }

    public void setNearPlane(float nearPlane)
    {
        this.nearPlane = nearPlane;
    }

    public void setFarPlane(float farPlane)
    {
        this.farPlane = farPlane;
    }

    // ===== Getters =====

    public Transform transform()
    {
        return this.transform;
    }

    public float getFieldOfView()
    {
        return (float)Math.toRadians(this.fieldOfView);
    }

    public float getNearPlane()
    {
        return this.nearPlane;
    }

    public float getFarPlane()
    {
        return this.farPlane;
    }
}
