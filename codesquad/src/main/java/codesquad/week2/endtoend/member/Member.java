package codesquad.week2.endtoend.member;

public class Member {
    private String word;
    private String name;

    public String getWord() {
        return word;
    }

    public String getName() {
        return name;
    }

    public Member(String gameMember) {
        this.name = gameMember;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
