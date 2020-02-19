public class Position<T> implements Position_<T> {
    private T data;
    private Position_<T> next;
    //public Position<T> head;
    Position(T val, Position_<T> next){
        this.data=val;
        this.next=next;
    }
    /*public void setData(T data)
    {
        this.data = data;
    }
    public void setNext(Position<T> next)
    {
        this.next = next;
    }*/
    public T value() {
        return data;
    }
    public Position_<T> after(){
        return next;
    }
}
