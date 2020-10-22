package by.compit.verhovni.sud.entity;

import java.math.BigDecimal;

/**
 * Класс OrderSuitConverted предназначен для корректного отображения ответа сервиса, т.к.
 * у возвращаемого объекта класса {@link supremeCourt.wsdl.OrderSuit} есть поле
 * формата {@link javax.xml.bind.JAXBElement<String>}, которое не отображается для пользователя.
 * В данном классе все поля имеют формат, необходимый для корректного отображения.
 * На одном из этапов выполнения прграммы происходит конвертация объекта класса
 * {@link supremeCourt.wsdl.OrderSuit} в объект класса OrderSuitConverted.
 */
public class OrderSuitConverted {

    private BigDecimal claimId;
    private String nameParticipant;
    private Integer unp;
    private String openDecisionDate;
    private String closeDecisionDate;
    private String price;
    private String priceDecl;

    public BigDecimal getClaimId() {
        return claimId;
    }

    public void setClaimId(BigDecimal claimId) {
        this.claimId = claimId;
    }

    public String getNameParticipant() {
        return nameParticipant;
    }

    public void setNameParticipant(String nameParticipant) {
        this.nameParticipant = nameParticipant;
    }

    public Integer getUnp() {
        return unp;
    }

    public void setUnp(Integer unp) {
        this.unp = unp;
    }

    public String getOpenDecisionDate() {
        return openDecisionDate;
    }

    public void setOpenDecisionDate(String openDecisionDate) {
        this.openDecisionDate = openDecisionDate;
    }

    public String getCloseDecisionDate() {
        return closeDecisionDate;
    }

    public void setCloseDecisionDate(String closeDecisionDate) {
        this.closeDecisionDate = closeDecisionDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceDecl() {
        return priceDecl;
    }

    public void setPriceDecl(String priceDecl) {
        this.priceDecl = priceDecl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderSuitConverted that = (OrderSuitConverted) o;

        if (claimId != null ? !claimId.equals(that.claimId) : that.claimId != null) return false;
        if (nameParticipant != null ? !nameParticipant.equals(that.nameParticipant) : that.nameParticipant != null)
            return false;
        if (unp != null ? !unp.equals(that.unp) : that.unp != null) return false;
        if (openDecisionDate != null ? !openDecisionDate.equals(that.openDecisionDate) : that.openDecisionDate != null)
            return false;
        if (closeDecisionDate != null ? !closeDecisionDate.equals(that.closeDecisionDate) : that.closeDecisionDate != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return priceDecl != null ? priceDecl.equals(that.priceDecl) : that.priceDecl == null;
    }

    @Override
    public int hashCode() {
        int result = claimId != null ? claimId.hashCode() : 0;
        result = 31 * result + (nameParticipant != null ? nameParticipant.hashCode() : 0);
        result = 31 * result + (unp != null ? unp.hashCode() : 0);
        result = 31 * result + (openDecisionDate != null ? openDecisionDate.hashCode() : 0);
        result = 31 * result + (closeDecisionDate != null ? closeDecisionDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceDecl != null ? priceDecl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderSuitConverted{" +
                "claimId=" + claimId +
                ", nameParticipant='" + nameParticipant + '\'' +
                ", unp=" + unp +
                ", openDecisionDate='" + openDecisionDate + '\'' +
                ", closeDecisionDate='" + closeDecisionDate + '\'' +
                ", price='" + price + '\'' +
                ", priceDecl='" + priceDecl + '\'' +
                '}';
    }
}
