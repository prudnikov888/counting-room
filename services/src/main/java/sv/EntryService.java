package sv;

import db.impl.EntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojos.Entry;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
public class EntryService extends BaseService<Entry> {

    @Autowired
    public EntryService (EntryDao entryDao) {
        super(entryDao);
    }
}
