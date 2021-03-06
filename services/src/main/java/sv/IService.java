package sv;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public interface IService<P> {

    void saveOrUpdate(P p);

    P get(Serializable id);

    P load(Serializable id);

    void delete(P p);

    List<P> getAll();
}
