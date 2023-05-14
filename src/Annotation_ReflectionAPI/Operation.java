package Annotation_ReflectionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
Получая извне названия классов, являющихся потенциальными сервисами, подлежащими инициализации,
проверяем их и инициализируем в начале программы (к примеру плагины из .jar файлов, помещенных в определенный каталог)
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
    Проверяет класс на наличие аннотации Service
    Если он есть и у него lazyLoad == false, то выводит информацию по классу и проверяет у методов наличие аннотации Init
    Если есть такой метод , то создаем экземпляр класса и вызываем у него Init метод с учетом флага suppressException
    Параллельно кладем проинициализированные объекты в мапу, чтобы иметь к ним доступ по имени
     */
    static void inspectService(String className) {
        Class<?> service = null;
        try {
            service = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Класс " + className +" не обнаружен!");
            return;
        }
        if (service.isAnnotationPresent(Service.class) && !service.getAnnotation(Service.class).lazyLoad()){
           System.out.println(service.getSimpleName()+ " это сервис! Имя его аннотации: " + service.getAnnotation(Service.class).name());
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
           System.out.println(service.getSimpleName() + " не является сервисом или не требует предварительной инициализации!");
       }
    }
}
