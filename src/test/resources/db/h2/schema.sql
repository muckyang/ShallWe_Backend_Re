--CREATE DATABASE IF NOT EXISTS 'test_db';
--USE `test_db`;

-- 테이블 test_db.comment 구조 내보내기
--CREATE TABLE IF NOT EXISTS `comment` (
--  `comment_id` bigint(20) NOT NULL,
--  `create_time` datetime(6) DEFAULT NULL,
--  `content` varchar(255) DEFAULT NULL,
--  `status` varchar(255) DEFAULT NULL,
--  `order_id` bigint(20) DEFAULT NULL,
--  `user_id` bigint(20) DEFAULT NULL,
--  PRIMARY KEY (`comment_id`),
--  KEY `FKnco04y20lvqd8dxyqlhobr840` (`order_id`),
--  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
--  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
--  CONSTRAINT `FKnco04y20lvqd8dxyqlhobr840` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
---- 내보낼 데이터가 선택되어 있지 않습니다.
--
---- 테이블 test_db.comment_history 구조 내보내기
--CREATE TABLE IF NOT EXISTS `comment_history` (
--  `comment_history_id` bigint(20) NOT NULL,
--  `comment_id` bigint(20) DEFAULT NULL,
--  `content` varchar(255) DEFAULT NULL,
--  `order_id` bigint(20) DEFAULT NULL,
--  `status` varchar(255) DEFAULT NULL,
--  `user_id` bigint(20) DEFAULT NULL,
--  PRIMARY KEY (`comment_history_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
---- 내보낼 데이터가 선택되어 있지 않습니다.
--
---- 테이블 shallwetest.hibernate_sequence 구조 내보내기
--CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
--  `next_not_cached_value` bigint(21) NOT NULL,
--  `minimum_value` bigint(21) NOT NULL,
--  `maximum_value` bigint(21) NOT NULL,
--  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
--  `increment` bigint(21) NOT NULL COMMENT 'increment value',
--  `cache_size` bigint(21) unsigned NOT NULL,
--  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
--  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
--) ENGINE=InnoDB SEQUENCE=1;
--
--CREATE TABLE IF NOT EXISTS `likes` (
--  `like_id` bigint(20) NOT NULL,
--  PRIMARY KEY (`like_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
---- 내보낼 데이터가 선택되어 있지 않습니다.
--
---- 테이블 shallwetest.orders 구조 내보내기
--CREATE TABLE IF NOT EXISTS `orders` (
--  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `create_time` datetime(6) DEFAULT NULL,
--  `category` varchar(255) DEFAULT NULL,
--  `comment_count` int(11) NOT NULL,
--  `description` varchar(255) DEFAULT NULL,
--  `order_end_time` datetime(6) DEFAULT NULL,
--  `goal_price` int(11) NOT NULL,
--  `like_count` int(11) NOT NULL,
--  `status` varchar(255) DEFAULT NULL,
--  `sum_price` int(11) NOT NULL,
--  `title` varchar(255) DEFAULT NULL,
--  `user_id` bigint(20) DEFAULT NULL,
--  PRIMARY KEY (`order_id`),
--  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
--  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
--) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
--
---- 내보낼 데이터가 선택되어 있지 않습니다.
--
---- 테이블 shallwetest.order_like 구조 내보내기
--CREATE TABLE IF NOT EXISTS `order_like` (
--  `order_like_id` bigint(20) NOT NULL,
--  `like_id` bigint(20) DEFAULT NULL,
--  `order_id` bigint(20) DEFAULT NULL,
--  PRIMARY KEY (`order_like_id`),
--  KEY `FKhc7fvbs6wumo1radat86g2oqo` (`like_id`),
--  KEY `FK2g9d13fvktqpku3r0dmtyq76p` (`order_id`),
--  CONSTRAINT `FK2g9d13fvktqpku3r0dmtyq76p` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
--  CONSTRAINT `FKhc7fvbs6wumo1radat86g2oqo` FOREIGN KEY (`like_id`) REFERENCES `likes` (`like_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
---- 내보낼 데이터가 선택되어 있지 않습니다.
--
---- 테이블 shallwetest.party 구조 내보내기
--CREATE TABLE IF NOT EXISTS `party` (
--  `party_id` bigint(20) NOT NULL,
--  `create_time` datetime(6) DEFAULT NULL,
--  `join_description` varchar(255) DEFAULT NULL,
--  `price` int(11) NOT NULL,
--  `status` varchar(255) DEFAULT NULL,
--  `order_id` bigint(20) DEFAULT NULL,
--  `user_id` bigint(20) DEFAULT NULL,
--  PRIMARY KEY (`party_id`),
--  KEY `FK5n28x67n97etojl3hgmri98l0` (`order_id`),
--  KEY `FKtcag4fsdqkmo7owjkk1p25h41` (`user_id`),
--  CONSTRAINT `FK5n28x67n97etojl3hgmri98l0` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
--  CONSTRAINT `FKtcag4fsdqkmo7owjkk1p25h41` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
---- 내보낼 데이터가 선택되어 있지 않습니다.
--
---- 테이블 shallwetest.tag 구조 내보내기
--CREATE TABLE IF NOT EXISTS `tag` (
--  `tag_id` bigint(20) NOT NULL,
--  `tag_name` varchar(255) DEFAULT NULL,
--  `order_id` bigint(20) DEFAULT NULL,
--  PRIMARY KEY (`tag_id`),
--  KEY `FK248gqp9d0gtesbwsds036u9fg` (`order_id`),
--  CONSTRAINT `FK248gqp9d0gtesbwsds036u9fg` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 shallwetest.user 구조 내보내기
--CREATE TABLE IF NOT EXISTS `user` (
--  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
--  `create_time` datetime(6) DEFAULT NULL,
--  `city` varchar(255) DEFAULT NULL,
--  `detail` varchar(255) DEFAULT NULL,
--  `street` varchar(255) DEFAULT NULL,
--  `email` varchar(255) DEFAULT NULL,
--  `birthday` date DEFAULT NULL,
--  `grade` int(11) NOT NULL,
--  `point` int(11) NOT NULL,
--  `status` varchar(255) DEFAULT NULL,
--  `name` varchar(255) DEFAULT NULL,
--  `nickname` varchar(255) DEFAULT NULL,
--  `password` varchar(255) DEFAULT NULL,
--  PRIMARY KEY (`user_id`)
--) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;