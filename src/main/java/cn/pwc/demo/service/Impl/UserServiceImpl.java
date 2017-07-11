package cn.pwc.demo.service.Impl;

import cn.pwc.demo.dao.UserDao;
import cn.pwc.demo.service.UserService;
import cn.pwc.demo.util.EhcacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author boom
 * @description ${DESCRIPTION}
 * @create 2017-05-14 16:11
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EhcacheUtil ehcacheUtil;

    @Override
    public Integer login(String name, String password, HttpSession httpSession) {
        Integer info = userDao.login(name,password);
        if(info>=0){
            Cache cache = ehcacheUtil.getCache("loginCache");
            cache.put(httpSession.getId(),httpSession);
        }
        return info;
    }
}
