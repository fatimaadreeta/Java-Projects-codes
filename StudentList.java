public class StudentList {
    //attributes
    private int noOfStudents;//counting number of students
    private Student[] studentList;//array that stores student type object
    private int MAXSTUDENTS; //max number of students//length of array
    
    public StudentList(int max){//constructor
        noOfStudents = 0;//count is 0
        if(max>0){//only takes value if max is a valid number of students
          MAXSTUDENTS = max;
          studentList = new Student[MAXSTUDENTS]; //length of array is set to MAXSTUDENTS
        }  
    }
    
    boolean add(Student student){//adds student in studentList[]
        boolean result = false;
    if(noOfStudents==MAXSTUDENTS){//when noOfStudents is more than the capacity of the array : MAXSTUDENTS - 1)
      result = false;
      System.out.println("No more students can be added.");
    }
    else if(noOfStudents<MAXSTUDENTS){
      studentList[noOfStudents] = student;//new student is entered in the array
      this.noOfStudents = noOfStudents + 1;//as 1 obj is entered, count/noOfStudents is increased : 1 box in array is filled-up
      result = true;
    }
    return result;
    }
    
 
    public int setStatus(String studentId, String status){//for postGrad
      boolean l = false;//takes a boolean value
      int determiner = 0;//int var determiner is created and initialised to 0
      
      for(int i = 0; i<MAXSTUDENTS; i++){
        if(studentList[i].getStudentId().equals(studentId)){//checking if the student found in the list
          postGrad p = new postGrad();//creating an instance of postgrad
          
          if(studentList[i] instanceof postGrad){//checking if the student is postgrad
          p = (postGrad)studentList[i];//downcasting
          l = p.setStatus(status);//storing a boolean type value
          }
          
          if(l==true){//determines if student is postgrad
            determiner = 1;//changes to 1 if true
            break;
          }
          else if(l==false){
            determiner = 0;
            break;
          }
        }
      }
      return determiner;
    }
             
    public int registerCourse(String studentId, Course course){
      boolean l = false;
      int determiner = 0;//initialised to 0
      for(int i = 0; i<MAXSTUDENTS; i++){
        if(studentId.equals(studentList[i].getStudentId())){
           underGrad u = new underGrad();
           if(studentList[i] instanceof underGrad){
             u = (underGrad)studentList[i];//downcasting
             l = u.registerCourse(course);//passes course to courselist
           }
           if(l==true){
           determiner = 1;
           break;
           }
           else if(l==false){
             determiner = 0;
             break;
           }
        }
      }
      return determiner;
    }

    
    public String toString(){
        String result ="";
       
        for(int i = 0; i < noOfStudents ; i++){
            result += studentList[i].toString();
            result += "\n-------------------------------\n";
        }
        return result;
    }   
    
    
}
