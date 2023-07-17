-- member
create table member2 (
    mno     int             auto_increment,
    userid  varchar(18)     unique,
    passwd  varchar(18)     not null,
    name    varchar(10)     not null,
    email   varchar(50)     unique,
    zipcode char(7)         not null,
    addr1   varchar(100)    not null,
    addr2   varchar(100)    not null,
    phone   char(13)        not null,
    regdate datetime        default current_timestamp,
    primary key (mno)
);

insert into member2
(userid, passwd, name, email, zipcode, addr1, addr2, phone)
values ('abc123','987xyz','cherry','cherry@abc123.co.kr',
        '123-456','서울 관악구','블라','123-4567-8901');

select * from member2;

-- board
create table board2 (
    bno                int                     auto_increment,
    title                varchar(100)       not null,
    userid             varchar(18)        not null,
    regdate           datetime           default current_timestamp,
    thumbs           int                    default 0,
    views              int                    default 0,
    contents          text                  not null,
    ipaddr             varchar(15)          not null,
    primary key     (bno)
    -- , foreign key      (userid) references member2(userid)

);

alter table board2
        add constraint fkuid
            foreign key (userid) references member2 (userid);
-- 제약 조건에 대한 이름을 지정한 것
-- 위에 같이쓰면 제약조건이 임의로 지정되고
-- 위에처럼 따로 쓰면 이름을 지정한거라서 나중에 수정 삭제가 용이하다. 안찾아도 되니까

insert into board2 (userid,title,contents, ipaddr)
values ('cherry','클라이밍 하고싶다.','비 좀 그만와라','66.249.70.131');

insert into board2 (userid,title,contents, ipaddr)
values ('climbing','헬스 재미없다.','기사 내용을 복사 붙여넣기 하시오','66.249.66.204');

insert into board2 (userid,title,contents, ipaddr)
values ('abc123','러닝도 재미없다.','하지만 비가 오면 달리지 못한다.','77.192.68.205');

select count(userid) cnt, ceil(count(userid) / 25) pages
from board2;

-- 외래키 제약 조건이 걸려있으면 참조하는 테이블의 실제 값이랑, 서로 맞춰줘야한다.
-- 무결성 제약조건 위배하기 때문에

select * from board2
         where title like '%클라이밍%';


-- pds
create table pds (
                     pno                int                     auto_increment,
                     title                varchar(100)       not null,
                     userid            varchar(18)        not null,
                     regdate          datetime           default current_timestamp,
                     thumbs          int                    default 0,
                     views              int                    default 0,
                     contents         text                  not null,
                     ipaddr            varchar(15)        not null,
                     primary key     (pno)
);


create table pdsattach (
    pano                int                       auto_increment,
    pno                  int                        not null,  -- 게시글 번호
    fname              varchar(200)          not null, -- 유효 아이디 포함 uuid
    ftype                varchar(3)             not null,
    fdown              int                         default 0,
    primary key (pano)
);

alter table pds
        add constraint fkpuid
                foreign key (userid) references member2 (userid);

alter table pdsattach
    add constraint fkpno
        foreign key (pno) references pds (pno);

-- join
select * from pds p join pdsattach pa
                         using (pno) where p.pno = '5';


-- view (가상테이블)
create view ppa
as
select * from pds p join pdsattach pa
                         using (pno);

select * from ppa where pno = '5';