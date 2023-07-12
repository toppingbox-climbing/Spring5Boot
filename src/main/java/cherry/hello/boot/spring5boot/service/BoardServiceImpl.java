package cherry.hello.boot.spring5boot.service;

import cherry.hello.boot.spring5boot.dao.BoardDAO;
import cherry.hello.boot.spring5boot.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardDAO bdao;

    @Override
    public boolean saveBoard(Board b) {
        return false;
    }

    @Override
    public List<Board> readBoard() {
        return bdao.selectBoard();
    }

    @Override
    public Board readOneBoard(String bno) {
        return null;
    }
}
