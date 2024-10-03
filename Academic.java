//B1901898
//Fatima Binte Faiz Adreeta
public class Academic {
    //instance variables
    private String name;
    private String designation;
    
    Academic(String name, String designation) {
      //Academic contructor
        this.name = name;
        this.designation = designation;
    }
    
    public void setName(String name){//setter for name
      this.name = name;
    }
    public String getName(){//getter for name
      return this.name;
    }
    public void setDesignation(String designation){//setter for designation
      this.designation = designation;
    }
    public String designation(){//getter for designation
      return this.designation;
    }
    
    public String toString(){
        return this.designation + " " + this.name;
    }
    
}
