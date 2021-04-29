
INSERT INTO comment (comment_id, create_time, content, status, order_id, user_id) VALUES
	(4, '2021-04-27 11:01:50.719477', '댓글 작성 합니다', 'NORMAL', 1, 2);

--INSERT INTO hibernate_sequence  VALUES	(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

INSERT INTO orders VALUES (1, '2021-04-27 11:01:50.562911', 'DELIVERY', 1, '치킨 같이 시켜 먹어요!', '2021-04-27 15:01:50.464900', 32000, 0, NULL, 0, '치킨먹을사람~', 1);

INSERT INTO party VALUES
	(3, '2021-04-27 11:01:50.604911', '글 게시자 본인 입니다.', 6000, 'JOIN', 1, 1);

INSERT INTO tag VALUES
	(1, '치킨', 1),
	(2, '음식', 1);

INSERT INTO user VALUES
	(1, '2021-04-27 11:01:48.594485', 'seoul', 'room 11673', '1673street', 'user1673@naver.com', '2013-03-08', 2, 1000, 'ACTIVE', 'Clone1673', 'nick1673', '12341234'),
	(99, '2021-04-27 11:01:50.376906', 'seoul', 'room 199716', '99716street', 'user99716@naver.com', '1994-11-18', 2, 1000, 'ACTIVE', 'Clone99716', 'nick99716', '12341234');
