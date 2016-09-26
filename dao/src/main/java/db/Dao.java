package db;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by anpr0915 on 25.09.2016.
 */
public interface Dao<P> {

    void saveOrUpdate(P p);

    P get(Serializable id);

    P load(Serializable id);

    void delete(P p);
}
