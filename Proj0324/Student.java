package proj0324;

public class Student extends Person {
    // 1. 속성
    private String stdId;
    private String jeongong;

    // 2. 생성자
    Student() {}
    Student(String name, String addr, String phone, String stdId, String jeongong) {
        super(name, addr, phone);
        this.stdId = stdId;
        this.jeongong = jeongong;
    }

    // 3. 메소드
    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getJeongong() {
        return jeongong;
    }

    public void setJeongong(String jeongong) {
        this.jeongong = jeongong;
    }

    // print() 메소드 구현
    public void print() {
        System.out.println("이름: " + getName());
        System.out.println("주소: " + getAddr());
        System.out.println("전화번호: " + getPhone());
        System.out.println("학번: " + stdId);
        System.out.println("전공: " + jeongong);
    }
}
