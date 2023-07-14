package cherry.hello.boot.spring5boot.service;

import cherry.hello.boot.spring5boot.model.Board;

import java.util.List;

public interface BoardService {

    boolean saveBoard(Board b);

    List<Board> readBoard(Integer cpg);

    Board readOneBoard(String bno);

    int countBoard();

    List<Board> readFindBoard(
            Integer cpg, String ftype, String fkey);

    int countFindBoard(String ftype, String fkey);

}
