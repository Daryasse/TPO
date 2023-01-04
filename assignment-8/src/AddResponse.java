import java.io.Serializable;
import java.math.BigInteger;

public class AddResponse implements Serializable {
    public final BigInteger sum;

    public AddResponse(BigInteger x, BigInteger y) {
        sum = findSum(x, y);
    }

    public BigInteger findSum(BigInteger num1, BigInteger num2) {
        if (num1 != null && num2 != null)
            return num1.add(num2);
        else if (num1 != null)
            return num1;
        else if (num2 != null)
            return num2;
        else return null;
    }

    @Override
    public String toString() {
        return "AddResponse: sum = " + sum;
    }
}
