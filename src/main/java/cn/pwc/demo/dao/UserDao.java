package cn.pwc.demo.dao;

import cn.pwc.demo.entity.TUserEntity;

/**
 * @author boom
 * @description ${DESCRIPTION}
 * @create 2017-05-15 18:11
 **/
public interface UserDao {

    Integer login(String name, String password);

}
