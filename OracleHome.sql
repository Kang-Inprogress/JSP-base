CREATE TABLE t_members(
    id varchar(10) not null primary key,
    pwd varchar(50) not null,
    name varchar(10),
    email varchar(50),
    joinDate DATE default sysdate
);

INSERT INTO t_members values ('kang', '112233', 'yeonwoo', 'yeonu1201@naver.com', sysdate);
INSERT INTO t_members values ('hong', '110290', 'gildong', 'higigw@gmail.com', sysdate);

SELECT * FROM t_members;