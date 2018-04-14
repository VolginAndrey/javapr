package demogame.view;

import common.Vec2D;
import demogame.viewmodel.BackgroundViewModel;
import demogame.viewmodel.BaseViewModel;
import demogame.viewmodel.BulletViewModel;
import demogame.viewmodel.CannonViewModel;
import demogame.viewmodel.EnemyViewModel;
import demogame.viewmodel.GameViewModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * @author zhaka
 */
public class GameDrawer
{
    Image bgImage;
    
    public GameDrawer()
    {
        BufferedImage img = null;
        
        try
        {
            img = ImageIO.read(getClass().getResourceAsStream("yoba.png"));
        }
        catch (Exception e)
        {
        }
        
        bgImage = img;
    }
    
    public void drawGame(GameViewModel game, Graphics g)
    {
        drawBackground(game.backgroundViewModel, g);
        
        drawBase(game.baseViewModel, g);
        drawCannon(game.cannonViewModel, g);
        
        game.bullets.forEach(bullet -> drawBullet(bullet, g));
        game.enemies.forEach(enemy -> drawEnemy(enemy, g));
    }
    
    private void drawBackground(BackgroundViewModel background, Graphics g)
    {
        //g.setColor(Color.black);
        
        Vec2D leftTopPoint = background.getDisplayLeftTop();
        Vec2D displaySize = background.getDisplayRightBottom().sub(leftTopPoint);
        
        g.drawImage(bgImage,
                (int) leftTopPoint.getX(),
                (int) leftTopPoint.getY()+1,
                (int) displaySize.getX()-1,
                (int) displaySize.getY()-1,
                (Image image, int i, int i1, int i2, int i3, int i4) -> true);
    }
    
    private void drawBase(BaseViewModel base, Graphics g)
    {
        g.setColor(base.getIsDestroyed() ? Color.red : Color.white);
        Vec2D leftTopPoint = base.getBaseDisplayLeftTop();
        Vec2D displaySize = base.getBaseDisplayRightBottom().sub(leftTopPoint);
        
        g.fillRect(
                (int) leftTopPoint.getX(),
                (int) leftTopPoint.getY(),
                (int) displaySize.getX(),
                (int) displaySize.getY());
    }
    
    private void drawBullet(BulletViewModel bullet, Graphics g)
    {
        Vec2D bulletLocation = bullet.getDisplayLocation();
        Vec2D bulletDirection = bullet.getDisplayDirection();
        Vec2D bulletPoint1 = bulletLocation.add(bulletDirection.mul(-0.5));
        Vec2D bulletPoint2 = bulletLocation.add(bulletDirection.mul(0.5));
        
        g.setColor(Color.green);
        drawBoldLine(bulletPoint1, bulletPoint2, g);
    }
    
    private void drawEnemy(EnemyViewModel enemy, Graphics g)
    {
        Vec2D enemyLocation = enemy.getDisplayLocation();
        double enemySize = enemy.getDisplaySize();
        
        g.setColor(Color.red);
        g.drawOval(
                (int) enemyLocation.getX(),
                (int) enemyLocation.getY(),
                (int) enemySize,
                (int) enemySize);
    }
    
    private void drawCannon(CannonViewModel cannon, Graphics g)
    {
        Vec2D cannonLocation = cannon.getDisplayLocation();
        Vec2D barrelEndLocation = cannon.getBarrelEndDisplayLocation();
        
        g.setColor(Color.red);
        drawBoldLine(cannonLocation, barrelEndLocation, g);
    }
    
    private void drawBoldLine(Vec2D p1, Vec2D p2, Graphics g)
    {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();
        
        g.drawLine(x1, y1, x2, y2);
        
        g.drawLine(x1 - 1, y1, x2 - 1, y2);
        g.drawLine(x1, y1 - 1, x2, y2 - 1);
        
        g.drawLine(x1 + 1, y1, x2 + 1, y2);
        g.drawLine(x1, y1 + 1, x2, y2 + 1);                
    }
}
