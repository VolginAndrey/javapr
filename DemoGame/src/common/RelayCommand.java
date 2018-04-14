package common;

import common.ICommand;
import common.Event;
import common.IEvent;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author zhaka
 */
public class RelayCommand implements ICommand
{
    private final Consumer<Object> _execute;
    
    private final Function<Object, Boolean> _canExecute;
    
    private final Event<ICommand> _canExecuteChanged = new Event<>();

    public RelayCommand(Consumer<Object> execute)
    {
        this(execute, null);
    }
    
    public RelayCommand(Consumer<Object> execute, Function<Object, Boolean> canExecute)
    {
        _execute = execute;
        _canExecute = canExecute;
    }
    
    @Override
    public void execute()
    {
        execute(null);
    }
    
    @Override
    public void execute(Object argument)
    {
        if(getCanExecute(argument))
        {
            _execute.accept(argument);
        }
    }

    @Override
    public boolean getCanExecute()
    {
        return getCanExecute(null);
    }
    
    @Override
    public boolean getCanExecute(Object argument)
    {
        return _canExecute == null || _canExecute.apply(argument);
    }

    public void OnCanExecuteChanged()
    {
        _canExecuteChanged.invoke(this);
    }

    @Override
    public IEvent<ICommand> getCanEcxecuteChangedEvent()
    {
        return _canExecuteChanged;
    }
}
