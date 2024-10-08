package Parliament;

/**
 * Represents a member of the Rajya Sabha.
 *  @use Create an instance of this class to manage and display information about Rajya Sabha members.
 */
public class rajyasabha {
    String rname;
    String rrole;
    String rparty;

    /**
     * Adds a new Rajya Sabha member with name, position, and party.
     * @param rname The name of the Rajya Sabha member.
     * @param rrole The position or role of the member.
     * @param rparty The party affiliation of the member.
     */
    public void addrsm(String rname,String rrole,String rparty){
        this.rname=rname;
        this.rrole=rrole;
        this.rparty=rparty;
    }

    /**
     * Displays information about the Rajya Sabha member.
     * @return A string representation of the Rajya Sabha member.
     */
    public String displayrsm(){
        String raj = "Name: " + rname + ", Role: " + rrole + ", Party: " + rparty;
        return raj;
    }
}

