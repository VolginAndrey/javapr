package demogame.model;

import common.Vec2D;

/**
 * @author zhaka
 */
public class ObjectWithLocation
{
    private final Vec2D _location;
    
    public ObjectWithLocation(Vec2D location)
    {
        _location = location;
    }
    
    public Vec2D getLocation()
    {
        return _location;
    }
}
