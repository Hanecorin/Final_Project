use play_data_talk;

show tables;

drop table if exists love;
drop table if exists reply;
drop table if exists post;
drop table if exists user;

CREATE TABLE user (
	   user_id     		VARCHAR(50) PRIMARY KEY,
	   pw 		VARCHAR(20) NOT NULL,
       name           			VARCHAR(10) NOT NULL,       
       mail          				VARCHAR(20) NOT NULL,
       img_url      			VARCHAR(100)
);

CREATE TABLE post (
	   post_id     		INT AUTO_INCREMENT PRIMARY KEY,
	   user_id 		VARCHAR(50),
       text           			VARCHAR(200) NOT NULL,       
       create_date          				date not null,
       update_date           				date, 
       keyword_first     			VARCHAR(10),
       keyword_second     			VARCHAR(10),
       keyword_third     			VARCHAR(10)
);

CREATE TABLE reply (
	   reply_id     		INT AUTO_INCREMENT PRIMARY KEY,
       post_id     		INT NOT NULL,
	   user_id 		VARCHAR(50),
       reply           			VARCHAR(100) NOT NULL,       
       create_date          				date not null,
       update_date           				date
);

CREATE TABLE love (
	love_id    INT AUTO_INCREMENT PRIMARY KEY,
    user_id varchar(50),
    post_id INT NOT NULL
);

ALTER TABLE post AUTO_INCREMENT = 1;
ALTER TABLE post  ADD FOREIGN KEY (user_id) REFERENCES user  (user_id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE reply AUTO_INCREMENT = 1;
ALTER TABLE reply  ADD FOREIGN KEY (post_id) REFERENCES post  (post_id) on delete cascade;
ALTER TABLE reply  ADD FOREIGN KEY (user_id) REFERENCES user  (user_id) on delete set null;

alter table love add foreign key (user_id) references user (user_id) on delete cascade;
alter table love add foreign key (post_id) references post (post_id) on delete cascade;

desc user;
desc post;
desc reply;
desc love;