package xmlProcessing.ModelXML;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlType(propOrder = { "code", "article", "categoryID", "subcategory", "name", "vendor", "DDP", "RRP",
        "availability", "priceUSD", "retailPriceUAH", "warranty"}, name = "Product")
@XmlRootElement
public class Product {

    protected Integer Code;
    protected String Article;
    protected Integer CategoryID;
    protected String Subcategory;
    protected String Name;
    protected String Vendor;
    protected Integer DDP;
    protected Integer RRP;
    protected String Availability;
    protected BigDecimal PriceUSD;
    protected BigDecimal RetailPriceUAH;
    protected Integer Warranty;

    public Product() {

    }
    public Product(Integer code, String article, Integer categoryID, String subcategory, String name,
                   String vendor, Integer DDP, Integer RRP, String availability, BigDecimal priceUSD,
                   BigDecimal retailPriceUAH, Integer warranty) {
        Code = code;
        Article = article;
        CategoryID = categoryID;
        Subcategory = subcategory;
        Name = name;
        Vendor = vendor;
        this.DDP = DDP;
        this.RRP = RRP;
        Availability = availability;
        PriceUSD = priceUSD;
        RetailPriceUAH = retailPriceUAH;
        Warranty = warranty;
    }

    public Integer getCode() {
        return Code;
    }
    public void setCode(Integer code) {
        Code = code;
    }
    public String getArticle() {
        return Article;
    }
    public void setArticle(String article) {
        Article = article;
    }
    public Integer getCategoryID() {
        return CategoryID;
    }
    public void setCategoryID(Integer categoryID) {
        CategoryID = categoryID;
    }
    public String getSubcategory() {
        return Subcategory;
    }
    public void setSubcategory(String subcategory) {
        Subcategory = subcategory;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getVendor() {
        return Vendor;
    }
    public void setVendor(String vendor) {
        Vendor = vendor;
    }
    public Integer getDDP() {
        return DDP;
    }
    public void setDDP(Integer DDP) {
        this.DDP = DDP;
    }
    public Integer getRRP() {
        return RRP;
    }
    public void setRRP(Integer RRP) {
        this.RRP = RRP;
    }
    public String getAvailability() {
        return Availability;
    }
    public void setAvailability(String availability) {
        Availability = availability;
    }
    public BigDecimal getPriceUSD() {
        return PriceUSD;
    }
    public void setPriceUSD(BigDecimal priceUSD) {
        PriceUSD = priceUSD;
    }
    public BigDecimal getRetailPriceUAH() {
        return RetailPriceUAH;
    }
    public void setRetailPriceUAH(BigDecimal retailPriceUAH) {
        RetailPriceUAH = retailPriceUAH;
    }
    public Integer getWarranty() {
        return Warranty;
    }
    public void setWarranty(Integer warranty) {
        Warranty = warranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Article != null ? !Article.equals(product.Article) : product.Article != null) return false;
        if (Availability != null ? !Availability.equals(product.Availability) : product.Availability != null) return false;
        if (CategoryID != null ? !CategoryID.equals(product.CategoryID) : product.CategoryID != null) return false;
        if (!Code.equals(product.Code)) return false;
        if (DDP != null ? !DDP.equals(product.DDP) : product.DDP != null) return false;
        if (Name != null ? !Name.equals(product.Name) : product.Name != null) return false;
        if (PriceUSD != null ? !PriceUSD.equals(product.PriceUSD) : product.PriceUSD != null) return false;
        if (RRP != null ? !RRP.equals(product.RRP) : product.RRP != null) return false;
        if (RetailPriceUAH != null ? !RetailPriceUAH.equals(product.RetailPriceUAH) : product.RetailPriceUAH != null) return false;
        if (Subcategory != null ? !Subcategory.equals(product.Subcategory) : product.Subcategory != null) return false;
        if (Vendor != null ? !Vendor.equals(product.Vendor) : product.Vendor != null) return false;
        if (Warranty != null ? !Warranty.equals(product.Warranty) : product.Warranty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Code.hashCode();
        result = 31 * result + (Article != null ? Article.hashCode() : 0);
        result = 31 * result + (CategoryID != null ? CategoryID.hashCode() : 0);
        result = 31 * result + (Subcategory != null ? Subcategory.hashCode() : 0);
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Vendor != null ? Vendor.hashCode() : 0);
        result = 31 * result + (DDP != null ? DDP.hashCode() : 0);
        result = 31 * result + (RRP != null ? RRP.hashCode() : 0);
        result = 31 * result + (Availability != null ? Availability.hashCode() : 0);
        result = 31 * result + (PriceUSD != null ? PriceUSD.hashCode() : 0);
        result = 31 * result + (RetailPriceUAH != null ? RetailPriceUAH.hashCode() : 0);
        result = 31 * result + (Warranty != null ? Warranty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Code=" + Code +
                ", Article='" + Article + '\'' +
                ", CategoryID=" + CategoryID +
                ", Subcategory='" + Subcategory + '\'' +
                ", Name='" + Name + '\'' +
                ", Vendor='" + Vendor + '\'' +
                ", DDP=" + DDP +
                ", RRP=" + RRP +
                ", Availability='" + Availability + '\'' +
                ", PriceUSD=" + PriceUSD +
                ", RetailPriceUAH=" + RetailPriceUAH +
                ", Warranty=" + Warranty +
                '}';
    }
}
