package model;

public class Student {

    private String fio;
    private int age;
    private String group_number;
    private double score;

    public Student() {
    }

    public Student(String fio, int age, String group_number, double score) {
        this.fio = fio;
        this.age = age;
        this.group_number = group_number;
        this.score = score;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup_number(String group_number) {
        this.group_number = group_number;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }

    public String getGroup_number() {
        return group_number;
    }

    public double getScore() {
        return score;
    }
}