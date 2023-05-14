package JUnit;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private static Map<Integer, User> allUsers = new HashMap<>();
    private static int countId = 0;
    private int id;
    private String name;
    private int age;
    private Sex sex;


    //список всех пользователей
    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    //список всех пользователей определенного пола
    public static List<User> getAllUsers(Sex sex) {
        return allUsers.values().stream().filter(x -> x.getSex().equals(sex)).collect(Collectors.toList());
    }

    //кол-во всех юзеров
    public static int getHowManyUsers() {
        return allUsers.size();
    }

    //кол-во юзерова определенного пола
    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    //сумма возрастов всех пользователей
    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.getAge();
        }
        return countAge;
    }

    //сумма возрастов всех пользователей определенного пола
    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (User user : getAllUsers(sex)){
            countAge += user.getAge();
        }
        return countAge;
    }

    //средний возраст всех пользователей
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    //средний возраст пользователей определенного пола
    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }


    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            init();
        }
    }

    public User() {
        init();
    }

    private void init() {
        if (!allUsers.containsValue(this)) {
            countId++;
            this.id = countId;
            allUsers.put(countId, this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && name.equals(user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
