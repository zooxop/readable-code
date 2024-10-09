package cleancode.studycafe.mine.io.parse;

public interface FileParser<T> {
    T parse(String[] values);
}
