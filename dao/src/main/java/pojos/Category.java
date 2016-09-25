package pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by prudnikov on 21.06.2015.
 */
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private long categoryId;

    @Column
    private String categoryName;

    @ManyToMany (mappedBy = "categories")
    private List<Account> accounts;

    public Category(){

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
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

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return (this.categoryId == category.categoryId);
    }

    @Override
    public int hashCode(){

        String s = categoryId + "";
        return s.hashCode();
    }
}
