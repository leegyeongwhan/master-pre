package codesquad.week2.Mission2._2.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader {
    //파일 한 번에 읽기
    @Override
    public List<String> recordReader() {
        //파일 객체 생성
        Path path = Paths.get("C:\\Users\\leekh\\IdeaProjects\\master-pre\\codesquad\\src\\main\\java\\codesquad\\week2\\Mission2\\_2\\input.txt");
        // 캐릭터셋 지정
        Charset cs = StandardCharsets.UTF_8;
        //파일 내용담을 리스트
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(path, cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
