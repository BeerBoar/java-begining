package Annotation_ReflectionAPI;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Init { //��������� ��� ������� ��������, ������� ����� ������� ��� ��������� �������������
    boolean suppressException() default false; //������ ��������� ��� ��������� ���������� �� ����� ���������� ������
}
