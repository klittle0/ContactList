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
    // To-string method
    public String toString(){
        return super.toString() + " " + jobTitle;
    }
}
