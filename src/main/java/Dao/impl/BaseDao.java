package Dao.impl;

import Dao.IbaseDao;
import Util.JPAUtill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao <T> implements IbaseDao<T> {

    private Class<T> clz;
    public  BaseDao(){
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }
    //getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）
    // 的直接超类的 Type，然后将其转ParameterizedType。
    //getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组
    // [0]就是这个数组中第一个了，简而言之就是获得超类的泛型参数的实际类型。



    @Override
    public void save(T s) {
        EntityManager manager = JPAUtill.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(T s) {
        EntityManager manager = JPAUtill.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(s);//升级于新建最大的区别
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Serializable Id) {
        EntityManager manager = JPAUtill.getEntityManager();
        manager.getTransaction().begin();
        T t= manager.find(clz,Id);
        manager.remove(t);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public T getOne(Serializable Id) {
        EntityManager manager = JPAUtill.getEntityManager();
        T t = manager.find(clz, Id);
        manager.close();
        return t;
    }

    @Override
    public List<T> getAll() {
        EntityManager manager = JPAUtill.getEntityManager();
        String sql = "select p from "+ clz.getName() +" as p";
        Query query = manager.createQuery(sql);
        return query.getResultList();
    }
}
