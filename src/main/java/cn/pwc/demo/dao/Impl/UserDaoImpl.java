package cn.pwc.demo.dao.Impl;

import cn.pwc.demo.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boom
 * @description ${DESCRIPTION}
 * @create 2017-05-15 18:11
 **/
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Integer login(String name, String password) {
        String hql = "select userId from TUserEntity where name=:name and password=:password";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter("name",name);
        query.setParameter("password",password);
        if(query.list().size() == 0){
            return -1;
        }
        Integer user = (Integer) query.list().get(0);
        return user;
    }
}
