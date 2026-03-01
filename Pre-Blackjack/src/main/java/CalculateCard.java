import java.util.List;

public class CalculateCard {
    public static void main(String[] args) {
        CalculateCard c = new CalculateCard();
        System.out.println(c.calculateStringCard("1"));
        System.out.println(c.calculateStringCard("J"));
        System.out.println(c.calculateStringCard("Q"));
        //System.out.println(c.calculateStringCard("D"));
        //System.out.println(c.calculateStringCard("11"));
        System.out.println(c.calculateStringCard("-1"));
    }

    public int calculateStringCard(String card) {
        if (judgeCard(card))
            return 10;

        try {
            int value = Integer.parseInt(card);
            if (value < 1 || value > 10) {
                throw new IllegalArgumentException("숫자 카드의 범위는 1 ~ 10 사이여야 합니다.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("옳바르지 않은 카드 입니다 : " + card);
        }
    }

    public boolean judgeCard(String card) {
        List<String> charCard = List.of("J", "Q", "K");
        return charCard.contains(card);
    }
}
