package demogame.model;

import common.Event;
import common.IEvent;

/**
 * @author zhaka
 */
public class PlayerScore
{
    private int _score;
    
    private final Event<PlayerScore> _updated = new Event<>();
    
    public IEvent<PlayerScore> getUpdatedEvent()
    {
        return _updated;
    }
    
    public int getScore()
    {
        return _score;
    }
    
    public void _setScore(int value)
    {
        _score = value;
        _updated.invoke(this);
    }
    
    public void initialize()
    {
        _setScore(0);
    }
}
