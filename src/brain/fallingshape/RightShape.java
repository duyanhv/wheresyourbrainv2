package brain.fallingshape;

import bases.GameObject;
import bases.ImageRenderer;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

/**
 * Created by duyanh on 11/1/17.
 */
public class RightShape extends GameObject implements PhysicsBody {
    public BoxCollider boxCollider;

    public RightShape(){

    }

    public void run(){

    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void setIsActive(boolean isActive) {

    }
}
