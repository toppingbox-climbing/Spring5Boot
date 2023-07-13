package cherry.hello.boot.spring5boot.mybatis;

import cherry.hello.boot.spring5boot.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
        int insertBoard(Board b);
List<Board> selectBoard(int stnum);
Board selectOneBoard(String bno);

int updateViewBoard(String bno);
}

