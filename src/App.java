import java.util.*;

public class App{

    
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);

            while(true) {

                System.out.println("------------------------------------");
                System.out.println("1. Add vaccine");
                System.out.println("2. Register Hospital");
                System.out.println("3. Register Citizen");
                System.out.println("4. Add slot for Vaccination");
                System.out.println("5. Book Slot for Vaccination");
                System.out.println("6. List all slots for a hospital");
                System.out.println("7. Check Vaccination Status");
                System.out.println("8. Exit");
                System.out.print("Enter option: ");
                
                int option = sc.nextInt();

                switch(option) {
                    case 1:
                        //query1();
                        break;
                    
                    case 2:
                        //query2();
                        break;
                  
                    case 3:
                        //query3();
                        break;

                    case 4:
                        //query4();
                        break;

                    case 5:
                        //query5();
                        break;

                    case 6:
                        //query6();
                        break;

                    case 7:
                        //query7();
                        break;
                    
                    case 8:
                        return;

                    default: System.out.println("Enter correct code!!!");
                }
            }
        }
}

class citizen {

}

class hospital{

}

class vaccine{

}

class slots{

}

