package Annotation_ReflectionAPI;

import java.lang.annotation.*;

@Documented //попадет в Javadoc
@Inherited //будет наследоваться потомками от родителя
@Target(ElementType.TYPE) //область применения: классы и интерфейсы
@Retention(RetentionPolicy.RUNTIME) //будет доступна во время Runtime

public @interface Service { //аннотация для пометки сервисов, которые будут загружаться в проекте
    String name();
    boolean lazyLoad() default false; //если true, то Init не вызывает и инициализация происходит при первом обращении к классу
}
