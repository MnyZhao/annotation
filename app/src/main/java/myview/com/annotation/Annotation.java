package myview.com.annotation;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Crate by E470PD on 2019/3/13
 */
@TestAnnotation(id = 1, msg = "天王盖地虎")
public class Annotation {
    @Check(value = "hi")
    int a;

    @TestAnnotation(id = 3, msg = "MethodAccess")
    public void test() {
    }

    public static void main(String args[]) {
        checkClassAnnotation();
        accessFiledAnnotation();
        accessMethodAnnotation();

    }

    public static void checkClassAnnotation() {
        //访问类上的注解
        //判断是否存在注解存在则获取注解 通过注解访问值
        boolean hasAnnotation = Annotation.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation = Annotation.class.getAnnotation(TestAnnotation.class);
            System.out.println(testAnnotation.id());
            System.out.println(testAnnotation.msg());
        }
    }

    /**
     * 访问变量注解
     */
    public static void accessFiledAnnotation() {
        //访问变量注解通过反射 获'取变量上的注解
        try {
            //通过反射获取变量
            Field as = Annotation.class.getDeclaredField("a");
            //设置访问权限
            as.setAccessible(true);
            //检测注解类型
            if (as.isAnnotationPresent(Check.class)) {
                //获取注解
                Check check = as.getAnnotation(Check.class);
                //判断是否存在
                if (check != null) {
                    //取值
                    System.out.println("Check.value-->" + check.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 访问方法上的注解
     */
    public static void accessMethodAnnotation() {
        try {
            //通过反射获取方法
            Method test = Annotation.class.getDeclaredMethod("test");
            //设置访问权限
            test.setAccessible(true);
            //检测注解类型
            if (test.isAnnotationPresent(TestAnnotation.class)) {
                //获取注解
                TestAnnotation annotation = test.getAnnotation(TestAnnotation.class);
                //判断是否存在
                if (annotation != null) {
                    //取值
                    System.out.println("Annotation.accessMethodAnnotation--->id:" +
                            annotation.id() + "--->msg:" + annotation.msg());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
/*
@interface Persons {
        Person[] value();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Repeatable(Persons.class)
    @interface Person {
        String role() default "";
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Persons({@Person(role = "pm"), @Person(role = "pd"), @Person(role = "ps")})
    class superMan {

    }
*/


