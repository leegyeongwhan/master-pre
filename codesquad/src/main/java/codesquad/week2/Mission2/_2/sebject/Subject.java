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

    public String getGuk() {
        return guk;
    }

    public String getEng() {
        return eng;
    }

    public int getSubjectCnt() {
        for (int i = 0; i < subjects.length; i++) {
            if (Integer.parseInt(subjects[i]) == 0) {
                subjectCnt--;
            }
            subjectCnt++;
        }
        return subjectCnt;
    }

    public String[] getSubjects() {

        return subjects;
    }

    public String getMath() {
        return math;
    }
}
