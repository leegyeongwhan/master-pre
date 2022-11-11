package codesquad.week2.Mission2._2.sebject;

import java.util.Arrays;

public class Subject {

    private String guk;
    private String eng;
    private String math;
    private String[] subjects;
    private int subjectCnt;

    private Subject(String guk, String eng, String math) {
        this.guk = guk;
        this.eng = eng;
        this.math = math;
    }

    public Subject(String[] subjectList) {
        this(subjectList[0], subjectList[1], subjectList[2]);
        this.subjects = subjectList;
        this.subjectCnt = subjectList.length;
    }

    public String[] getSubjects() {
        return subjects;
    }
}
