import java.io.Serializable;

public class EchoResponse implements Serializable {
    public final String message;

    public EchoResponse(String message) {
        this.message = doEcho(message);
    }

    @Override
    public String toString() {
        return "EchoResponse: \"" + message + "\"";
    }

    public String doEcho (String message){
        return "ECHO: " + message;
    }
}
