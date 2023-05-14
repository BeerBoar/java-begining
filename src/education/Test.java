package education;

public class Test {
    public static void main(String[] args) {
        int[] n = {1, 2, 3};
        int sum = 0;
        for (int i = 0; i< n.length; i++){
            sum+=Math.pow(n[i], 2);
        }
        System.out.println(sum);
    }
}
