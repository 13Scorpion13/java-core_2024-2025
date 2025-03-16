package lr2;

public class Example4 {

    public static class Person {

        private String name;
        private int age;
        private String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
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
            if (age > 0) {
                this.age = age;
            } else {
                System.out.println("Возраст должен быть положительным числом.");
            }
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void displayInfo() {
            System.out.println("Имя: " + name);
            System.out.println("Возраст: " + age);
            System.out.println("Пол: " + gender);
        }
    }


    public static void main(String[] args) {

        Person person = new Person("Ксения", 22, "Женский");

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());

    }
}


