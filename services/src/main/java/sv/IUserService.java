package sv;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public interface IUserService<P> extends IService<P> {


}
