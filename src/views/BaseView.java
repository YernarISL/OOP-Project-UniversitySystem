package views;
import java.util.Scanner;

public class BaseView {
	Scanner in = new Scanner(System.in);
	RegistryView rv = new RegistryView();
	MenuView mv = new MenuView();
	
	public void printMenuView() {
		mv.printHeader();
		mv.menuSelection();
		mv.selectMenuAction();
	}
	
}