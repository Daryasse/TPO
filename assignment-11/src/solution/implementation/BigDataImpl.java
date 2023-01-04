package implementation;

import interfaces.IBigData;
import model.BigData;
import requests.DownloadRequest;
import requests.QueryRequest;
import requests.UploadRequest;
import responses.DownloadResponse;
import responses.QueryResponse;
import responses.UploadResponse;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.MTOM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@MTOM
@WebService(name = "IBigData", targetNamespace = "http://eleven/big-data")
public final class BigDataImpl implements IBigData {

    private static List<BigData> files;
    private static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        Endpoint.publish(IBigData.url, new BigDataImpl());
        logger.info("SERVICE STARTED");
        files = BigData.generateList();
    }

    @Override
    public DownloadResponse downloadFile(DownloadRequest request) {
        for (BigData file: files){
            if(file.getFileName().equals(request.fileName)){
                return new DownloadResponse(file.getFileName(), file.getData());
            }
        }
        return null;
    }

    @Override
    public UploadResponse uploadFile(UploadRequest request) {
        BigData newData = new BigData( request.fileName,request.fileincoded, request.keyword);
        files.add(newData);

        if(files.get(files.size()-1).fileName.equals(request.fileName)
            && files.get(files.size()-1).keyword.equals(request.keyword)
                && files.get(files.size()-1).data.equals(request.fileincoded)){
            return new UploadResponse("Successfully uploaded");
        }else{
            return new UploadResponse("Error occurred");
        }
    }

    @Override
    public QueryResponse getFileQuery(QueryRequest request) {
        List<String> fileNames = new ArrayList<>();

        Map<String, List<BigData>> findByKeyword = files.stream().collect(
                Collectors.groupingBy(BigData::getKeyword, TreeMap::new, Collectors.toList()));

        List<BigData> list = findByKeyword.get(request.keyword);

        for (BigData file: list){
            fileNames.add(file.fileName);
        }
        return new QueryResponse(fileNames);
    }
}
