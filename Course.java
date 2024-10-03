//B1901898
public class Course {
  //attributes of source code
    private String name;
    private String code;
    
    Course(String name, String code){
      //constructor
        this.name = name;
        this.code = code;
    }
    
    public void setName(String n){//setter for course name
      this.name = n;
    }
    public String getName(){//getter for course name
      return this.name;
    }
    public void setCode(String c){//setter for course code
      this.code = c;
    }
    public String getCode(){//getter for course code
      return this.code;
    }
    
    public String toString() {
      //redefined toString() method
        return code + ": " + name;
    }
}
