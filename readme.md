###声明注解 通过@interface
###@interface 注解名称
###例如：
    public @interface TestAnnotation{
         //注解属性只能是8种 基本数据类型 类 接口 以及 注解数组
         String value() defalut ""; //通过default赋默认值
    };
###我们可以给类 方法 变量设置注解
####并通过反射去获得注解
####通过isAnnotationPresent(Class<? extends Annotation> annotationClass) 判断是否某个注解
####获取方法注解 要先通过反射获取方法 比如

 @TestAnnotation(id = 3, msg = "MethodAccess")
    public void test() {}
    //先获取方法 设置访问权限  获取注解 判断注解是否为空 获取注解值
    public static void accessMethodAnnotation() {
        try {
            Method test = Annotation.class.getDeclaredMethod("test");
            test.setAccessible(true);
            TestAnnotation annotation = test.getAnnotation(TestAnnotation.class);
            if (annotation != null) {
                System.out.println("Annotation.accessMethodAnnotation--->id:" +
                        annotation.id() + "--->msg:" + annotation.msg());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
###获取类注解 方法注解 变量注解 均在类Annotation 里有注释
