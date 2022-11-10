package codesquad.week2.Mission2._2;

import codesquad.week2.Mission2._2.sebject.Subject;
import codesquad.week2.Mission2._2.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public void start() {
        FileReader reader = new FileReader();
        List<String> fileList = reader.recordReader();
        int recordSize = getRecordSize(fileList);

        Record record = new Record();
        RecordService recordService = record.recordService();
        for (int i = 0; i < recordSize; i++) {
            String[] splits = fileList.get(i).split(" ");
            String[] studentList = {splits[0], splits[1], splits[2]};
            String[] subjectList = removeSplits(splits, 2);
            Student student = new Student(studentList);
            Subject subject = new Subject(subjectList);
            recordService.print(student, subject);
        }
    }

    private String[] removeSplits(String[] arr, int indx) {
        List<String> result = new ArrayList<>(Arrays.asList(arr));
        for (int i = 0; i <= indx; i++) {
            result.remove(0);
        }
        return result.toArray(new String[0]);
    }


    private int getRecordSize(List<String> fileList) {
        int recordSize = 0;
        for (String s : fileList) {
            recordSize++;
        }
        return recordSize;
    }
}
