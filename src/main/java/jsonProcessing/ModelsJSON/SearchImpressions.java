package jsonProcessing.ModelsJSON;

import java.io.Serializable;

public class SearchImpressions {

    private Integer eventProductId;
    private String test;
    private String eventProductName;
    private Float eventProductPrice;
    private String eventProductVendorName;
    private String eventCategoryName;
    private String eventList;
    private Integer eventPosition;

    public SearchImpressions() {
    }

    public SearchImpressions(Integer eventProductId, String test, String eventProductName, Float eventProductPrice, String eventProductVendorName, String eventCategoryName, String eventList, Integer eventPosition) {
        this.eventProductId = eventProductId;
        this.test = test;
        this.eventProductName = eventProductName;
        this.eventProductPrice = eventProductPrice;
        this.eventProductVendorName = eventProductVendorName;
        this.eventCategoryName = eventCategoryName;
        this.eventList = eventList;
        this.eventPosition = eventPosition;
    }

    @Override
    public String toString() {
        return "SearchImpressions{" +
                "eventProductId=" + eventProductId +
                ", test='" + test + '\'' +
                ", eventProductName='" + eventProductName + '\'' +
                ", eventProductPrice=" + eventProductPrice +
                ", eventProductVendorName='" + eventProductVendorName + '\'' +
                ", eventCategoryName='" + eventCategoryName + '\'' +
                ", eventList='" + eventList + '\'' +
                ", eventPosition=" + eventPosition +
                '}';
    }
}
