package demogame.model;

import common.Vec2D;

/**
 * @author zhaka
 */
public class MovingObject extends ObjectWithLocation
{
    private final Vec2D _velocity;

    public Vec2D getVelocity()
    {
        return _velocity;
    }

    public MovingObject(Vec2D location, Vec2D velocity)
    {
        super(location);
        _velocity = velocity;
    }
    
    public void Move(double dt)
    {
        getLocation().inc(_velocity.mul(dt));
    }
}
