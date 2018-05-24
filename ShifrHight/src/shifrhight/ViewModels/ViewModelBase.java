/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shifrhight.ViewModels;

import common.Event;
import common.IEvent;
import common.NotifyPropertyChangedBase;

/**
 *
 * @author volgin
 */
public abstract class ViewModelBase extends NotifyPropertyChangedBase{
        private final Event<String> _errorOccured = new Event<>();
    
    protected final void onErrorOccured(String propertyName)
    {
        _errorOccured.invoke(propertyName);
    }

    public final IEvent<String> getErrorOccured()
    {
        return _errorOccured;
    }
}
