import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObject extends UnicastRemoteObject
        implements IEcho, IAdd {

    public RemoteObject() throws RemoteException {
    }

    @Override
    public AddResponse add(AddRequest request) throws RemoteException {
        return new AddResponse(request.component1,request.component2);
    }

    @Override
    public EchoResponse echo(EchoRequest request) throws RemoteException {
        return new EchoResponse(request.message);
    }
}
