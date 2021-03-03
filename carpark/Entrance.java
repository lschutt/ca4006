import java.lang.*;
import java.util.*;

public class Entrance implements Runnable
{
  private CarParkManager carParkManager;
  private String threadName;
  private Queue<Car> queue = new LinkedList<Car>();

  public Entrance(CarParkManager carParkManager, String threadName, Queue<Car> queue)
  {
    this.carParkManager = carParkManager;
    this.threadName     = threadName;
    this.queue          = queue;
  }

  @Override
  public void run()
  {
    try
    {
      while(!(queue.isEmpty()))
      {
        carParkManager.fillSpace(queue);
      }
    }

    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  public void setThreadName(String threadName)
  {
    this.threadName = threadName;
  }

  public String getThreadName()
  {
    return this.threadName;
  }

  public void setQueue(Queue<Car> queue)
  {
    this.queue = queue;
  }

  public Queue<Car> getQueue()
  {
    return this.queue;
  }

  public void setCarParkManager(CarParkManager carParkManager)
  {
    this.carParkManager = carParkManager;
  }

  public CarParkManager getCarParkManager()
  {
    return this.carParkManager;
  }
}
