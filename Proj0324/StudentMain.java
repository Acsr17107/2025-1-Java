package proj0324;

interface PrintInterface {
    void print();
}

public class StudentMain {

    public static void main(String[] args) {
        // Student ��ü ����
        Student s1 = new Student("������", "��õ��", "010-1234-5678", "20242785", "�ΰ����ɼ���Ʈ�����а�");
        Student s2 = new Student("����ȯ", "����", "010-1234-5679", "20249999", "��ǻ�ͼ���Ʈ�����а�");

        // PrintInterface ����
        PrintInterface object1 = new PrintInterface() {
            @Override
            public void print() {
                // �л� ������ ���
                s1.print();
                System.out.println();
                s2.print();
            }
        };

        // print() ȣ��
        object1.print();
    }
}
