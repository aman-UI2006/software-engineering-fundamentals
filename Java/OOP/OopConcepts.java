public class OopConcepts {
 interface Payable { double amountDue(); }
 static abstract class Employee implements Payable {
  private final String name;
  Employee(String name){this.name=name;}
  public final String name(){return name;}
  public abstract String role();
 }
 static final class Developer extends Employee {
  private final double salary;
  Developer(String name,double salary){super(name);if(salary<0)throw new IllegalArgumentException();this.salary=salary;}
  public String role(){return "Developer";}
  public double amountDue(){return salary;}
 }
 static final class Contractor implements Payable {
  private final double hours,rate;
  Contractor(double hours,double rate){if(hours<0||rate<0)throw new IllegalArgumentException();this.hours=hours;this.rate=rate;}
  public double amountDue(){return hours*rate;}
 }
 public static void main(String[]args){
  Payable[] team={new Developer("Asha",70000),new Contractor(40,800)};
  for(Payable p:team)System.out.println(p.amountDue());
  Employee e=new Developer("Ravi",65000);
  System.out.println(e.name()+" — "+e.role());
 }
}
