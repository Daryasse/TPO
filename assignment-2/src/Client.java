import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {
    private static final String MUL_REG = "^(MUL)(\\s+)([0-9]+)(\\s+)([0-9]+)";
    private static final Pattern mulRegex = Pattern.compile(MUL_REG);
    private static final String ECHO_REG = "^(ECHO)(\\s+)([\\w|\\s+|\\.|\\']+)+";
    private static final Pattern echoRegex = Pattern.compile(ECHO_REG);

    private static ByteBuffer buffer;
    private static SocketChannel client;

    private Client(){
        try {
            client = SocketChannel.open(new InetSocketAddress("localhost", 1234));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = ByteBuffer.allocate(1024);
    }

    public static void main(String[] args){
        new Client();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter ECHO to repeat message or MUL for multiplication of 2 numbers:");
                String input = scanner.nextLine();
                if (checkInput(input)) {
                    System.out.println(send(input));
                } else {
                    System.out.println("Wrong request");
                    continue;
                }
            }
    }

    public static String send(String input){
        buffer = ByteBuffer.wrap(input.getBytes());
        String result = null;
        try {
            client.write(buffer);
            buffer.clear();
            buffer = ByteBuffer.allocate(1024);
            client.read(buffer);
            result = new String(buffer.array()).trim();
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
        public static boolean checkInput(String input){
            if (echoRegex.matcher(input).find() || mulRegex.matcher(input).find()) {
                return true;
            } else {
                return false;
            }
        }

}
