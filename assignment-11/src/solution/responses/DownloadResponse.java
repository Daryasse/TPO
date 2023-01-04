package responses;

public class DownloadResponse {
    public String fileName;
    public byte[] fileincoded;

    public DownloadResponse(){}

    public DownloadResponse(String fileName, byte[] fileincoded){
        this.fileName = fileName;
        this.fileincoded = fileincoded;
    }
}
