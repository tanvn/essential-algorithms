package queue;

public interface Queue<T> {
    public Queue<T> deQueue();

    public Queue<T> enQueue(T t);

    public T head();

    public boolean isEmpty();
}


