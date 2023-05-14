package Annotation_ReflectionAPI;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Init { //аннотация для методов сервисов, которые нужно вызвать для первичной инициализации
    boolean suppressException() default false; //модель поведения при появлении исключений во время выполнения метода
}
