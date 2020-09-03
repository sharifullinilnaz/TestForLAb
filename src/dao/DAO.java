package dao;
import model.Student;
import java.util.List;

public interface DAO {

    public List<Student> getTop3();
    public int getStudentsWithMin();
    public int getStudentsWithMax();
    public List<Student> getBestStudentsInGroup();

}