//B190198
import java.util.Scanner;
public class Reg{
  public static void main(String[] args){
    Scanner m = new Scanner(System.in);
    
    //underGrad s1 = new underGrad("Ali", "8","BIT", 10);
    //System.out.println(s1.toString());
    //Student: Alice ID: 2 pursuing BCS has completed 70 credits 
///The student has not registered for any courses this semester
    
    System.out.println("Enter student's name:");
    String name = m.nextLine();
    System.out.println("Enter student ID:");
    String ID = m.nextLine();
    System.out.println("Enter programme: ");
    String p = m.nextLine();
    System.out.println("Enter credits completed: ");
    int c = m.nextInt();
    underGrad s1 = new underGrad(name, ID, p, c);
    System.out.println("Have you taken any course(s) this semester? ");//if user has taken courses
    char ans = m.next().charAt(0);//stores answer in a char named ans
    
    switch (ans){
      case 'Y' : case 'y':
        for(int i = 0; i<4; i++){
        m.nextLine();
        System.out.println("Enter course name: ");
        String c_n = m.nextLine();
        System.out.println("Enter course code: ");
        String c_c = m.nextLine();
        s1.registerCourse(new Course(c_n, c_c));
      }
        
       System.out.println("The student has registered for the following 4 courses this semester");
       for(int i =0; i<4; i++){//for printing courses
         System.out.println(s1.courselist[i]);
        }
        System.out.println("Want to have any more courses?" );//if student is interested to take more course
       break;
      case 'N' : case 'n':
        System.out.println("Student has not taken any course this semester");
        break;
    }
    char choice2 = m.next().charAt(0);
    switch (choice2){
      case 'Y' : case 'y':
        m.nextLine();
        System.out.println("Enter course name: ");
        String courseName = m.nextLine();
        System.out.println("Enter course code: ");
        String courseCode = m.nextLine();
        Course c5 = new Course(courseName, courseCode);
        s1.registerCourse(c5);
        break;
      case 'N' : case 'n':
        System.out.println();
        break;
    }
    
    System.out.println();
    System.out.println();
    postGrad s3 = new postGrad("Adil Ali", "8", "Ph.D", new Academic("Abdul Wahab", "Prof."));
    s3.setStatus("RESEARCH");
    System.out.println(s3);
    System.out.println();
    Academic a2 = new Academic("Xi Ping", "Assoc. Prof.");
    postGrad s4 = new postGrad("Sally", "7", "MIT", a2);
    s4.setStatus("THESIS WRITING");
    System.out.println(s4);
                               
  }
}