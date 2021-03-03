public class ParkingSpace
{
  private double length = 4.8;
  private double width  = 2.4;
  private Car    car    = null;
  private double spaceArea;

  public ParkingSpace(){}

  public ParkingSpace(double length, double width, Car car)
  {
    this.length = length;
    this.width  = width;
    this.car    = car;
  }

  public ParkingSpace(Car car)
  {
    this.car = car;
  }

  public double getLength()
  {
    return this.length;
  }

  public void setLength(double length)
  {
    this.length = length;
  }

  public double getWidth()
  {
    return this.width;
  }

  public void setWidth(double width)
  {
    this.width = width;
  }

  public double getSpaceArea()
  {
    return this.spaceArea;
  }

  public void setSpaceArea()
  {
    this.spaceArea = calculateSpaceArea();
  }

  public double calculateSpaceArea()
  {
    return this.spaceArea = length * width;
  }

  public Car getCar()
  {
    return this.car;
  }

  public void setCar(Car car)
  {
    this.car = car;
  }

  public void removeCar()
  {
    this.car = null;
  }

  public void print()
  {
    System.out.println("Length: " + getLength() + ", Width: " + getWidth() + ", Total Area: " + getSpaceArea());
    System.out.println("Car: ");
    car.print();
  }

  @Override
  public String toString()
  {
    return "Length: " + getLength() + ", Width: " + getWidth() + " , Total Area: " + getSpaceArea() + ", Car: " + getCar();
  }
}
