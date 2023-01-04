package responses;

import java.util.List;

public class QueryResponse {

    public List<String> fileNames;

    public QueryResponse(){}
    public QueryResponse(List<String> fileNames){
        this.fileNames = fileNames;
    }
}
