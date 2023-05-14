package Annotation_ReflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
������� ����� �������� �������, ���������� �������������� ���������, ����������� �������������,
��������� �� � �������������� � ������ ��������� (� ������� ������� �� .jar ������, ���������� � ������������ �������)
 */

public class Operation {
    private static Map <String,Object> services = new HashMap<>();
    public static void main(String[] args){
        inspectService("Annotation_ReflectionAPI.LazyService");
        inspectService("Annotation_ReflectionAPI.SimpleService");
        inspectService("java.lang.String");
        inspectService("java.lang.Str");
        System.out.println(services);
        LazyService lazy = (LazyService) services.get("Lazy");
        if (Objects.nonNull(lazy)) {
            lazy.testMethod();
        }
    }

    /*
    ��������� ����� �� ������� ��������� Service
    ���� �� ���� � � ���� lazyLoad == false, �� ������� ���������� �� ������ � ��������� � ������� ������� ��������� Init
    ���� ���� ����� ����� , �� ������� ��������� ������ � �������� � ���� Init ����� � ������ ����� suppressException
    ����������� ������ ��������������������� ������� � ����, ����� ����� � ��� ������ �� �����
     */
    static void inspectService(String className) {
        Class<?> service = null;
        try {
            service = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("����� " + className +" �� ���������!");
            return;
        }
        if (service.isAnnotationPresent(Service.class) && !service.getAnnotation(Service.class).lazyLoad()){
           System.out.println(service.getSimpleName()+ " ��� ������! ��� ��� ���������: " + service.getAnnotation(Service.class).name());
           List<Method> methods = Arrays.stream(service.getMethods()).filter(x -> x.isAnnotationPresent(Init.class)).toList();
           if(!methods.isEmpty()){
               try {
                   Object o = service.getDeclaredConstructor().newInstance();
                   services.put(service.getAnnotation(Service.class).name(), o);
                   for (Method x : methods) {
                       x.invoke(o);
                   }
               } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                   if (methods.get(0).getAnnotation(Init.class).suppressException()){
                       System.out.println("Exception was suppressed!");
                   }else throw new RuntimeException(e);
               }
           }
       }else {
           System.out.println(service.getSimpleName() + " �� �������� �������� ��� �� ������� ��������������� �������������!");
       }
    }
}
