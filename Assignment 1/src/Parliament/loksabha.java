package Parliament;

/**
 * Represents a member of the Lok Sabha.
 * @use Create an instance of this class to manage and display information about Lok Sabha members.
 */
public class loksabha {
    String lname;
    String lrole;
    String lparty;

    /**
     * Adds a new Lok Sabha member with name, position, and party.
     * @param lname The name of the Lok Sabha member.
     * @param lrole The position or role of the member.
     * @param lparty The party affiliation of the member.
     */
    public void addlsm(String lname,String lrole,String lparty){
        this.lname=lname;
        this.lrole=lrole;
        this.lparty=lparty;
    }

    /**
     * Displays information about the Lok Sabha member.
     * @return A string representation of the Lok Sabha member.
     */
    public String displaylsm(){
        String lok = "Name: " + lname + ", Role: " + lrole + ", Party: " + lparty;
        return lok;
    }
}
