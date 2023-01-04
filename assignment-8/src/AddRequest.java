import java.io.Serializable;
import java.math.BigInteger;

public class AddRequest implements Serializable {

        public final BigInteger component1;
        public final BigInteger component2;

        public AddRequest(BigInteger component1, BigInteger component2) {
            this.component1 = component1;
            this.component2 = component2;
        }

        @Override
        public String toString() {
            return "AddRequest: component1 = " + component1 + ", component2 = " + component2;
        }
}
