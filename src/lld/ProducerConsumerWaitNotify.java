package lld;

public class ProducerConsumerWaitNotify {
  
  private String message;
  private boolean empty = true;
  
  public synchronized void put(String msg) {
    while (!empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println("producer - interrupted");
      }
    }
    message = msg;
    empty = false;
    System.out.println("pushed message " + msg);
    notifyAll();
  }
  
  public synchronized String take() {
    while (empty) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println("consumer - interrupted");
      }
    }
    empty = true;
    System.out.println("read message " + message);
    notifyAll();
    return message;
  }

  public static void main(String[] args) {
    ProducerConsumerWaitNotify producerConsumerWaitNotify = new ProducerConsumerWaitNotify();
    Thread producer = new Thread(() -> {
      producerConsumerWaitNotify.put("Hello");
      producerConsumerWaitNotify.put("Dear");
      producerConsumerWaitNotify.put("How");
      producerConsumerWaitNotify.put("Do");
      producerConsumerWaitNotify.put("You");
      producerConsumerWaitNotify.put("Do");
      producerConsumerWaitNotify.put("End");
    });

    Thread consumer = new Thread(() -> {
      String msg = producerConsumerWaitNotify.take();
      while (!msg.equals("End")) {
        System.out.println(msg);
        msg = producerConsumerWaitNotify.take();
      }
    });
    
    consumer.start();
    producer.start();
  }

}
