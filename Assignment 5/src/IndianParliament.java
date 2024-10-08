

import java.util.*;

// Enumeration to define member types
enum MemberType {
    PRESIDENT, RAJYA_SABHA, LOK_SABHA
}

/**
 * Annotator for metadata information.
 */
@interface Info {
    String author();
    String version();
}

/**
 * Base class ParliamentMember representing a generic member of the Parliament.
 */
@Info(author = "Vaibhav Talekar", version = "2.0")
abstract class ParliamentMember {
    protected String name;
    protected String role;
    protected String party;

    // Constructor for initializing the common properties
    public ParliamentMember(String name, String role, String party) {
        this.name = name;
        this.role = role;
        this.party = party;
    }

    // Abstract method to be implemented by subclasses (virtual method)
    public abstract String displayMemberInfo();

    // Overloaded method for setting information
    public void setInfo(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Overloaded method for setting information with party
    public void setInfo(String name, String role, String party) {
        this.name = name;
        this.role = role;
        this.party = party;
    }

    // Getter and Setter methods (Encapsulation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}

/**
 * Class President extending ParliamentMember.
 */
class President extends ParliamentMember {

    // Constructor for initializing President-specific properties
    public President(String name, String party) {
        super(name, "President", party);
    }

    @Override
    public String displayMemberInfo() {
        return "President: " + name + ", Party: " + party;
    }
}

/**
 * Class RajyaSabha extending ParliamentMember.
 */
class RajyaSabha extends ParliamentMember {

    // Constructor for initializing Rajya Sabha member-specific properties
    public RajyaSabha(String name, String role, String party) {
        super(name, role, party);
    }

    @Override
    public String displayMemberInfo() {
        return "Rajya Sabha Member: Name: " + name + ", Role: " + role + ", Party: " + party;
    }
}

/**
 * Class LokSabha extending ParliamentMember.
 */
class LokSabha extends ParliamentMember {

    // Constructor for initializing Lok Sabha member-specific properties
    public LokSabha(String name, String role, String party) {
        super(name, role, party);
    }

    @Override
    public String displayMemberInfo() {
        return "Lok Sabha Member: Name: " + name + ", Role: " + role + ", Party: " + party;
    }
}

public class IndianParliament {

    public static void main(String[] args) {

        // President instance
        President president = new President("Unknown", "Unknown");

        // List to hold Rajya Sabha members
        List<RajyaSabha> rajyaSabhaMembers = new ArrayList<>();

        // List to hold Lok Sabha members
        List<LokSabha> lokSabhaMembers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nIndian Parliament:");
            System.out.println("1. Add President");
            System.out.println("2. Display President");
            System.out.println("3. Add Rajya Sabha Member");
            System.out.println("4. Add Lok Sabha Member");
            System.out.println("5. List Rajya Sabha Members");
            System.out.println("6. List Lok Sabha Members");
            System.out.println("7. Display Indian Parliament");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add President
                    System.out.println("Enter President Name:");
                    String pname = scanner.nextLine();
                    System.out.println("Enter President Party:");
                    String pparty = scanner.nextLine();
                    president.setInfo(pname, "President", pparty);
                    break;

                case 2:
                    // Display President
                    System.out.println(president.displayMemberInfo());
                    break;

                case 3:
                    // Add Rajya Sabha Member
                    System.out.println("Enter Rajya Sabha Member Name:");
                    String rname = scanner.nextLine();
                    System.out.println("Enter Role:");
                    String rrole = scanner.nextLine();
                    System.out.println("Enter Party:");
                    String rparty = scanner.nextLine();
                    rajyaSabhaMembers.add(new RajyaSabha(rname, rrole, rparty));
                    break;

                case 4:
                    // Add Lok Sabha Member
                    System.out.println("Enter Lok Sabha Member Name:");
                    String lname = scanner.nextLine();
                    System.out.println("Enter Role:");
                    String lrole = scanner.nextLine();
                    System.out.println("Enter Party:");
                    String lparty = scanner.nextLine();
                    lokSabhaMembers.add(new LokSabha(lname, lrole, lparty));
                    break;

                case 5:
                    // List Rajya Sabha Members
                    System.out.println("Rajya Sabha Members:");
                    for (int i = 0; i < rajyaSabhaMembers.size(); i++) {
                        System.out.println((i + 1) + ". " + rajyaSabhaMembers.get(i).displayMemberInfo());
                    }
                    break;

                case 6:
                    // List Lok Sabha Members
                    System.out.println("Lok Sabha Members:");
                    for (int i = 0; i < lokSabhaMembers.size(); i++) {
                        System.out.println((i + 1) + ". " + lokSabhaMembers.get(i).displayMemberInfo());
                    }
                    break;

                case 7:
                    // Display Indian Parliament
                    System.out.println(president.displayMemberInfo());
                    System.out.println("\nRajya Sabha Members:");
                    for (RajyaSabha member : rajyaSabhaMembers) {
                        System.out.println(member.displayMemberInfo());
                    }
                    System.out.println("\nLok Sabha Members:");
                    for (LokSabha member : lokSabhaMembers) {
                        System.out.println(member.displayMemberInfo());
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 0);
    }
}
