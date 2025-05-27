package proj0324;

interface PrintInterface {
    void print();
}

public class StudentMain {

    public static void main(String[] args) {
        // Student 객체 생성
        Student s1 = new Student("윤도현", "양천구", "010-1234-5678", "20242785", "인공지능소프트웨어학과");
        Student s2 = new Student("신지환", "서울", "010-1234-5679", "20249999", "컴퓨터소프트웨어학과");

        // PrintInterface 구현
        PrintInterface object1 = new PrintInterface() {
            @Override
            public void print() {
                // 학생 정보를 출력
                s1.print();
                System.out.println();
                s2.print();
            }
        };

        // print() 호출
        object1.print();
    }
}
