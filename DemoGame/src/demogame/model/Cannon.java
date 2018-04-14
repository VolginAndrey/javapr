package demogame.model;

import common.Vec2D;
import common.Event;
import common.IEvent;

/**
 * @author zhaka
 */
public class Cannon extends ObjectWithLocation
{
    private final CannonBarrel _barrel = new CannonBarrel();
   
    
    private final Event<Bullet> _bulletCreated = new Event<>();
    
    public Cannon(Vec2D location)
    {
        super(location);
    }
        
    public Vec2D getBarrelEndLocation()
    {
        return getLocation().add(_barrel.getBarrelOffset());
    }

    public void turnBarrelLeft()
    {
        _barrel.turnLeft();
    }
    
    public void turnBarrelRight()
    {
        _barrel.turnRight();
    }
    
    public void Shoot()
    {
        _bulletCreated.invoke(
                new Bullet(
                getLocation().add(_barrel.getBarrelOffset()),
                _barrel.getBulletVelocity(RawConfig.Bullet.INITIAL_VELOCITY)));
    }
    
    public IEvent<Bullet> getBulletCreatedEvent()
    {
        return _bulletCreated;
    }
}
