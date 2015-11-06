package entity;

import java.math.BigDecimal;

public class XMLprice {
    private Integer OurReserv;
    private Long II;
    private Long klientID;
    private BigDecimal price1;
    private BigDecimal price_UAH;
    private BigDecimal priceRRP;
    private BigDecimal priceRRP_UAH;
    private BigDecimal priceDiler;
    private Boolean ddp;
    private String Artikul;
    private String nal;
    private String PosCode;
    private String Tip;
    private String pictureURL;
    private String tovURL;
    private String tnved;
    private String barcode;
    private String productID;
    private String war;

    public XMLprice() {
    }

    public XMLprice(Long klientID, String artikul, BigDecimal price1, String nal, String posCode, BigDecimal price_UAH) {
        this.klientID = klientID;
        Artikul = artikul;
        this.price1 = price1;
        this.nal = nal;
        PosCode = posCode;
        this.price_UAH = price_UAH;
    }

    public XMLprice(Long II, Long klientID, String artikul, BigDecimal price1, BigDecimal price_UAH, String nal,
                    String war, String posCode, String tip, BigDecimal priceRRP, BigDecimal priceRRP_UAH, Boolean ddp,
                    BigDecimal priceDiler) {
        this.II = II;
        this.klientID = klientID;
        this.Artikul = artikul;
        this.price1 = price1;
        this.price_UAH = price_UAH;
        this.nal = nal;
        this.war = war;
        this.PosCode = posCode;
        this.Tip = tip;
        this.priceRRP = priceRRP;
        this.priceRRP_UAH = priceRRP_UAH;
        this.ddp = ddp;
        this.priceDiler = priceDiler;
    }

    public Long getII() {
        return II;
    }
    public void setII(Long II) {
        this.II = II;
    }

    public Long getKlientID() {
        return klientID;
    }
    public void setKlientID(Long klientID) {
        this.klientID = klientID;
    }

    public String getArtikul() {
        return Artikul;
    }
    public void setArtikul(String artikul) {
        Artikul = artikul;
    }

    public BigDecimal getPrice1() {
        return price1;
    }
    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getPrice_UAH() {
        return price_UAH;
    }
    public void setPrice_UAH(BigDecimal price_UAH) {
        this.price_UAH = price_UAH;
    }

    public String getNal() {
        return nal;
    }
    public void setNal(String nal) {
        this.nal = nal;
    }

    public String getWar() {
        return war;
    }
    public void setWar(String war) {
        this.war = war;
    }

    public String getPosCode() {
        return PosCode;
    }
    public void setPosCode(String posCode) {
        PosCode = posCode;
    }

    public String getTip() {
        return Tip;
    }
    public void setTip(String tip) {
        Tip = tip;
    }

    public BigDecimal getPriceRRP() {
        return priceRRP;
    }
    public void setPriceRRP(BigDecimal priceRRP) {
        this.priceRRP = priceRRP;
    }

    public BigDecimal getPriceRRP_UAH() {
        return priceRRP_UAH;
    }
    public void setPriceRRP_UAH(BigDecimal priceRRP_UAH) {
        this.priceRRP_UAH = priceRRP_UAH;
    }

    public Boolean getDdp() {
        return ddp;
    }
    public void setDdp(Boolean ddp) {
        this.ddp = ddp;
    }

    public BigDecimal getPriceDiler() {
        return priceDiler;
    }
    public void setPriceDiler(BigDecimal priceDiler) {
        this.priceDiler = priceDiler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XMLprice xmLprice = (XMLprice) o;

        if (Artikul != null ? !Artikul.equals(xmLprice.Artikul) : xmLprice.Artikul != null) return false;
        if (!II.equals(xmLprice.II)) return false;
        if (PosCode != null ? !PosCode.equals(xmLprice.PosCode) : xmLprice.PosCode != null) return false;
        if (Tip != null ? !Tip.equals(xmLprice.Tip) : xmLprice.Tip != null) return false;
        if (ddp != null ? !ddp.equals(xmLprice.ddp) : xmLprice.ddp != null) return false;
        if (!klientID.equals(xmLprice.klientID)) return false;
        if (nal != null ? !nal.equals(xmLprice.nal) : xmLprice.nal != null) return false;
        if (price1 != null ? !price1.equals(xmLprice.price1) : xmLprice.price1 != null) return false;
        if (priceDiler != null ? !priceDiler.equals(xmLprice.priceDiler) : xmLprice.priceDiler != null) return false;
        if (priceRRP != null ? !priceRRP.equals(xmLprice.priceRRP) : xmLprice.priceRRP != null) return false;
        if (priceRRP_UAH != null ? !priceRRP_UAH.equals(xmLprice.priceRRP_UAH) : xmLprice.priceRRP_UAH != null)
            return false;
        if (price_UAH != null ? !price_UAH.equals(xmLprice.price_UAH) : xmLprice.price_UAH != null) return false;
        if (war != null ? !war.equals(xmLprice.war) : xmLprice.war != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = II.hashCode();
        result = 31 * result + klientID.hashCode();
        result = 31 * result + (Artikul != null ? Artikul.hashCode() : 0);
        result = 31 * result + (price1 != null ? price1.hashCode() : 0);
        result = 31 * result + (price_UAH != null ? price_UAH.hashCode() : 0);
        result = 31 * result + (nal != null ? nal.hashCode() : 0);
        result = 31 * result + (war != null ? war.hashCode() : 0);
        result = 31 * result + (PosCode != null ? PosCode.hashCode() : 0);
        result = 31 * result + (Tip != null ? Tip.hashCode() : 0);
        result = 31 * result + (priceRRP != null ? priceRRP.hashCode() : 0);
        result = 31 * result + (priceRRP_UAH != null ? priceRRP_UAH.hashCode() : 0);
        result = 31 * result + (ddp != null ? ddp.hashCode() : 0);
        result = 31 * result + (priceDiler != null ? priceDiler.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "XMLprice{" +
                "II=" + II +
                ", klientID=" + klientID +
                ", Artikul='" + Artikul + '\'' +
                ", price1=" + price1 +
                ", price_UAH=" + price_UAH +
                ", nal='" + nal + '\'' +
                ", war='" + war + '\'' +
                ", PosCode='" + PosCode + '\'' +
                ", Tip='" + Tip + '\'' +
                ", priceRRP=" + priceRRP +
                ", priceRRP_UAH=" + priceRRP_UAH +
                ", ddp=" + ddp +
                ", priceDiler=" + priceDiler +
                '}';
    }
}
