import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;

public class CalculateCardTest {

    @Test
    public void 숫자_카드_판정_테스트(){
        // given
        CalculateCard calculateCard = new CalculateCard();
        String card = "3";

        // when & then
        Assertions.assertFalse(calculateCard.judgeCard(card));
    }

    @Test
    public void 문자_카드_판정_테스트(){
        // given
        CalculateCard calculateCard = new CalculateCard();
        String card = "J";

        // when & then
        Assertions.assertTrue(calculateCard.judgeCard(card));
    }

    @Test
    public void 문자_카드_점수_계산_테스트(){
        // given
        CalculateCard calculateCard = new CalculateCard();
        String literalCard = "J";
        int expect = 10;

        // when
        int result = calculateCard.calculateCard(literalCard);

        // then
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void 숫자_카드_점수_계산_테스트(){
        // given
        CalculateCard calculateCard = new CalculateCard();
        String numberCard = "4";
        int expect = 4;

        // when
        int result = calculateCard.calculateCard(numberCard);

        // then
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void 숫자_카드_범위_예외_테스트(){
        // given
        CalculateCard calculateCard = new CalculateCard();
        String numberCard = "11";

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> calculateCard.calculateCard(numberCard));
    }

}
