package codesquad.week2.endtoend.game;

import codesquad.week2.endtoend.gameReader.ScannerReaderImpl;
import codesquad.week2.endtoend.member.Member;

import java.util.List;

public class PlayGame {
    static ScannerReaderImpl scannerReader;

    public void play() {
        scannerReader = new ScannerReaderImpl();
        scannerReader.GameReader();
        List<Member> members = scannerReader.getMembers();
        memberGetWord(members);
    }

    private void memberGetWord(List<Member> members) {
        String startWord = scannerReader.getStartWord();
        while (true) {
            for (int i = 0; i < members.size(); i++) {
                System.out.print(members.get(i).getName() + ">>");
                String sccanWord = scannerReader.scan().next();
                members.get(i).setWord(sccanWord);
                String word = members.get(i).getWord();

                if (startWord.charAt(startWord.length() - 1) == word.charAt(0)) {
                    startWord = word;
                    continue;
                }else {
                    System.out.println(members.get(i).getName() + "이 졌습니다");
                    System.exit(0);
                }

            }
        }
    }

}
