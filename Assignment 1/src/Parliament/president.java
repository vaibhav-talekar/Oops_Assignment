package Parliament;

/**
 * Represents the President of India.
 * @use Create an instance of this class to manage and display information about President.
 */
public class president{
    String pname;
    String pparty;

    /**
     * Adds a new President with name and party.
     * @param pname The name of the President.
     * @param pparty The party affiliation of the President.
     */
    public void addpres(String pname,String pparty){
        this.pname=pname;
        this.pparty=pparty;

    }

    /**
     * Displays information about the President.
     * @return A string representation of the President.
     */
    public String displaypres(){
        String president="President: "+pname+", Party: "+pparty;
        return president;

    }
}