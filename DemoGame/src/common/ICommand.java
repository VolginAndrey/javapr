package common;

import common.IEvent;

/**
 * @author zhaka
 */
public interface ICommand
{
    void execute();
    
    void execute(Object argument);
    
    boolean getCanExecute();
    
    boolean getCanExecute(Object argument);
    
    IEvent<ICommand> getCanEcxecuteChangedEvent();
}
