//B1901898
abstract public class Student{
  //abstract class attributes
  private String name;
  private String studentId;
  private String programme;
  
  Student(String name, String studentId, String programme){
    this.name = name;
    this.studentId = studentId;
    this.programme = programme;
  }
  
  public void setProgramme(String s){
    this.programme = s;
  }
  public String getProgramme(){
    return this.programme;
  }
    
  public void setStudentId(String Id){
    this.studentId = Id;
  }
  public String getStudentId(){
    return this.studentId;
  }
    
  public void setName(String n){
    this.name = n;
  }
  public String getName(){
    return this.name;
  }
  
  abstract String calculateSemFee();//abstract methods cannot have method body in the parent class
  
  public String toString(){
    return "Student: "+this.name+" ID: "+this.studentId+" pursuing "+this.programme;
  } 
}