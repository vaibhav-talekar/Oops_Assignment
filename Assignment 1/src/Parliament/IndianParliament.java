package Parliament;
import java.util.*;
/**
 * @author Vaibhav Talekar
 * Roll No. 53
 * @version 1.0
 * Start Date:  16/06/2024
 * Modified Date:23/07/2024
 * Title: Implementation of Indian Parliament
 * Description: This is a Menu-Driven program implementing the indian parliament using the concepts of OOPs.
 */

/**
 * Represents the Indian Parliament with President, Rajya Sabha, and Lok Sabha members.
 *  @use This method serves as the entry point for the program. Run this method to interact with the Indian Parliament management system.
 */
public class IndianParliament {

    /**
     * Main method to interact with the Indian Parliament system.
     * Provides a menu-driven interface for adding and displaying Presidents, Rajya Sabha members and Lok Sabha members.
     */
    public static void main(String[] args){

        // Create a new instance of the President
        president p1=new president();

        // Array to hold Rajya Sabha members
        rajyasabha[]rs =new rajyasabha[250];
        int r=-1;  // Index for the Rajya Sabha members array

        // Array to hold Lok Sabha members
        loksabha[]ls =new loksabha[543];
        int l=-1; // Index for the Lok Sabha members array


        int choice;   // User choice from the menu
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Menu-driven loop for managing the Indian Parliament information
        do{

            // Display menu options
            System.out.println("\nIndian Parliament:");
            System.out.println("1. Add President");
            System.out.println("2. Display President");
            System.out.println("3. Add Rajya Sabha Member");
            System.out.println("4. Add lok Sabha Member");
            System.out.println("5. list Rajya Sabha Member");
            System.out.println("6. List Lok Sabha Member");
            System.out.println("7. Indian Parliament");
            System.out.println("0. Exit");

            // Get user choice
            System.out.println("\nEnter your choice:");
            choice = scanner.nextInt();

            // Execute actions based on user choice
            switch(choice){

                case 1 :
                    // Add a President
                    System.out.println("\nPlease Enter President Name and Party");
                    scanner.nextLine();  // Consume newline left-over
                    String pname = scanner.nextLine();
                    String pparty = scanner.nextLine();
                    p1.addpres(pname,pparty);
                    break;

                case 2 :
                    // Display the President
                    System.out.println(p1.displaypres());
                    break;

                case 3 :
                    // Add a Rajya Sabha Member
                    r++;
                    System.out.println("\nPLease Enter Name, Role, Party");
                    scanner.nextLine();  // Consume newline left-over
                    String rname= scanner.nextLine();
                    String rrole= scanner.nextLine();
                    String rparty= scanner.nextLine();

                    rs[r]=new rajyasabha();
                    rs[r].addrsm(rname,rrole,rparty);

                    break;

                case 4:
                    // Add a Lok Sabha Member
                    l++;
                    System.out.println("\nPLease Enter Name, Role, Party");
                    scanner.nextLine();  // Consume newline left-over
                    String lname= scanner.nextLine();
                    String lrole= scanner.nextLine();
                    String lparty= scanner.nextLine();

                    ls[l]=new loksabha();
                    ls[l].addlsm(lname,lrole,lparty);

                    break;

                case 5:
                    // List Rajya Sabha Members
                    System.out.println("\nRajya Sabha Members :");
                    for(int i=0;i<rs.length;i++){
                        if(rs[i]== null){
                            break;
                        }
                        else {
                            System.out.println((i+1)+". "+rs[i].displayrsm());
                        }
                    }
                    break;

                case 6:
                    // List Lok Sabha Members
                    System.out.println("\nLok Sabha Members :");
                    for(int i=0;i<ls.length;i++){
                        if(ls[i]== null){
                            break;
                        }
                        else {
                            System.out.println((i+1)+". "+ls[i].displaylsm());
                        }
                    }
                    break;

                case 7:
                    // Display all information
                    System.out.println("\nIndian Parliament :");
                    System.out.println(p1.displaypres());
                    System.out.println("\nRajya Sabha Members:");
                    for(int i=0;i<rs.length;i++){
                        if(rs[i]== null){
                            break;
                        }
                        else {
                            System.out.println((i+1)+". "+rs[i].displayrsm());
                        }
                    }
                    System.out.println("\nLok Sabha Members:");
                    for(int i=0;i<ls.length;i++){
                        if(ls[i]== null){
                            break;
                        }
                        else {
                            System.out.println((i+1)+". "+ls[i].displaylsm());
                        }
                    }
                    break;

                case 0:
                    // Exit the application
                    System.out.println("\nExiting....");
                    break;

            }
        }while(choice!=0);  // Continue looping until user chooses to exit
    }
}
