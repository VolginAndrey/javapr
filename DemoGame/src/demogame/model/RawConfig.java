package demogame.model;

/**
 * @author zhaka
 */
public class RawConfig
{
    public class CannonBarrel
    {
        public static final int LOWER_ANGLE_BOUND = 0;
        
        public static final int UPPER_ANGLE_BOUND = 180;
        
        public static final int INITIAL_ANGLE_DELTA = 5;
        
        public static final int INITIAL_ANGLE = 90;
        
        public static final int BARREL_LENGTH = 25;
    }
        
    public class Game
    {
        public static final double AREA_WIDTH = 480;
        
        public static final double AREA_HEIGHT = 640;
        
        public static final double ENEMY_PERIOD_MILLISECONDS = 1300;
        
        public static final double BASE_LINE_HEIGHT = 10;
    }
    
    public class Cannon
    {
        public static final double INITIAL_X = Game.AREA_WIDTH/2;
        
        public static final double INITIAL_Y = 0;
    }
    
    public class Bullet
    {
        public static final double LENGTH = 5;
        
        public static final double INITIAL_VELOCITY = 150;
    }
    
    public class Enemy
    {
        public static final double SIZE = 10;
        
        public static final double INITIAL_VELOCITY = 40;
    }
}
