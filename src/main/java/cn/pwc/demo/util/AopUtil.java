package cn.pwc.demo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author boom
 * @description 切面
 * @create 2017-05-18 13:14
 **/
//声明这是一个切面
@Aspect
@Component
public class AopUtil {

    @Pointcut("execution(* cn.pwc.demo.controller.*.*(..))")
    public void aspect(){

    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("调用时间 " + new Date() + "调用的方法 " + joinPoint.getSignature());
    }

}
