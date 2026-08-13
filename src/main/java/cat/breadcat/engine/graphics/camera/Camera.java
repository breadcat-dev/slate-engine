package cat.breadcat.engine.graphics.camera;


import cat.breadcat.math.quaternions.Quaternionf;
import cat.breadcat.math.vectors.Vector3f;


public final class Camera
{
    // ===== Fields =====

    private Vector3f position;
    private Quaternionf rotation;
    private float fieldOfView;
    private float nearPlane;
    private float farPlane;
}
