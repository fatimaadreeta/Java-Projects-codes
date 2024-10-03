//B1901898
//Fatima Binte Faiz Adreeta
public class underGrad extends Student{
  //attributes/instance variables of UnderGrad class
  protected Course[] courselist;
  private int creditsCompleted;
  private int noOfCourseRegistered;//to count the inputs for courselist
  
  public underGrad(){
    this("undefned", "undefined", "undefined", 0);
  }
  
  public underGrad(String name ,String studentId, String programme, int creditsCompleted){
    //constructor
    // * values/arguments passed through the 
    // constructor is being set to the appropriate instance variables *
    super(name, studentId, programme);//passing value through parent class constructor
    this.creditsCompleted = creditsCompleted;
    courselist = new Course[4];
    this.noOfCourseRegistered = 0;//count initialised to 0
  }
  public boolean registerCourse(Course course){
    //method that registers a course
      boolean result;//a variable of boolean type (result) is created
      result = false;//result is initialised to false
    if(noOfCourseRegistered==4){//when count has reached courselist limit 
      System.out.println("Course cannot be registered : (Maximum reached)");
      result = false;
    }
    else if(noOfCourseRegistered<4){
      courselist[noOfCourseRegistered] = course;
      this.noOfCourseRegistered = noOfCourseRegistered + 1;//as 1 obj is entered, count is increased : 1 box in array is filled-up
      result = true;
    }
    return result;//boolean variable returned
  }
  
   String calculateSemFee(){
     double perFee = 500;//fee per credit hours
     int creditHour = 4;//credit hours every course
     
     double semFee = this.noOfCourseRegistered * perFee * creditHour;
     //calculating semester fee
     return " and has semester tuition fee "+semFee+"RM";
  }
  
  public void setCreditsCompleted(int n){//setter for credits completed
    this.creditsCompleted = n;
  }
  public int getCreditsCompleted(){//getter for credits completed
    return this.creditsCompleted;
  }
  public String getCourseList(){
    String final_result = "";//final string
    String result = "";//string to add courses
    if(noOfCourseRegistered==0){//if no courses registered for this semester
       result += "Student has not registered for any courses this semester";
      }
    else{
        final_result += "The student has registered for the following "+noOfCourseRegistered+" courses this semester: ";
        final_result +="\n";
    for(int i = 0; i<noOfCourseRegistered; i++){
        result += courselist[i];
        result += "\n";
      }
    }
    final_result += result;
    return final_result; //returns the whole result
  }
    
  public String toString(){//combining the string in superclass with values specific for underGrad class
    return super.toString()+" has completed "+this.creditsCompleted+" credits"+"\n"+getCourseList()+calculateSemFee();
  }
}
                   