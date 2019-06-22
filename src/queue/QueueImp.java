package queue;

public class QueueImp<T> implements Queue<T> {

  private T head;
  private QueueImp<T> next;

  protected QueueImp() {
    this.head = null;
    this.next = null;
  }

  private QueueImp(T head, QueueImp next) {
    this.head = head;
    this.next = next;
  }

  @Override
  public Queue<T> deQueue() {
    if(this.next == null) {
      return new QueueImp<>();
    } else return this.next;

  }

  @Override
  public Queue<T> enQueue(T t) {
    if (this.head == null) {
      return new QueueImp<>(t, null);

    } else {
      return new QueueImp<>(t, this);
    }
  }

  @Override
  public T head() {
    return this.head;
  }

  @Override
  public boolean isEmpty() {
    return this.head == null;
  }
}
