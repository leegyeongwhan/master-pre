package codesquad.week2.Mission2._2.student;

public class Student {
    private String name;
    private static int hakbun = 1000;
    //private final int HAK_BUN;
    private String major;

    public Student(String[] studentList) {
        this.name = studentList[0];
        //    HAK_BUN = hakbun++;
        this.major = studentList[2];
    }

    public String getName() {
        return name;
    }

    public static int getHakbun() {
        return hakbun;
    }

    public String getMajor() {
        return major;
    }
}
