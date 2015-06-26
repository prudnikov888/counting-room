package pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prudnikov on 21.06.2015.
 */
public class Account implements Serializable {
    private long accountId;
    private String accountName;
    private double balance;
    private String currency;
    private List<Category> categories;
    public Account(){

    }
    public Account (String accountName, double balance, String currency, List<Category> categories){
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
        this.categories = categories;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj instanceof Account) {
            Account temp = (Account) obj;
            if (accountId == temp.accountId
                    && accountName.equals(temp.accountName)
                    && balance == temp.balance
                    && currency.equals(temp.currency)
                    )
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        String s = accountId + "";
        return s.hashCode();
    }


}
