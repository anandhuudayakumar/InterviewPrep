import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger(String.valueOf(5000))));
    }

    public static BigInteger factorial(BigInteger n){
        if(n.compareTo(BigInteger.ONE)==0) return BigInteger.ONE;
        else return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
