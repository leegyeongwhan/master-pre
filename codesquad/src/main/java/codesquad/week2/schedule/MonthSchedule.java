package codesquad.week2.schedule;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 이번달 스케쥴 관리 프로그램.
 * 할일(입력:1, 보기:2, 끝내기:3) >>1
 * 날짜(1~30)?1
 * 할일(빈칸없이입력)?자바공부
 * <p>
 * 할일(입력:1, 보기:2, 끝내기:3) >>2
 * 날짜(1~30)?1
 * 1일의 할 일은 자바공부입니다.
 * <p>
 * 할일(입력:1, 보기:2, 끝내기:3) >>3
 * 프로그램을 종료합니다.
 */
public class MonthSchedule {

    public static void main(String[] args) {
        System.out.println("이번달 스케쥴 관리 프로그램.");
        Scanner scanner = new Scanner(System.in);
        scheduleStart(scanner);
    }

    private static void scheduleStart(Scanner scanner) {
        List<MYDay> schedule = new ArrayList<>();

        while (true) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    dayToDo(scanner, schedule);
                    break;
                case 2:
                    daySearch(scanner, schedule);
                    break;
                case 3:
                    System.out.println("프로그램 종료");
                    System.exit(0);
            }
        }
    }

    private static void daySearch(Scanner scanner, List<MYDay> schedule) {
        System.out.print("날짜(1~30)?");
        int day = scanner.nextInt();

        for (MYDay date : schedule) {
            if (date.getDay() == day) {
                System.out.println(date.hasWork());
            }
        }
    }

    private static void dayToDo(Scanner scanner, List<MYDay> schedule) {
        MYDay myDay = new MYDay();
        System.out.print("날짜(1~30)?");
        myDay.saveTOday(scanner.nextInt());
        System.out.print("할일(빈칸없이입력)?");
        myDay.saveTodayWork(scanner.next());
        schedule.add(myDay);
    }
}
