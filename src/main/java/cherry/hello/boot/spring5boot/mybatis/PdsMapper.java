package cherry.hello.boot.spring5boot.mybatis;
import cherry.hello.boot.spring5boot.model.PdsAttach;
import org.apache.ibatis.annotations.Mapper;
import cherry.hello.boot.spring5boot.model.Pds;
import java.util.List;
import java.util.Map;

@Mapper
public interface PdsMapper {
        int insertPds(Pds b);

        int lastPdsPno();

        int insertPdsAttach(PdsAttach pa);

        List<Pds> selectpds(int stnum);
        Pds selectOnepds(String bno);

        int selectCountpds();

        List<Pds> selectPds(int stnum);

        int selectCountPds();

        PdsAttach selectOnePdsAttach(String pno);

        Pds selectOnePds(String pno);

        //
//int updateViewpds(String bno);
//

//
//List<pds> selectFindpds(Map<String, Object> params);
//int  countFindpds(Map<String, Object> params);
}