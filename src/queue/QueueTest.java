package queue;

public class QueueTest {
  public static void main(String[] args) {

      Queue<Integer> myQueue = new QueueImp<>();
      myQueue = myQueue.deQueue();
      System.out.println(myQueue.head());
      myQueue = myQueue.enQueue(10);
      myQueue = myQueue.enQueue(20);
      myQueue = myQueue.enQueue(30);
      System.out.println(myQueue.head());
      myQueue = myQueue.deQueue();
      System.out.println(myQueue.head());
      myQueue = myQueue.deQueue();
      System.out.println(myQueue.head());
      myQueue = myQueue.deQueue();
      System.out.println(myQueue.head());

  }
}
