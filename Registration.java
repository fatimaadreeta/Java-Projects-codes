//B1901898
import java.util.Scanner;
public class Registration{
  //driver class
  public static void main (String [] args){
    Scanner m = new Scanner(System.in);

    //System.out.println(s3.calculateSemFee());
    
    //level 3
    System.out.println("Enter size of the list: ");
    int array = m.nextInt();
    StudentList studentlist = new StudentList(array);
    Student s1, s2;
    s1 = new underGrad();//s1 is now an object of undergrad
    s2 = new postGrad();//s2 is now an object of postgrad
    
    String name;//student name
    String id;//student id
    String programme;//student programme
    int credits;//credits completed
    String advisor;//academic name
    String designation;//academic designation
    char s_choice;//choice for string
    String status = "";//status for postgrad
    String c_name;//course name
    String c_code;//course code
    int d = 0;//determiner int value
    
    char choice = '1';//a String type var choiceString
    
    do{
      System.out.println("1 --> Add Undergrad student");
      System.out.println("2 --> Add Postgrad Student");
      System.out.println("3 --> Set Status");
      System.out.println("4 --> Register course");
      System.out.println("5 --> All Registered Students");
      System.out.println("Q/q --> Quit ");
      System.out.println("Enter your choice: ");
      choice = m.next().charAt(0);//taking the char at 0 position and storing it to choice
      switch (choice){
        case '1':
          System.out.println("Enter Name: ");
          m.nextLine();
          name = m.nextLine();
          System.out.println("Enter Id: ");
          id = m.nextLine();
          System.out.println("Enter Programme: ");
          programme = m.nextLine();
          System.out.println("Enter Credits completed: ");
          credits = m.nextInt();
          s1 = new underGrad(name, id, programme, credits);//undergrad student created
          studentlist.add(s1);//added to studentlist
          break;
        case '2':
          System.out.println("Enter Name: ");
          m.nextLine();
          name = m.nextLine();
          System.out.println("Enter Id: ");
          id = m.nextLine();
          System.out.println("Enter Programme: ");
          programme = m.nextLine();
          System.out.println("Enter Supervisor Name: ");
          advisor = m.nextLine();
          System.out.println("Enter Supervisor Designation: ");
          designation = m.nextLine();
          s2 = new postGrad(name, id, programme, new Academic(advisor, designation));//postgrad student created
          studentlist.add(s2);//added to studentlist
          break;
        case '3':
          System.out.println("Enter Id: ");
          m.nextLine();
          id = m.nextLine();
          System.out.println("R -> RESEARCH"); 
          System.out.println("T -> THESIS WRITING");
          System.out.println("Enter choice: ");
          s_choice = m.next().charAt(0);
          switch (s_choice){
            case 'R':
              status = "RESEARCH";//status is now set to RESEARCH 
              break;
            case 'T':
              status = "THESIS WRITING";//status is now set to THESIS WRITING
              break;
          }
          d = studentlist.setStatus(id, status);//returns 0/1;
          System.out.println(d);
          break;
        case '4':
          System.out.println("Enter Id: ");
          m.nextLine();
          id = m.nextLine();
          System.out.println("Enter Course Name: ");
          c_name = m.nextLine();
          System.out.println("Enter Course Code: ");
          c_code = m.nextLine();
          Course c = new Course(c_name, c_code);//a new Course object created
          d = studentlist.registerCourse(id, c);
          System.out.println(d);
          break;
        case '5':
          System.out.println(studentlist.toString());
          System.out.println();
          break;
      }
      System.out.println();
    }while(!(Character.toString(choice)).equalsIgnoreCase("q"));         
  }
}
  