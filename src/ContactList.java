import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam, Mr. Blick, & Kate Little
 * @version: 2022-2023
 */

public class ContactList
{
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student \n2. Worker");
        int type = s.nextInt();
        s.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First name:");
        String firstName = s.nextLine();
        System.out.println("Last name:");
        String lastName = s.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = s.nextLine();
        // If user wants to create a new student:
        if (type == 1){
            System.out.println("Grade:");
            int grade = s.nextInt();
            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        }
        // If user wants to create a new worker:
        else if (type == 2){
            System.out.println("Job title: ");
            String jobTitle = s.nextLine();
            contacts.add(new Worker(firstName, lastName, phoneNumber, jobTitle));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (Person each: contacts){
            System.out.println(each);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // Sorts by first name
        int n = contacts.size();
        if (sortBy == 0){
            for (int pass = 1; pass < n; pass++){
                for (int comp = 0; comp < n - pass; comp++){
                    // If the first string is later in the alphabet than second String, switch order
                    if (contacts.get(comp).getFirstName().compareTo(contacts.get(comp + 1).getFirstName()) > 0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }

            }
        }
        // Sorts by last name
        else if (sortBy == 1){
            for (int pass = 1; pass < n; pass++){
                for (int comp = 0; comp < n - pass; comp++){
                    // If the first string is later in the alphabet than second String, switch order
                    if (contacts.get(comp).getLastName().compareTo(contacts.get(comp + 1).getLastName()) > 0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }
            }

        }
        // Sorts by phone number
        else if (sortBy == 2){
            for (int pass = 1; pass < n; pass++){
                for (int comp = 0; comp < n - pass; comp++){
                    // If the first string is later in the alphabet than second String, switch order
                    if (contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber()) > 0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp + 1));
                        contacts.set(comp + 1, temp);
                    }
                }

            }
        }
    }

    /**
     * Uses modified for loop to search list by first name
     */
    public Person searchByFirstName(String firstName){
        for (Person each: contacts){
            if (each.getFirstName().equals(firstName)){
                return each;
            }
        }
        return null;
    }

    /**
     * Uses modified for loop to search list by last name
     */
    public Person searchByLastName(String lastName){
        for (Person each: contacts){
            if (each.getLastName().equals(lastName)){
                return each;
            }
        }
        return null;
    }
    /**
     * Uses modified for loop to search list by phone number
     */
    public Person searchByPhoneNumber(String phoneNumber){
        for (Person each: contacts){
            if (each.getPhoneNumber().equals(phoneNumber)){
                return each;
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (Person each: contacts){
            if (each instanceof Student){
                System.out.println(each);
            }
        }
    }
    /**
     * If the name was found in the list, program prints it.
     * Otherwise, it says that person was not found
     */
    public void present(Person found, String characteristic){
        if (found != null){
            System.out.println(found);
        }
        else{
            System.out.println(characteristic + " is not in the list.");
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        int input = -1;
        // Continues prompting user for input until they enter 0
        while (input != 0){
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome to your Contacts List");
            System.out.println("Please pick from the following menu options");
            printMenuOptions();
            input = s.nextInt();
            if (input == 1){
                addContact();
            }
            if (input == 2){
                sort(0);
                printContacts();
            }
            if (input == 3){
                sort(1);
                printContacts();
            }
            if (input == 4){
                sort(2);
                printContacts();
            }
            if (input == 5){
                listStudents();
            }
            if (input == 6){
                s.nextLine();
                System.out.println("Enter a first name: ");
                String firstName = s.nextLine();
                Person found = searchByFirstName(firstName);
                present(found, firstName);
            }
            if (input == 7){
                s.nextLine();
                System.out.println("Enter a last name: ");
                String lastName = s.nextLine();
                Person found = searchByLastName(lastName);
                present(found, lastName);
            }
            if (input == 8){
                s.nextLine();
                System.out.println("Enter a phone number: ");
                String phoneNumber = s.nextLine();
                Person found = searchByPhoneNumber(phoneNumber);
                present(found, phoneNumber);
            }
        }
    }

    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
