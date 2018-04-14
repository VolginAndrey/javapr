package common;

/**
 * @author zhaka
 */
public class Vec2D
{
    private double _x;
    
    private double _y;
    
    public Vec2D() { this(0,0); }
    
    public Vec2D(double x, double y)
    {
        _x = x;
        _y = y;
    }
    
    public double getX()
    {
        return _x;
    }
    
    public void setX(double value)
    {
        _x = value;
    }

    public double getY()
    {
        return _y;
    }
    
    public void setY(double value)
    {
        _y = value;
    }
    
    public boolean isInsideRect(double x1, double y1, double x2, double y2)
    {
        return _x >= x1
            && _x <= x2
            && _y >= y1
            && _y <= y2;
    }
    
    public void inc(Vec2D v)
    {
        _x += v._x;
        _y += v._y;
    }
    
    public Vec2D add(Vec2D v)
    {
        return new Vec2D(_x + v._x, _y + v._y);
    }
    
    public Vec2D sub(Vec2D v)
    {
        return new Vec2D(_x - v._x, _y - v._y);
    }
    
    public Vec2D mul(double a)
    {
        return new Vec2D(_x*a, _y*a);
    }
    
    public double len()
    {
        return Math.sqrt(_x*_x + _y*_y);
    }
    
    public Vec2D norm()
    {
        double l = len();
        return l == 0
                ? new Vec2D(0, 0)
                : new Vec2D(_x/l, _y/l);
    }
}
