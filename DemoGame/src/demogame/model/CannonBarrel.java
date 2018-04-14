package demogame.model;

import common.Vec2D;
import common.NotifyPropertyChangedBase;

/**
 * @author zhaka
 */
public class CannonBarrel extends NotifyPropertyChangedBase
{
    private final int _angleDelta;
    
    private int _angle;
        
    public int getAngle()
    {
        return _angle;
    }
    
    public Vec2D getBarrelOffset()
    {
        return new Vec2D(
                RawConfig.CannonBarrel.BARREL_LENGTH*Math.cos(Math.toRadians(_angle)),
                RawConfig.CannonBarrel.BARREL_LENGTH*Math.sin(Math.toRadians(_angle)));
    }
    
    public Vec2D getBulletVelocity(double scalarVelocity)
    {
        return new Vec2D(
                scalarVelocity*Math.cos(Math.toRadians(_angle)),
                scalarVelocity*Math.sin(Math.toRadians(_angle)));
    }
        
    private void setAngle(int value)
    {
        _angle = value;
        
        if (_angle < RawConfig.CannonBarrel.LOWER_ANGLE_BOUND)
        {
            _angle = RawConfig.CannonBarrel.LOWER_ANGLE_BOUND;
        }
        
        if (_angle > RawConfig.CannonBarrel.UPPER_ANGLE_BOUND)
        {
            _angle = RawConfig.CannonBarrel.UPPER_ANGLE_BOUND;
        }
        
        onPropertyChanged("Angle");
    }
    
    public void turnLeft()
    {
        setAngle(_angle + _angleDelta);
    }
    
    public void turnRight()
    {
        setAngle(_angle - _angleDelta);
    }
    
    public CannonBarrel()
    {
        _angle = RawConfig.CannonBarrel.INITIAL_ANGLE;
        _angleDelta = RawConfig.CannonBarrel.INITIAL_ANGLE_DELTA;
    }
}
