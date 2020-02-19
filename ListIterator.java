public class ListIterator<T> implements java.util.Iterator<T> {
    private Position_<T> current_node;
    ListIterator(LinkedList<T> list)
    {
        current_node = list.tail;
    }
    public boolean hasNext()
    {

        return current_node != null;
    }
    public T next()
    {
        T data = current_node.value();
        current_node = current_node.after();
        return data;
    }

}
