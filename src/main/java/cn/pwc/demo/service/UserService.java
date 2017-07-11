package cn.pwc.demo.service;

import javax.servlet.http.HttpSession;

/**
 * @author boom
 * @description ${DESCRIPTION}
 * @create 2017-05-14 16:11
 **/
public interface UserService {

    Integer login(String name, String password, HttpSession httpSession);

}
