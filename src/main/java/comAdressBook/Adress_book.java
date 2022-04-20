package comAdressBook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Adress_book {
	private ArrayList<Contact_Info> contactBook = new ArrayList<Contact_Info>();
	Scanner sc = new Scanner(System.in);
	private static int numberOfConatcts = 0;

	public Adress_book() {
		// TODO Auto-generated constructor stub
	}

	public void contactAdd() {
		System.out.println("Enter Person details:");

		Contact_Info person = details();
		boolean isDuplicate = contactBook.stream().anyMatch(new Predicate<Contact_Info>() {
			public boolean test(Contact_Info contact) {
				return contact.equals(person);
			}
		});
		if (isDuplicate) {
			System.out.println("Duplicate data entry. discarded");
		} else {
			contactBook.add(person);
		}
	}

	public void edit() {
		System.out.println("enter the name to edit contact details");
		String name = sc.next();
		System.out.println("enter the choice to edit details");
		System.out.println("1.First Name\\n2.Last Name\\n3.City\\n4.State\\n5.Zip Code\\n6.Phone\\n7.Email");
		int choice = sc.nextInt();
		int index = 0;
		for (index = 0; index < numberOfConatcts; index++)
			if (name.equals(contactBook.get(index).getFirstName())) {
				System.out.println("name exists , now enter the new details");
				switch (choice) {
				case 1:
					System.out.println("Enter new First Name");
					String newFirstName = sc.next();
					contactBook.get(index).setFirstName(newFirstName);
					break;
				case 2:
					System.out.println("Enter new Last Name");
					String newLastName = sc.next();
					contactBook.get(index).setLastName(newLastName);
					break;
				case 3:
					System.out.println("Enter new City");
					String newCity = sc.next();
					contactBook.get(index).setCity(newCity);
					break;
				case 4:
					System.out.println("Enter new State");
					String newState = sc.next();
					contactBook.get(index).setState(newState);
					break;
				case 5:
					System.out.println("Enter new State");
					int newZip = sc.nextInt();
					contactBook.get(index).setZip(newZip);
					break;
				case 6:
					System.out.println("Enter new Phone Number");
					int newPNumber = sc.nextInt();
					contactBook.get(index).setPhoneNumber(newPNumber);
					break;
				case 7:
					System.out.println("Enter new Email");
					String newEmail = sc.next();
					contactBook.get(index).setEmail(newEmail);
					break;
				}

			} else {
				System.out.println("No contact found");
			}
	}

	public void delete() {
		int index;
		System.out.println("Enter the name of the contact to delete");
		String name = sc.next();
		for (index = 0; index < numberOfConatcts; index++)
			if (contactBook.get(index).getFirstName().equals(name)) {
				break;
			}
		while (!contactBook.get(index + 1).equals(null)) {
			contactBook.set(index, contactBook.get(index + 1));
			index++;
		}
		contactBook.set(index, null);
		System.out.println("Deleted details of : " + name);
	}

	public void display() {
		Contact_Info person;
		System.out.println("Enter name to see details");
		String name = sc.next();

		for (int i = 0; i < contactBook.size(); i++) {
			if (contactBook.get(i).getFirstName().equals(name)) {
				person = contactBook.get(i);
				System.out.println(person);
			}
		}
	}

	private static Contact_Info details() {
		try (Scanner sc = new Scanner(System.in)) {
			Contact_Info person1 = new Contact_Info();

			System.out.println("Enter firstName:");
			person1.setFirstName(sc.next());
			System.out.println("Enter SecondName:");
			person1.setLastName(sc.next());
			System.out.println("Enter Address:");
			person1.setAddress(sc.next());
			System.out.println("Enter City:");
			person1.setCity(sc.next());
			System.out.println("Enter State:");
			person1.setState(sc.next());
			System.out.println("Enter Pin code:");
			person1.setZip(sc.nextInt());
			System.out.println("Enter Phone number:");
			person1.setPhoneNumber(sc.nextInt());
			System.out.println("Enter email:");
			person1.setEmail(sc.next());
			return person1;
		}
	}

}