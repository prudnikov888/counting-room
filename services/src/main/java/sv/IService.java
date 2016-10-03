package sv;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
public interface IService<P> {

    void saveOrUpdate(P p);

    P get(Serializable id);

    P load(Serializable id);

    void delete(P p);
}
