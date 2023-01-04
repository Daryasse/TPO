import java.math.BigInteger;
import java.rmi.Naming;

public class Client {
    public static void main(String[] args){

        try {
            IAdd add = (IAdd) Naming.lookup("add");
            BigInteger component1 = BigInteger.valueOf(7846393);
            BigInteger component2 = BigInteger.valueOf(968456943);
            AddRequest addRequest = new AddRequest(component1, component2);
            AddResponse addResponse = add.add(addRequest);
            System.out.println(addResponse);

            IEcho echo = (IEcho) Naming.lookup("echo");
            EchoRequest echoRequest = new EchoRequest("Trying to echo");
            EchoResponse echoResponse = echo.echo(echoRequest);
            System.out.println(echoResponse);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
