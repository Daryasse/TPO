import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args){

        try {
            LocateRegistry.createRegistry(1099);
            RemoteObject remoteObject = new RemoteObject();
            Naming.bind("echo", remoteObject);
            Naming.bind("add",remoteObject);
            System.out.println("Server has started");
        }
        catch(Throwable e){
            System.err.println(e);
        }
    }
}
