package Dao;

import java.io.Serializable;
import java.util.List;


//基础持久化维护类的接口，以便多个实体类使用
//这里使用了泛型，泛型可以理解为可以接受所有类型的数据
public interface IbaseDao<T> {
    void save(T s);
    void update(T s);
    void delete(Serializable Id);
    T getOne(Serializable Id);
    List<T> getAll();
}
