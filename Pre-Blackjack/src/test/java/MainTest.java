import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class MainTest {

    @Test
    @DisplayName("숫자 카드는 해당 숫자만큼의 점수를 반환한다")
    public void calculateCard_NumberCard_ReturnsOriginalValue() {
        // given
        Card card = new Card(Emblem.SPADE, Rank.TWO);
        int expected = 2;

        // when & then
        Assertions.assertEquals(expected, card.calculateCard());
    }

    @Test
    @DisplayName("10 점수 카드는 10점을 반환한다")
    public void calculateCard_TenCard_ReturnsTen() {
        // given
        Card card = new Card(Emblem.SPADE, Rank.TEN);
        int expected = 10;

        // when & then
        Assertions.assertEquals(expected, card.calculateCard());
    }

    @Test
    @DisplayName("문자 카드(J, Q, K)는 모두 10점을 반환해야 한다")
    public void calculateCard_FaceCards_ReturnsTen() {
        // given
        Card jack = new Card(Emblem.HEART, Rank.JACK);
        Card queen = new Card(Emblem.DIAMOND, Rank.QUEEN);
        Card king = new Card(Emblem.CLOVER, Rank.KING);

        // when & then
        Assertions.assertAll(
                () -> Assertions.assertEquals(10, jack.calculateCard(), "JACK은 10점이어야 합니다."),
                () -> Assertions.assertEquals(10, queen.calculateCard(), "QUEEN은 10점이어야 합니다."),
                () -> Assertions.assertEquals(10, king.calculateCard(), "KING은 10점이어야 합니다.")
        );
    }

    @Test
    @DisplayName("Rank 상수를 통해 점수 값을 올바르게 조회할 수 있다")
    public void from_ValidRank_ReturnsCorrectValue() {
        // given
        int expect = 10;

        // when & then
        Assertions.assertEquals(expect, Rank.from(Rank.TEN));
    }


    // 실험 2: 테스트 코드 작성

    // 1. 테스트를 작성하기 어려운 코드 1곳
    // 대상: Rank 클래스의 public static int from(Rank rank) 메서드

    // 2. 관찰 기록
    // 사실: getter 사용 지양 원칙을 준수하려다 보니, Rank의 값을 가져오기 위해 자기 자신을 파라미터로 받아 for문을 돌며 값을 찾는 정적 메서드를 구현하게 되었다.
    // 문제: 단순한 점수 확인을 위해 불필요하게 복잡한 조회 로직을 거쳐야 하며, 이는 테스트의 직관성을 떨어뜨린다. 또한 객체의 자율성을 지키려다 내부 구현(루프 로직)이 비대해지는 결과가 초래되었다.

    // 3. 바꾸고 싶은 부분과 이유
    // 바꾸고 싶은 부분: Rank Enum에 불변 데이터인 점수를 반환하는 getValue()를 추가하고, Card가 이를 직접 활용하도록 변경하고 싶다
    // 이유: 트럼프 카드의 점수는 변하지 않는 고정 상수다. 무조건적인 getter 배제보다는 '값이 변하지 않는 데이터'에 대해 조회를 허용하되, 이 값을 외부에서 가져와 계산하지 않고 객체 내부에서 처리하도록(Tell, Don't Ask) 설계하는 것이 테스트와 유지보수 측면에서 더 유리하기 때문이다.

}
