package comAdressBook;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Adress_book {
	
	static Scanner sc = new Scanner(System.in);
    static List<Contact_Info> list = new LinkedList<Contact_Info>();

	public static void contactAdd() {

		System.out.println("Enter your firstName : ");
        String firstName = sc.nextLine();
        System.out.println("Enter your lastName : ");
        String lastName = sc.nextLine();
        System.out.println("Enter your address : ");
        String address = sc.nextLine();
        System.out.println("Enter your city : ");
        String city = sc.nextLine();
        System.out.println("Enter your state : ");
        String state = sc.nextLine();
        System.out.println("Enter your pin : ");
        String pin = sc.nextLine();
        System.out.println("Enter your MobileNo : ");
        String MobileNo = sc.nextLine();
        System.out.println("Enter your email : ");
        String email = sc.nextLine();
        Contact_Info obj = new Contact_Info(firstName, lastName, city, state, pin, MobileNo, email);
        list.add(obj);

	}

	
	
	public static void contactEdit()
    {
        
        System.out.println("Enter first name for confirmation : ");
        String Name = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equalsIgnoreCase(Name))
            {
                list.remove(i);
                contactAdd();
                System.out.println("Successfully Edit data");
            }
            else {
                System.out.println("No data found in Address Book");
            }
        }
    }

	public static void main(String[] args) {

		Adress_book ad = new Adress_book ();
		System.out.println("Welcome to AddressBook");
        
        System.out.println("Enter details of new contact");
        contactAdd();
        
        contactEdit();

        System.out.println(list);
	}
}