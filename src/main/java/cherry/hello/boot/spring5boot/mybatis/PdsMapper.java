package cherry.hello.boot.spring5boot.mybatis;

import cherry.hello.boot.spring5boot.model.Pds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PdsMapper {
        int insertPds(Pds b);

        int lastPdsPno();

//List<pds> selectpds(int stnum);
//pds selectOnepds(String bno);
//
//int updateViewpds(String bno);
//
//int selectCountpds();
//
//List<pds> selectFindpds(Map<String, Object> params);
//int  countFindpds(Map<String, Object> params);

}

