package Annotation_ReflectionAPI;

@Service(name = "Lazy", lazyLoad = true)
public class LazyService {

    @Init(suppressException = true)
    public void lazyInit() throws Exception{
        System.out.println("Lazy");
        throw new Exception("My Exception");
    }
    public void testMethod(){
        System.out.println("It's a functional object!");
    }

    public LazyService() {
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