package entity;

public class GoodsForScan {

    private Long КодТовара;
    private Integer КодТипа;
    private String artikul;

    public GoodsForScan() {

    }
    public GoodsForScan(Long КодТовара, Integer КодТипа, String artikul) {
        this.КодТовара = КодТовара;
        this.КодТипа = КодТипа;
        this.artikul = artikul;
    }

    public Long getКодТовара() {
        return КодТовара;
    }
    public void setКодТовара(Long кодТовара) {
        this.КодТовара = кодТовара;
    }
    public Integer getКодТипа() {
        return КодТипа;
    }
    public void setКодТипа(Integer кодТипа) {
        this.КодТипа = кодТипа;
    }
    public String getArtikul() {
        return artikul;
    }
    public void setArtikul(String artikul) {
        this.artikul = artikul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsForScan goodsForScan = (GoodsForScan) o;

        if (!artikul.equals(goodsForScan.artikul)) return false;
        if (!КодТовара.equals(goodsForScan.КодТовара)) return false;
        if (!КодТипа.equals(goodsForScan.КодТипа)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = КодТовара.hashCode();
        result = 31 * result + КодТипа.hashCode();
        result = 31 * result + artikul.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GoodsForScan{ " +
                "КодТовара = " + КодТовара +
                ", КодТипа = '" + КодТипа + '\'' + "\t"+
                ", artikul = " + artikul +
                '}';
    }
}
