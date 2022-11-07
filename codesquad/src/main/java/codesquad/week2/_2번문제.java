package codesquad.week2;

public class _2번문제 {
    public static void main(String[] args) {
        Book[] Abooks = new Book[6];
        Abooks[0] = new Book("태백산맥", "조정래");
        Abooks[1] = new Book("이기적 유전자", "리처드 도킨즈");
        Abooks[2] = new Book("자전거 도둑", "박완서");
        Abooks[3] = new Book("토지", "박경리");
        Abooks[4] = new Book("대변동", "제레드 다이아몬드");

        Book[] A_1books = Abooks.clone();//깊은복사

        Book[] Bbooks = Abooks.clone(); //깊은복사
        Bbooks[5] = new Book("사피엔스", "유발 하라리");
//
        Abooks[2] = new Book("그 많던 싱아는 누가 다 먹었을까", "박완서");

        System.out.println("Abooks");
        for (Book Abook : Abooks) {
            System.out.println(Abook);
        }

        System.out.println();
        System.out.println("a_1book");
        for (Book a_1book : A_1books) {
            System.out.println(a_1book);
        }
//
        System.out.println();
        System.out.println("bbook");
        for (Book bbook : Bbooks) {
            System.out.println(bbook);
        }

    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

