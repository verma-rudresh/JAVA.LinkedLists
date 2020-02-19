public class NodeIterator<T> implements java.util.Iterator<T>
{
    private Position_<T> current_node;
    NodeIterator(Position_<T> head)
    {
        this.current_node = head;
    }

    public boolean hasNext()
    {
        // TODO Auto-generated method stub
        return current_node != null;
    }

    public Position_<T> Next()
    {
        // TODO Auto-generated method stub
        Position_<T> nodePtr = current_node;
        current_node =  current_node.after();
        return nodePtr;
    }
    public T next() {
        return null;
    }
}
