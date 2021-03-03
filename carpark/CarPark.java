import java.util.*;

public class CarPark
{
  public static void main(String [] args)
  {
    //The Threads Manager
    CarParkManager carParkManager = new CarParkManager();

    // The queues
    Queue<Car> entranceOneQueue   = new LinkedList<Car>();
    Queue<Car> entranceTwoQueue   = new LinkedList<Car>();
    Queue<Car> entranceThreeQueue = new LinkedList<Car>();
    Queue<Car> exitOneQueue       = new LinkedList<Car>();
    Queue<Car> exitTwoQueue       = new LinkedList<Car>();
    Queue<Car> exitThreeQueue     = new LinkedList<Car>();

    int carId = 0;
    int numberOfCars = Integer.parseInt(args[0]);
    Car incoming = new Car();

    for(int i = 0; i < numberOfCars; i++)
    {
      switch(((int)(Math.random() * (4 - 1)) + 1))
      {
        case 1:
        incoming = new Car("" + ++carId, "Student", "Entrance 1", "Exit 3",   0.14, 0.2, 0.3);
        entranceOneQueue.add(incoming);
        exitThreeQueue.add(incoming);
        break;

        case 2:
        incoming = new Car("" + ++carId, "Lecturer", "Entrance 2", "Exit 1",   0.14, 0.2, 0.3);
        entranceTwoQueue.add(incoming);
        exitOneQueue.add(incoming);
        break;

        case 3:
        incoming = new Car("" + ++carId, "Student", "Entrance 3", "Exit 2",   0.14, 0.2, 0.3);
        entranceThreeQueue.add(incoming);
        exitTwoQueue.add(incoming);
        break;
      }
    }

    //The Threads below are Producer Threads
    Thread entranceOne   = new Thread(new Entrance(carParkManager, "Entrance Thread 1", entranceOneQueue));
    Thread entranceTwo   = new Thread(new Entrance(carParkManager, "Entrance Thread 2", entranceTwoQueue));
    Thread entranceThree = new Thread(new Entrance(carParkManager, "Entrance Thread 3", entranceThreeQueue));

    //The Threads below are Consumer Threads
    Thread exitOne   = new Thread(new Exit(carParkManager, "Exit Thread 1", exitOneQueue));
    Thread exitTwo   = new Thread(new Exit(carParkManager, "Exit Thread 2", exitTwoQueue));
    Thread exitThree = new Thread(new Exit(carParkManager, "Exit Thread 3", exitThreeQueue));

    //Logic for execution
    try
    {
      entranceOne.start();
      entranceTwo.start();
      entranceThree.start();
      exitOne.start();
      exitTwo.start();
      exitThree.start();

      entranceOne.join();
      entranceTwo.join();
      entranceThree.join();
      exitOne.join();
      exitTwo.join();
      exitThree.join();

      System.out.println("Finish");
    }

    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
