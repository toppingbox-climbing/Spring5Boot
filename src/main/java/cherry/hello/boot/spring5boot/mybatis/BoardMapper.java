package cherry.hello.boot.spring5boot.mybatis;

import cherry.hello.boot.spring5boot.model.Board;
import cherry.hello.boot.spring5boot.model.Member;
import cherry.hello.boot.spring5boot.model.Zipcode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
        int insertBoard(Board b);
List<Board> selectBoard();
Board selectOneBoard(String bno);
}

