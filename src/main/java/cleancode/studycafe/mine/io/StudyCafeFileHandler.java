package cleancode.studycafe.mine.io;

import cleancode.studycafe.mine.io.parse.FileParser;
import cleancode.studycafe.mine.io.parse.StudyCafeLockerPassParser;
import cleancode.studycafe.mine.io.parse.StudyCafePassParser;
import cleancode.studycafe.mine.model.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.pass.StudyCafePass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler implements FileHandler {

    private static final String PASS_LIST_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private static final String LOCKER_LIST_PATH = "src/main/resources/cleancode/studycafe/locker.csv";

    @Override
    public List<StudyCafePass> readStudyCafePasses() {
        FileParser<StudyCafePass> studyCafePassFileParser = new StudyCafePassParser();
        return readFromFileAndParse(PASS_LIST_PATH, studyCafePassFileParser);
    }

    @Override
    public List<StudyCafeLockerPass> readLockerPasses() {
        FileParser<StudyCafeLockerPass> studyCafeLockerPassFileParser = new StudyCafeLockerPassParser();
        return readFromFileAndParse(LOCKER_LIST_PATH, studyCafeLockerPassFileParser);
    }

    private <T> List<T> readFromFileAndParse(String filePath, FileParser<T> parser) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<T> result = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                result.add(parser.parse(values));
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
