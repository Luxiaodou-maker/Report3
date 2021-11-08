import Dao.impl.StuDao;
import Entity.Student;
import org.junit.*;

import java.util.List;

public class StudentDaoTest {
    StuDao stuDao=new StuDao();

    //测试插入函数
    @Test
    public void create(){
        Student student=new Student();
        student.setId("20201120504");
        student.setName("小黄");
        student.setPassword("huang123");
        stuDao.save(student);
    }
    //测试删除方法
    @Test
    public void delete(){
   stuDao.delete("20201120500");
    }
    //测试升级方法
    @Test
    public void update(){
        Student student=new Student();
        student.setId("20201120504");
        student.setName("小黄");
        student.setPassword("huang12366");
        stuDao.update(student);
    }

    //测试查询方法
    @Test
    public void findall(){
        List<Student> studentList=stuDao.getAll();//用链表储存
        for (Student student: studentList) {
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getPassword());
            System.out.println();
        }
    }

    //测试登陆方法
    @Test
    public void login(){
        System.out.println(stuDao.Login("小黄","huang12366"));
        //根据姓名和密码登录
    }
}
