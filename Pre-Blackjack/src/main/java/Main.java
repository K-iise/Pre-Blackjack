public class Main {
    public static void main(String[] args) {
        // 케이스 1: 스페이드 2 카드
        Card c1 = new Card(Emblem.SPADE, Rank.TWO);
        System.out.println("Test 1: " + (c1.calculateCard() == 2));

        // 케이스 2: 하트 J 카드
        Card c2 = new Card(Emblem.HEART, Rank.JACK);
        System.out.println("Test 2: " + (c2.calculateCard() == 10));

        // 케이스 3: 다이아몬드 5 카드
        Card c3 = new Card(Emblem.DIAMOND, Rank.FIVE);
        System.out.println("Test 3: " + (c3.calculateCard() == 5));

        // 케이스 4: 클로버 Q 카드
        Card c4 = new Card(Emblem.CLOVER, Rank.QUEEN);
        System.out.println("Test 4 : " + (c4.calculateCard() == 10));

        // 케이스 5: 스페이드 10 카드
        Card c5 = new Card(Emblem.SPADE, Rank.TEN);
        System.out.println("Test 5 : " + (c5.calculateCard() == 10));

        // 케이스 6: 하트 K 카드
        Card c6 = new Card(Emblem.HEART, Rank.KING);
        System.out.println("Test 6 : " + (c6.calculateCard() == 11));
    }

    // 실험 1: main 기반 검증의 한계

    // 1. 관찰 포인트
    // Q. 케이스가 늘어나니 어디를 수정해야 했는가?
    // 사실: 케이스를 6개로 늘리기 위해 main 메서드 안에서 Card 객체 생성 코드와 System.out.println 출력문을 각각 6번 작성해야 했다.
    // 테스트 케이스 하나를 추가할 때마다 실행 로직과 출력 로직을 매번 수동으로 추가해야 하므로 코드가 비대해지고 관리가 어려워진다.

    // Q. 수정하면서 놓친 것은 없는가?
    // 테스트 케이스를 수동으로 늘리다 보니(복사 붙여넣기),
    // 사실: 기존 코드를 복사해서 붙여넣는 과정에서 대상 객체(예: K 카드)와 기대값(예: 10점)을 매칭할 때 수동으로 값을 입력했다.
    // 문제: 복사 붙여넣기 시 실수로 기대값을 잘못 입력하면(예: K인데 11로 입력), 로직이 맞더라도 테스트 자체가 틀려버리는 '휴먼 에러'를 잡아낼 방법이 없다.

    // Q. 이전 케이스가 여전히 동작하는지 어떻게 확인했는가?
    // 사실: 새로운 테스트(Test 6)를 추가한 뒤, 이전 1~5번 케이스가 여전히 통과하는지 확인하기 위해 콘솔 창의 출력 결과(True/False)를 일일이 눈으로 읽어야 했다.
    // 문제: 케이스가 수십 개로 늘어날 경우, 중간에 단 하나의 False가 섞여 있어도 사람이 눈으로 발견하지 못하고 지나칠 위험이 매우 크다.


}
