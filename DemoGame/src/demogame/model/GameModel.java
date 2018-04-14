package demogame.model;

import common.Vec2D;
import common.Event;
import common.IEvent;
import common.NotifyPropertyChangedBase;

/**
 * @author zhaka
 */
public class GameModel extends NotifyPropertyChangedBase
{
    private final Event<Bullet> _bulletAdded = new Event<>();
    
    private final Event<Enemy> _enemyAdded = new Event<>();
    
    private final EnemySpawner _enemySpawner = new EnemySpawner();
    
    public final PlayerScore playerScore = new PlayerScore();
    
    public final Background background = new Background();
    
    public final Base base = new Base();
    
    private final CollisionManager _collisionManager = new CollisionManager();
    
    public final Cannon cannon;

    public GameModel()
    {
        cannon = new Cannon(new Vec2D(
                RawConfig.Cannon.INITIAL_X,
                RawConfig.Cannon.INITIAL_Y));
        
        cannon.getBulletCreatedEvent().addCallback(bullet -> addBullet(bullet));
        _enemySpawner.getEnemySpawnedEvent().addCallback(enemy -> addEnemy(enemy));
        _collisionManager.getBaseAttackedEvent().addCallback(enemy -> attackBase());
        _collisionManager.getEnemyDestroyedEvent().addCallback(enemy -> playerScore._setScore(playerScore.getScore() + 1));
    }
    
    public void initialize()
    {
        base.initialize();
        _collisionManager.initialize();
        playerScore.initialize();
    }
    
    public IEvent<Bullet> getBulletAddedEvent()
    {
        return _bulletAdded;
    }
    
    public IEvent<Bullet> getBulletRemovedEvent()
    {
        return _collisionManager.getBulletRemovedEvent();
    }
    
    public IEvent<Enemy> getEnemyAddedEvent()
    {
        return _enemyAdded;
    }
    
    public IEvent<Enemy> getEnemyRemovedEvent()
    {
        return _collisionManager.getEnemyRemovedEvent();
    }
    
    public IEvent<Enemy> getEnemyDestroyedEvent()
    {
        return _collisionManager.getEnemyDestroyedEvent();
    }
    
    public IEvent<Enemy> getBaseAttackedEvent()
    {
        return _collisionManager.getBaseAttackedEvent();
    }
    
    private void attackBase()
    {
        base.attack();
    }
    
    private void addBullet(Bullet bullet)
    {
        _collisionManager.addBullet(bullet);
        _bulletAdded.invoke(bullet);
    }
    
    private void addEnemy(Enemy enemy)
    {
        _collisionManager.addEnemy(enemy);
        _enemyAdded.invoke(enemy);
    }
    
    public void Update(double dt)
    {
        if (base.isDestroyed())
        {
            return;
        }
        
        _enemySpawner.update(dt);
        _collisionManager.update(dt);
    }
}
