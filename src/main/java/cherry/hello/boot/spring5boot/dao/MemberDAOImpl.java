package cherry.hello.boot.spring5boot.dao;

import cherry.hello.boot.spring5boot.model.Member;
import cherry.hello.boot.spring5boot.model.Zipcode;
import cherry.hello.boot.spring5boot.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("mdao")
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    // mybatis 를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입 방식 사용!
    @Autowired
    final MemberMapper memberMapper;

//    @Autowired
//    private SqlSession sqlSession;
    @Override
    public int insertMember(Member m) {
        //insert(insert 관련 맵핑, 매개변수)
        //sqlSession.insert("",m) 매개변수 원래 하나 더 써야하는데, "" <-이것. 근데 문자를 안써도 되게 아래 코드로 바꾼것.
        //sqlSession.insert("insertMember",m)로 사용하는 방식보다 편리
        //return sqlSession.insert("MemberMapper.insertMember",m);
        return memberMapper.insertMember(m);
    }

    @Override
    public List<Member> selectMember() {

        return memberMapper.selectMember();
    }

    @Override
    public List<Zipcode> selectzip(String dong) {

        return memberMapper.findZipcode(dong);
    }
}
