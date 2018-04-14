package demogame.view;

import common.ICommand;
import javax.swing.JButton;

/**
 * @author zhaka
 */
public class CommandButton extends JButton
{
    private ICommand _command;
    
    private boolean _isEnabled = true;
    
    public void bindCommand(ICommand command)
    {
        _command = command;
        command.getCanEcxecuteChangedEvent().addCallback(cmd -> updateEnabled());
        
        addActionListener(ae -> performAction());
    }
    
    @Override
    public void setEnabled(boolean enabled)
    {
        _isEnabled = enabled;
        updateEnabled();
    }
    
    private void updateEnabled()
    {
        super.setEnabled(_isEnabled && _command.getCanExecute());
    }

    private void performAction()
    {
        if(_command != null)
        {
            _command.execute();
        }
    }
}
