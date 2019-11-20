package main.com.liubin;

import main.com.liubin.array.Array;

public class Student {

    private String name;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student() {

    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        array.add(new Student("Alice", 100));
        array.add(new Student("Bob", 77));
        array.add(new Student("Charlie", 88));
        System.out.println(array);
    }
}
