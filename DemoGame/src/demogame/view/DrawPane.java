package demogame.view;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author zhaka
 */
public class DrawPane extends JPanel
{
    private IDrawGraphicsHandler _drawGraphics;

    public void setDrawGraphics(IDrawGraphicsHandler drawGraphics)
    {
        _drawGraphics = drawGraphics;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        if (_drawGraphics != null)
        {
            _drawGraphics.drawGraphics(g, getWidth(), getHeight());
        }
    }

    @FunctionalInterface
    public interface IDrawGraphicsHandler
    {
        void drawGraphics(Graphics g, int width, int height);
    }
}
