package cherry.hello.boot.spring5boot.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Member {
    private String mno;
    private String userid;
    private String passwd;
    private String name;
    private String jumin;
    private String email;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String phone;
    private String regdate;
}
