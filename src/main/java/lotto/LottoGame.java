package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class LottoGame {
    public void start() {
        OutputView.print(Message.PAYMENT_REQUEST);
        OutputView.print(Message.LINE_BREAK);

        String money = InputView.read();
        validateNumber(money);

    }

    public void validateNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
        }
    }

    public void validateMultiple(String input) {
        if (Stream.of(input)
                .map(Integer::parseInt)
                .anyMatch(number -> number % 1000 != 0)) {
            throw new IllegalArgumentException("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}

class OutputView {
    public static void print(String message) {
        System.out.print(message);
    }
}

class InputView {
    public static String read() {
        return Console.readLine();
    }
}


class Message {
    public static String PAYMENT_REQUEST = "구입금액을 입력해 주세요.";
    public static String PAYMENT_COMPLETE = "개를 구매했습니다.";
    public static String WINNING_NUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    public static String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";
    public static String WINNING_STATISTICS_RESULT = "당첨 통계";
    public static String DIVIDING_LINE = "-";
    public static String MATCH = "일치";
    public static String LEFT_PARENTHESIS = "(";
    public static String RIGHT_PARENTHESIS = ")";
    public static String WON = "원";
    public static String COUNT = "개";
    public static String COMMA = ",";
    public static String SPACE = " ";
    public static String TOTAL_RETURN = "총 수익률은";
    public static String PERCENT_SIGN = "%";
    public static String END_EXPLAINE = "입니다.";
    public static String LINE_BREAK = "\n";
}
