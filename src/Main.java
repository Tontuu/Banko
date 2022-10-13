public class Main {
    public static void main(String[] args) {
	Menu menu = new Menu();

	while (menu.getScreen() != Menu.Screen.EXIT) {
	    System.out.print("\033\143");
	    menu.print();
	    menu.getInput();
	}
    }
}
