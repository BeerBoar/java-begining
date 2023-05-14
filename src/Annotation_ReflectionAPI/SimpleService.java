package Annotation_ReflectionAPI;

@Service(name = "Simple")
public class SimpleService {
    @Init
    public void initService(){
        System.out.println("Simple");
    }

    public SimpleService() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
