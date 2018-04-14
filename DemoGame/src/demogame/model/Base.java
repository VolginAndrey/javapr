package demogame.model;

import common.Event;
import common.IEvent;

/**
 * @author zhaka
 */
public class Base
{
    private int _hitPoints;
    
    private final Event<Base> _baseAttacked = new Event<>();
    
    private final Event<Base> _baseDestroyed = new Event<>();
    
    public Base()
    {
        initialize();
    }
    
    public IEvent<Base> getBaseAttackedEvent()
    {
        return _baseAttacked;
    }
    
    public IEvent<Base> getBaseDestroyedEvent()
    {
        return _baseDestroyed;
    }
    
    public int getHitPoints()
    {
        return _hitPoints;
    }
    
    public void attack()
    {
        _hitPoints -= 1;
        _baseAttacked.invoke(this);
        checkBase();
    }
        
    private void checkBase()
    {
        if(isDestroyed())
        {
            _baseDestroyed.invoke(this);
        }
    }
    
    public boolean isDestroyed()
    {
        return _hitPoints == 0;
    }

    public final void initialize()
    {
        _hitPoints = 3;
        _baseAttacked.invoke(this);
    }
}
