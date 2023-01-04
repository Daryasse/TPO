import interfaces.IBigData;
import model.BigData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import requests.DownloadRequest;
import requests.QueryRequest;
import requests.UploadRequest;
import responses.DownloadResponse;
import responses.QueryResponse;
import responses.UploadResponse;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class Testing {
    private static final Logger logger = Logger.getAnonymousLogger();
    private IBigData iBigData;

    @Before
    public void before() throws MalformedURLException {
        URL wsdl = new URL(interfaces.IBigData.url + "?wsdl");
        QName qname = new QName("http://eleven/big-data", "BigDataImplService");
        Service service = Service.create(wsdl, qname);
        this.iBigData = service.getPort(IBigData.class);
    }


    @Test
    public void downloadFile(){
        String fileName = "file2";
        DownloadResponse downloadResponse = this.iBigData.downloadFile(new DownloadRequest(fileName)); // download file "file2"
        Assert.assertNotNull(downloadResponse); // check if it is not null
        Assert.assertEquals(downloadResponse.fileName , fileName); //compare files by name
        logger.info("File Name " + downloadResponse.fileName + " Content: " + downloadResponse.fileincoded.toString()); // about file
    }

    @Test
    public void getFileQuery(){
        String keyWord = "keyword"; //keyword to query
        String fileName = "file0"; //file name
        QueryResponse queryResponse = this.iBigData.getFileQuery(new QueryRequest(keyWord)); // files' keywords "keyword"
        Assert.assertNotNull(queryResponse);
        Assert.assertEquals(queryResponse.fileNames.size(), 5); //check size
        Assert.assertEquals(queryResponse.fileNames.get(0), fileName); // name of files are equal

    }

    @Test
    public void uploadFile(){
        String check = "Successfully uploaded";
        BigData sample = BigData.getTestSample();
        UploadResponse uploadResponse = this.iBigData.uploadFile(new UploadRequest(sample.fileName, sample.data , sample.keyword));
        Assert.assertNotNull(uploadResponse);
        Assert.assertEquals(check, uploadResponse.response);
    }
}
