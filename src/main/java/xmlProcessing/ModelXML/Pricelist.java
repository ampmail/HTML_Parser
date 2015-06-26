package xmlProcessing.ModelXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"name", "products"}, name = "Pricelist")
@XmlRootElement
public class Pricelist {
    private String name;
    private List<Product> products = new ArrayList<Product>();

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuffer productlists = new StringBuffer();
        for (Product product : this.products) {
            productlists.append("{").append(product.getCode()).append(", ")
                    .append(product.getArticle()).append(", ")
                    .append(product.getCategoryID()).append(", ")
                    .append(product.getSubcategory()).append(", ")
                    .append(product.getName()).append(", ")
                    .append(product.getVendor()).append(", ")
                    .append(product.getDDP()).append(", ")
                    .append(product.getRRP()).append(", ")
                    .append(product.getAvailability()).append(", ")
                    .append(product.getPriceUSD()).append(", ")
                    .append(product.getRetailPriceUAH()).append(", ")
                    .append(product.getWarranty()).append("}\n");
        }
        return "Pricelist{" +
                "name='" + name + '\'' +
                ", products={\n" + productlists +
                "}";
    }
}