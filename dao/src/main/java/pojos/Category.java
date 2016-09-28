package pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue (strategy = SEQUENCE, generator = "category_seq")
    private BigInteger categoryId;

    @Column
    private String categoryName;

    @OneToMany (mappedBy = "category")
    private List<Account> accounts;

    @OneToOne
    private User user;

    public Category(){

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return Objects.equals(this.categoryId, category.categoryId);
    }

    @Override
    public int hashCode(){
        String s = categoryId + "";
        return s.hashCode();
    }
}
