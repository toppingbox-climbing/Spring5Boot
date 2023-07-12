package cherry.hello.boot.spring5boot.board;

import cherry.hello.boot.spring5boot.model.Board;
import cherry.hello.boot.spring5boot.model.Member;
import cherry.hello.boot.spring5boot.mybatis.BoardMapper;
import cherry.hello.boot.spring5boot.mybatis.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("boardMapper select Test")
    void selectBoard() {

        List<Board> results = boardMapper.selectBoard();

        System.out.println(results);
        assertNotNull(results);
    }
}