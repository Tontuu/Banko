import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    public static enum Screen {
	MAIN,
	DEPOSIT,
	WITHDRAW,
	OPTIONS,
	CHANGE_NAME,
	CHANGE_NATIONALITY,
	EXIT
    }
    private Screen screen = Screen.MAIN;
    private boolean printException = false;

    User user = new User("Ton", "Brazil");

    public Screen getScreen() {
	return this.screen;
    }

    public void setScreen(Screen screen) {
	this.screen = screen;
    }


    public void getInput() {
	try {
	    if (getScreen() == Screen.MAIN) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		if (input == 1) {
		    setScreen(Screen.DEPOSIT);
		} else if (input == 2) {
		    setScreen(Screen.WITHDRAW);
		} else if (input == 3) {
		    setScreen(Screen.OPTIONS);
		} else if (input == 4) {
		    setScreen(Screen.EXIT);
		} else {
		    printException = true;
		}
		
	    } else if (getScreen() == Screen.DEPOSIT) {
		Scanner scanner = new Scanner(System.in);
		String amount = scanner.nextLine();

		user.deposit(amount);
		setScreen(Screen.MAIN);
	    } else if (getScreen() == Screen.WITHDRAW) {
		Scanner scanner = new Scanner(System.in);
		String amount = scanner.nextLine();

		user.withdraw(amount);
		setScreen(Screen.MAIN);
	    } else if (getScreen() == Screen.OPTIONS) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		if (input == 1) {
		    setScreen(Screen.CHANGE_NAME);
		} else if (input == 2) {
		    setScreen(Screen.CHANGE_NATIONALITY);
		} else if (input == 3) {
		    setScreen(Screen.MAIN);
		} else {
		    printException = true;
		}
	    } else if (getScreen() == Screen.CHANGE_NAME) {
		Scanner scanner = new Scanner(System.in);
		String input_name = scanner.nextLine();

		user.setName(input_name);
		setScreen(Screen.MAIN);
	    } else if (getScreen() == Screen.CHANGE_NATIONALITY) {
		Scanner scanner = new Scanner(System.in);
		String input_nationality = scanner.nextLine();

		user.setNationality(input_nationality);
		setScreen(Screen.MAIN);
	    }
	} catch (NumberFormatException | InputMismatchException e) {
	    printException = true;
	} 


    }

    public void print() {
	if (printException) {
	    System.out.println("Invalid option, choose again.");
	    System.out.println("-----------");
	    printException = false;
	} else {
	    System.out.println(user.getName() + " - " + user.getNationality());
	    System.out.println("Balance: $" + user.getMoney());
	    System.out.println("-----------");
	}
	if (getScreen() == Screen.MAIN) {
	    System.out.println("Deposit [1]");
	    System.out.println("Withdraw [2]");
	    System.out.println("Options [3]");
	    System.out.println("Exit [4]");
	    System.out.println("-----------");
	    System.out.print("Option: ");
	}

	if (getScreen() == Screen.DEPOSIT) {
	    System.out.println("DEPOSIT");
	    System.out.println("-----------");
	    System.out.print("Deposit amount: ");
	}

	if (getScreen() == Screen.WITHDRAW) {
	    System.out.println("WITHDRAW");
	    System.out.println("-----------");
	    System.out.print("Withdraw amount: ");
	}

	if (getScreen() == Screen.OPTIONS) {
	    System.out.println("OPTIONS");
	    System.out.println("-----------");
	    System.out.println("Change name [1]");
	    System.out.println("Change nationality [2]");
	    System.out.println("Cancel [3]");
	    System.out.println("-----------");
	    System.out.print("Option: ");
	}

	if (getScreen() == Screen.CHANGE_NAME) {
	    System.out.println("Change name");
	    System.out.println("-----------");
	    System.out.println("Old name: " + user.getName());
	    System.out.print("New name: ");
	}

	if (getScreen() == Screen.CHANGE_NATIONALITY) {
	    System.out.println("Change nationality");
	    System.out.println("-----------");
	    System.out.println("Old nationality: " + user.getNationality());
	    System.out.print("New nationality: ");
	}
    }
}
