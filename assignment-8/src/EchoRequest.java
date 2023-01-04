import java.io.Serializable;

public class EchoRequest implements Serializable {

    public final String message;

    public EchoRequest(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EchoRequest: messageToEcho= \"" + message +"\"";
    }
}
