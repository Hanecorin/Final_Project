-- user Test Data 생성
insert into user values('abcd@naver.com', 'a1234', '김가나', 'abcd@naver.com', null);
insert into user values('lalala@gmail.com', 'b9876', '노바다', 'lalala@gmail.com', null);

-- post Test Data 생성
insert into post (user_id, text, create_date) values('abcd@naver.com','this is test','2022-01-01');
insert into post (user_id, text, create_date) values('lalala@gmail.com','this is test','2022-01-01');

-- reply Test Data 생성
insert into reply (post_id, user_id, reply, create_date) values(1,'abcd@naver.com','thie is test','2022-01-01');

-- love Test Data 생성
insert into love values(1, 'abcd@naver.com',1);
insert into love values(2, 'lalala@gmail.com',1);

select * from user;
select * from post;
select * from reply;
select * from love;

delete from user where user_id = 'abcd@naver.com';
delete from post where post_id = 1;