package common;

import java.util.function.Consumer;

/**
 * @author zhaka
 */
public interface INotifyCollectionChanged<TItem>
{
    void AddItemAddedListener(Consumer<TItem> listener);
    
    void RemoveItemAddedListener(Consumer<TItem> listener);
    
    void AddItemRemovedListener(Consumer<TItem> listener);
    
    void RemoveItemRemovedListener(Consumer<TItem> listener);
}
