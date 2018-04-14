package common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zhaka
 */
public class ObservableCollection<TItem> implements INotifyCollectionChanged<TItem>
{
    private final List<Consumer<TItem>> _itemAddedListeners = new ArrayList<>();
    
    private final List<Consumer<TItem>> _itemRemovedListeners = new ArrayList<>();
    
    @Override
    public void AddItemAddedListener(Consumer<TItem> listener)
    {
        if(!_itemAddedListeners.contains(listener))
        {
            _itemAddedListeners.add(listener);
        }
    }

    @Override
    public void RemoveItemAddedListener(Consumer<TItem> listener)
    {
        if(_itemAddedListeners.contains(listener))
        {
            _itemAddedListeners.remove(listener);
        }
    }

    @Override
    public void AddItemRemovedListener(Consumer<TItem> listener)
    {
        if(!_itemRemovedListeners.contains(listener))
        {
            _itemRemovedListeners.add(listener);
        }
    }

    @Override
    public void RemoveItemRemovedListener(Consumer<TItem> listener)
    {
        if(_itemRemovedListeners.contains(listener))
        {
            _itemRemovedListeners.remove(listener);
        }
    }
    

    
}
