import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

public class Server {
    private static final String MUL_REG = "^MUL\\s+[0-9]+\\s+[0-9]+";
    private static final Pattern mulRegex = Pattern.compile(MUL_REG);
    private static final String ECHO_REG = "^ECHO\\s+[\\w|\\s+|\\.|\\']+";
    private static final Pattern echoRegex = Pattern.compile(ECHO_REG);

    public Server(){
    }

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        Selector selector = Selector.open();
        server.bind(new InetSocketAddress("localhost", 1234));
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator i = selectedKeys.iterator();
            while (i.hasNext()) {
                SelectionKey key = (SelectionKey) i.next();
                if (key.isAcceptable()){
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    try {
                        answer(buffer, key);
                    }catch (IOException e) {
                    }
                }
                i.remove();
                buffer = ByteBuffer.allocate(1024);
            }
        }
    }
    private static void answer(ByteBuffer buffer, SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        client.read(buffer);
        String res = new String(buffer.array()).trim();
        System.out.println(res);
        String response = RequestDealing(res);
        buffer.flip();
        client.write(ByteBuffer.wrap(response.getBytes()));
        buffer.clear();
    }

    public static String RequestDealing(String ind) {
        if(mulRegex.matcher(ind).find()) {
            String[] variables = ind.split(" ");
            int a = Integer.parseInt(variables[1]);
            int b = Integer.parseInt(variables[2]);
            int mul = a * b;
            return "MUL: "+ mul;
        }else if(echoRegex.matcher(ind).find()) {
            return ind;
        }
        return "Wrong request";
    }

}
