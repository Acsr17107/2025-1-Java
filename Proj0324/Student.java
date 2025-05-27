package proj0324;

public class Student extends Person {
    // 1. �Ӽ�
    private String stdId;
    private String jeongong;

    // 2. ������
    Student() {}
    Student(String name, String addr, String phone, String stdId, String jeongong) {
        super(name, addr, phone);
        this.stdId = stdId;
        this.jeongong = jeongong;
    }

    // 3. �޼ҵ�
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

    // print() �޼ҵ� ����
    public void print() {
        System.out.println("�̸�: " + getName());
        System.out.println("�ּ�: " + getAddr());
        System.out.println("��ȭ��ȣ: " + getPhone());
        System.out.println("�й�: " + stdId);
        System.out.println("����: " + jeongong);
    }
}
