package views;

public class BaseView {
	MenuView mv = new MenuView();
	
	public void printMenuView() {
		mv.printHeader();
		mv.menuSelection();
	}
	
}