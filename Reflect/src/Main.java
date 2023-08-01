import java.lang.reflect.*;

/**
 * 为了演示方便，代码并不一定规范，实际开发不要参考
 * 输出结果：
 * public java.lang.String species
 * public java.lang.String superName
 * -------------------------------
 * public java.lang.String species
 * private boolean isKitten
 * private java.lang.String nickName
 * private final java.lang.String finalField
 * private static java.lang.String staticField
 * -------------------------------
 * public java.lang.String getFinalField()
 * public java.lang.String getNickName()
 * public void setKitten(boolean arg0)
 * public boolean isKitten()
 * public int getSuperAge()
 * public void setSuperAge(int arg0)
 * public final native void wait(long arg0) throws java.lang.InterruptedException
 * public final void wait(long arg0, int arg1) throws java.lang.InterruptedException
 * public final void wait() throws java.lang.InterruptedException
 * public boolean equals(java.lang.Object arg0)
 * public java.lang.String toString()
 * public native int hashCode()
 * public final native java.lang.Class getClass()
 * public final native void notify()
 * public final native void notifyAll()
 * -------------------------------
 * private void printParameters(java.lang.String arg0, int arg1)
 * public java.lang.String getFinalField()
 * public java.lang.String getNickName()
 * private void testForPrivateMethod()
 * public void setKitten(boolean arg0)
 * public boolean isKitten()
 * -------------------------------
 * private method printParameters, param value: First Arg, num: 100
 * -------------------------------
 * before value: Haha
 * after value: Pipi
 * -------------------------------
 * before value from method: finalValue
 * after value from field: ChangeValue
 * after value from method: finalValue
 * -------------------------------
 * get result:staticField
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("Cat");
//        Class clazz = Cat.class;

        printAllPublicFields(clazz);
        System.out.println("-------------------------------");
        printClassAllFields(clazz);
        System.out.println("-------------------------------");
        printAllPublicMethods(clazz);
        System.out.println("-------------------------------");
        printClassAllMethods(clazz);
        System.out.println("-------------------------------");
        invokePrivateMethod();
        System.out.println("-------------------------------");
        invokePrivateField();
        System.out.println("-------------------------------");
        invokePrivateFinalField();
        System.out.println("-------------------------------");
        invokePrivateStaticField();
    }

    private static void invokePrivateStaticField() throws NoSuchFieldException, IllegalAccessException {
        // 本类私有静态字段，不需要实例就可以获取对应的值
        Field field = Cat.class.getDeclaredField("staticField");
        field.setAccessible(true);
        String result = (String) field.get(null);
        System.out.println("get result:" + result);
    }

    private static void invokePrivateFinalField() throws NoSuchFieldException, IllegalAccessException {
        // 修改本类私有常量字段，注意结果未生效，因此编译期间就做了替换，所以字段修改了，但是使用到字段的方法没有修改
        Cat cat = new Cat();
        System.out.println("before value from method: " + cat.getFinalField());
        Field field = cat.getClass().getDeclaredField("finalField");
        field.setAccessible(true);
        field.set(cat, "ChangeValue");
        System.out.println("after value from field: " + field.get(cat));
        System.out.println("after value from method: " + cat.getFinalField());
    }

    private static void invokePrivateField() throws NoSuchFieldException, IllegalAccessException {
        // 修改本类私有字段
        Cat cat = new Cat();
        System.out.println("before value: " + cat.getNickName());
        Field field = cat.getClass().getDeclaredField("nickName");
        field.setAccessible(true);
        field.set(cat, "Pipi");
        System.out.println("after value: " + cat.getNickName());
    }

    private static void invokePrivateMethod()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 调用本类私有方法
        Cat cat = new Cat();
        Method method = cat.getClass().getDeclaredMethod("printParameters", String.class, int.class);
        method.setAccessible(true);
        method.invoke(cat, "First Arg", 100);
    }

    private static void printClassAllMethods(Class clazz) {
        // 获取本类所有方法，不管是什么访问权限的
        Method[] methods = clazz.getDeclaredMethods();
        printMethods(methods);
    }

    private static void printAllPublicMethods(Class clazz) {
        // 获取所有 public 访问权限的方法，包括本类声明的和从父类继承的
        Method[] methods = clazz.getMethods();
        printMethods(methods);
    }

    private static void printMethods(Method[] methods) {
        Parameter[] parameters;
        Parameter parameter;
        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers()) + " " +
                    method.getReturnType().getName() + " " + method.getName() + "(");
            parameters = method.getParameters();
            for (int i = 0, length = parameters.length; i < length; i++) {
                parameter = parameters[i];
                System.out.print(parameter.getType().getName() + " " + parameter.getName());
                if (i != length -1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (int i = 0, length = exceptionTypes.length; i < length; i++) {
                if (i == 0) {
                    System.out.print(" throws ");
                }
                System.out.print(exceptionTypes[i].getName());
                if (i != length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static void printClassAllFields(Class clazz) {
        // 获取所有成员变量，不管是什么访问权限的
        Field[] fields = clazz.getDeclaredFields();
        printFields(fields);
    }

    private static void printAllPublicFields(Class clazz) {
        // 获取所有 public 访问权限的变量，包括本类声明的和从父类继承的
        Field[] fields = clazz.getFields();
        printFields(fields);
    }

    private static void printFields(Field[] fields) {
        for (Field field : fields) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " +
                    field.getType().getName() + " " + field.getName());
        }
    }
}