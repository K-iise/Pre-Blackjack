public class Card {
    private final Emblem emblem;
    private final Rank rank;

    public Card(Emblem emblem, Rank rank) {
        this.emblem = emblem;
        this.rank = rank;
    }

    public int calculateCard() {
        return Rank.from(this.rank);
    }

}
