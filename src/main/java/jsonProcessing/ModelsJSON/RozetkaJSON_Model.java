package jsonProcessing.ModelsJSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RozetkaJSON_Model {

    private String pageType;
    private String searchType;
    private String productsQuantityTotal;
    private String productsQuantityAvailable;
    public List<Object> searchImpressions;

    public RozetkaJSON_Model() {
    }

    public RozetkaJSON_Model(String pageType, String searchType, String productsQuantityTotal, String productsQuantityAvailable, List<Object> searchImpressions) {
        this.pageType = pageType;
        this.searchType = searchType;
        this.productsQuantityTotal = productsQuantityTotal;
        this.productsQuantityAvailable = productsQuantityAvailable;
        this.searchImpressions = searchImpressions;
    }

    @Override
    public String toString() {
        return "RozetkaJSON_Model{" +
                "pageType='" + pageType + '\'' +
                ", searchType='" + searchType + '\'' +
                ", productsQuantityTotal='" + productsQuantityTotal + '\'' +
                ", productsQuantityAvailable='" + productsQuantityAvailable + '\'' +
                ", searchImpressions=" + searchImpressions +
                '}';
    }
}

//  dataLayer.push({
// "pageType":"SearchResults",
// "searchType":"specific",
// "productsQuantityTotal":"1",
// "productsQuantityAvailable":"1",
// "searchImpressions":
// [{
// "eventProductId":318126,
// "test":"specific: model",
// "eventProductName":"Western Digital Green 4TB 5400rpm 64MB WD40EZRX 3.5 SATA III",
// "eventProductPrice":176.44444444444,
// "eventProductVendorName":"western-digital",
// "eventCategoryName":"\u0416\u0435\u0441\u0442\u043a\u0438\u0435 \u0434\u0438\u0441\u043a\u0438",
// "eventList":"Search Impressions",
// "eventPosition":1
// }]
// });
/*
dataLayer.push({"pageType":"SearchResults","searchType":"specific","productsQuantityTotal":"2","productsQuantityAvailable":"1","searchImpressions":[{"eventProductId":1128405,"test":"specific: model","eventProductName":"Samsung Galaxy Tab S 8.4 16GB Titanium Bronze (SM-T700NTSASEK)","eventProductPrice":418.55813953488,"eventProductVendorName":"samsung","eventCategoryName":"\u041f\u043b\u0430\u043d\u0448\u0435\u0442\u044b","eventList":"Search Impressions","eventPosition":1},{"eventProductId":1279640,"test":"specific: model","eventProductName":"Samsung UE65HU8700+ \u041f\u043b\u0430\u043d\u0448\u0435\u0442 Samsung Galaxy Tab S 8.4 16GB Titanium Bronze (SM-T700NTSASEK)","eventProductPrice":3651.1162790698,"eventProductVendorName":"samsung","eventCategoryName":"\u0422\u0435\u043b\u0435\u0432\u0438\u0437\u043e\u0440\u044b","eventList":"Search Impressions","eventPosition":2}]});
*/