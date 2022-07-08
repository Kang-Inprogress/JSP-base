SELECT * FROM t_members;

SELECT decode(count(id), 1, 'true', 'false') AS RESULT FROM t_members WHERE id='kang' AND pwd='112233';

INSERT ALL
    INTO t_members VALUES('takeshi' , 'take11', '강연우', 'yanu1201@naver.com', sysdate)
    INTO t_members VALUES('gurei' , 'Gurei123', '김동욱', 'mrsushi18@naver.com', sysdate)
    INTO t_members VALUES('yamato' , 'yamayama', '심준영', 'youngman1@naver.com', sysdate)
    INTO t_members VALUES('yuria' , 'yuri99', '임민주', 'Im9@naver.com', sysdate)
    INTO t_members VALUES('tai' , 'tai', '강태우', 'taiwoo@naver.com', sysdate)
    INTO t_members VALUES('franky' , 'hurankuSausage', '김경중', 'lightheavy97@naver.com', sysdate)
    INTO t_members VALUES('midori' , 'nokkryeonkk', '박세준', 'Seijoon1@naver.com', sysdate)
    INTO t_members VALUES('tsuyoshi' , 'tsuyoii', '김우현', 'hyeonwoo19@naver.com', sysdate)
    INTO t_members VALUES('ryoma' , 'iimaItaidesu', '강동현', 'kangkgri@naver.com', sysdate)
    INTO t_members VALUES('yamada' , 'untenMakasero', '조현성', 'bestdriver82@naver.com', sysdate)
SELECT * FROM DUAL;