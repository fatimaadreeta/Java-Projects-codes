import java.util.Scanner;

public class B1901898{
  
  
  public static String transactionID(){
    int ID = (int)((Math.random()*1000)+1);//auto generated ID created and stored
      String tID = "";//tID created and initialised
      if(ID>=1 && ID<=999){//checks whether ID between 1 and 999
        if(ID>=1 && ID<=9){//if ID between 1 and 9, then executes and stores value to tID
          tID = "00"+ID;
        }
        else if(ID>=10 && ID<=99){//if ID between 10 and 99, then executes and stores value to tID
          tID = "0"+ID;
        }
        else if(ID>=100 && ID<=999){//if ID between 100 and 999, then executes and stores value to tID
          tID = ""+ID;
        }
      }
      return tID;//returns auto-generated transaction ID
  }
  
  public static char Category(String c){//to take value for category regardless of the case
    if(c.equalsIgnoreCase("m")){
      c= "M";
    }
    else if(c.equalsIgnoreCase("r")){
      c= "R";
    }
    else if(c.equalsIgnoreCase("e")){
      c= "E";
    }
    else{
      System.out.println("Please enter a valid value(M/R/E): ");
    }
    char e = c.charAt(0);
    return e; //returns the valid value for category
  }
  
  public static int DaysStayed(int day){//checks if the stayed days are between 14 and 42
    int stayedDays;
    if(day >=14 && day<=42){
      stayedDays = day;
    }
    else{
      stayedDays = 21;//default value is set as 21
      System.out.println("Default value of stayed days is 21");
    }
    return stayedDays; //returns the days stayed
  }
  
  public static String highestAmount(double highest, String name, char cat){//String method for printing info for highest payer
    String nat = "";
    if(cat=='M'){
      nat = "a Malaysian";
    }
    else if(cat=='R'){
      nat = "a Resident";
    }
    else if(cat=='E'){
      nat = "an Expat";
    }
    return "Highest amount paid "+highest+" RM by "+name+", is "+nat;//returns info for highest payer
  }
  
  public static String averageM(double Mtotal, int Mguests){//calculates average amount of Malaysians
    double average = Mtotal/Mguests;
    return "Average amount from Malaysians: "+average+" RM";//returns string of average payment
  }
  
  public static String averageF(double Ftotal, int Fguests){//calculates average amount of Foreigners
    double average = Ftotal/Fguests;
    return "Average amount from foreigners: "+average+" RM";//returns string of average payment
  }
  
  public static int QuarantineFund(int qFund, double gPay){//to update and calculate quarantine fund
    int quFund = 0;//variable that initialises the return value
    if(qFund>=gPay){//condition applied if qFund is still more or equal govt pay
      quFund = qFund - (int)gPay;
    }
    else{
      System.out.println("Insufficient balance in the Quarantine fund");
    }
    return quFund;//returns updated value of quarantine fund
  }
      
      
    
