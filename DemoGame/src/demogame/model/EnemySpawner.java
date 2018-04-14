package demogame.model;

import common.Vec2D;
import common.Event;
import common.IEvent;
import java.util.Random;

/**
 * @author zhaka
 */
public class EnemySpawner
{
    private double _timeSinceLastEnemy;

    private final Event<Enemy> _enemySpawned = new Event<>();

    private final Random _random = new Random();

    public IEvent<Enemy> getEnemySpawnedEvent()
    {
        return _enemySpawned;
    }

    public void update(double dt)
    {
        _timeSinceLastEnemy += dt;

        if (_timeSinceLastEnemy > RawConfig.Game.ENEMY_PERIOD_MILLISECONDS/1000)
        {
            SpawnEnemy();
            _timeSinceLastEnemy -= RawConfig.Game.ENEMY_PERIOD_MILLISECONDS/1000;
        }
    }

    private void SpawnEnemy()
    {
        _enemySpawned.invoke(
                new Enemy(
                        new Vec2D(_random.nextDouble() * RawConfig.Game.AREA_WIDTH, RawConfig.Game.AREA_HEIGHT),
                        new Vec2D(0, -1).mul(RawConfig.Enemy.INITIAL_VELOCITY)));
    }
}
