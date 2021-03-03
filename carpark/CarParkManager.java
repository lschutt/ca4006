import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;


public class CarParkManager
{
  private final int totalNumberOfParkingSpaces = 1000;
  private LinkedList<ParkingSpace> parkingSpaces = new LinkedList<ParkingSpace>();
  private int numberOfCars = 0; // tracks number of cars in the car park
  private int totalSpacesAvailable = totalNumberOfParkingSpaces; // initial value is for empty car park
  private boolean carPresent = false; // indicator for car presence inside car park
  private int index; // location of specific car in car park

  public synchronized void freeSpace(Queue<Car> queue) throws InterruptedException
  {
      if(!(queue.isEmpty()))
      {
        for(ParkingSpace ps : parkingSpaces)
        {
          if(ps.getCar() != null)
          {
            if(ps.getCar().getName().equals(queue.element().getName()))
            {
              carPresent = true;
              index = parkingSpaces.indexOf(ps);
            }
          }
        }

        if(carPresent && queue.element().getExitProblem())
        {
          System.out.println("Car " + queue.element().getName() + " at " + queue.element().getExitName() + " has an exit problem...");
          System.out.println();
          wait(500);
          queue.element().setExitProblem(false);
        }

        if(carPresent)
        {
          if(!(queue.isEmpty()))
          {
            if(queue.element().getDoubleParking())
            {
               totalSpacesAvailable++;
            }
            parkingSpaces.add(index, new ParkingSpace()); // clear parking space
            Car car = queue.remove(); // remove car from queue, because it left already
            numberOfCars--;
            totalSpacesAvailable++;
            System.out.println("Car " + car.getName() + " at " + car.getExitName() + " just left. Queue size is now: " + queue.size() + " Number of cars inside: " + numberOfCars + " Number of spaces: " + totalSpacesAvailable);
            System.out.println();
            carPresent = false;
            notifyAll();
          }
        }
      }
  }

  public synchronized void fillSpace(Queue<Car> queue) throws InterruptedException
  {
      while(numberOfCars >= totalNumberOfParkingSpaces)
      {
        System.out.println("Car " + queue.element().getName() + " is at " + queue.element().getEntranceName() + " waiting to get in...");
        System.out.println();
        wait();
      }

     if(queue.element().getEntranceProblem())
      {
        System.out.println("Car " + queue.element().getName() + " at " + queue.element().getEntranceName() + " has an entrance problem...");
        System.out.println();
        wait(500);
        queue.element().setEntranceProblem(false); // fix entrance problem once woken from wait
      }

      if(!(queue.isEmpty()))
      {
        if(queue.element().getDoubleParking())
        {
          totalSpacesAvailable--; // double parking detected, so dec once here - and consequently another below
        }
        Car car = queue.remove();
        parkingSpaces.add(new ParkingSpace(car));
        numberOfCars++;
        totalSpacesAvailable--;
        System.out.println("Car " + car.getName() + " at " + car.getEntranceName() + " just came in. Queue size is now: " + queue.size() + ". Number of cars inside: " + numberOfCars + " Number of spaces: " + totalSpacesAvailable);
        System.out.println();
        notifyAll();
      }
   }
}
