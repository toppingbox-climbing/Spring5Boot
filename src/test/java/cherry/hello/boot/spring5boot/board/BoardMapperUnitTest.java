package cherry.hello.boot.spring5boot.board;

import cherry.hello.boot.spring5boot.model.Board;
import cherry.hello.boot.spring5boot.mybatis.BoardMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("boardMapper select Test")
    void selectBoard() {

        int cpg = 1;
        int stnum = (cpg-1) * 25;

        List<Board> results = boardMapper.selectBoard(stnum);

        System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("boardMapper selectOne Test")
    void selectOneBoard() {
        String bno = "810";
        Board result = boardMapper.selectOneBoard(bno);

        assertNotNull(result);
    }
    @Test
    @DisplayName("boardMapper insert Test")
    @Transactional
    void insertBoard() {
        Board b = new Board();
        b.setUserid("abc123");
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");

        int result = boardMapper.insertBoard(b);
        assertEquals(result,1);
    }

    @Test
    @DisplayName("boardMapper UpdateView Test")
    @Transactional
    void updateBoard() {
        String bno = "810";

        int result = boardMapper.updateViewBoard(bno);
                assertEquals(result,1);
    }
}