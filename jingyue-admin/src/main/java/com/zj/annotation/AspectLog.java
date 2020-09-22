package com.zj.annotation;

import com.zj.jingyuesystem.annotation.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AspectLog {
   private org.slf4j.Logger logger= LoggerFactory.getLogger(AspectLog.class);
    @Pointcut()
    public void point() {

    }
    @Around(value ="execution(* com.zj.sys.web..*.*(..))")
    public Object aspectLog(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String methodName = signature.getName();
        System.out.println(methodName);
//        Class type = signature.getDeclaringType();
        Object target = point.getTarget();
        Class<?> targetClass = target.getClass();
        if (targetClass.isAnnotationPresent(Logger.class)) {
            Logger classAnnotation = targetClass.getAnnotation(Logger.class);
            String value = classAnnotation.value();
            logger.info("进入类" + targetClass.getName() + ":" + value);
        }

//            Method[] methods = target.getClass().getMethods();
                if (method.isAnnotationPresent(Logger.class)) {
                    if (method.getName().equals(methodName)) {
                        Logger annotation = method.getAnnotation(Logger.class);
                        String methodAnno = annotation.value();
                        logger.info("进入方法："+method.getName()+":"+methodAnno);
                    }



        }

           Object   proceed= point.proceed();


    return  proceed;

    }
}
