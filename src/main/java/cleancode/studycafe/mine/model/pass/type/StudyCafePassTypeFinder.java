package cleancode.studycafe.mine.model.pass.type;

import cleancode.studycafe.mine.exception.AppException;

public class StudyCafePassTypeFinder {

    private StudyCafePassTypeFinder() {
    }

    public static StudyCafePassType findPassType(String userInput) {
        if ("1".equals(userInput)) {
            return StudyCafePassType.HOURLY;
        }
        if ("2".equals(userInput)) {
            return StudyCafePassType.WEEKLY;
        }
        if ("3".equals(userInput)) {
            return StudyCafePassType.FIXED;
        }
        throw new AppException("잘못된 입력입니다.");
    }
}
