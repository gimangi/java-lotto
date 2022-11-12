package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import config.ErrorConstants;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_NUMBERS_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException(ErrorConstants.INVALID_RANGE);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean[] used = new boolean[46];
        for (int n : numbers) {
            if (used[n]) {
                throw new IllegalArgumentException(ErrorConstants.HAVE_DUPLICATION);
            }
            used[n] = true;
        }
    }

}
