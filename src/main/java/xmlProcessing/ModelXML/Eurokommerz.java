package xmlProcessing.ModelXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"семейство", "UID", "артикул", "название", "описание", "едИзм", "цена", "наличие", "бренд"}, name = "Eurokommerz")
public class Eurokommerz {

    private String семейство;
    private String UID;
    private String артикул;
    private String название;
    private String описание;
    private String едИзм;
    private String цена;
    private String наличие;
    private String бренд;

    @XmlElement(name = "Семейство")
    public String getСемейство() {
        return семейство;
    }
    public void setСемейство(String семейство) {
        this.семейство = семейство;
    }

    @XmlElement(name = "UID")
    public String getUID() {
        return UID;
    }
    public void setUID(String UID) {
        this.UID = UID;
    }

    @XmlElement(name = "Артикул")
    public String getАртикул() {
        return артикул;
    }
    public void setАртикул(String артикул) {
        this.артикул = артикул;
    }

    @XmlElement(name = "Название")
    public String getНазвание() {
        return название;
    }
    public void setНазвание(String название) {
        this.название = название;
    }

    @XmlElement(name = "Описание")
    public String getОписание() {
        return описание;
    }
    public void setОписание(String описание) {
        this.описание = описание;
    }

    @XmlElement(name = "ЕдИзм")
    public String getЕдИзм() {
        return едИзм;
    }
    public void setЕдИзм(String едИзм) {
        this.едИзм = едИзм;
    }

    @XmlElement(name = "Цена")
    public String getЦена() {
        return цена;
    }
    public void setЦена(String цена) {
        this.цена = цена;
    }

    @XmlElement(name = "Наличие")
    public String getНаличие() {
        return наличие;
    }
    public void setНаличие(String наличие) {
        this.наличие = наличие;
    }

    @XmlElement(name = "Бренд")
    public String getБренд() {
        return бренд;
    }
    public void setБренд(String бренд) {
        this.бренд = бренд;
    }

}