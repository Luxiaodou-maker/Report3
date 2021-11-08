package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//表明这是一个实体类
@Table(name = "stuinfo_2")//设置表名
public class Student {
    @Id//设置主键
    private  String id;
    private  String name;
    private  String password;

    @Column(name = "id",length =25,nullable = false,unique = true)
    //设置实体类中属性与数据表中字段的对应关系
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name = "name",length = 25,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password",length = 25,nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
