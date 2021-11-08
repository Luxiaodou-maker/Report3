package Dao.impl;

import Dao.IbaseDao;
import Dao.IstuDao;
import Entity.Student;
import Util.JPAUtill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


//继承了BaseDao中的具体方法，实现了IstuDao的方法
public class StuDao extends BaseDao<Student> implements IstuDao {

    @Override
    public boolean Login(String name, String password) {
        EntityManager manager = JPAUtill.getEntityManager();
        String sql = "select s from Student s where s.name=:name and s.password=:password ";
        Query query = manager.createQuery(sql);
        query.setParameter("name",name);
        query.setParameter("password",password);
        List list = query.getResultList();
        manager.close();
        return list.size()>=1;
    }
}
