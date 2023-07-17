package cherry.hello.boot.spring5boot.dao;

import cherry.hello.boot.spring5boot.model.Pds;
import cherry.hello.boot.spring5boot.model.PdsAttach;

import java.util.List;

public interface PdsDAO {

    int insertPds(Pds p);

    int insertPdsAttach(PdsAttach pa);

    List<Pds> selectPds(int stnum);

    int selectCountPds();

    Pds selectOnePds(String pno);
}
