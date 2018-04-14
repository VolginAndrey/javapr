package demogame.model;

import common.Vec2D;

/**
 * @author zhaka
 */
public class Background
{
    private final Vec2D _leftTop = new Vec2D(0, RawConfig.Game.AREA_HEIGHT);
    private final Vec2D _rightBottom = new Vec2D(RawConfig.Game.AREA_WIDTH, 0);
    
    public Vec2D getLeftTop()
    {
        return _leftTop;
    }
    
    public Vec2D getRightBottom()
    {
        return _rightBottom;
    }
}
