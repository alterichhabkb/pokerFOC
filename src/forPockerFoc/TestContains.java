package forPockerFoc;

public class TestContains {

	public static void main(String[] args) {
		Player p1 = new Player(1,"Person01", 2500, "p1");
		Player p2 = new Player(1,"Person02", 2500, "p2");
		
		MainWindow.setOtherPlayer01("Name: " + p1.getName() + "\n" + "Score: " + p1.getChipNumber() + "\n");
		System.out.println(MainWindow.otherPlayer01.getText());
		
		MainWindow.setOtherPlayer02("Name: " + p2.getName() + "\n" + "Score: " + p2.getChipNumber() + "\n");
		System.out.println(MainWindow.otherPlayer02.getText());

	}

}
