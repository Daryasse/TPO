package interfaces;

import requests.DownloadRequest;
import requests.QueryRequest;
import requests.UploadRequest;
import responses.DownloadResponse;
import responses.QueryResponse;
import responses.UploadResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(name = "IBigData", targetNamespace = "http://eleven/big-data")
public interface IBigData {
    public static final String url = "http://localhost:8080/big-data";

    @WebMethod (action = "http://eleven/big-data/download")
    public DownloadResponse downloadFile(DownloadRequest request);

    @WebMethod (action = "http://eleven/big-data/upload")
    public UploadResponse uploadFile(UploadRequest request);

    @WebMethod (action = "http://eleven/big-data/query")
    public QueryResponse getFileQuery(QueryRequest request);

}
