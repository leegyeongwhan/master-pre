package codesquad.week2.Mission2._2;

import codesquad.week2.Mission2._2.reader.FileReader;
import codesquad.week2.Mission2._2.record.Record;
import codesquad.week2.Mission2._2.record.RecordService;
import codesquad.week2.Mission2._2.sebject.Subject;
import codesquad.week2.Mission2._2.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public void start() {
        List<String> fileList = getList();
        inputRecord(fileList);
    }

    private void inputRecord(List<String> fileList) {
        int recordSize = getRecordSize(fileList);
        RecordService recordService = getRecordService();

        for (int i = 0; i < recordSize; i++) {
            //input suduent ,subject
            String[] splits = fileList.get(i).split(" ");
            String[] studentList = {splits[0], splits[1], splits[2]};
            String[] subjectList = removeSplits(splits, 2);
            Student student = new Student(studentList);
            Subject subject = new Subject(subjectList);
            recordService.print(student, subject);
        }
    }

    private List<String> getList() {
        FileReader reader = new FileReader();
        List<String> fileList = reader.recordReader();
        return fileList;
    }

    private RecordService getRecordService() {
        Record record = new Record();
        RecordService recordService = record.recordService();
        return recordService;
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
