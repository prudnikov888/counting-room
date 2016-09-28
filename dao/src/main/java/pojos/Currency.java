package pojos;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by anpr0915 on 26.09.2016.
 */
@Entity
public class Currency implements Serializable {

    @Id
    @SequenceGenerator(name = "currency_seq", sequenceName = "currency_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "currency_seq")
    private BigInteger currencyId;

    @Column
    private String currencyFullName;

    @NaturalId
    private String currencyAbbreviation;


    public BigInteger getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(BigInteger currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyFullName() {
        return currencyFullName;
    }

    public void setCurrencyFullName(String currencyFullName) {
        this.currencyFullName = currencyFullName;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Currency)) {
            return false;
        }
        Currency currency = (Currency) obj;
        return Objects.equals(this.currencyId, currency.currencyId);
    }

    @Override
    public int hashCode() {
        String s = currencyId + "";
        return s.hashCode();
    }
}
