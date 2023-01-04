package model;

import javax.xml.bind.annotation.XmlType;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@XmlType(namespace = "http://eleven")
public class BigData {
    public String fileName;
    public byte[] data;
    public String keyword;

    public BigData(){}
    public BigData(String fileName, byte[] data, String keyword){
        this.fileName = fileName;
        this.data = data;
        this.keyword = keyword;
    }
    private static final int size = 0x1000; //4kB

    public static List<BigData> generateList(){
        List<BigData> files = new ArrayList<>();
        int a = 0;
        while(a < 5){
            String filename = "file" + a;
            String keyword = "keyword";
            byte[] data = genCode(size);
            files.add(new BigData(filename, data, keyword));
            a++;
        }
        return files;
    }

    private static byte[] genCode(int size) {
        SecureRandom random = new SecureRandom();
        try{
            random = SecureRandom.getInstanceStrong();
        }catch (Throwable e){
            e.printStackTrace();
        }
        byte[] data = new byte[size];
        random.nextBytes(data);
        return data;
    }

    public static BigData getTestSample(){
        String fileName = "justForTest";
        String keyword  = "keywword";
        byte[] data = genCode(size);
        return new BigData(fileName, data, keyword);
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

    public String getKeyword() {
        return keyword;
    }
}
