import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public final class MappedFile<args, WRITE> {
    private static final int SleepTime = 1000;
    private static final File filik = new File("file.txt");
    private static final Random random = new Random();
    private static final int BUFFER_SIZE = 16;
    private static final int ITERATION_COUNT = 15;
    private static final int STOP = -1;
    private static final int CONTINUE = 1;
    private RandomAccessFile file;
    private MappedByteBuffer buffer;

    public MappedFile(File file, Mode mode) {
        try {
            if (mode == Mode.write) {
                file.delete();
            } else {
                if (!file.exists() && !file.isFile() && !file.canRead()) {
                    System.out.println("file " + file + " doesn't exist or cannot be read");
                }
            }
            this.file = new RandomAccessFile(file, "rw");
            FileChannel channel = this.file.getChannel();
            buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(int iterationCount) {
        boolean infiniteRun = (iterationCount <= 0);
        while (infiniteRun || iterationCount > 0) {
            buffer.rewind();
            buffer.getInt();
            int lastOperationMark = buffer.getInt();
            if (lastOperationMark == Mode.read.getMark()) {
                int val1 = random.nextInt(100) + 1;
                int val2 = random.nextInt(10) + 1;
                buffer.rewind();
                buffer.putInt(CONTINUE).putInt(Mode.write.getMark()).putInt(val1).putInt(val2);
                if (!infiniteRun) {
                    iterationCount--;
                }
            }
            sleep();
        }
        buffer.rewind();
        buffer.putInt(STOP).putInt(Mode.write.getMark());
    }

    public void write() {
        write(ITERATION_COUNT);
    }

    public void read() {
        main: while (true) {
            buffer.rewind();
            int stopOrContinue = buffer.getInt();
            int lastOperationMark = buffer.getInt();
            if (stopOrContinue == STOP && lastOperationMark == Mode.write.getMark()) {
                break main;
            } else {
                if (lastOperationMark == Mode.write.getMark()) {
                    double val1 = buffer.getInt();
                    double val2 = buffer.getInt();
                    buffer.rewind();
                    buffer.putInt(CONTINUE).putInt(Mode.read.getMark());
                    double power = Math.pow(val1, val2);
                    System.out.println("1st number to the power of the 2nd " + power);
                }
            }
            sleep();
        }
    }


    public static void main(String... args) {

        try {
            if (args.length < 1) {
                System.out.println("specify argument: read or write");
                return;
            }
            Mode mode = Mode.getMode(args[0]);
            if (mode != null) {
                MappedFile file = new MappedFile(filik, mode);
                switch (mode) {
                    case write:
                        file.write();
                        break;
                    case read:
                        file.read();
                        break;
                    default:
                        System.out.println("invalid argument: " + args[0]);
                        return;
                }
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(SleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
