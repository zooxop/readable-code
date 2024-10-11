package cleancode.studycafe.mine.studycafe.parse;

public interface FileParser<T> {
    T parse(String[] values);
}
