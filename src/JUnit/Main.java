package JUnit;

public class Main {
    public static void main(String[] args) {
        new User("�������", 35, Sex.MALE);
        new User("������", 34, Sex.FEMALE);
        new User("�����", 7, Sex.FEMALE);


        System.out.println("��� ������������:");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("��� ������������: MALE");
        User.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("��� ������������: FEMALE");
        User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("================================================");
        System.out.println("���� �������������: " + User.getHowManyUsers());
        System.out.println("���� ������������� MALE: " + User.getHowManyUsers(Sex.MALE));
        System.out.println("���� ������������� FEMALE: " + User.getHowManyUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("����� ������� ���� �������������: " + User.getAllAgeUsers());
        System.out.println("����� ������� ���� ������������� MALE: " + User.getAllAgeUsers(Sex.MALE));
        System.out.println("����� ������� ���� ������������� FEMALE: " + User.getAllAgeUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("������� ������� ���� �������������: " + User.getAverageAgeOfAllUsers());
        System.out.println("������� ������� ���� ������������� MALE: " + User.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("������� ������� ���� ������������� FEMALE: " + User.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("================================================");
    }
}
