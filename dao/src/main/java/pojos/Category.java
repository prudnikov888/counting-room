package pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prudnikov on 21.06.2015.
 */
public class Category implements Serializable {
    private long categoryId;
    private String categoryName;
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
        if (obj instanceof Category) {
            Category temp = (Category) obj;
            if (categoryId == temp.categoryId
                    && categoryName.equals(temp.categoryName)
                    )
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode(){
        String s = categoryId + "";
        return s.hashCode();
    }


}