  public static void main (String [] args){ 
    Scanner input = new Scanner(System.in);
    
    int qFund = 3000;//initial amount of Quarantine fund
    System.out.println("Quarantine Fund Balance: "+qFund+" RM");//prints the default value
    System.out.println();//empty line
    System.out.println("Enter guest name(q/Q to quit): ");//takes the name of the guest, or quits program
    String name = input.nextLine();
    int gcounter = 0; //counts the number of guests
    double total = 0.0; //to store the total amount of all guests
    double highest = 0.0; //to store the highest paid amount
    String highName = "";//to store the name of highest payer
    char highCat = '\u0000';//to store the nationality of highest payer
    char cat = '\u0000';//to store category
    int Mguests = 0;//number of malaysian guests 
    int Fguests = 0;//number of foreigner guests
    double Mtotal = 0.0;//total amount paid by Malaysian guests
    double Ftotal = 0.0;//total amount paid by foreigner guests
    
    
    if(name.equalsIgnoreCase("q")){ //prints if name = q
      System.out.println("No transactions");
    }
    
    else{ //executes if name != q
      while(!name.equalsIgnoreCase("q")){
      System.out.println("Category: ");//asks for nationality (malaysian/resident/expat)
      String c = input.nextLine();//takes user input
      char catCheck = Category(c);//temporary var to store the category
      if(catCheck=='M'||catCheck=='E'||catCheck=='R'){
        cat = catCheck;//stores valid value to cat
      }
      else{
        c = input.nextLine();//asks for value again
        catCheck = Category(c);//invokes method to verify input
      }
        
      System.out.println("Days stayed: ");//asks for days stayed
      int days = input.nextInt();//takes user input
      days = DaysStayed(days);//method invoked to calculate valid days, returned value stored to days
      input.nextLine();//for name to be asked again, makes the loop run
      
      System.out.println("Transaction ID: "+transactionID());//prints the ID
      
      double TC = 0.0;//TC = Total charge
      double CPD = 0.0;//CPD = charge per day
      
      if(cat=='M'){
          CPD = 80.3;
          Mguests++;//CPD is set, Mguests is incremented by 1
      }
      
      else if(cat=='R'){
          CPD = 100.6;
          Fguests++;//CPD is set, Fguests is incremented by 1
      }
      
      else if(cat=='E'){
          CPD = 120.9;
          Fguests++;//CPD is set, Fguests is incremented by 1
      }
      TC = days * CPD;//calculation of total charge
      System.out.println("Amount charged for "+days+" days @"+CPD+" RM/day: "+TC);//prints days stayed, CPD and TC
      
       if(TC>highest){//to store the name,category and amount of the highest payer
        highest = TC;
        highName = name;
        highCat = cat;
      }
      
      double GP = 0.0;//represents fund paid by government
      double SP = 0.0;//represents fund paid by self
      
      if(cat=='M'){
        
        Mtotal = Mtotal + TC;//guest's TC gets added to the total of Malaysian guests
        
        if(TC<1500){
          GP = 100; //fixed amount 100
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
        else if(TC>=1500 && TC<2000){
          GP = TC * .15;//15% of the total charge
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
        else if(TC>=2000 && TC<2500){
          GP = TC *.215;//21.5% of the total charge
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
        else if(TC>=2500){
          GP = TC * .275;//27.5% of the total charge
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
      }
      else if(cat=='R' || cat=='E'){
        
        Ftotal = Ftotal + TC;//guest's TC gets added to the total of foreigner guests
        
        if(TC<2000){
          GP = 80; //fixed amount 80
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
        else if(TC>=2000 && TC<3000){
          GP = TC * .095; //9.5% of the total charge
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
        else if(TC>=3000){
          GP = TC * .175; //17.5% of the total charge
          qFund = QuarantineFund(qFund, GP);//govt pay is deducted, qFund is updated
        }
      }
      
      SP = TC - GP; //calculation of self paid fund
      System.out.println("Paid by self: "+SP);//output of self paid fund
      System.out.println("Paid by Govt.: "+GP);//output of govt paid fund
      System.out.println("Quarantine Fund Balance: "+qFund+" RM");//output of updated qFund
      if(qFund<GP){//applicable when qFund is less than govt pay
        System.out.println("Would you like to: ");
        System.out.println("T.top up, any other key to quit");
        System.out.println("Your choice: ");//asks for user choice to top up 
        char choice = input.next().charAt(0);
        if(choice=='T' || choice=='t'){
          System.out.println("Top up Amount: ");
          int topUp = input.nextInt();//takes user input for top up balance
          qFund = qFund + topUp;//top up balance gets added to the qFund
        }
      }  
      
       total = total + TC;//adds to the total charge
       gcounter++;//number of total guests get incremented by 1
       
       System.out.println("Enter guest name(q/Q to quit): ");//re-prompting for the loop to continue
       name = input.nextLine();
      }
    System.out.println("Total Amount paid by "+gcounter+" guests is: "+total+" RM");//prints the total amount and the number of guests
    System.out.println(highestAmount(highest, highName, highCat));//prints the info of the highest payer
    System.out.println(averageM(Mtotal, Mguests));//prints the average amount paid by Malaysians
    System.out.println(averageF(Ftotal, Fguests)); //prints the average amount paid by Foreigners
    System.out.println("Quarantine Fund Balance: "+qFund+" RM");//prints the final balance of Quarantine fund
    }
  }
 }