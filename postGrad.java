//B1901898
public class postGrad extends Student{
  //instance variables
   private Academic supervisor;//reference variable of Academic type; var name = supervisor
   private String status;
   
   public postGrad(){
     this("undefined", "undefined", "undefined", null);
   }
   
   public postGrad(String name, String studentId, String programme, Academic supervisor){
     //set the values passed to the class variables
     super(name, studentId, programme);//invoked the parent constructor
     this.supervisor = supervisor;
     this.status = "AUDIT";
   }
   
   public boolean setStatus(String s){//setter for status
     boolean result = false;
     String[] status = new String[2];//an array named status is created
     status[0] = "RESEARCH";//value is set at position 0
     status[1] = "THESIS WRITING";//value is set at position 1
     
       if(s.equals(status[0]) || s.equals(status[1])){
         this.status = s;//the String entered becomes the status
         result = true;
       }
       else{
         this.status = s;//the string entered becomes the status
         return false;
     }
     return result;
   }
  
   public void setSupervisor(Academic r){//setter for supervisor
     this.supervisor = r;
   }
   public Academic getSupervisor(){//getter for supervisor
     return this.supervisor;
   }
   String calculateSemFee(){
     double fee = 0;//initialised the semester fee
     String pro = super.getProgramme();//getting the value of programme and storing it in pro
     char s = pro.charAt(0);//getting the 1st character of the student's programme
  
     switch (s){
       case 'M':
         fee = 6000;
         break;
       case 'P':
         fee = 8000;
         break;
     }
       return "and has semester tuition fee: "+fee+"RM";
  }
    public String toString(){//combining the string in superclass with values specific for postGrad class
    return super.toString()+" ("+this.status+") is under the supervision of "+this.supervisor+calculateSemFee();
    }
}

    
     
       
          
     
   