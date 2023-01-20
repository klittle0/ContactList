/**
 * A class that represents a Worker
 *
 * Created for Menlo School CS2
 *
 * @author: Kate Little
 * @version: 2022-2023
 */
public class Worker extends Person{
    private String jobTitle;

    // Constructor
    public Worker(String firstName, String lastName, String phoneNumber, String jobTitle){
        super(firstName, lastName, phoneNumber);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    // To-string method prints firstName lastName — phoneNumber jobTitle
    public String toString(){
        return super.toString() + " " + jobTitle;
    }
}
