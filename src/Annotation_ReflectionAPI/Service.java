package Annotation_ReflectionAPI;

import java.lang.annotation.*;

@Documented //������� � Javadoc
@Inherited //����� ������������� ��������� �� ��������
@Target(ElementType.TYPE) //������� ����������: ������ � ����������
@Retention(RetentionPolicy.RUNTIME) //����� �������� �� ����� Runtime

public @interface Service { //��������� ��� ������� ��������, ������� ����� ����������� � �������
    String name();
    boolean lazyLoad() default false; //���� true, �� Init �� �������� � ������������� ���������� ��� ������ ��������� � ������
}
