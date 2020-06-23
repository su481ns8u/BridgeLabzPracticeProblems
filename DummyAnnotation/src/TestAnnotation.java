import java.lang.reflect.Method;
import java.text.Annotation;

public class TestAnnotation {
    @Override
    @MethodInfo(author = "Sudhanshu", comments = "Main method", date = "Jun 23 2020", revision = 1)
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Jun 23 2020")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    public static void main(String[] args) {
        try {
            for (Method method : TestAnnotation.class.getMethods()) {
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (java.lang.annotation.Annotation ano : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method '" + method + "' : " + ano);
                        }
                        MethodInfo methodAno = method.getAnnotation(MethodInfo.class);
                        if (methodAno.revision() == 1) {
                            System.out.println("Method with revision no. 1 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}