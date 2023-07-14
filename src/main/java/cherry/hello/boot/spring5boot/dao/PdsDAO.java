package cherry.hello.boot.spring5boot.dao;

import cherry.hello.boot.spring5boot.model.Pds;
import cherry.hello.boot.spring5boot.model.PdsAttach;

public interface PdsDAO {

    int insertPds(Pds p);

    int insertPdsAttach(PdsAttach pa);

}
