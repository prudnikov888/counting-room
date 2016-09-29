package sv;

import db.impl.HouseholdDao;
import org.springframework.beans.factory.annotation.Autowired;
import pojos.Household;

/**
 * Created by anpr0915 on 29.09.2016.
 */
public class HouseholdService extends BaseService<Household> {

    @Autowired
    public HouseholdService (HouseholdDao householdDao) {
        super(householdDao);
    }
}
