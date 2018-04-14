package demogame.model;

import common.Event;
import common.IEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaka
 */
public class CollisionManager
{
    private final Event<Bullet> _bulletRemoved = new Event<>();
    
    private final Event<Enemy> _enemyRemoved = new Event<>();
    
    private final Event<Enemy> _enemyDestroyed = new Event<>();
    
    private final Event<Enemy> _baseAttacked = new Event<>();
        
    private final List<Bullet> _bullets = new ArrayList<>();
    
    private final List<Enemy> _enemies = new ArrayList<>();
    
    public IEvent<Bullet> getBulletRemovedEvent()
    {
        return _bulletRemoved;
    }
    
    public IEvent<Enemy> getEnemyRemovedEvent()
    {
        return _enemyRemoved;
    }
    
    public IEvent<Enemy> getEnemyDestroyedEvent()
    {
        return _enemyDestroyed;
    }
    
    public IEvent<Enemy> getBaseAttackedEvent()
    {
        return _baseAttacked;
    }
    
    public void addBullet(Bullet bullet)
    {
        _bullets.add(bullet);
    }
    
    private void removeBullet(Bullet bullet)
    {
        _bullets.remove(bullet);
        _bulletRemoved.invoke(bullet);
    }
    
    public void addEnemy(Enemy enemy)
    {
        _enemies.add(enemy);
    }
    
    private void removeEnemy(Enemy enemy)
    {
        _enemies.remove(enemy);
        _enemyRemoved.invoke(enemy);
    }
    
    private void destroyEnemy(Enemy enemy)
    {
        removeEnemy(enemy);
        _enemyDestroyed.invoke(enemy);
    }
    
    private void attackBase(Enemy enemy)
    {
        removeEnemy(enemy);
        _baseAttacked.invoke(enemy);
    }
    
    public void update(double dt)
    {
        _bullets.forEach(bullet -> bullet.Move(dt));
        _enemies.forEach(enemy -> enemy.Move(dt));
        
        List<Bullet> bulletsToRemove = new ArrayList<>();
        List<Enemy> enemiesToRemove = new ArrayList<>();
        
        _bullets.forEach(bullet ->
                {
                    for(Enemy enemy: _enemies)
                    {
                        if(isColliding(bullet, enemy))
                        {
                            enemiesToRemove.add(enemy);
                            bulletsToRemove.add(bullet);
                            break;
                        }
                    }
                });
        
        bulletsToRemove.forEach(bullet -> removeBullet(bullet));
        enemiesToRemove.forEach(enemy -> destroyEnemy(enemy));
        
        bulletsToRemove.clear();
        enemiesToRemove.clear();
        
        _enemies.forEach(
                enemy ->
                {
                    if (isEnemyOnBase(enemy))
                    {
                        enemiesToRemove.add(enemy);
                    }
                });
        
        enemiesToRemove.forEach(enemy -> attackBase(enemy));
        enemiesToRemove.clear();
        
        _bullets.forEach(
                bullet ->
                {
                    if (isOutOfBounds(bullet))
                    {
                        bulletsToRemove.add(bullet);
                    }
                });
        
        _enemies.forEach(
                enemy ->
                {
                    if (isOutOfBounds(enemy))
                    {
                        enemiesToRemove.add(enemy);
                    }
                });
        
        bulletsToRemove.forEach(bullet -> removeBullet(bullet));
        enemiesToRemove.forEach(enemy -> removeEnemy(enemy));
    }
    
    private static boolean isColliding(Bullet bullet, Enemy enemy)
    {
        return enemy.getLocation().sub(bullet.getLocation()).len() < RawConfig.Enemy.SIZE;
    }
    
    private static boolean isEnemyOnBase(Enemy enemy)
    {
        return enemy.getLocation().getY() < RawConfig.Game.BASE_LINE_HEIGHT;
    }
    
    private static boolean isOutOfBounds(MovingObject movingObject)
    {
        return !movingObject.getLocation().isInsideRect(0, 0, RawConfig.Game.AREA_WIDTH, RawConfig.Game.AREA_HEIGHT);
    }

    void initialize()
    {
        List<Bullet> bulletsToRemove = new ArrayList<>(_bullets);
        List<Enemy> enemiesToRemove = new ArrayList<>(_enemies);
        
        bulletsToRemove.forEach(bullet -> removeBullet(bullet));
        enemiesToRemove.forEach(enemy -> removeEnemy(enemy));
    }
}
