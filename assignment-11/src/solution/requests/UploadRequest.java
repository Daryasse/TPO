package requests;

public class UploadRequest {
    public String fileName;
    public byte[] fileincoded;
    public String keyword;

    public UploadRequest(){}
    public UploadRequest(String fileName, byte[] fileincoded, String keyword){
        this.fileName = fileName;
        this.fileincoded = fileincoded;
        this.keyword = keyword;
    }
}
