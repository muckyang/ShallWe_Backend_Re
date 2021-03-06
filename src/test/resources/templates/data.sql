
INSERT INTO `comment` (`comment_id`, `create_time`, `content`, `status`, `order_id`, `user_id`) VALUES
	(4, '2021-04-27 11:01:50.719477', '댓글 작성 합니다', 'NORMAL', 1, 2);

INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

INSERT INTO `orders` (`order_id`, `create_time`, `category`, `comment_count`, `description`, `order_end_time`, `goal_price`, `like_count`, `status`, `sum_price`, `title`, `user_id`) VALUES
	(1, '2021-04-27 11:01:50.562911', 'DELIVERY', 1, '치킨 같이 시켜 먹어요!', '2021-04-27 15:01:50.464900', 32000, 0, NULL, 0, '치킨먹을사람~', 1);

INSERT INTO `party` (`party_id`, `create_time`, `join_description`, `price`, `status`, `order_id`, `user_id`) VALUES
	(3, '2021-04-27 11:01:50.604911', '글 게시자 본인 입니다.', 6000, 'JOIN', 1, 1);

INSERT INTO `tag` (`tag_id`, `tag_name`, `order_id`) VALUES
	(1, '치킨', 1),
	(2, '음식', 1);

INSERT INTO `user` (`user_id`, `create_time`, `city`, `detail`, `street`, `email`, `birthday`, `grade`, `point`, `status`, `name`, `nickname`, `password`) VALUES
	(1, '2021-04-27 11:01:48.594485', 'seoul', 'room 11673', '1673street', 'user1673@naver.com', '2013-03-08', 2, 1000, 'ACTIVE', 'Clone1673', 'nick1673', '12341234'),
	(2, '2021-04-27 11:01:48.713599', 'seoul', 'room 12449', '2449street', 'user2449@naver.com', '1998-01-26', 2, 1000, 'ACTIVE', 'Clone2449', 'nick2449', '12341234'),
	(3, '2021-04-27 11:01:48.721599', 'seoul', 'room 13768', '3768street', 'user3768@naver.com', '2005-10-08', 2, 1000, 'ACTIVE', 'Clone3768', 'nick3768', '12341234'),
	(4, '2021-04-27 11:01:48.728599', 'seoul', 'room 14952', '4952street', 'user4952@naver.com', '2007-09-25', 2, 1000, 'ACTIVE', 'Clone4952', 'nick4952', '12341234'),
	(5, '2021-04-27 11:01:48.735601', 'seoul', 'room 15992', '5992street', 'user5992@naver.com', '1999-05-11', 2, 1000, 'ACTIVE', 'Clone5992', 'nick5992', '12341234'),
	(6, '2021-04-27 11:01:48.741600', 'seoul', 'room 16781', '6781street', 'user6781@naver.com', '2012-12-28', 2, 1000, 'ACTIVE', 'Clone6781', 'nick6781', '12341234'),
	(7, '2021-04-27 11:01:48.747606', 'seoul', 'room 17675', '7675street', 'user7675@naver.com', '2016-09-25', 2, 1000, 'ACTIVE', 'Clone7675', 'nick7675', '12341234'),
	(8, '2021-04-27 11:01:48.753599', 'seoul', 'room 18454', '8454street', 'user8454@naver.com', '1992-01-18', 2, 1000, 'ACTIVE', 'Clone8454', 'nick8454', '12341234'),
	(9, '2021-04-27 11:01:48.759599', 'seoul', 'room 19664', '9664street', 'user9664@naver.com', '1996-03-03', 2, 1000, 'ACTIVE', 'Clone9664', 'nick9664', '12341234'),
	(10, '2021-04-27 11:01:48.765600', 'seoul', 'room 110028', '10028street', 'user10028@naver.com', '2004-10-05', 2, 1000, 'ACTIVE', 'Clone10028', 'nick10028', '12341234'),
	(11, '2021-04-27 11:01:48.771600', 'seoul', 'room 111049', '11049street', 'user11049@naver.com', '2010-03-24', 2, 1000, 'ACTIVE', 'Clone11049', 'nick11049', '12341234'),
	(12, '2021-04-27 11:01:48.777616', 'seoul', 'room 112223', '12223street', 'user12223@naver.com', '2019-12-06', 2, 1000, 'ACTIVE', 'Clone12223', 'nick12223', '12341234'),
	(13, '2021-04-27 11:01:48.783599', 'seoul', 'room 113255', '13255street', 'user13255@naver.com', '2008-11-08', 2, 1000, 'ACTIVE', 'Clone13255', 'nick13255', '12341234'),
	(14, '2021-04-27 11:01:48.788597', 'seoul', 'room 114556', '14556street', 'user14556@naver.com', '2011-04-05', 2, 1000, 'ACTIVE', 'Clone14556', 'nick14556', '12341234'),
	(15, '2021-04-27 11:01:48.793600', 'seoul', 'room 115827', '15827street', 'user15827@naver.com', '2001-04-01', 2, 1000, 'ACTIVE', 'Clone15827', 'nick15827', '12341234'),
	(16, '2021-04-27 11:01:48.800600', 'seoul', 'room 116946', '16946street', 'user16946@naver.com', '1994-06-12', 2, 1000, 'ACTIVE', 'Clone16946', 'nick16946', '12341234'),
	(17, '2021-04-27 11:01:48.806602', 'seoul', 'room 117534', '17534street', 'user17534@naver.com', '2009-03-11', 2, 1000, 'ACTIVE', 'Clone17534', 'nick17534', '12341234'),
	(18, '2021-04-27 11:01:48.811599', 'seoul', 'room 118503', '18503street', 'user18503@naver.com', '2004-04-15', 2, 1000, 'ACTIVE', 'Clone18503', 'nick18503', '12341234'),
	(19, '2021-04-27 11:01:48.817631', 'seoul', 'room 119603', '19603street', 'user19603@naver.com', '1995-06-15', 2, 1000, 'ACTIVE', 'Clone19603', 'nick19603', '12341234'),
	(20, '2021-04-27 11:01:48.824601', 'seoul', 'room 120501', '20501street', 'user20501@naver.com', '1990-11-28', 2, 1000, 'ACTIVE', 'Clone20501', 'nick20501', '12341234'),
	(21, '2021-04-27 11:01:48.829603', 'seoul', 'room 121211', '21211street', 'user21211@naver.com', '1994-07-03', 2, 1000, 'ACTIVE', 'Clone21211', 'nick21211', '12341234'),
	(22, '2021-04-27 11:01:48.836599', 'seoul', 'room 122723', '22723street', 'user22723@naver.com', '1994-08-23', 2, 1000, 'ACTIVE', 'Clone22723', 'nick22723', '12341234'),
	(23, '2021-04-27 11:01:48.842603', 'seoul', 'room 123574', '23574street', 'user23574@naver.com', '2006-12-26', 2, 1000, 'ACTIVE', 'Clone23574', 'nick23574', '12341234'),
	(24, '2021-04-27 11:01:48.847640', 'seoul', 'room 124684', '24684street', 'user24684@naver.com', '2016-11-28', 2, 1000, 'ACTIVE', 'Clone24684', 'nick24684', '12341234'),
	(25, '2021-04-27 11:01:48.853640', 'seoul', 'room 125221', '25221street', 'user25221@naver.com', '2008-09-06', 2, 1000, 'ACTIVE', 'Clone25221', 'nick25221', '12341234'),
	(26, '2021-04-27 11:01:48.859640', 'seoul', 'room 126427', '26427street', 'user26427@naver.com', '2016-03-27', 2, 1000, 'ACTIVE', 'Clone26427', 'nick26427', '12341234'),
	(27, '2021-04-27 11:01:48.864616', 'seoul', 'room 127312', '27312street', 'user27312@naver.com', '2015-04-25', 2, 1000, 'ACTIVE', 'Clone27312', 'nick27312', '12341234'),
	(28, '2021-04-27 11:01:48.897601', 'seoul', 'room 128883', '28883street', 'user28883@naver.com', '1998-03-08', 2, 1000, 'ACTIVE', 'Clone28883', 'nick28883', '12341234'),
	(29, '2021-04-27 11:01:48.903605', 'seoul', 'room 129093', '29093street', 'user29093@naver.com', '2002-02-23', 2, 1000, 'ACTIVE', 'Clone29093', 'nick29093', '12341234'),
	(30, '2021-04-27 11:01:48.909601', 'seoul', 'room 130012', '30012street', 'user30012@naver.com', '2011-07-07', 2, 1000, 'ACTIVE', 'Clone30012', 'nick30012', '12341234'),
	(31, '2021-04-27 11:01:48.918602', 'seoul', 'room 131837', '31837street', 'user31837@naver.com', '1990-01-05', 2, 1000, 'ACTIVE', 'Clone31837', 'nick31837', '12341234'),
	(32, '2021-04-27 11:01:48.928608', 'seoul', 'room 132192', '32192street', 'user32192@naver.com', '2009-09-08', 2, 1000, 'ACTIVE', 'Clone32192', 'nick32192', '12341234'),
	(33, '2021-04-27 11:01:48.935599', 'seoul', 'room 133870', '33870street', 'user33870@naver.com', '1997-09-20', 2, 1000, 'ACTIVE', 'Clone33870', 'nick33870', '12341234'),
	(34, '2021-04-27 11:01:49.437327', 'seoul', 'room 134586', '34586street', 'user34586@naver.com', '2019-05-12', 2, 1000, 'ACTIVE', 'Clone34586', 'nick34586', '12341234'),
	(35, '2021-04-27 11:01:49.445316', 'seoul', 'room 135521', '35521street', 'user35521@naver.com', '1995-09-09', 2, 1000, 'ACTIVE', 'Clone35521', 'nick35521', '12341234'),
	(36, '2021-04-27 11:01:49.450315', 'seoul', 'room 136463', '36463street', 'user36463@naver.com', '2009-01-13', 2, 1000, 'ACTIVE', 'Clone36463', 'nick36463', '12341234'),
	(37, '2021-04-27 11:01:49.456346', 'seoul', 'room 137109', '37109street', 'user37109@naver.com', '2012-02-02', 2, 1000, 'ACTIVE', 'Clone37109', 'nick37109', '12341234'),
	(38, '2021-04-27 11:01:49.462316', 'seoul', 'room 138678', '38678street', 'user38678@naver.com', '2018-06-19', 2, 1000, 'ACTIVE', 'Clone38678', 'nick38678', '12341234'),
	(39, '2021-04-27 11:01:49.467314', 'seoul', 'room 139299', '39299street', 'user39299@naver.com', '1995-06-27', 2, 1000, 'ACTIVE', 'Clone39299', 'nick39299', '12341234'),
	(40, '2021-04-27 11:01:49.473315', 'seoul', 'room 140807', '40807street', 'user40807@naver.com', '1993-02-20', 2, 1000, 'ACTIVE', 'Clone40807', 'nick40807', '12341234'),
	(41, '2021-04-27 11:01:49.478316', 'seoul', 'room 141436', '41436street', 'user41436@naver.com', '2000-11-18', 2, 1000, 'ACTIVE', 'Clone41436', 'nick41436', '12341234'),
	(42, '2021-04-27 11:01:49.483317', 'seoul', 'room 142641', '42641street', 'user42641@naver.com', '2018-06-13', 2, 1000, 'ACTIVE', 'Clone42641', 'nick42641', '12341234'),
	(43, '2021-04-27 11:01:49.488314', 'seoul', 'room 143699', '43699street', 'user43699@naver.com', '1991-04-07', 2, 1000, 'ACTIVE', 'Clone43699', 'nick43699', '12341234'),
	(44, '2021-04-27 11:01:49.493317', 'seoul', 'room 144027', '44027street', 'user44027@naver.com', '2010-01-03', 2, 1000, 'ACTIVE', 'Clone44027', 'nick44027', '12341234'),
	(45, '2021-04-27 11:01:49.499315', 'seoul', 'room 145174', '45174street', 'user45174@naver.com', '1999-05-26', 2, 1000, 'ACTIVE', 'Clone45174', 'nick45174', '12341234'),
	(46, '2021-04-27 11:01:49.505318', 'seoul', 'room 146255', '46255street', 'user46255@naver.com', '2009-11-04', 2, 1000, 'ACTIVE', 'Clone46255', 'nick46255', '12341234'),
	(47, '2021-04-27 11:01:49.510317', 'seoul', 'room 147192', '47192street', 'user47192@naver.com', '2008-04-14', 2, 1000, 'ACTIVE', 'Clone47192', 'nick47192', '12341234'),
	(48, '2021-04-27 11:01:49.515315', 'seoul', 'room 148501', '48501street', 'user48501@naver.com', '2014-02-12', 2, 1000, 'ACTIVE', 'Clone48501', 'nick48501', '12341234'),
	(49, '2021-04-27 11:01:49.520315', 'seoul', 'room 149535', '49535street', 'user49535@naver.com', '1994-08-19', 2, 1000, 'ACTIVE', 'Clone49535', 'nick49535', '12341234'),
	(50, '2021-04-27 11:01:49.525317', 'seoul', 'room 150007', '50007street', 'user50007@naver.com', '2019-11-25', 2, 1000, 'ACTIVE', 'Clone50007', 'nick50007', '12341234'),
	(51, '2021-04-27 11:01:49.528314', 'seoul', 'room 151352', '51352street', 'user51352@naver.com', '2017-02-19', 2, 1000, 'ACTIVE', 'Clone51352', 'nick51352', '12341234'),
	(52, '2021-04-27 11:01:49.532313', 'seoul', 'room 152002', '52002street', 'user52002@naver.com', '2009-11-13', 2, 1000, 'ACTIVE', 'Clone52002', 'nick52002', '12341234'),
	(53, '2021-04-27 11:01:49.545318', 'seoul', 'room 153882', '53882street', 'user53882@naver.com', '1991-12-01', 2, 1000, 'ACTIVE', 'Clone53882', 'nick53882', '12341234'),
	(54, '2021-04-27 11:01:49.549316', 'seoul', 'room 154572', '54572street', 'user54572@naver.com', '1993-10-05', 2, 1000, 'ACTIVE', 'Clone54572', 'nick54572', '12341234'),
	(55, '2021-04-27 11:01:49.554317', 'seoul', 'room 155339', '55339street', 'user55339@naver.com', '2012-11-24', 2, 1000, 'ACTIVE', 'Clone55339', 'nick55339', '12341234'),
	(56, '2021-04-27 11:01:49.603346', 'seoul', 'room 156956', '56956street', 'user56956@naver.com', '1997-01-22', 2, 1000, 'ACTIVE', 'Clone56956', 'nick56956', '12341234'),
	(57, '2021-04-27 11:01:49.607317', 'seoul', 'room 157550', '57550street', 'user57550@naver.com', '2011-10-12', 2, 1000, 'ACTIVE', 'Clone57550', 'nick57550', '12341234'),
	(58, '2021-04-27 11:01:49.612315', 'seoul', 'room 158986', '58986street', 'user58986@naver.com', '2019-09-04', 2, 1000, 'ACTIVE', 'Clone58986', 'nick58986', '12341234'),
	(59, '2021-04-27 11:01:49.617315', 'seoul', 'room 159193', '59193street', 'user59193@naver.com', '2018-07-03', 2, 1000, 'ACTIVE', 'Clone59193', 'nick59193', '12341234'),
	(60, '2021-04-27 11:01:49.622315', 'seoul', 'room 160651', '60651street', 'user60651@naver.com', '2007-07-06', 2, 1000, 'ACTIVE', 'Clone60651', 'nick60651', '12341234'),
	(61, '2021-04-27 11:01:49.627317', 'seoul', 'room 161740', '61740street', 'user61740@naver.com', '1997-09-05', 2, 1000, 'ACTIVE', 'Clone61740', 'nick61740', '12341234'),
	(62, '2021-04-27 11:01:49.669316', 'seoul', 'room 162003', '62003street', 'user62003@naver.com', '2019-09-06', 2, 1000, 'ACTIVE', 'Clone62003', 'nick62003', '12341234'),
	(63, '2021-04-27 11:01:49.676315', 'seoul', 'room 163445', '63445street', 'user63445@naver.com', '2017-12-23', 2, 1000, 'ACTIVE', 'Clone63445', 'nick63445', '12341234'),
	(64, '2021-04-27 11:01:49.680313', 'seoul', 'room 164879', '64879street', 'user64879@naver.com', '1991-06-02', 2, 1000, 'ACTIVE', 'Clone64879', 'nick64879', '12341234'),
	(65, '2021-04-27 11:01:49.685314', 'seoul', 'room 165978', '65978street', 'user65978@naver.com', '2002-04-05', 2, 1000, 'ACTIVE', 'Clone65978', 'nick65978', '12341234'),
	(66, '2021-04-27 11:01:49.689314', 'seoul', 'room 166154', '66154street', 'user66154@naver.com', '1998-12-08', 2, 1000, 'ACTIVE', 'Clone66154', 'nick66154', '12341234'),
	(67, '2021-04-27 11:01:49.734279', 'seoul', 'room 167552', '67552street', 'user67552@naver.com', '2017-03-19', 2, 1000, 'ACTIVE', 'Clone67552', 'nick67552', '12341234'),
	(68, '2021-04-27 11:01:49.750830', 'seoul', 'room 168521', '68521street', 'user68521@naver.com', '2008-05-02', 2, 1000, 'ACTIVE', 'Clone68521', 'nick68521', '12341234'),
	(69, '2021-04-27 11:01:49.759370', 'seoul', 'room 169640', '69640street', 'user69640@naver.com', '1991-11-24', 2, 1000, 'ACTIVE', 'Clone69640', 'nick69640', '12341234'),
	(70, '2021-04-27 11:01:49.803156', 'seoul', 'room 170984', '70984street', 'user70984@naver.com', '1991-10-27', 2, 1000, 'ACTIVE', 'Clone70984', 'nick70984', '12341234'),
	(71, '2021-04-27 11:01:49.814014', 'seoul', 'room 171635', '71635street', 'user71635@naver.com', '2004-12-04', 2, 1000, 'ACTIVE', 'Clone71635', 'nick71635', '12341234'),
	(72, '2021-04-27 11:01:49.823000', 'seoul', 'room 172577', '72577street', 'user72577@naver.com', '2004-11-17', 2, 1000, 'ACTIVE', 'Clone72577', 'nick72577', '12341234'),
	(73, '2021-04-27 11:01:49.869878', 'seoul', 'room 173039', '73039street', 'user73039@naver.com', '2011-01-15', 2, 1000, 'ACTIVE', 'Clone73039', 'nick73039', '12341234'),
	(74, '2021-04-27 11:01:49.878294', 'seoul', 'room 174994', '74994street', 'user74994@naver.com', '2009-01-20', 2, 1000, 'ACTIVE', 'Clone74994', 'nick74994', '12341234'),
	(75, '2021-04-27 11:01:49.886900', 'seoul', 'room 175045', '75045street', 'user75045@naver.com', '2008-07-11', 2, 1000, 'ACTIVE', 'Clone75045', 'nick75045', '12341234'),
	(76, '2021-04-27 11:01:49.933640', 'seoul', 'room 176135', '76135street', 'user76135@naver.com', '2007-02-04', 2, 1000, 'ACTIVE', 'Clone76135', 'nick76135', '12341234'),
	(77, '2021-04-27 11:01:49.946188', 'seoul', 'room 177589', '77589street', 'user77589@naver.com', '2004-06-02', 2, 1000, 'ACTIVE', 'Clone77589', 'nick77589', '12341234'),
	(78, '2021-04-27 11:01:49.995197', 'seoul', 'room 178766', '78766street', 'user78766@naver.com', '2004-07-27', 2, 1000, 'ACTIVE', 'Clone78766', 'nick78766', '12341234'),
	(79, '2021-04-27 11:01:50.005204', 'seoul', 'room 179242', '79242street', 'user79242@naver.com', '1999-01-27', 2, 1000, 'ACTIVE', 'Clone79242', 'nick79242', '12341234'),
	(80, '2021-04-27 11:01:50.014190', 'seoul', 'room 180780', '80780street', 'user80780@naver.com', '1997-03-25', 2, 1000, 'ACTIVE', 'Clone80780', 'nick80780', '12341234'),
	(81, '2021-04-27 11:01:50.059249', 'seoul', 'room 181523', '81523street', 'user81523@naver.com', '1995-06-16', 2, 1000, 'ACTIVE', 'Clone81523', 'nick81523', '12341234'),
	(82, '2021-04-27 11:01:50.069199', 'seoul', 'room 182779', '82779street', 'user82779@naver.com', '2012-10-28', 2, 1000, 'ACTIVE', 'Clone82779', 'nick82779', '12341234'),
	(83, '2021-04-27 11:01:50.095260', 'seoul', 'room 183487', '83487street', 'user83487@naver.com', '2004-08-21', 2, 1000, 'ACTIVE', 'Clone83487', 'nick83487', '12341234'),
	(84, '2021-04-27 11:01:50.103182', 'seoul', 'room 184945', '84945street', 'user84945@naver.com', '2018-04-07', 2, 1000, 'ACTIVE', 'Clone84945', 'nick84945', '12341234'),
	(85, '2021-04-27 11:01:50.108901', 'seoul', 'room 185687', '85687street', 'user85687@naver.com', '2004-05-20', 2, 1000, 'ACTIVE', 'Clone85687', 'nick85687', '12341234'),
	(86, '2021-04-27 11:01:50.114080', 'seoul', 'room 186425', '86425street', 'user86425@naver.com', '1996-08-23', 2, 1000, 'ACTIVE', 'Clone86425', 'nick86425', '12341234'),
	(87, '2021-04-27 11:01:50.149264', 'seoul', 'room 187854', '87854street', 'user87854@naver.com', '2004-06-19', 2, 1000, 'ACTIVE', 'Clone87854', 'nick87854', '12341234'),
	(88, '2021-04-27 11:01:50.159268', 'seoul', 'room 188708', '88708street', 'user88708@naver.com', '1999-01-04', 2, 1000, 'ACTIVE', 'Clone88708', 'nick88708', '12341234'),
	(89, '2021-04-27 11:01:50.166258', 'seoul', 'room 189895', '89895street', 'user89895@naver.com', '2011-08-01', 2, 1000, 'ACTIVE', 'Clone89895', 'nick89895', '12341234'),
	(90, '2021-04-27 11:01:50.214529', 'seoul', 'room 190705', '90705street', 'user90705@naver.com', '2005-02-25', 2, 1000, 'ACTIVE', 'Clone90705', 'nick90705', '12341234'),
	(91, '2021-04-27 11:01:50.225129', 'seoul', 'room 191057', '91057street', 'user91057@naver.com', '1996-06-21', 2, 1000, 'ACTIVE', 'Clone91057', 'nick91057', '12341234'),
	(92, '2021-04-27 11:01:50.232860', 'seoul', 'room 192521', '92521street', 'user92521@naver.com', '2016-08-14', 2, 1000, 'ACTIVE', 'Clone92521', 'nick92521', '12341234'),
	(93, '2021-04-27 11:01:50.240590', 'seoul', 'room 193353', '93353street', 'user93353@naver.com', '1999-05-22', 2, 1000, 'ACTIVE', 'Clone93353', 'nick93353', '12341234'),
	(94, '2021-04-27 11:01:50.287317', 'seoul', 'room 194124', '94124street', 'user94124@naver.com', '2008-04-28', 2, 1000, 'ACTIVE', 'Clone94124', 'nick94124', '12341234'),
	(95, '2021-04-27 11:01:50.296314', 'seoul', 'room 195597', '95597street', 'user95597@naver.com', '1998-04-22', 2, 1000, 'ACTIVE', 'Clone95597', 'nick95597', '12341234'),
	(96, '2021-04-27 11:01:50.304288', 'seoul', 'room 196394', '96394street', 'user96394@naver.com', '2000-06-01', 2, 1000, 'ACTIVE', 'Clone96394', 'nick96394', '12341234'),
	(97, '2021-04-27 11:01:50.356667', 'seoul', 'room 197649', '97649street', 'user97649@naver.com', '1992-02-23', 2, 1000, 'ACTIVE', 'Clone97649', 'nick97649', '12341234'),
	(98, '2021-04-27 11:01:50.368091', 'seoul', 'room 198276', '98276street', 'user98276@naver.com', '2019-08-18', 2, 1000, 'ACTIVE', 'Clone98276', 'nick98276', '12341234'),
	(99, '2021-04-27 11:01:50.376906', 'seoul', 'room 199716', '99716street', 'user99716@naver.com', '1994-11-18', 2, 1000, 'ACTIVE', 'Clone99716', 'nick99716', '12341234');
