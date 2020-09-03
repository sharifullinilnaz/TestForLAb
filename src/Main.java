import model.Student;
import dao.DAO;
import dao.StudentDAOImpl;
import java.util.List;

public class Main {

    public static void main(String [] args) {

        DAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.getTop3();

        for (Student student : students) {
            System.out.println();
            System.out.println("fio: " + student.getFio());
            System.out.println("age: " + student.getAge());
            System.out.println("group_number: " + student.getGroup_number());
            System.out.println("score: " + student.getScore());
        }

        System.out.println("Count of students with min score : " + studentDAO.getStudentsWithMin());
        System.out.println("Count of students with max score : " + studentDAO.getStudentsWithMax());

        List<Student> bestStudentsInGroup = studentDAO.getBestStudentsInGroup();

        System.out.println("Best students in group: ");

        for (Student student : bestStudentsInGroup) {
            System.out.println(student.getFio());
            System.out.println(student.getAge());
            System.out.println(student.getGroup_number());
            System.out.println(student.getScore());
        }
    }

}