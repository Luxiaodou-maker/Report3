package Dao;

import Entity.Student;


//继承了Ibasedao的具体方法，也可以在这里写上对应类独有的方法
public interface IstuDao extends IbaseDao<Student>{
    boolean Login(String name,String password);
}
