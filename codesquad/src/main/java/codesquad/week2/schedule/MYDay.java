package codesquad.week2.schedule;

public class MYDay {
    private String work; //하루의 할 일을 나타내는 문자열
    private int day;


    public void saveTodayWork(String work) {
        this.work = work;
    }

    public String hasWork() {
        if (work == null) {
            return "없습니다.";
        } else {
            return day + "일의 할 일은" + work + "입니다.";
        }
    }

    public void saveTOday(int nextInt) {
        this.day = nextInt;
    }

    public int getDay() {
        return day;
    }
}

