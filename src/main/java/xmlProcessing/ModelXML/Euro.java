package xmlProcessing.ModelXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"row", "cell"}, name = "Pricelist")
@XmlRootElement
public class Euro {

    private String row;
    private String cell;

    @XmlElement(name = "Row")
    public String getRow() {
        return row;
    }
    public void setRow(String row) {
        this.row = row;
    }

    @XmlElement(name = "Cell")
    public String getCell() {
        return cell;
    }
    public void setCell(String cell) {
        this.cell = cell;
    }
}
