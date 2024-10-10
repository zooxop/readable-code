package cleancode.studycafe.mine.model.pass.type;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석"),
    NONE("데이터 없음"),
    ;
    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

}
