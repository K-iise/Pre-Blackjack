import java.util.List;

public class CalculateCard {
    public static void main(String[] args) {
        CalculateCard c = new CalculateCard();
        System.out.println(c.calculateStringCard("1"));
        System.out.println(c.calculateStringCard("J"));
        System.out.println(c.calculateStringCard("Q"));
    }

    public int calculateStringCard(String card) {
        if (judgeCard(card))
            return 10;
        return Integer.parseInt(card);
    }

    public boolean judgeCard(String card) {
        List<String> charCard = List.of("J", "Q", "K");
        return charCard.contains(card);
    }
}
