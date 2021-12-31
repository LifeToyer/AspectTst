package com.example.aspecttst;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private static final Logger logger = LoggerFactory.getLogger(Aspect.class);

    @Pointcut("@annotation(com.example.aspecttst.ApiOperation)")
    public void pointCut(){}

    @Before("pointCut()")
    public Object before(JoinPoint jp){
        Object[] args = jp.getArgs();// 获得参数列表
        String className = jp.getThis().toString();
        String methodName = jp.getSignature().getName(); // 获得方法名
        logger.info("位于：" + className + "调用了" + methodName + "()方法！！！！！");
        logger.info("=====================================");
        args[0] ="xx";
        logger.info("方法前");
        return args;
    }
    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterReturn(Object result){
//        unAdd add = (unAdd) result ;
        logger.info("方法后");
    }
}
