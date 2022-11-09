package codesquad.week2.endtoend.gameReader;

import codesquad.week2.endtoend.member.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerReaderImpl implements GameReader {
    final static String START_WORD = "기러기";
    static List<Member> members = new ArrayList<>();

    @Override
    public void GameReader() {
        startGamePrint();
        int memberNumber = getMemberNumber(scan());
        inputGameMember(memberNumber, members);
        startWordPrint();
    }

    public String getStartWord() {
        return START_WORD;
    }

    public static List<Member> getMembers() {
        return members;
    }

    public Scanner scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }


    private void inputGameMember(int memberNumber, List<Member> members) {
        for (int i = 0; i < memberNumber; i++) {
            System.out.print("참가자 이름을 입력해주세요. >> ");
            String gameMember = scan().next();
            Member member = new Member(gameMember);
            members.add(member);
        }
    }

    private void startGamePrint() {
        System.out.println("끝말잇기 게임을 시작합니다!! ");
        System.out.print("게임에 참여하는 인원은 몇명입니까>> ");
    }

    private void startWordPrint() {
        System.out.println("시작 단어는" + START_WORD + " 입니다");
    }

    private int getMemberNumber(Scanner scanner) {
        int memberNumber = scanner.nextInt();
        return memberNumber;
    }
}
