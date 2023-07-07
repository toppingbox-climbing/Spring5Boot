package cherry.hello.boot.spring5boot;

import cherry.hello.boot.spring5boot.dao.MemberDAO;
import cherry.hello.boot.spring5boot.dao.MemberDAOImpl;
import cherry.hello.boot.spring5boot.model.Member;
import cherry.hello.boot.spring5boot.mybatis.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberMapperUnitTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("MemberMapper insert Test")
    void insertMember() {
        Member m = new Member(null,"","","","",
                "","","","",null);

        int result = memberMapper.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);
    }
}