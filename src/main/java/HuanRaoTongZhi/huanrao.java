package HuanRaoTongZhi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yangjiaying
 * @create 2019-03-30 上午3:43
 * @email 1296813487@qq.com
 */
@Aspect
@Component
public class huanrao {
    @Pointcut("execution(* HuanRaoTongZhi.*.*(..))")
    public void qierudian(){}

    @Around("qierudian()")
    public Object tongzhi(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("通知1");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("通知2");
        return o;
    }
}
