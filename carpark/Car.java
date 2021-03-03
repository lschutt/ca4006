public class Car
{
  private String name;
  private String type;
  private String ownerType;
  private String entranceName;
  private String exitName;

  private double probOfDoubleParking;
  private double probOfEntranceProblem;
  private double probOfExitProblem;

  private boolean doubleParking;
  private boolean entranceProblem;
  private boolean exitProblem;

  public Car(){}

  public Car(String name, String ownerType, String entranceName, String exitName, double probOfDoubleParking, double probOfEntranceProblem, double probOfExitProblem)
  {
    this.name = name;
    this.ownerType     = ownerType;
    this.entranceName  = entranceName;
    this.exitName      = exitName;
    this.probOfDoubleParking   = probOfDoubleParking;
    this.probOfEntranceProblem = probOfEntranceProblem;
    this.probOfExitProblem     = probOfExitProblem;

    this.doubleParking   = probCalculator(probOfDoubleParking);
    this.entranceProblem = probCalculator(probOfEntranceProblem);
    this.exitProblem     = probCalculator(probOfExitProblem);
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return this.name;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getType()
  {
    return this.type;
  }

  public void setEntranceName(String entranceName)
  {
    this.entranceName  = entranceName;
  }

  public String getEntranceName()
  {
    return this.entranceName;
  }

  public void setExitName(String exitName)
  {
    this.exitName  = exitName;
  }

  public String getExitName()
  {
    return this.exitName;
  }

  public void setProbOfDoubleParking(double probOfDoubleParking)
  {
    this.probOfDoubleParking = probOfDoubleParking;
  }

  public double getProbOfDoubleParking()
  {
    return this.probOfDoubleParking;
  }

  public void setProbOfEntranceProblem(double probOfEntranceProblem)
  {
    this.probOfEntranceProblem = probOfEntranceProblem;
  }

  public double getProbOfEntranceProblem()
  {
    return this.probOfEntranceProblem;
  }

  public void setProbOfExitProblem(double probOfExitProblem)
  {
    this.probOfExitProblem = probOfExitProblem;
  }

  public double getProbOfExitProblem()
  {
    return this.probOfExitProblem;
  }

  public void setOwnerType(String ownerType)
  {
    this.ownerType = ownerType;
  }

  public String getOwnerType()
  {
    return this.ownerType;
  }

  public void setDoubleParking(boolean doubleParking)
  {
    this.doubleParking = doubleParking;
  }

  public boolean getDoubleParking()
  {
    return this.doubleParking;
  }

  public void setEntranceProblem(boolean entranceProblem)
  {
    this.entranceProblem = entranceProblem;
  }

  public boolean getEntranceProblem()
  {
    return this.entranceProblem;
  }

  public void setExitProblem(boolean exitProblem)
  {
    this.exitProblem = exitProblem;
  }

  public boolean getExitProblem()
  {
    return this.exitProblem;
  }

  public boolean probCalculator(double probability)
  {
    return Math.random() >= (1.0 - probability);
  }

  public void print()
  {
    System.out.print("Name: " + getName() + ", Type: " + getType() + "Prob. of Double Parking: " + getProbOfDoubleParking() + ", Prob. of Entrance Problem: " + getProbOfEntranceProblem() + ", Prob. of Exit Problem: " + getProbOfExitProblem() + ", Owner Type: " + getOwnerType());
  }

  @Override
  public String toString()
  {
    return "Name: " + getName() + ", Type: " + getType() + ", Owner Type: " + getOwnerType();
  }
}
