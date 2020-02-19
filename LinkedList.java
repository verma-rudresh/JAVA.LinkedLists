public class LinkedList<T> implements LinkedList_<T>   {
     private Position_<T> head;
     Position_<T> tail;
    public Position_<T> add(T e)
    {
        // Create a new node with given data
        Position_<T> new_node = new Position<T>(e,tail);

        tail = new_node;
        head = new_node;
        return tail;
    }

    public int count()
    {
        int num = 0;
        while(head!=null) {
            num++;
            head = head.after();
        }
        return num;
    }


    public NodeIterator<T> positions()
    {

        //Position_<T> node = node_itr.Next();
        return new NodeIterator<T> (  head);

    }
}
