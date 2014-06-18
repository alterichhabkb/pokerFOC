package valueObjects;

public class CardsTest {

	public static void main(String[] args) {
	
		Cards c = Cards.getKarte();
		System.out.println(c.name());
		System.out.println(c.getCard().getRank());
		System.out.println(c.getCard().getSuit());
		System.out.println(c.getCard().getValue());
		System.out.println(c.getImage());
		System.out.println("/n");
		Cards g = Cards.getKarte();
		System.out.println(g.name());
		System.out.println(g.getCard().getRank());
		System.out.println(g.getCard().getSuit());
		System.out.println(g.getCard().getValue());
		System.out.println(g.getImage());

	}

}
