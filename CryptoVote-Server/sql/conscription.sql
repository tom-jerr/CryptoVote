/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : conscription

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 16/05/2023 07:19:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_comment_info
-- ----------------------------
DROP TABLE IF EXISTS `app_comment_info`;
CREATE TABLE `app_comment_info` (
  `comment_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `comment_info` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `user_id` varchar(255) DEFAULT NULL COMMENT 'user_id',
  `com_systime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统时间',
  `dianzan` varchar(255) DEFAULT '0' COMMENT '0:未点赞 1:已点赞',
  `zixun_id` varchar(255) DEFAULT NULL COMMENT '咨询id',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of app_comment_info
-- ----------------------------
BEGIN;
INSERT INTO `app_comment_info` (`comment_id`, `comment_info`, `user_id`, `com_systime`, `dianzan`, `zixun_id`) VALUES (3, '评论内容', '6', '2023-04-13 23:28:01', '0', '14');
INSERT INTO `app_comment_info` (`comment_id`, `comment_info`, `user_id`, `com_systime`, `dianzan`, `zixun_id`) VALUES (4, '么么', '6', '2023-04-13 23:40:08', '0', '14');
INSERT INTO `app_comment_info` (`comment_id`, `comment_info`, `user_id`, `com_systime`, `dianzan`, `zixun_id`) VALUES (5, '么么', '6', '2023-04-13 23:40:45', '1', '14');
INSERT INTO `app_comment_info` (`comment_id`, `comment_info`, `user_id`, `com_systime`, `dianzan`, `zixun_id`) VALUES (6, '干什么呢', '6', '2023-04-14 00:03:29', '0', '15');
INSERT INTO `app_comment_info` (`comment_id`, `comment_info`, `user_id`, `com_systime`, `dianzan`, `zixun_id`) VALUES (7, '真好呀', '7', '2023-04-14 09:56:35', '0', '18');
INSERT INTO `app_comment_info` (`comment_id`, `comment_info`, `user_id`, `com_systime`, `dianzan`, `zixun_id`) VALUES (8, '还来么？', '7', '2023-04-14 09:56:45', '1', '18');
COMMIT;

-- ----------------------------
-- Table structure for app_first_manage
-- ----------------------------
DROP TABLE IF EXISTS `app_first_manage`;
CREATE TABLE `app_first_manage` (
  `news_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `news_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `picurl` varchar(500) DEFAULT NULL COMMENT '图片链接',
  `content` text COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '0:征兵 1:新闻',
  `sys_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='首页管理';

-- ----------------------------
-- Records of app_first_manage
-- ----------------------------
BEGIN;
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (1, '“四优先”为大学生参军开辟“绿色通道”', 'https://www.gfbzb.gov.cn/news/img/1599944121.jpg', '4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）', '1', '2023-04-13 15:24:49');
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (2, '携笔从戎卫世博，立足本职铸忠诚', 'https://t3.chei.com.cn/common/zbbm/images/0_02_01.png', '我是复旦大学的一名学生汪航。父亲为我取这个名字，就是希望我能在汪洋大海里乘风破浪地航行。我的父亲是一名蓝天卫士，从小我就在部队大院中长大，和军队结下了不解之缘。看到解放军叔叔们的飒爽英姿，我非常地羡慕和向往，梦想着有一天我也能成为他们当中的一员，父亲从小就以一名军人的标准来要求我，使得我从小就有着一股不怕苦、不服输的军人气质。2008年，我没有辜负家人亲友的希望，成功地考上了复旦大学。记得那是大二刚开学的时候，徜徉在百年复旦静谧的林荫道上，我正盘算着这个学期该选些什么课，忽然感觉那天的校园有点不一样，原来是两旁参天的法国梧桐上那鲜艳的条幅。“响应世博召唤，接受祖国挑选”，看着热血沸腾的红色标语，我的心底激起了阵阵涟漪，小时候穿着父亲军装学敬礼的样子又浮现在脑海。作为一名复旦大学的在读生，为了自己的梦想，为了响应“参与世博、奉献世博、保卫世博”的号召，我毅然选择了暂停学业，投身到火热的警营和崇高而艰巨的世博安保任务中来的。记得我要参军的消息传开后，身边的同学朋友都不能理解，觉得放着好好的书不读，非要到部队“遭罪”何苦呢。都说“像你这样当过学生会主席，获得过上海市三好学生，钢琴乐理都十级，毕业后一定能找到一份称心的工作的，去部队不过是浪费时间而已”。但我不这样想，从军入伍是每名适龄青年的应尽义务，是每个热血男儿的应有之志，尤其是对于一名名牌大学的大学生来讲，更应当以报效国家为己任，在国家需要、世博需要的时候义无反顾的投身其中，让自己的闪亮青春在火热的警营中放射光芒。到了部队后，快节奏、高强度的警营生活让我感受到前所未有的压力和挑战，我暗暗下定决心：作为一个大学生士兵，能够来到这绿色的警营，就一定要发挥出我的优势，当好兵、站好岗，做一名合格的武警战士。两年来，在中队领导的精心培养和战友们的大力支持下，我积极利用自身特长为部队的宣传文化工作作出了应有的贡献。除了在中队主编队刊《征途》杂志，担任中队报道员、小广播员、教歌员等重要角色外，我还发挥自己的演讲特长，代表支队多次参加军地演讲活动，大力宣扬武警部队先进事迹，为支队赢得了不少荣誉。2010年8月，我作为官兵代表前往浦东新区上钢社区演讲，大力宣扬武警上海总队官兵在世博安保任务中的光荣事迹，受到了现场观众的高度肯定。在演讲会后的交流中，我还应领导和居民要求介绍并演唱了自己创作的队歌《战斗的青春》，让他们赞不绝口。在2011年6月武警上海总队举行的《嘹亮军歌献给党》建党90周年歌咏大赛上，我作为武警十支队合唱团钢琴伴奏和教歌员自己编写伴奏谱，并协助编排歌曲的艺术效果和动作，得到了上海师范大学专业艺术指导老师的肯定，也为支队代表队的成功演出作出了贡献。在两年的军旅生涯里，我先后有幸参加了世博会、世游赛这两项国际盛事的安保任务以及“10.1”国庆观灯执勤等近十项重大执勤任务。世博会中作为值机员，最重要的工作就是利用X光机去辨认游客携带的物品。记得有两次发现都让我很紧张，一次是查获了一名农民工兄弟由于疏忽而随身携带了4把菜刀，还有一次是及时发现一个旅游团几乎每人都携带了几枚子弹壳，在第一时间报告当班干部和民警后，这些安全隐患得到了有效排除。2011年的6月23日上午6时，那时还是世游赛筹备阶段，我正在安检大棚里执勤，一辆白色标致车试图逃避安检而强行冲闯车检大棚，发现这一情况后，我立即向当班干部报告，并与民警一同前往处置，成功化解了一次执勤事故。两年的时间里，经过部队的摔打和任务的磨练，曾经的青涩与迷茫已化作如今的成熟与坚定，曾经的天之骄子也已成长为一名合格的武警战士。面对压力的时候，想想在世博园面对103万游客等待安检时的场景，只会让我更加地从容面对、泰然处之。面对困难的时候，想想在每次5公里武装越野中坚持到底时的场景，只会让我更加地坚定信念、破浪前行。充实而短暂的两年警营生活彷佛还在眼前，入伍之初许下的誓言也在大家的帮助和自己的努力下逐一实现。在部队的这两年给了我丰富的阅历，崇高的追求，还有强健的体魄。两年的时间里我荣立了三等功，入了党，被评为十佳世博卫士，2011年11月份我还作为优秀大学生士兵的典型被人民日报，解放、文汇、新民等媒体放渚重要版面进行宣传。现在的我已经回到了阔别已久的校园，重新开始了我的学生生活，但这两年的经历对我来说是无尽的财富。也为我现在的学习生活甚至一些社会实践的工作提供了很好的身体基础以及为人处事的准则。让我更容易得到周围同学、同事的认可。规律的生活是部队给我带了的一大好处，以前经常通宵打游戏，睡到日上三竿才起床，现在的我虽然晚上不会像在部队那样早睡，但早上一般都不会睡懒觉，这也给我今年暑假的实习带来了很大的帮助，经常早早地就到了公司，得到领导的好评。而规律的生活带来的就是身体上的收获，家里帮助父母扛扛米，抬抬家具那完全是小菜一碟。我妈现在经常说，还是有儿子好，能帮家里干干体力活，有个当过兵的儿子那更是好的没话说。此外和同学朋友运动时，你的好体能也会成为别人艳羡的对象。今年八月一日，我就读的复旦大学国际关系与公共事务学院慰问了共建单位武警上海总队第一支队十中队，也就是我们熟知的南京路上好八连。期间我们进行了一场篮球对抗赛，我虽然带伤上阵，但始终保持着很好的体能，十中队的战士都说当过兵就是不一样。部队带来的第二大好处就是有助于培养成功的品质。雷厉风行，令行禁止;有礼有节，不卑不亢;严于律已，宽以待人。这些都是当代军人的良好品质，一个人一旦拥有了这些品质，也就拥有了成就事业、拓展人生取之不尽、用之不竭的力量源泉。对于我们来说就是体现在为人处事方面，这是一个看起来很宽泛的词语，但其实体现在我们日常生活的角角落落。首先是待人接物的礼貌，记得刚从学校回来的时候去老师办公室都会敲门喊报告，同学朋友叫我名字还是习惯性的大声答“到”，这还经常让喊我的人吓一跳。现在去老师办公室，或者实习的时候去领导办公室，虽然不会傻傻地大声喊报告了，但是敲门还是一贯坚持的。接收人家的物品或者递给别人东西我也基本都习惯了双手递接。每次开完会我都会把椅子等物品恢复原处，通过这些细小的待人接物的语言动作就会在不知不觉中给人留下好的印象。其次就是做事的态度，当兵说话算数，说到做到，服从命令是军人的天职。更有见红旗就扛，有第一就争的强烈荣誉感。这种品格也是现今地方党政机关、精英企业所必备的。部队带来的第三个好处就是可以养成独立生活的能力。像我们这样的80后、90后的年青人大多从小在长辈的精心呵护下成长，但缺乏生活的历练，更缺乏独立生活的能力，过着骄生惯养，饭来张口，衣来伸手的生活。而当兵入伍后，就不同了，离开了父母，失去了依靠。衣服、被子得自己洗;每月的津贴费，得盘算着怎么花;面对问题，得自己独立应对处置…等等，时间久了，父母的那根“拐杖”就自然地被扔掉了。独立的生活方有独立的人格，拥有独立的人格才能在以后的人生独挡一面、堪当大任。真心希望能有更多的有志青年，特别是大学生们能怀有一颗参军报国的心，像我们一样，通过自己的实际行动，走向军营为祖国的国防建设献出自己应尽的义务。', '1', '2023-04-13 15:24:49');
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (3, '从军中骄子到商界英才的万达董事长王健林', 'https://t1.chei.com.cn/common/zbbm/images/5_img.png,https://t4.chei.com.cn/common/zbbm/images/4_img.png', '一、敢闯敢试他是敢为天下先的地产大亨，他是与马云对赌一个亿的冒险家，他是中国的房地产首富，三年内，两次荣登“胡润房地产富豪榜”榜首，更是以集团形式捐款超过28亿的慈善家，他胆识过人，霸气外露，是血气方刚的企业家，他扬言只要万达进入的行业，其他的企业都没有机会做老大。他拒绝模仿，大胆创新，是名副其实的行动派。他就是大连万达集团董事长王健林。受家庭的影响，15岁的王健林就从四川来到东北，入伍参军，并且在28岁就成为了一名正团职干部。 在1987年，为了响应国家“百万裁军”的号召，王健林告别了自己18年的部队生活。转业后，王健林来到大连市西岗区区政府任办公室主任。但很快，本认为仕途无量的王健林竟弃政从商，通过企业改制的机会，创建了大连万达集团股份有限公司。迈入了房地产这个圈后，万达的第一桶金是大连市政府北门的棚户区改造。这是一个多少有些无奈的举措，作为一家民营企业，万达拿不到当时房地产开发项目所需的配额，只能承接旧城改造这个不被看好的工程。王健林作了大胆的尝试，铝合金窗，防盗门，改明厅，设洗手间，这些现在看来的“小儿科”，在当年都是创举。因为给每个房间设洗手间，万达还遭到了纪委的审查，其时这是局级以上干部住房才有的配置。万达在这个项目挣了近千万，更重要的是闯出了一条新路，成为全国首家进行旧城改造的企业，迅速做大了企业规模。成为全国房地产第一家跨区域发展的企业，也是万达大胆闯出来的。万达异地开发的第一站在广州，五六年下来，没挣到多少钱，但增强了信心，既然在当时所谓的圣地、房地产发源地都能站住脚，还有什么好怕?自此，万达“更多锻炼胆量，一发不可收拾”，成为全国跨区域最多的企业，遍布80多个城市。敢闯敢试不是蛮干。王健林如此界定两者的区别：“敢闯敢试是看准了去试不怕失败， 蛮干是没有目的去干。”“看准了”，也就是把握大方向。二、 长袖善舞不怵官场、往来自如，天生的大院气质，言出必行的个性，这样的“势”能让王健林颇显神秘——在很多人的眼中，受政府青睐的万达似乎游离于市场竞争之外。王的父亲曾是省级官员，这样的家庭环境，让王对权力体系并无神秘感。而18年的军队生涯以及转业后在国企的经历，同样让王健林深谙政府之道。他对大政方针、行业趋势、发展热点，始终抱有远超普通中国商人的热情。他是这个时代出色的机遇猎手，发现了最厚的雪——利润丰厚的地产行业;最长的坡——城市化进程、消费勃兴的几次重大的机会。万达的成功不仅是因为产品的成功，更因为它能准确卡位时代。很多开发商至今对商业地产的理解是做持有型物业收租，这种立意就比万达差了许多。万达的商业地产不只是收租物业，而是改变城市功能、结构的产品。市长们对万达广场的追捧，是因为它有把城市非中心变成中心的能力，这是地方政府业绩的孵化器。万达广场18个月开业，则满足了地方官员在任期内看到政绩的需要。三、 执着创新关于万达，可以轻而易举地看到它的两面性：一方面，它的产品(地产、院线、百货等)都是市场化的;另一方，它似乎总受到政府的青睐。在一个政府完全垄断了资源供给的行业，彻底市场化只是梦想。“理想主义者万科，会被动地弯腰;现实主义者万达，是主动但有尊严地弯腰。”万达的尊严，来自于它的创新能力。万达发明了有中国特色的商业地产发展模式—综合体发展模式，业界评价万达武汉楚河汉街项目“改变了武汉的功能和定位”。“我为什么一直要搞创新，就是要政府来主动找我。你要是去找它，它牛哄哄的，要是吃拿卡要怎么办?你是给还是不给?它要是来找你就容易得多。”王健林说。“我就是不信邪。”王健林说。万达早期商业地产项目不成功，他亲自向美国一家擅长做商场人流动向设计的购物中心学习。万达规划院副院长朱其玮印象最深的一件事是，2003年春节前一天，绝大多数员工都已经离开，王健林让朱把购物中心的设计图拿给他，春节期间接着研究。万达院线、百货在成立之初都不被看好，甚至遭到内部人的反对，都没有让王健林动摇。武汉的汉秀有复杂的水下机械设备，最初只有好莱坞一家公司能做。这家公司得知万达已决定投资后，故意将1500万美元的价格提到了4500万。“这小子把我身上创新精神彻底激活了。要是2000万美元，我就让他做了。”王健林一想到以后还要处处受制于人，就改变了主意，自己研发这个东西“总不会比神五、神六还难吧”。最后，这套设备还真让万达自己做出来了。四、善于借势“做企业一定要顺势而为，不要逆势而动。”王健林如是说。他善于借势，2002年，万达尝试向商业地产转型，首先想到了要与世界500强公司合作。为了说服沃尔玛，他亲自数次登门拜访相关负责人，竟然不得入其门。后来还是通过政府人士的牵线，才最终达成合作。在万达初期扩张中，和世界500强公司站在一起的小公司万达，增加了与政府谈判拿地的筹码。如今宾主易位，沃尔玛要拜访王健林，也要提前若干时间预约。在2008年之后的快速扩张时期，万达将政府的势能用到了极致;而收购AMC，更是借到了文化产业热的东风。“亲近政府，远离政治”是王健林的名言，他认为万达获得超越发展，是因为它能做“国企不会干、民企干不了的事情”。万达所做的很多项目，国企没有相关的能力与人才;而动辄几十上百亿投资，对民企门槛又太高。王健林曾在一个国企培训局给很多国企领导讲课，他在课上说：“今天民营企业已经不是过去了。如果出现一批500亿规模、未来上千亿的企业，民企也能办大事，国企就会彻底没戏。”五、现金为王外界一直对于万达的扩张速度和资金链十分关注，王健林认为，“扩张肯定是有这个风险的，没有风险就不是做企业了，做什么都是有风险的，企业本身就是风险和机遇并存。那就是看你在控制风险方面掌握得好，可能就发展的更好。”万达体量越来越大，(扩张)速度好像也没有减缓下来，很多人是有担心的，作为我们自己内部主要控制的核心就是控制好现金流，就是确保有足够的现金流量和防范。就像家庭一样，一定要存一点钱，防止出现意外的事，做企业也一样，除了正常的现金流以外，要有足够的现金流的余量来防止出现或者是不确定性出现，因为不然的话，像我们每年投资量这么大，所以我们万达现金流是作为企业的生命线和第一位的。六、专业慈善家在外界给予的众多耀眼的头衔之下，万达王健林独爱慈善家的封号。事实上，作为“能力越大责任越大”的王健林，有着自己的计划，还对慈善的目的和创新提出了个性鲜明的看法。在他看来，慈善本身不为博名，至于做慈善的这些年，无非就是企业的现金流实力越来越大，可能每年的规划预算在这方面多一点。同时，他还为万达制定了详细的计划：“我们近期做的计划就是，从2011年到2015年是20亿，平均每年4亿的安排，并且有专门的团队来运作这个事情。”“如果我的商业地产上市，可能我就会宣布把我在商业地产集团这部分股份捐出去，做一个大的慈善基金。这块资产大概相当于我在商业地产的资产的90%。慈善是一门专业，我们仅仅把它看成乐施行为是不对的，我会找一个团队来运作这个事情。”王健林表示。此外，王健林个人还想在未来更多地支持青年创业作为慈善发展方向，“从2000年到现在，几乎没有出现成功的创业家。我觉得如果中国创业成功的企业家出现断代，可能对国家的危害比政策的失误更危险，所以从这个层面讲，我愿意支持更多的青年创业。”他认为有更多人创业，国家才有希望。七、高度重视诚信王健林把诚信经营和狠抓工程质量作为开创事业的立足点。1991年，王健林带领大连市西岗区住宅开发公司(万达集团前身)开发的大连市民政街小区成为全东北第一个住宅工程质量全优小区，被首届“中国质量万里行”活动组委会授予当年全国唯一一块“优质住宅工程”奖牌。1996年初，针对当时房地产行业质量低劣、面积短缺、欺诈销售的普遍现象，王健林在全国房企中率先提出“三项承诺”，保护消费者利益。2000年6月29日，建设部、中国消费者协会等六家单位在人民大会堂召开千人大会，推介万达集团销售放心房的经验，王健林作为房企唯一代表做典型发言，这是改革开放以来建设部首次推介一个房地产企业的典型经验。八、真情关爱员工在万达的发展中，王健林始终坚持“以人为本”的理念，倾心关爱员工，广纳八方人才。万达集团的骨干员工流失率在全国大型企业中最低，王健林被全国工商联和全国总工会评为“全国关爱员工优秀民营企业家”。王健林的做法：一是提供一流待遇，万达员工的薪酬水平属于国内同行业的最高水准，万达集团在基层员工中实行独特的工龄工资制度，员工除正常收入外，每工作一年增加1200元工龄工资，工作满5年的基层员工每年仅工龄工资收入就达6000元。二是建立培训机制，每年投入上亿万元用于员工培训，并在廊坊投资7亿元建立了国内一流的万达学院。三是注重人文关怀。王健林要求总部和子公司都建立员工食堂，为员工提供免费工作餐;推出幸福假期制度，给予集团评选的优秀员工及其家人报销两人往返机票及住宿费，任选各地万达酒店度假。', '1', '2023-04-13 15:24:49');
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (4, '招收军士的招收条件', 'https://img1.gtimg.com/news/pics/hv1/54/58/1864/121221444.jpg,https://inews.gtimg.com/newsapp_bt/0/13099572106/1000.jpg', '招收对象所学专业应当符合部队专业需要。所学专业在就读的普通高等学校已经开展职业技能鉴定的，应当取得中级以上职业资格证书。招收的普通高等学校毕业生年龄不超过24周岁。', '0', '2023-04-13 15:24:49');
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (5, '招收军士基本情况介绍', 'https://www.hgdaily.com.cn/w/3/upfile/4/2020/12/24/20201224110546714002.png,https://pimage.cqcb.com/d/file/county/dadukouquxinwen/2020-12-29/e8f35ac81a7c19c7c39539aa67084bbd.jpg', '我军现役士兵按兵役性质分为义务兵役制士兵和志愿兵役制士兵。义务兵役制士兵称为义务兵，志愿兵役制士兵称为军士。军士属于士兵军衔序列，但不同于义务兵役制士兵，是士兵中的骨干。义务兵实行供给制，发给津贴，军士实行工资制和定期增资制度。目前部队面向高校毕业生既招收军士，也招收义务兵，这是两个不同兵役性质的士兵系列。直接从非军事部门招收军士(简称招收军士)，是指根据《兵役法》、《征兵工作条例》以及有关规定，直接招收普通高等学校的毕业生入伍，作为志愿兵役制士兵到部队服现役。招收军士招收对象为全日制大专以上学历，所学专业符合部队专业需要，招收时间从每年8月份开始，9月底结束。', '0', '2023-04-13 15:24:49');
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (6, '招收军士的政治考核', 'https://t1.chei.com.cn/news/img/1867075652.jpg', '符合招收军士征集条件的往届高校毕业生需在户口所在地报名应征并参加政治考核。符合招收军士征集条件的应届高校毕业生既可在生源地(入读高校前户口所在地)报名应征，也可在毕业高校所在地报名应征，在生源地报名应征的，由生源地按有关规定组织政考，在毕业高校所在地报名应征的，无论户口是否转入学校，其政治考核一律由毕业学校所在地县(市、区)公安机关负责，由入学前户口所在地县(市、区)公安机关协查。', '0', '2023-04-13 15:24:49');
INSERT INTO `app_first_manage` (`news_id`, `news_title`, `picurl`, `content`, `type`, `sys_time`) VALUES (7, '视力基本要求？', 'https://www.ckxw.net/pic2_900_900/upfiles/2018-04/20180409233513413.jpg,https://img2.zjolcdn.com/pic/0/17/81/01/17810150_843343.jpg', '任何一眼裸眼视力低于4.5，不合格。任何一眼裸眼视力低于4.8，需进行矫正视力检查，任何一眼矫正视力低于4.8或矫正度数超过600度，不合格。屈光不正经准分子激光手术（不含有晶体眼人工晶体植入术等其他术式）后半年以上，无并发症，任何一眼裸眼视力达到4.8，眼底检查正常，除条件兵外合格。条件兵视力合格条件按有关标准执行。', '0', '2023-04-13 15:24:49');
COMMIT;

-- ----------------------------
-- Table structure for app_hxpeople
-- ----------------------------
DROP TABLE IF EXISTS `app_hxpeople`;
CREATE TABLE `app_hxpeople` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `hx_name` varchar(255) DEFAULT NULL COMMENT '候选人姓名',
  `hx_url` varchar(255) DEFAULT NULL COMMENT '候选人图片',
  `hx_num_piao` varchar(255) DEFAULT NULL COMMENT '候选人得票',
  `backup` varchar(255) DEFAULT '' COMMENT '备注',
  `room_id` varchar(255) DEFAULT NULL COMMENT '房间号id',
  `one_all` varchar(255) DEFAULT '0' COMMENT '1:单选 2：多选',
  `close_ticket` varchar(255) DEFAULT '0' COMMENT '0:默认 1:结束投票',
  `is_del` varchar(255) DEFAULT '0' COMMENT '0:未删除 1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='候选人表';

-- ----------------------------
-- Records of app_hxpeople
-- ----------------------------
BEGIN;
INSERT INTO `app_hxpeople` (`id`, `hx_name`, `hx_url`, `hx_num_piao`, `backup`, `room_id`, `one_all`, `close_ticket`, `is_del`) VALUES (1, '候选人1', '候选人图片url', '3', '2', '3', '0', '0', '0');
INSERT INTO `app_hxpeople` (`id`, `hx_name`, `hx_url`, `hx_num_piao`, `backup`, `room_id`, `one_all`, `close_ticket`, `is_del`) VALUES (3, '候选人2', '候选人图片2', '1', '', '3', '0', '0', '0');
INSERT INTO `app_hxpeople` (`id`, `hx_name`, `hx_url`, `hx_num_piao`, `backup`, `room_id`, `one_all`, `close_ticket`, `is_del`) VALUES (6, '啦啦啦', 'http://xychead.xueyiche.vip/pic_1684170839602.jpg', '0', '', '6', '0', '0', '0');
INSERT INTO `app_hxpeople` (`id`, `hx_name`, `hx_url`, `hx_num_piao`, `backup`, `room_id`, `one_all`, `close_ticket`, `is_del`) VALUES (7, '哦哦哦', 'http://xychead.xueyiche.vip/pic_1684170856883.jpg', '0', '', '6', '0', '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for app_room
-- ----------------------------
DROP TABLE IF EXISTS `app_room`;
CREATE TABLE `app_room` (
  `room_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `room_pass` varchar(255) DEFAULT NULL COMMENT '房间密码',
  `room_title` varchar(255) DEFAULT NULL COMMENT '房间标题',
  `room_url` varchar(255) DEFAULT NULL COMMENT '房间图片',
  `roomtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `one_all` varchar(255) DEFAULT '0' COMMENT '1:单选 2：多选',
  `close_ticket` varchar(255) DEFAULT '0' COMMENT '0:默认 1:结束投票',
  `is_del` varchar(255) DEFAULT '0' COMMENT '0:未删除 1:删除',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='房间大厅';

-- ----------------------------
-- Records of app_room
-- ----------------------------
BEGIN;
INSERT INTO `app_room` (`room_id`, `user_id`, `room_pass`, `room_title`, `room_url`, `roomtime`, `one_all`, `close_ticket`, `is_del`) VALUES (3, '9', '6677', '呢呢呢', 'http://xychead.xueyiche.vip/pic_1683816017432.jpg', '2023-05-11 22:40:27', '1', '1', '0');
INSERT INTO `app_room` (`room_id`, `user_id`, `room_pass`, `room_title`, `room_url`, `roomtime`, `one_all`, `close_ticket`, `is_del`) VALUES (4, '9', '000000', '吃开了', 'http://xychead.xueyiche.vip/pic_1683816532048.jpg', '2023-05-11 22:49:00', '0', '0', '0');
INSERT INTO `app_room` (`room_id`, `user_id`, `room_pass`, `room_title`, `room_url`, `roomtime`, `one_all`, `close_ticket`, `is_del`) VALUES (5, '8', '333', '333', '2323', '2023-05-16 01:10:12', '0', '0', '0');
INSERT INTO `app_room` (`room_id`, `user_id`, `room_pass`, `room_title`, `room_url`, `roomtime`, `one_all`, `close_ticket`, `is_del`) VALUES (6, '10', '0000', '测试', 'http://xychead.xueyiche.vip/pic_1684169954517.jpg', '2023-05-16 01:11:34', '1', '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for app_shenhe
-- ----------------------------
DROP TABLE IF EXISTS `app_shenhe`;
CREATE TABLE `app_shenhe` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `pic` varchar(500) DEFAULT NULL COMMENT '报名图片',
  `minzu` varchar(255) DEFAULT NULL COMMENT '民族',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `age` varchar(50) DEFAULT NULL COMMENT '年龄',
  `zzmm` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `jiguan` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `hyzk` varchar(255) DEFAULT NULL COMMENT '婚姻状况',
  `xlxx` varchar(255) DEFAULT NULL COMMENT '学历信息',
  `cylb` varchar(255) DEFAULT NULL COMMENT '从业类别',
  `dszv` varchar(255) DEFAULT NULL COMMENT '独生子女',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `sfzid` varchar(255) DEFAULT NULL COMMENT '身份证',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `type` varchar(255) DEFAULT '0' COMMENT '0:未审核 1:审核通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1237 DEFAULT CHARSET=utf8mb4 COMMENT='报名审核';

-- ----------------------------
-- Records of app_shenhe
-- ----------------------------
BEGIN;
INSERT INTO `app_shenhe` (`id`, `user_id`, `pic`, `minzu`, `sex`, `age`, `zzmm`, `jiguan`, `hyzk`, `xlxx`, `cylb`, `dszv`, `name`, `phone`, `sfzid`, `address`, `type`) VALUES (1231, '23', '1231', '231', '男', '1231', '23', '123', '123', '123', '123', '123', '123', '12', '12', '123', '1');
INSERT INTO `app_shenhe` (`id`, `user_id`, `pic`, `minzu`, `sex`, `age`, `zzmm`, `jiguan`, `hyzk`, `xlxx`, `cylb`, `dszv`, `name`, `phone`, `sfzid`, `address`, `type`) VALUES (1233, '1', 'picurl', '汉族', '男', '18', '群众', '哈尔滨', '未婚', '大学', 'IT', '独生子女', '周杰伦', '1365555555', '2301871987498237', '黑龙江哈尔滨江北', '1');
INSERT INTO `app_shenhe` (`id`, `user_id`, `pic`, `minzu`, `sex`, `age`, `zzmm`, `jiguan`, `hyzk`, `xlxx`, `cylb`, `dszv`, `name`, `phone`, `sfzid`, `address`, `type`) VALUES (1234, '12', 'picurl', '汉族', '男', '18', '群众', '哈尔滨', '未婚', '大学', 'IT', '独生子女', '周杰伦', '1365555555', '2301871987498237', '黑龙江哈尔滨江北', '0');
INSERT INTO `app_shenhe` (`id`, `user_id`, `pic`, `minzu`, `sex`, `age`, `zzmm`, `jiguan`, `hyzk`, `xlxx`, `cylb`, `dszv`, `name`, `phone`, `sfzid`, `address`, `type`) VALUES (1235, '6', 'http://xychead.xueyiche.vip/pic_1681352609646.jpg', '汉族', '男', '16', '群众', '哈尔滨', '未婚', '小学', '明', '是', '路飞', '18346012117', '26', '26', '1');
INSERT INTO `app_shenhe` (`id`, `user_id`, `pic`, `minzu`, `sex`, `age`, `zzmm`, `jiguan`, `hyzk`, `xlxx`, `cylb`, `dszv`, `name`, `phone`, `sfzid`, `address`, `type`) VALUES (1236, '7', 'http://xychead.xueyiche.vip/pic_1681437420933.jpg', '汉族', '女', '16', '群众', '北京', '未婚', '小学', '罢了', '是', '测试', '13000000000', '2318466467949797', '2318466467949797', '0');
COMMIT;

-- ----------------------------
-- Table structure for app_toupiao
-- ----------------------------
DROP TABLE IF EXISTS `app_toupiao`;
CREATE TABLE `app_toupiao` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tp_user_id` varchar(255) DEFAULT NULL COMMENT '投票人id',
  `hx_people_id` varchar(255) DEFAULT NULL COMMENT '候选人id',
  `toupiaotime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投票时间',
  `room_id` varchar(255) DEFAULT NULL COMMENT '房间id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of app_toupiao
-- ----------------------------
BEGIN;
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (1, '2', '3', '2023-05-13 22:48:19', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (2, '6', '3', '2023-05-14 22:04:01', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (3, '7', '3', '2023-05-14 22:30:36', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (4, '7', '1', '2023-05-15 21:50:19', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (12, '8', '1', '2023-05-15 22:45:12', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (13, '8', '3', '2023-05-15 22:45:13', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (14, '10', '1', '2023-05-15 23:18:30', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (15, '10', '1', '2023-05-15 23:18:47', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (16, '10', '1', '2023-05-15 23:19:49', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (17, '10', '1', '2023-05-16 01:19:35', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (18, '10', '1', '2023-05-16 01:21:00', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (19, '10', '1', '2023-05-16 01:24:12', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (20, '10', '1', '2023-05-16 01:26:43', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (22, '10', '1', '2023-05-16 01:29:55', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (24, '10', '6', '2023-05-16 01:35:14', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (25, '10', '6', '2023-05-16 01:41:11', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (26, '10', '7', '2023-05-16 01:48:00', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (27, '10', '6', '2023-05-16 01:48:00', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (28, '10', '6', '2023-05-16 01:48:20', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (29, '10', '7', '2023-05-16 01:50:33', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (30, '10', '6', '2023-05-16 01:50:33', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (31, '8', '6', '2023-05-16 01:51:28', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (32, '8', '7', '2023-05-16 01:51:28', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (33, '8', '6', '2023-05-16 01:51:32', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (34, '8', '7', '2023-05-16 01:51:32', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (35, '8', '6', '2023-05-16 01:52:00', '6');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (36, '8', '1', '2023-05-16 02:03:38', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (37, '8', '1', '2023-05-16 02:03:52', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (38, '8', '1', '2023-05-16 02:05:44', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (39, '8', '1', '2023-05-16 02:08:21', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (40, '8', '1', '2023-05-16 02:10:13', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (41, '8', '1', '2023-05-16 02:11:32', '3');
INSERT INTO `app_toupiao` (`id`, `tp_user_id`, `hx_people_id`, `toupiaotime`, `room_id`) VALUES (42, '8', '3', '2023-05-16 02:11:37', '3');
COMMIT;

-- ----------------------------
-- Table structure for app_zixun
-- ----------------------------
DROP TABLE IF EXISTS `app_zixun`;
CREATE TABLE `app_zixun` (
  `zixun_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '咨询标题',
  `img1` varchar(500) DEFAULT NULL COMMENT '图片1',
  `img2` varchar(900) DEFAULT NULL COMMENT '图片2',
  `img3` varchar(500) DEFAULT NULL COMMENT '图片3',
  `mark` varchar(255) DEFAULT NULL COMMENT '标签',
  `backup` varchar(255) DEFAULT NULL COMMENT '备注',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `zx_systime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`zixun_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='咨询管理';

-- ----------------------------
-- Records of app_zixun
-- ----------------------------
BEGIN;
INSERT INTO `app_zixun` (`zixun_id`, `title`, `img1`, `img2`, `img3`, `mark`, `backup`, `user_id`, `zx_systime`) VALUES (14, '征兵了', 'http://xychead.xueyiche.vip/pic_1681397811343.jpg,http://xychead.xueyiche.vip/pic_1681397811358.jpg,http://xychead.xueyiche.vip/pic_1681397811360.jpg,http://xychead.xueyiche.vip/pic_1681397811361.jpg', NULL, NULL, '我们一起征兵了', '我们一起征兵了', '6', '2023-04-13 22:56:47');
INSERT INTO `app_zixun` (`zixun_id`, `title`, `img1`, `img2`, `img3`, `mark`, `backup`, `user_id`, `zx_systime`) VALUES (15, '什么时候开始征兵？？', 'http://xychead.xueyiche.vip/pic_1681397921488.jpg,http://xychead.xueyiche.vip/pic_1681397921498.jpg,http://xychead.xueyiche.vip/pic_1681397921499.jpg', NULL, NULL, '快开始了吧', '快开始了吧', '6', '2023-04-13 22:58:40');
COMMIT;

-- ----------------------------
-- Table structure for app_zixun_info
-- ----------------------------
DROP TABLE IF EXISTS `app_zixun_info`;
CREATE TABLE `app_zixun_info` (
  `zx_xq_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `zixun_id` varchar(255) DEFAULT NULL COMMENT 'zixun_id',
  `zixun_title` varchar(255) DEFAULT NULL COMMENT '咨询详情标题',
  `zx_pic_url` varchar(900) DEFAULT NULL COMMENT '图片地址',
  `zixuninfo` varchar(255) DEFAULT NULL COMMENT '咨询内容',
  `backup` varchar(255) DEFAULT NULL COMMENT '备注',
  `zx_systime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`zx_xq_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='咨询详情';

-- ----------------------------
-- Records of app_zixun_info
-- ----------------------------
BEGIN;
INSERT INTO `app_zixun_info` (`zx_xq_id`, `zixun_id`, `zixun_title`, `zx_pic_url`, `zixuninfo`, `backup`, `zx_systime`) VALUES (1, '1', '12', 'http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg', '322323', '111', '2023-04-13 19:49:50');
INSERT INTO `app_zixun_info` (`zx_xq_id`, `zixun_id`, `zixun_title`, `zx_pic_url`, `zixuninfo`, `backup`, `zx_systime`) VALUES (2, '12', '343', 'http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg', '3232', '222', '2023-04-13 19:50:12');
COMMIT;

-- ----------------------------
-- Table structure for appuser_info
-- ----------------------------
DROP TABLE IF EXISTS `appuser_info`;
CREATE TABLE `appuser_info` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `head_url` varchar(900) DEFAULT NULL COMMENT '头像地址',
  `back_url` varchar(900) DEFAULT NULL COMMENT '背景图',
  `userphone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `introduce` varchar(500) DEFAULT NULL COMMENT '简介',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='个人信息';

-- ----------------------------
-- Records of appuser_info
-- ----------------------------
BEGIN;
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (1, 'aaa4', '666', '7777', '1234', '1234', '男', '14', '简介', '备注');
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (2, '24', 'sdf', 'sdf', '432', '42', NULL, '423', '42', NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (3, NULL, 'sd', 'df', '12344', '1234123', NULL, NULL, NULL, NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (4, NULL, 'sdf', 'df', '123443', '1234123', NULL, NULL, NULL, NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (5, NULL, 'sdf', 'df', '189777', '123123', NULL, NULL, NULL, NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (6, '路飞7', 'http://xychead.xueyiche.vip/pic_1681351141083.jpg', 'http://xychead.xueyiche.vip/pic_1681350288959.jpg', '18346012117', 'qwer', '男', '19', '你蘑菇', NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (7, '蜡笔小新', 'http://xychead.xueyiche.vip/pic_1681437348894.jpg', 'http://xychead.xueyiche.vip/pic_1681437380699.jpg', '13000000000', 'qwer', '男', '22', '吃呀', NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (8, '18888', 'http://xychead.xueyiche.vip/pic_1684173067135.jpg', NULL, '18888888888', 'qwer', NULL, NULL, NULL, NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (9, NULL, NULL, NULL, '13666666666', 'qwer', NULL, NULL, NULL, NULL);
INSERT INTO `appuser_info` (`user_id`, `nickname`, `head_url`, `back_url`, `userphone`, `password`, `sex`, `age`, `introduce`, `remark`) VALUES (10, '龙珠', 'http://xychead.xueyiche.vip/pic_1684164012183.jpg', NULL, '16666666666', 'qwer', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作 sub主子表操作）',
  `package_name` varchar(100) DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
BEGIN;
INSERT INTO `gen_table` (`table_id`, `table_name`, `table_comment`, `sub_table_name`, `sub_table_fk_name`, `class_name`, `tpl_category`, `package_name`, `module_name`, `business_name`, `function_name`, `function_author`, `gen_type`, `gen_path`, `options`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, 'picture_url', '图片地址', '', NULL, 'PictureUrl', 'crud', 'com.ruoyi.system', 'system', 'url', '轮播图', 'chris', '0', '/', '{\"parentMenuId\":\"2000\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"轮播图\",\"treeCode\":\"\"}', 'admin', '2023-04-09 21:22:16', '', '2023-04-09 21:39:08', '');
INSERT INTO `gen_table` (`table_id`, `table_name`, `table_comment`, `sub_table_name`, `sub_table_fk_name`, `class_name`, `tpl_category`, `package_name`, `module_name`, `business_name`, `function_name`, `function_author`, `gen_type`, `gen_path`, `options`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, 'app_first_manage', '首页管理', '', NULL, 'AppFirstManage', 'crud', 'com.ruoyi.system', 'system', 'manage', '首页管理', 'chris', '0', '/', '{\"parentMenuId\":\"2007\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"首页管理\",\"treeCode\":\"\"}', 'admin', '2023-04-13 00:26:43', '', '2023-04-13 00:28:06', '');
INSERT INTO `gen_table` (`table_id`, `table_name`, `table_comment`, `sub_table_name`, `sub_table_fk_name`, `class_name`, `tpl_category`, `package_name`, `module_name`, `business_name`, `function_name`, `function_author`, `gen_type`, `gen_path`, `options`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, 'app_shenhe', '报名审核', '', NULL, 'AppShenhe', 'crud', 'com.ruoyi.system', 'system', 'shenhe', '报名审核', 'chris', '0', '/', '{\"parentMenuId\":\"2009\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"报名管理\",\"treeCode\":\"\"}', 'admin', '2023-04-13 00:26:43', '', '2023-04-13 00:29:07', '');
INSERT INTO `gen_table` (`table_id`, `table_name`, `table_comment`, `sub_table_name`, `sub_table_fk_name`, `class_name`, `tpl_category`, `package_name`, `module_name`, `business_name`, `function_name`, `function_author`, `gen_type`, `gen_path`, `options`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, 'app_zixun', '咨询管理', '', NULL, 'AppZixun', 'crud', 'com.ruoyi.system', 'system', 'zixun', '咨询管理', 'ruoyi', '0', '/', '{\"parentMenuId\":\"2008\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"咨询管理\",\"treeCode\":\"\"}', 'admin', '2023-04-13 00:26:43', '', '2023-04-13 00:30:19', '');
INSERT INTO `gen_table` (`table_id`, `table_name`, `table_comment`, `sub_table_name`, `sub_table_fk_name`, `class_name`, `tpl_category`, `package_name`, `module_name`, `business_name`, `function_name`, `function_author`, `gen_type`, `gen_path`, `options`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, 'appuser_info', '个人信息', '', NULL, 'AppuserInfo', 'crud', 'com.ruoyi.system', 'system', 'info', '用户管理', 'ruoyi', '0', '/', '{\"parentMenuId\":\"2010\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"用户管理\",\"treeCode\":\"\"}', 'admin', '2023-04-13 00:26:43', '', '2023-04-13 00:31:25', '');
INSERT INTO `gen_table` (`table_id`, `table_name`, `table_comment`, `sub_table_name`, `sub_table_fk_name`, `class_name`, `tpl_category`, `package_name`, `module_name`, `business_name`, `function_name`, `function_author`, `gen_type`, `gen_path`, `options`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, 'app_room', '房间大厅', '', NULL, 'AppRoom', 'crud', 'com.ruoyi.system', 'system', 'room', '房间大厅', 'ChrisGai', '0', '/', '{\"parentMenuId\":\"2035\",\"treeName\":\"\",\"treeParentCode\":\"\",\"parentMenuName\":\"房间管理\",\"treeCode\":\"\"}', 'admin', '2023-05-11 21:25:11', '', '2023-05-11 21:28:00', '');
COMMIT;

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) DEFAULT '' COMMENT '字典类型',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表字段';

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
BEGIN;
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '1', 'id', 'id', 'int(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-04-09 21:22:16', NULL, '2023-04-09 21:39:08');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '1', 'imgurl', '', 'varchar(500)', 'String', 'imgurl', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 2, 'admin', '2023-04-09 21:22:16', NULL, '2023-04-09 21:39:08');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '1', 'type', '0:首页 1:咨询', 'varchar(5)', 'String', 'type', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 3, 'admin', '2023-04-09 21:22:16', NULL, '2023-04-09 21:39:08');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '2', 'news_id', 'id', 'int(20)', 'Long', 'newsId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:28:06');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '2', 'news_title', '标题', 'varchar(255)', 'String', 'newsTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:28:06');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, '2', 'picurl', '图片链接', 'varchar(500)', 'String', 'picurl', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 3, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:28:06');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, '2', 'content', '内容', 'varchar(255)', 'String', 'content', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'summernote', '', 4, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:28:06');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, '2', 'type', '0:征兵 1:新闻', 'varchar(255)', 'String', 'type', '0', '0', NULL, NULL, '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:28:06');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, '3', 'id', 'id', 'int(20)', 'Long', 'id', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, '3', 'user_id', '用户id', 'varchar(255)', 'String', 'userId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, '3', 'pic', '报名图片', 'varchar(500)', 'String', 'pic', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 3, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, '3', 'minzu', '民族', 'varchar(255)', 'String', 'minzu', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (13, '3', 'sex', '性别', 'varchar(255)', 'String', 'sex', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (14, '3', 'age', '年龄', 'varchar(50)', 'String', 'age', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (15, '3', 'zzmm', '政治面貌', 'varchar(255)', 'String', 'zzmm', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, '3', 'jiguan', '籍贯', 'varchar(255)', 'String', 'jiguan', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (17, '3', 'hyzk', '婚姻状况', 'varchar(255)', 'String', 'hyzk', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (18, '3', 'xlxx', '学历信息', 'varchar(255)', 'String', 'xlxx', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (19, '3', 'cylb', '从业类别', 'varchar(255)', 'String', 'cylb', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (20, '3', 'dszv', '独生子女', 'varchar(255)', 'String', 'dszv', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (21, '3', 'name', '姓名', 'varchar(255)', 'String', 'name', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 13, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (22, '3', 'phone', '手机号', 'varchar(255)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (23, '3', 'sfzid', '身份证', 'varchar(255)', 'String', 'sfzid', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 15, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (24, '3', 'address', '家庭住址', 'varchar(255)', 'String', 'address', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 16, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (25, '3', 'type', '0:未审核 1:审核通过', 'varchar(255)', 'String', 'type', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 17, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:29:07');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (26, '4', 'zixun_id', 'id', 'int(20)', 'Long', 'zixunId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (27, '4', 'title', '咨询标题', 'varchar(255)', 'String', 'title', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (28, '4', 'img1', '图片1', 'varchar(500)', 'String', 'img1', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 3, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (29, '4', 'img2', '图片2', 'varchar(900)', 'String', 'img2', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 4, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (30, '4', 'img3', '图片3', 'varchar(500)', 'String', 'img3', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 5, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (31, '4', 'mark', '标签', 'varchar(255)', 'String', 'mark', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (32, '4', 'backup', '备注', 'varchar(255)', 'String', 'backup', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (33, '4', 'user_id', '用户id', 'varchar(255)', 'String', 'userId', '0', '0', NULL, NULL, NULL, NULL, NULL, 'EQ', 'input', '', 8, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:30:19');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (34, '5', 'user_id', 'id', 'int(20)', 'Long', 'userId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (35, '5', 'nickname', '昵称', 'varchar(255)', 'String', 'nickname', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (36, '5', 'userphone', '手机号', 'varchar(255)', 'String', 'userphone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (37, '5', 'password', '密码', 'varchar(255)', 'String', 'password', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (38, '5', 'sex', '性别', 'varchar(255)', 'String', 'sex', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'select', '', 5, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (39, '5', 'age', '年龄', 'varchar(255)', 'String', 'age', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (40, '5', 'introduce', '简介', 'varchar(500)', 'String', 'introduce', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 7, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (41, '5', 'remark', '备注', 'varchar(255)', 'String', 'remark', '0', '0', NULL, NULL, NULL, NULL, NULL, 'EQ', 'input', '', 8, 'admin', '2023-04-13 00:26:43', NULL, '2023-04-13 00:31:25');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (42, '6', 'room_id', 'id', 'int(20)', 'Long', 'roomId', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 1, 'admin', '2023-05-11 21:25:11', NULL, '2023-05-11 21:28:00');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (43, '6', 'user_id', '用户id', 'varchar(255)', 'String', 'userId', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 2, 'admin', '2023-05-11 21:25:11', NULL, '2023-05-11 21:28:00');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (44, '6', 'room_pass', '房间密码', 'varchar(255)', 'String', 'roomPass', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 3, 'admin', '2023-05-11 21:25:11', NULL, '2023-05-11 21:28:00');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (45, '6', 'room_title', '房间标题', 'varchar(255)', 'String', 'roomTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2023-05-11 21:25:11', NULL, '2023-05-11 21:28:00');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (46, '6', 'room_url', '房间图片', 'varchar(255)', 'String', 'roomUrl', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 5, 'admin', '2023-05-11 21:25:11', NULL, '2023-05-11 21:28:00');
INSERT INTO `gen_table_column` (`column_id`, `table_id`, `column_name`, `column_comment`, `column_type`, `java_type`, `java_field`, `is_pk`, `is_increment`, `is_required`, `is_insert`, `is_edit`, `is_list`, `is_query`, `query_type`, `html_type`, `dict_type`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (47, '6', 'roomtime', '创建时间', 'timestamp', 'Date', 'roomtime', '0', '0', NULL, '1', '1', '1', NULL, 'EQ', 'input', '', 6, 'admin', '2023-05-11 21:25:11', NULL, '2023-05-11 21:28:00');
COMMIT;

-- ----------------------------
-- Table structure for picture_url
-- ----------------------------
DROP TABLE IF EXISTS `picture_url`;
CREATE TABLE `picture_url` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `imgurl` varchar(500) DEFAULT NULL,
  `type` varchar(5) DEFAULT NULL COMMENT '0:首页 1:咨询',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='图片地址';

-- ----------------------------
-- Records of picture_url
-- ----------------------------
BEGIN;
INSERT INTO `picture_url` (`id`, `imgurl`, `type`) VALUES (1, 'https://www.hinews.cn/pic/0/10/57/66/10576686_629796.jpg', '0');
INSERT INTO `picture_url` (`id`, `imgurl`, `type`) VALUES (2, 'https://img1.baidu.com/it/u=1044432704,3206383340&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500', '0');
INSERT INTO `picture_url` (`id`, `imgurl`, `type`) VALUES (3, 'https://www.chinanews.com.cn/fileftp/2009/10/2009-10-30/U225P4T47D11893F967DT20091030114157.jpg', '0');
INSERT INTO `picture_url` (`id`, `imgurl`, `type`) VALUES (4, 'https://lres.cloudhubei.com.cn/c2/litedfs/resource/180cmsAttach/node2/20220211/8bb0fccc21a86ed3e3472b82f5cc054c96e1696cc6b04cf99ace3a738b080b59.jpg', '1');
INSERT INTO `picture_url` (`id`, `imgurl`, `type`) VALUES (5, 'https://imagepphcloud.thepaper.cn/pph/image/72/635/115.jpg', '1');
INSERT INTO `picture_url` (`id`, `imgurl`, `type`) VALUES (6, 'https://inews.gtimg.com/newsapp_bt/0/13230928931/1000', '1');
COMMIT;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, '用户管理-密码字符范围', 'sys.account.chrtype', '0', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数字和特殊字符（目前支持的特殊字符包括：~!@#$%^&*()-=_+）');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, '用户管理-初始密码修改策略', 'sys.account.initPasswordModify', '0', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '0：初始密码修改策略关闭，没有任何提示，1：提醒用户，如果未修改初始密码，则在登录时就会提醒修改密码对话框');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (7, '用户管理-账号密码更新周期', 'sys.account.passwordValidateDays', '0', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '密码更新周期（填写数字，数据初始化值为0不限制，若修改必须为大于0小于365的正整数），如果超过这个周期登录系统时，则在登录时就会提醒修改密码对话框');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (8, '主框架页-菜单导航显示风格', 'sys.index.menuStyle', 'default', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '菜单导航显示风格（default为左侧导航菜单，topnav为顶部导航菜单）');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (9, '主框架页-是否开启页脚', 'sys.index.footer', 'true', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '是否开启底部页脚显示（true显示，false隐藏）');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (10, '主框架页-是否开启页签', 'sys.index.tagsView', 'true', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '是否开启菜单多页签显示（true显示，false隐藏）');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (11, '用户登录-黑名单列表', 'sys.login.blackIPList', '', 'Y', 'admin', '2023-04-09 07:35:56', '', NULL, '设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
INSERT INTO `sys_dept` (`dept_id`, `parent_id`, `ancestors`, `dept_name`, `order_num`, `leader`, `phone`, `email`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '性别男');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '性别女');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '通知');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '公告');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '其他操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '停用状态');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '登录状态列表');
COMMIT;

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
BEGIN;
INSERT INTO `sys_job` (`job_id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_job` (`job_id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_job` (`job_id`, `job_name`, `job_group`, `invoke_target`, `cron_expression`, `misfire_policy`, `concurrent`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2023-04-09 07:35:56', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`),
  KEY `idx_sys_logininfor_s` (`status`),
  KEY `idx_sys_logininfor_lt` (`login_time`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
BEGIN;
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (100, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 07:45:40');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (101, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 07:47:53');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (102, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-04-09 07:51:51');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (103, 'ry', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 07:51:57');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (104, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 08:06:19');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (105, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 08:19:22');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (106, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 08:22:21');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (107, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-04-09 08:24:28');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (108, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 08:31:41');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (109, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 10:02:51');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (110, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 21:21:56');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (111, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 21:58:20');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (112, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-09 22:56:51');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (113, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 06:39:31');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (114, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 06:41:07');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (115, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 06:48:29');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (116, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 06:57:28');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (117, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 06:59:08');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (118, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 07:32:47');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (119, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-10 07:37:40');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (120, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-12 14:12:11');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (121, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-12 14:28:00');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (122, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-12 14:29:21');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (123, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-12 23:40:19');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (124, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-13 00:23:40');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (125, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-13 00:39:10');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (126, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-13 07:38:20');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (127, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-13 09:06:21');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (128, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-13 23:54:44');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (129, 'admin', '36.132.141.199', 'XX XX', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-13 23:57:09');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (130, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 06:31:08');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (131, 'admin', '111.42.61.169', 'XX XX', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 09:13:21');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (132, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 09:17:20');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (133, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 09:36:29');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (134, 'admin', '111.42.61.169', 'XX XX', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 09:37:58');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (135, 'admin', '111.42.61.169', 'XX XX', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 09:39:09');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (136, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 09:39:09');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (137, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 10:19:21');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (138, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 17:44:03');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (139, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 20:13:38');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (140, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-14 20:48:05');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (141, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 11:31:28');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (142, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 13:07:59');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (143, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:01:39');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (144, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:04:30');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (145, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:07:41');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (146, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:12:25');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (147, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:18:02');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (148, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-04-15 14:25:52');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (149, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:26:01');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (150, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-04-15 14:26:53');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (151, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:33:09');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (152, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-04-15 14:34:47');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (153, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 14:48:54');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (154, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-04-15 14:53:11');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (155, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-04-15 15:01:58');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (156, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-05-11 21:24:08');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (157, 'zhengbing', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '退出成功', '2023-05-11 21:24:13');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (158, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '1', '密码输入错误1次', '2023-05-11 21:24:19');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (159, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-05-11 21:24:23');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (160, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-05-11 21:36:18');
INSERT INTO `sys_logininfor` (`info_id`, `login_name`, `ipaddr`, `login_location`, `browser`, `os`, `status`, `msg`, `login_time`) VALUES (161, 'admin', '127.0.0.1', '内网IP', 'Chrome 11', 'Mac OS X', '0', '登录成功', '2023-05-11 22:42:36');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `is_refresh` char(1) DEFAULT '1' COMMENT '是否刷新（0刷新 1不刷新）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2042 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '系统管理', 0, 1, '#', '', 'M', '0', '1', '', 'fa fa-gear', 'admin', '2023-04-09 07:35:56', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '系统监控', 0, 2, '#', '', 'M', '0', '1', '', 'fa fa-video-camera', 'admin', '2023-04-09 07:35:56', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '系统工具', 0, 3, '#', '', 'M', '0', '1', '', 'fa fa-bars', 'admin', '2023-04-09 07:35:56', '', NULL, '系统工具目录');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, '若依官网', 0, 4, 'http://ruoyi.vip', 'menuBlank', 'C', '1', '1', '', 'fa fa-location-arrow', 'admin', '2023-04-09 07:35:56', 'ry', '2023-04-09 07:52:25', '若依官网地址');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (100, '用户管理', 1, 1, '/system/user', '', 'C', '0', '1', 'system:user:view', 'fa fa-user-o', 'admin', '2023-04-09 07:35:56', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (101, '角色管理', 1, 2, '/system/role', '', 'C', '0', '1', 'system:role:view', 'fa fa-user-secret', 'admin', '2023-04-09 07:35:56', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (102, '菜单管理', 1, 3, '/system/menu', '', 'C', '0', '1', 'system:menu:view', 'fa fa-th-list', 'admin', '2023-04-09 07:35:56', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (103, '部门管理', 1, 4, '/system/dept', '', 'C', '0', '1', 'system:dept:view', 'fa fa-outdent', 'admin', '2023-04-09 07:35:56', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (104, '岗位管理', 1, 5, '/system/post', '', 'C', '0', '1', 'system:post:view', 'fa fa-address-card-o', 'admin', '2023-04-09 07:35:56', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (105, '字典管理', 1, 6, '/system/dict', '', 'C', '0', '1', 'system:dict:view', 'fa fa-bookmark-o', 'admin', '2023-04-09 07:35:56', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (106, '参数设置', 1, 7, '/system/config', '', 'C', '0', '1', 'system:config:view', 'fa fa-sun-o', 'admin', '2023-04-09 07:35:56', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (107, '通知公告', 1, 8, '/system/notice', '', 'C', '0', '1', 'system:notice:view', 'fa fa-bullhorn', 'admin', '2023-04-09 07:35:56', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (108, '日志管理', 1, 9, '#', '', 'M', '0', '1', '', 'fa fa-pencil-square-o', 'admin', '2023-04-09 07:35:56', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (109, '在线用户', 2, 1, '/monitor/online', '', 'C', '0', '1', 'monitor:online:view', 'fa fa-user-circle', 'admin', '2023-04-09 07:35:56', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (110, '定时任务', 2, 2, '/monitor/job', '', 'C', '0', '1', 'monitor:job:view', 'fa fa-tasks', 'admin', '2023-04-09 07:35:56', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (111, '数据监控', 2, 3, '/monitor/data', '', 'C', '0', '1', 'monitor:data:view', 'fa fa-bug', 'admin', '2023-04-09 07:35:56', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (112, '服务监控', 2, 4, '/monitor/server', '', 'C', '0', '1', 'monitor:server:view', 'fa fa-server', 'admin', '2023-04-09 07:35:56', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (113, '缓存监控', 2, 5, '/monitor/cache', '', 'C', '0', '1', 'monitor:cache:view', 'fa fa-cube', 'admin', '2023-04-09 07:35:56', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (114, '表单构建', 3, 1, '/tool/build', '', 'C', '0', '1', 'tool:build:view', 'fa fa-wpforms', 'admin', '2023-04-09 07:35:56', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (115, '代码生成', 3, 2, '/tool/gen', '', 'C', '0', '1', 'tool:gen:view', 'fa fa-code', 'admin', '2023-04-09 07:35:56', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (116, '系统接口', 3, 3, '/tool/swagger', '', 'C', '0', '1', 'tool:swagger:view', 'fa fa-gg', 'admin', '2023-04-09 07:35:56', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (500, '操作日志', 108, 1, '/monitor/operlog', '', 'C', '0', '1', 'monitor:operlog:view', 'fa fa-address-book', 'admin', '2023-04-09 07:35:56', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (501, '登录日志', 108, 2, '/monitor/logininfor', '', 'C', '0', '1', 'monitor:logininfor:view', 'fa fa-file-image-o', 'admin', '2023-04-09 07:35:56', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1000, '用户查询', 100, 1, '#', '', 'F', '0', '1', 'system:user:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1001, '用户新增', 100, 2, '#', '', 'F', '0', '1', 'system:user:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1002, '用户修改', 100, 3, '#', '', 'F', '0', '1', 'system:user:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1003, '用户删除', 100, 4, '#', '', 'F', '0', '1', 'system:user:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1004, '用户导出', 100, 5, '#', '', 'F', '0', '1', 'system:user:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1005, '用户导入', 100, 6, '#', '', 'F', '0', '1', 'system:user:import', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1006, '重置密码', 100, 7, '#', '', 'F', '0', '1', 'system:user:resetPwd', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1007, '角色查询', 101, 1, '#', '', 'F', '0', '1', 'system:role:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1008, '角色新增', 101, 2, '#', '', 'F', '0', '1', 'system:role:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1009, '角色修改', 101, 3, '#', '', 'F', '0', '1', 'system:role:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1010, '角色删除', 101, 4, '#', '', 'F', '0', '1', 'system:role:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1011, '角色导出', 101, 5, '#', '', 'F', '0', '1', 'system:role:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1012, '菜单查询', 102, 1, '#', '', 'F', '0', '1', 'system:menu:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1013, '菜单新增', 102, 2, '#', '', 'F', '0', '1', 'system:menu:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1014, '菜单修改', 102, 3, '#', '', 'F', '0', '1', 'system:menu:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1015, '菜单删除', 102, 4, '#', '', 'F', '0', '1', 'system:menu:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1016, '部门查询', 103, 1, '#', '', 'F', '0', '1', 'system:dept:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1017, '部门新增', 103, 2, '#', '', 'F', '0', '1', 'system:dept:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1018, '部门修改', 103, 3, '#', '', 'F', '0', '1', 'system:dept:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1019, '部门删除', 103, 4, '#', '', 'F', '0', '1', 'system:dept:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1020, '岗位查询', 104, 1, '#', '', 'F', '0', '1', 'system:post:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1021, '岗位新增', 104, 2, '#', '', 'F', '0', '1', 'system:post:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1022, '岗位修改', 104, 3, '#', '', 'F', '0', '1', 'system:post:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1023, '岗位删除', 104, 4, '#', '', 'F', '0', '1', 'system:post:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1024, '岗位导出', 104, 5, '#', '', 'F', '0', '1', 'system:post:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1025, '字典查询', 105, 1, '#', '', 'F', '0', '1', 'system:dict:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1026, '字典新增', 105, 2, '#', '', 'F', '0', '1', 'system:dict:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1027, '字典修改', 105, 3, '#', '', 'F', '0', '1', 'system:dict:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1028, '字典删除', 105, 4, '#', '', 'F', '0', '1', 'system:dict:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1029, '字典导出', 105, 5, '#', '', 'F', '0', '1', 'system:dict:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1030, '参数查询', 106, 1, '#', '', 'F', '0', '1', 'system:config:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1031, '参数新增', 106, 2, '#', '', 'F', '0', '1', 'system:config:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1032, '参数修改', 106, 3, '#', '', 'F', '0', '1', 'system:config:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1033, '参数删除', 106, 4, '#', '', 'F', '0', '1', 'system:config:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1034, '参数导出', 106, 5, '#', '', 'F', '0', '1', 'system:config:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1035, '公告查询', 107, 1, '#', '', 'F', '0', '1', 'system:notice:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1036, '公告新增', 107, 2, '#', '', 'F', '0', '1', 'system:notice:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1037, '公告修改', 107, 3, '#', '', 'F', '0', '1', 'system:notice:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1038, '公告删除', 107, 4, '#', '', 'F', '0', '1', 'system:notice:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1039, '操作查询', 500, 1, '#', '', 'F', '0', '1', 'monitor:operlog:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1040, '操作删除', 500, 2, '#', '', 'F', '0', '1', 'monitor:operlog:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1041, '详细信息', 500, 3, '#', '', 'F', '0', '1', 'monitor:operlog:detail', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1042, '日志导出', 500, 4, '#', '', 'F', '0', '1', 'monitor:operlog:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1043, '登录查询', 501, 1, '#', '', 'F', '0', '1', 'monitor:logininfor:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1044, '登录删除', 501, 2, '#', '', 'F', '0', '1', 'monitor:logininfor:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1045, '日志导出', 501, 3, '#', '', 'F', '0', '1', 'monitor:logininfor:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1046, '账户解锁', 501, 4, '#', '', 'F', '0', '1', 'monitor:logininfor:unlock', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1047, '在线查询', 109, 1, '#', '', 'F', '0', '1', 'monitor:online:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1048, '批量强退', 109, 2, '#', '', 'F', '0', '1', 'monitor:online:batchForceLogout', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1049, '单条强退', 109, 3, '#', '', 'F', '0', '1', 'monitor:online:forceLogout', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1050, '任务查询', 110, 1, '#', '', 'F', '0', '1', 'monitor:job:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1051, '任务新增', 110, 2, '#', '', 'F', '0', '1', 'monitor:job:add', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1052, '任务修改', 110, 3, '#', '', 'F', '0', '1', 'monitor:job:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1053, '任务删除', 110, 4, '#', '', 'F', '0', '1', 'monitor:job:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1054, '状态修改', 110, 5, '#', '', 'F', '0', '1', 'monitor:job:changeStatus', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1055, '任务详细', 110, 6, '#', '', 'F', '0', '1', 'monitor:job:detail', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1056, '任务导出', 110, 7, '#', '', 'F', '0', '1', 'monitor:job:export', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1057, '生成查询', 115, 1, '#', '', 'F', '0', '1', 'tool:gen:list', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1058, '生成修改', 115, 2, '#', '', 'F', '0', '1', 'tool:gen:edit', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1059, '生成删除', 115, 3, '#', '', 'F', '0', '1', 'tool:gen:remove', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1060, '预览代码', 115, 4, '#', '', 'F', '0', '1', 'tool:gen:preview', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1061, '生成代码', 115, 5, '#', '', 'F', '0', '1', 'tool:gen:code', '#', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2000, '轮播图', 0, 5, '#', 'menuItem', 'C', '0', '1', '', 'fa fa-american-sign-language-interpreting', 'admin', '2023-04-09 21:37:28', 'admin', '2023-04-09 21:37:44', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2001, '轮播图', 2000, 1, '/system/url', '', 'C', '0', '1', 'system:url:view', '#', 'admin', '2023-04-09 21:40:17', '', NULL, '轮播图菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2002, '轮播图查询', 2001, 1, '#', '', 'F', '0', '1', 'system:url:list', '#', 'admin', '2023-04-09 21:40:17', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2003, '轮播图新增', 2001, 2, '#', '', 'F', '0', '1', 'system:url:add', '#', 'admin', '2023-04-09 21:40:17', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2004, '轮播图修改', 2001, 3, '#', '', 'F', '0', '1', 'system:url:edit', '#', 'admin', '2023-04-09 21:40:17', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2005, '轮播图删除', 2001, 4, '#', '', 'F', '0', '1', 'system:url:remove', '#', 'admin', '2023-04-09 21:40:18', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2006, '轮播图导出', 2001, 5, '#', '', 'F', '0', '1', 'system:url:export', '#', 'admin', '2023-04-09 21:40:18', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2007, '首页管理', 0, 6, '#', 'menuItem', 'C', '0', '1', '', 'fa fa-building-o', 'admin', '2023-04-13 00:24:23', 'admin', '2023-04-13 00:25:06', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2008, '咨询管理', 0, 7, '#', 'menuItem', 'C', '0', '1', NULL, '#', 'admin', '2023-04-13 00:25:32', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2009, '报名管理', 0, 8, '#', 'menuItem', 'C', '0', '1', NULL, '#', 'admin', '2023-04-13 00:25:47', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2010, '用户管理', 0, 9, '#', 'menuItem', 'C', '0', '1', NULL, '#', 'admin', '2023-04-13 00:26:04', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2011, '用户管理', 2010, 1, '/system/info', '', 'C', '0', '1', 'system:info:view', '#', 'admin', '2023-04-13 00:32:41', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2012, '用户管理查询', 2011, 1, '#', '', 'F', '0', '1', 'system:info:list', '#', 'admin', '2023-04-13 00:32:41', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2013, '用户管理新增', 2011, 2, '#', '', 'F', '0', '1', 'system:info:add', '#', 'admin', '2023-04-13 00:32:41', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2014, '用户管理修改', 2011, 3, '#', '', 'F', '0', '1', 'system:info:edit', '#', 'admin', '2023-04-13 00:32:41', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2015, '用户管理删除', 2011, 4, '#', '', 'F', '0', '1', 'system:info:remove', '#', 'admin', '2023-04-13 00:32:41', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2016, '用户管理导出', 2011, 5, '#', '', 'F', '0', '1', 'system:info:export', '#', 'admin', '2023-04-13 00:32:41', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2017, '咨询管理', 2008, 1, '/system/zixun', '', 'C', '0', '1', 'system:zixun:view', '#', 'admin', '2023-04-13 00:32:53', '', NULL, '咨询管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2018, '咨询管理查询', 2017, 1, '#', '', 'F', '0', '1', 'system:zixun:list', '#', 'admin', '2023-04-13 00:32:53', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2019, '咨询管理新增', 2017, 2, '#', '', 'F', '0', '1', 'system:zixun:add', '#', 'admin', '2023-04-13 00:32:53', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2020, '咨询管理修改', 2017, 3, '#', '', 'F', '0', '1', 'system:zixun:edit', '#', 'admin', '2023-04-13 00:32:53', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2021, '咨询管理删除', 2017, 4, '#', '', 'F', '0', '1', 'system:zixun:remove', '#', 'admin', '2023-04-13 00:32:53', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2022, '咨询管理导出', 2017, 5, '#', '', 'F', '0', '1', 'system:zixun:export', '#', 'admin', '2023-04-13 00:32:53', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2023, '报名审核', 2009, 1, '/system/shenhe', '', 'C', '0', '1', 'system:shenhe:view', '#', 'admin', '2023-04-13 00:33:06', '', NULL, '报名审核菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2024, '报名审核查询', 2023, 1, '#', '', 'F', '0', '1', 'system:shenhe:list', '#', 'admin', '2023-04-13 00:33:06', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2025, '报名审核新增', 2023, 2, '#', '', 'F', '0', '1', 'system:shenhe:add', '#', 'admin', '2023-04-13 00:33:06', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2026, '报名审核修改', 2023, 3, '#', '', 'F', '0', '1', 'system:shenhe:edit', '#', 'admin', '2023-04-13 00:33:06', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2027, '报名审核删除', 2023, 4, '#', '', 'F', '0', '1', 'system:shenhe:remove', '#', 'admin', '2023-04-13 00:33:06', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2028, '报名审核导出', 2023, 5, '#', '', 'F', '0', '1', 'system:shenhe:export', '#', 'admin', '2023-04-13 00:33:06', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2029, '首页管理', 2007, 1, '/system/manage', '', 'C', '0', '1', 'system:manage:view', '#', 'admin', '2023-04-13 00:33:20', '', NULL, '首页管理菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2030, '首页管理查询', 2029, 1, '#', '', 'F', '0', '1', 'system:manage:list', '#', 'admin', '2023-04-13 00:33:20', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2031, '首页管理新增', 2029, 2, '#', '', 'F', '0', '1', 'system:manage:add', '#', 'admin', '2023-04-13 00:33:20', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2032, '首页管理修改', 2029, 3, '#', '', 'F', '0', '1', 'system:manage:edit', '#', 'admin', '2023-04-13 00:33:20', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2033, '首页管理删除', 2029, 4, '#', '', 'F', '0', '1', 'system:manage:remove', '#', 'admin', '2023-04-13 00:33:20', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2034, '首页管理导出', 2029, 5, '#', '', 'F', '0', '1', 'system:manage:export', '#', 'admin', '2023-04-13 00:33:20', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2035, '房间管理', 0, 10, '#', 'menuItem', 'M', '0', '1', NULL, 'fa fa-institution', 'admin', '2023-05-11 21:24:55', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2036, '房间大厅', 2035, 1, '/system/room', '', 'C', '0', '1', 'system:room:view', '#', 'admin', '2023-05-11 21:28:37', '', NULL, '房间大厅菜单');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2037, '房间大厅查询', 2036, 1, '#', '', 'F', '0', '1', 'system:room:list', '#', 'admin', '2023-05-11 21:28:37', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2038, '房间大厅新增', 2036, 2, '#', '', 'F', '0', '1', 'system:room:add', '#', 'admin', '2023-05-11 21:28:37', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2039, '房间大厅修改', 2036, 3, '#', '', 'F', '0', '1', 'system:room:edit', '#', 'admin', '2023-05-11 21:28:37', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2040, '房间大厅删除', 2036, 4, '#', '', 'F', '0', '1', 'system:room:remove', '#', 'admin', '2023-05-11 21:28:37', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `url`, `target`, `menu_type`, `visible`, `is_refresh`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2041, '房间大厅导出', 2036, 5, '#', '', 'F', '0', '1', 'system:room:export', '#', 'admin', '2023-05-11 21:28:37', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice` (`notice_id`, `notice_title`, `notice_type`, `notice_content`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '管理员');
INSERT INTO `sys_notice` (`notice_id`, `notice_title`, `notice_type`, `notice_content`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '管理员');
COMMIT;

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  `cost_time` bigint(20) DEFAULT '0' COMMENT '消耗时间',
  PRIMARY KEY (`oper_id`),
  KEY `idx_sys_oper_log_bt` (`business_type`),
  KEY `idx_sys_oper_log_s` (`status`),
  KEY `idx_sys_oper_log_ot` (`oper_time`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
BEGIN;
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (100, '用户管理', 1, 'com.ruoyi.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"\"],\"userName\":[\"paul\"],\"deptName\":[\"\"],\"phonenumber\":[\"\"],\"email\":[\"\"],\"loginName\":[\"paul\"],\"sex\":[\"0\"],\"role\":[\"2\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 07:50:53', 244);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (101, '用户管理', 1, 'com.ruoyi.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"\"],\"userName\":[\"paul1\"],\"deptName\":[\"\"],\"phonenumber\":[\"\"],\"email\":[\"\"],\"loginName\":[\"paul1\"],\"sex\":[\"0\"],\"role\":[\"2\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 07:51:22', 127);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (102, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'ry', '测试部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"4\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"若依官网\"],\"url\":[\"http://ruoyi.vip\"],\"target\":[\"menuBlank\"],\"perms\":[\"\"],\"orderNum\":[\"4\"],\"icon\":[\"fa fa-location-arrow\"],\"visible\":[\"1\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 07:52:25', 93);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (103, '个人信息', 2, 'com.ruoyi.web.controller.system.SysProfileController.updateAvatar()', 'POST', 1, 'ry', '测试部门', '/system/user/profile/updateAvatar', '127.0.0.1', '内网IP', '', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 07:55:18', 961);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (104, '个人信息', 2, 'com.ruoyi.web.controller.system.SysProfileController.updateAvatar()', 'POST', 1, 'admin', '研发部门', '/system/user/profile/updateAvatar', '127.0.0.1', '内网IP', '', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 08:10:43', 241);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (105, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/importTable', '127.0.0.1', '内网IP', '{\"tables\":[\"picture_url\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 21:22:17', 1010);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (106, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"轮播图\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"1\"],\"icon\":[\"fa fa-american-sign-language-interpreting\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 21:37:28', 47);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (107, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2000\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"轮播图\"],\"url\":[\"#\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"5\"],\"icon\":[\"fa fa-american-sign-language-interpreting\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 21:37:44', 22);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (108, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/edit', '127.0.0.1', '内网IP', '{\"tableId\":[\"1\"],\"tableName\":[\"picture_url\"],\"tableComment\":[\"图片地址\"],\"className\":[\"PictureUrl\"],\"functionAuthor\":[\"chris\"],\"remark\":[\"\"],\"columns[0].columnId\":[\"1\"],\"columns[0].sort\":[\"1\"],\"columns[0].columnComment\":[\"id\"],\"columns[0].javaType\":[\"Long\"],\"columns[0].javaField\":[\"id\"],\"columns[0].isInsert\":[\"1\"],\"columns[0].queryType\":[\"EQ\"],\"columns[0].htmlType\":[\"input\"],\"columns[0].dictType\":[\"\"],\"columns[1].columnId\":[\"2\"],\"columns[1].sort\":[\"2\"],\"columns[1].columnComment\":[\"\"],\"columns[1].javaType\":[\"String\"],\"columns[1].javaField\":[\"imgurl\"],\"columns[1].isInsert\":[\"1\"],\"columns[1].isEdit\":[\"1\"],\"columns[1].isList\":[\"1\"],\"columns[1].isQuery\":[\"1\"],\"columns[1].queryType\":[\"EQ\"],\"columns[1].htmlType\":[\"textarea\"],\"columns[1].dictType\":[\"\"],\"columns[2].columnId\":[\"3\"],\"columns[2].sort\":[\"3\"],\"columns[2].columnComment\":[\"0:首页 1:咨询\"],\"columns[2].javaType\":[\"String\"],\"columns[2].javaField\":[\"type\"],\"columns[2].isInsert\":[\"1\"],\"columns[2].isEdit\":[\"1\"],\"columns[2].isList\":[\"1\"],\"columns[2].isQuery\":[\"1\"],\"columns[2].queryType\":[\"EQ\"],\"columns[2].htmlType\":[\"select\"],\"columns[2].dictType\":[\"\"],\"tplCategory\":[\"crud\"],\"packageName\":[\"com.ruoyi.system\"],\"moduleName\":[\"system\"],\"businessName\":[\"url\"],\"functionName\":[\"轮播图\"],\"params[parentMenuId]\":[\"2000\"],\"params[parentMenuName]\":[\"轮播图\"],\"genType\":[\"0\"],\"genPath\":[\"/\"],\"subTableName\":[\"\"],\"params[treeCode]\":[\"\"],\"params[treeParentCode]\":[\"\"],\"params[treeName]\":[\"\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-09 21:39:08', 36);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (109, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.download()', 'GET', 1, 'admin', '研发部门', '/tool/gen/download/picture_url', '127.0.0.1', '内网IP', '\"picture_url\"', NULL, 0, NULL, '2023-04-09 21:39:15', 1259);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (110, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.download()', 'GET', 1, 'admin', '研发部门', '/tool/gen/download/picture_url', '127.0.0.1', '内网IP', '\"picture_url\"', NULL, 0, NULL, '2023-04-09 21:39:20', 841);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (111, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '127.0.0.1', '内网IP', '{\"id\":[\"2\"],\"imgurl\":[\"https://th.bing.com/th/id/R.987f582c510be58755c4933cda68d525?rik=C0D21hJDYvXosw&riu=http%3a%2f%2fimg.pconline.com.cn%2fimages%2fupload%2fupc%2ftx%2fwallpaper%2f1305%2f16%2fc4%2f20990657_1368686545122.jpg&ehk=netN2qzcCVS4ALUQfDOwxAwFcy41oxC%2b0xTFvOYy5ds%3d&risl=&pid=ImgRaw&r=0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-12 14:30:00', 310);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (112, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '127.0.0.1', '内网IP', '{\"id\":[\"1\"],\"imgurl\":[\"https://th.bing.com/th/id/R.987f582c510be58755c4933cda68d525?rik=C0D21hJDYvXosw&riu=http%3a%2f%2fimg.pconline.com.cn%2fimages%2fupload%2fupc%2ftx%2fwallpaper%2f1305%2f16%2fc4%2f20990657_1368686545122.jpg&ehk=netN2qzcCVS4ALUQfDOwxAwFcy41oxC%2b0xTFvOYy5ds%3d&risl=&pid=ImgRaw&r=0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-12 14:30:06', 6);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (113, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"首页管理\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"6\"],\"icon\":[\"\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:24:23', 86);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (114, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2007\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"首页管理\"],\"url\":[\"#\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"6\"],\"icon\":[\"fa fa-building-o\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:24:53', 100);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (115, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/edit', '127.0.0.1', '内网IP', '{\"menuId\":[\"2007\"],\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"首页管理\"],\"url\":[\"#\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"6\"],\"icon\":[\"fa fa-building-o\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:25:06', 25);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (116, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"咨询管理\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"7\"],\"icon\":[\"\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:25:32', 25);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (117, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"报名管理\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"8\"],\"icon\":[\"\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:25:47', 18);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (118, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"C\"],\"menuName\":[\"用户管理\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"9\"],\"icon\":[\"\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:26:04', 38);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (119, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/importTable', '127.0.0.1', '内网IP', '{\"tables\":[\"app_zixun,app_shenhe,app_first_manage,appuser_info\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:26:43', 1165);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (120, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/edit', '127.0.0.1', '内网IP', '{\"tableId\":[\"2\"],\"tableName\":[\"app_first_manage\"],\"tableComment\":[\"首页管理\"],\"className\":[\"AppFirstManage\"],\"functionAuthor\":[\"chris\"],\"remark\":[\"\"],\"columns[0].columnId\":[\"4\"],\"columns[0].sort\":[\"1\"],\"columns[0].columnComment\":[\"id\"],\"columns[0].javaType\":[\"Long\"],\"columns[0].javaField\":[\"newsId\"],\"columns[0].isInsert\":[\"1\"],\"columns[0].queryType\":[\"EQ\"],\"columns[0].htmlType\":[\"input\"],\"columns[0].dictType\":[\"\"],\"columns[1].columnId\":[\"5\"],\"columns[1].sort\":[\"2\"],\"columns[1].columnComment\":[\"标题\"],\"columns[1].javaType\":[\"String\"],\"columns[1].javaField\":[\"newsTitle\"],\"columns[1].isInsert\":[\"1\"],\"columns[1].isEdit\":[\"1\"],\"columns[1].isList\":[\"1\"],\"columns[1].isQuery\":[\"1\"],\"columns[1].queryType\":[\"EQ\"],\"columns[1].htmlType\":[\"input\"],\"columns[1].dictType\":[\"\"],\"columns[2].columnId\":[\"6\"],\"columns[2].sort\":[\"3\"],\"columns[2].columnComment\":[\"图片链接\"],\"columns[2].javaType\":[\"String\"],\"columns[2].javaField\":[\"picurl\"],\"columns[2].isInsert\":[\"1\"],\"columns[2].isEdit\":[\"1\"],\"columns[2].isList\":[\"1\"],\"columns[2].isQuery\":[\"1\"],\"columns[2].queryType\":[\"EQ\"],\"columns[2].htmlType\":[\"textarea\"],\"columns[2].dictType\":[\"\"],\"columns[3].columnId\":[\"7\"],\"columns[3].sort\":[\"4\"],\"columns[3].columnComment\":[\"内容\"],\"columns[3].javaType\":[\"String\"],\"columns[3].javaField\":[\"content\"],\"columns[3].isInsert\":[\"1\"],\"columns[3].isEdit\":[\"1\"],\"columns[3].isList\":[\"1\"],\"columns[3].isQuery\":[\"1\"],\"columns[3].queryType\":[\"EQ\"],\"columns[3].htmlType\":[\"summernote\"],\"columns[3].dictType\":[\"\"],\"columns[4].columnId\":[\"8\"],\"columns[4].sort\":[\"5\"],\"columns[4].columnComment\":[\"0:征兵 1:新闻\"],\"columns[4].javaType\":[\"String\"],\"columns[4].javaField\":[\"type\"],\"columns[4].isEdit\":[\"1\"],\"columns[4].isList\":[\"1\"],\"columns[4].isQuery\":[\"1\"],\"columns[4].queryType\":[\"EQ\"],\"columns[4].htmlType\":[\"select\"],\"columns[4].dictType\":[\"\"],\"tplCategory\":[\"crud\"],\"packageName\":[\"com.ruoyi.system\"],\"moduleName\":[\"system\"],\"businessName\":[\"manage\"],\"functionName\":[\"首页管理\"],\"params[parentMenuId]\":[\"2007\"],\"params[parentMenuName]\":[\"首页管理\"],', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:28:06', 37);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (121, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/edit', '127.0.0.1', '内网IP', '{\"tableId\":[\"3\"],\"tableName\":[\"app_shenhe\"],\"tableComment\":[\"报名审核\"],\"className\":[\"AppShenhe\"],\"functionAuthor\":[\"chris\"],\"remark\":[\"\"],\"columns[0].columnId\":[\"9\"],\"columns[0].sort\":[\"1\"],\"columns[0].columnComment\":[\"id\"],\"columns[0].javaType\":[\"Long\"],\"columns[0].javaField\":[\"id\"],\"columns[0].isInsert\":[\"1\"],\"columns[0].queryType\":[\"EQ\"],\"columns[0].htmlType\":[\"input\"],\"columns[0].dictType\":[\"\"],\"columns[1].columnId\":[\"10\"],\"columns[1].sort\":[\"2\"],\"columns[1].columnComment\":[\"用户id\"],\"columns[1].javaType\":[\"String\"],\"columns[1].javaField\":[\"userId\"],\"columns[1].isInsert\":[\"1\"],\"columns[1].isEdit\":[\"1\"],\"columns[1].isList\":[\"1\"],\"columns[1].isQuery\":[\"1\"],\"columns[1].queryType\":[\"EQ\"],\"columns[1].htmlType\":[\"input\"],\"columns[1].dictType\":[\"\"],\"columns[2].columnId\":[\"11\"],\"columns[2].sort\":[\"3\"],\"columns[2].columnComment\":[\"报名图片\"],\"columns[2].javaType\":[\"String\"],\"columns[2].javaField\":[\"pic\"],\"columns[2].isInsert\":[\"1\"],\"columns[2].isEdit\":[\"1\"],\"columns[2].isList\":[\"1\"],\"columns[2].isQuery\":[\"1\"],\"columns[2].queryType\":[\"EQ\"],\"columns[2].htmlType\":[\"textarea\"],\"columns[2].dictType\":[\"\"],\"columns[3].columnId\":[\"12\"],\"columns[3].sort\":[\"4\"],\"columns[3].columnComment\":[\"民族\"],\"columns[3].javaType\":[\"String\"],\"columns[3].javaField\":[\"minzu\"],\"columns[3].isInsert\":[\"1\"],\"columns[3].isEdit\":[\"1\"],\"columns[3].isList\":[\"1\"],\"columns[3].isQuery\":[\"1\"],\"columns[3].queryType\":[\"EQ\"],\"columns[3].htmlType\":[\"input\"],\"columns[3].dictType\":[\"\"],\"columns[4].columnId\":[\"13\"],\"columns[4].sort\":[\"5\"],\"columns[4].columnComment\":[\"性别\"],\"columns[4].javaType\":[\"String\"],\"columns[4].javaField\":[\"sex\"],\"columns[4].isInsert\":[\"1\"],\"columns[4].isEdit\":[\"1\"],\"columns[4].isList\":[\"1\"],\"columns[4].isQuery\":[\"1\"],\"columns[4].queryType\":[\"EQ\"],\"columns[4].htmlType\":[\"select\"],\"columns[4].dictType\":[\"\"],\"columns[5].columnId\":[\"14\"],\"columns[5].sort\":[\"6\"],\"columns[5].columnComment\":[\"年龄\"],\"columns[5].javaType\":[\"String\"],\"columns[5].javaField\":[\"age\"],\"columns[5].isInsert\":[\"1\"],\"columns[5].isEdit\":[', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:29:07', 144);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (122, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/edit', '127.0.0.1', '内网IP', '{\"tableId\":[\"4\"],\"tableName\":[\"app_zixun\"],\"tableComment\":[\"咨询管理\"],\"className\":[\"AppZixun\"],\"functionAuthor\":[\"ruoyi\"],\"remark\":[\"\"],\"columns[0].columnId\":[\"26\"],\"columns[0].sort\":[\"1\"],\"columns[0].columnComment\":[\"id\"],\"columns[0].javaType\":[\"Long\"],\"columns[0].javaField\":[\"zixunId\"],\"columns[0].isInsert\":[\"1\"],\"columns[0].queryType\":[\"EQ\"],\"columns[0].htmlType\":[\"input\"],\"columns[0].dictType\":[\"\"],\"columns[1].columnId\":[\"27\"],\"columns[1].sort\":[\"2\"],\"columns[1].columnComment\":[\"咨询标题\"],\"columns[1].javaType\":[\"String\"],\"columns[1].javaField\":[\"title\"],\"columns[1].isInsert\":[\"1\"],\"columns[1].isEdit\":[\"1\"],\"columns[1].isList\":[\"1\"],\"columns[1].isQuery\":[\"1\"],\"columns[1].queryType\":[\"EQ\"],\"columns[1].htmlType\":[\"input\"],\"columns[1].dictType\":[\"\"],\"columns[2].columnId\":[\"28\"],\"columns[2].sort\":[\"3\"],\"columns[2].columnComment\":[\"图片1\"],\"columns[2].javaType\":[\"String\"],\"columns[2].javaField\":[\"img1\"],\"columns[2].isInsert\":[\"1\"],\"columns[2].isEdit\":[\"1\"],\"columns[2].isList\":[\"1\"],\"columns[2].isQuery\":[\"1\"],\"columns[2].queryType\":[\"EQ\"],\"columns[2].htmlType\":[\"textarea\"],\"columns[2].dictType\":[\"\"],\"columns[3].columnId\":[\"29\"],\"columns[3].sort\":[\"4\"],\"columns[3].columnComment\":[\"图片2\"],\"columns[3].javaType\":[\"String\"],\"columns[3].javaField\":[\"img2\"],\"columns[3].isInsert\":[\"1\"],\"columns[3].isEdit\":[\"1\"],\"columns[3].isList\":[\"1\"],\"columns[3].isQuery\":[\"1\"],\"columns[3].queryType\":[\"EQ\"],\"columns[3].htmlType\":[\"textarea\"],\"columns[3].dictType\":[\"\"],\"columns[4].columnId\":[\"30\"],\"columns[4].sort\":[\"5\"],\"columns[4].columnComment\":[\"图片3\"],\"columns[4].javaType\":[\"String\"],\"columns[4].javaField\":[\"img3\"],\"columns[4].isInsert\":[\"1\"],\"columns[4].isEdit\":[\"1\"],\"columns[4].isList\":[\"1\"],\"columns[4].isQuery\":[\"1\"],\"columns[4].queryType\":[\"EQ\"],\"columns[4].htmlType\":[\"textarea\"],\"columns[4].dictType\":[\"\"],\"columns[5].columnId\":[\"31\"],\"columns[5].sort\":[\"6\"],\"columns[5].columnComment\":[\"标签\"],\"columns[5].javaType\":[\"String\"],\"columns[5].javaField\":[\"mark\"],\"columns[5].isInsert\":[\"1\"],\"columns[5', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:30:19', 140);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (123, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/edit', '127.0.0.1', '内网IP', '{\"tableId\":[\"5\"],\"tableName\":[\"appuser_info\"],\"tableComment\":[\"个人信息\"],\"className\":[\"AppuserInfo\"],\"functionAuthor\":[\"ruoyi\"],\"remark\":[\"\"],\"columns[0].columnId\":[\"34\"],\"columns[0].sort\":[\"1\"],\"columns[0].columnComment\":[\"id\"],\"columns[0].javaType\":[\"Long\"],\"columns[0].javaField\":[\"userId\"],\"columns[0].isInsert\":[\"1\"],\"columns[0].queryType\":[\"EQ\"],\"columns[0].htmlType\":[\"input\"],\"columns[0].dictType\":[\"\"],\"columns[1].columnId\":[\"35\"],\"columns[1].sort\":[\"2\"],\"columns[1].columnComment\":[\"昵称\"],\"columns[1].javaType\":[\"String\"],\"columns[1].javaField\":[\"nickname\"],\"columns[1].isInsert\":[\"1\"],\"columns[1].isEdit\":[\"1\"],\"columns[1].isList\":[\"1\"],\"columns[1].isQuery\":[\"1\"],\"columns[1].queryType\":[\"LIKE\"],\"columns[1].htmlType\":[\"input\"],\"columns[1].dictType\":[\"\"],\"columns[2].columnId\":[\"36\"],\"columns[2].sort\":[\"3\"],\"columns[2].columnComment\":[\"手机号\"],\"columns[2].javaType\":[\"String\"],\"columns[2].javaField\":[\"userphone\"],\"columns[2].isInsert\":[\"1\"],\"columns[2].isEdit\":[\"1\"],\"columns[2].isList\":[\"1\"],\"columns[2].isQuery\":[\"1\"],\"columns[2].queryType\":[\"EQ\"],\"columns[2].htmlType\":[\"input\"],\"columns[2].dictType\":[\"\"],\"columns[3].columnId\":[\"37\"],\"columns[3].sort\":[\"4\"],\"columns[3].columnComment\":[\"密码\"],\"columns[3].javaType\":[\"String\"],\"columns[3].javaField\":[\"password\"],\"columns[3].isInsert\":[\"1\"],\"columns[3].isEdit\":[\"1\"],\"columns[3].isList\":[\"1\"],\"columns[3].isQuery\":[\"1\"],\"columns[3].queryType\":[\"EQ\"],\"columns[3].htmlType\":[\"input\"],\"columns[3].dictType\":[\"\"],\"columns[4].columnId\":[\"38\"],\"columns[4].sort\":[\"5\"],\"columns[4].columnComment\":[\"性别\"],\"columns[4].javaType\":[\"String\"],\"columns[4].javaField\":[\"sex\"],\"columns[4].isInsert\":[\"1\"],\"columns[4].isEdit\":[\"1\"],\"columns[4].isList\":[\"1\"],\"columns[4].isQuery\":[\"1\"],\"columns[4].queryType\":[\"EQ\"],\"columns[4].htmlType\":[\"select\"],\"columns[4].dictType\":[\"\"],\"columns[5].columnId\":[\"39\"],\"columns[5].sort\":[\"6\"],\"columns[5].columnComment\":[\"年龄\"],\"columns[5].javaType\":[\"String\"],\"columns[5].javaField\":[\"age\"],\"columns[5].isInsert\":[\"1\"],\"colu', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:31:25', 93);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (124, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.batchGenCode()', 'GET', 1, 'admin', '研发部门', '/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{\"tables\":[\"app_first_manage,app_shenhe,app_zixun,appuser_info\"]}', NULL, 0, NULL, '2023-04-13 00:31:58', 1040);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (125, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.batchGenCode()', 'GET', 1, 'admin', '研发部门', '/tool/gen/batchGenCode', '127.0.0.1', '内网IP', '{\"tables\":[\"app_first_manage,app_shenhe,app_zixun,appuser_info\"]}', NULL, 0, NULL, '2023-04-13 00:32:00', 1074);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (126, '首页管理', 1, 'com.ruoyi.web.controller.system.AppFirstManageController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/add', '127.0.0.1', '内网IP', '{\"newsTitle\":[\"23\"],\"picurl\":[\"234\"],\"content\":[\"<p>234523452345</p>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:39:31', 522);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (127, '咨询管理', 1, 'com.ruoyi.web.controller.system.AppZixunController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/zixun/add', '127.0.0.1', '内网IP', '{\"title\":[\"12\"],\"img1\":[\"123\"],\"img2\":[\"1231\"],\"img3\":[\"3213\"],\"mark\":[\"123\"],\"backup\":[\"123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:41:16', 27);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (128, '咨询管理', 2, 'com.ruoyi.web.controller.system.AppZixunController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/zixun/edit', '127.0.0.1', '内网IP', '{\"zixunId\":[\"1\"],\"title\":[\"12\"],\"img1\":[\"123\"],\"img2\":[\"1231\"],\"img3\":[\"3213\"],\"mark\":[\"1231231\"],\"backup\":[\"123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:41:22', 9);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (129, '报名审核', 1, 'com.ruoyi.web.controller.system.AppShenheController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/shenhe/add', '127.0.0.1', '内网IP', '{\"id\":[\"1231\"],\"userId\":[\"23\"],\"pic\":[\"1231\"],\"minzu\":[\"231\"],\"age\":[\"1231\"],\"zzmm\":[\"23\"],\"jiguan\":[\"123\"],\"hyzk\":[\"123\"],\"xlxx\":[\"123\"],\"cylb\":[\"123\"],\"dszv\":[\"123\"],\"name\":[\"123\"],\"phone\":[\"12\"],\"sfzid\":[\"12\"],\"address\":[\"123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:41:45', 36);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (130, '用户管理', 1, 'com.ruoyi.web.controller.system.AppuserInfoController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/info/add', '127.0.0.1', '内网IP', '{\"nickname\":[\"24\"],\"userphone\":[\"432\"],\"age\":[\"423\"],\"introduce\":[\"42\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 00:42:40', 24);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (131, '咨询管理', 1, 'com.ruoyi.web.controller.system.AppZixunController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/zixun/add', '127.0.0.1', '内网IP', '{\"title\":[\"123\"],\"img1\":[\"123\"],\"img2\":[\"123\"],\"img3\":[\"123\"],\"mark\":[\"123\"],\"backup\":[\"123\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 07:38:35', 346);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (132, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '127.0.0.1', '内网IP', '{\"id\":[\"3\"],\"imgurl\":[\"https://th.bing.com/th/id/R.987f582c510be58755c4933cda68d525?rik=C0D21hJDYvXosw&riu=http%3a%2f%2fimg.pconline.com.cn%2fimages%2fupload%2fupc%2ftx%2fwallpaper%2f1305%2f16%2fc4%2f20990657_1368686545122.jpg&ehk=netN2qzcCVS4ALUQfDOwxAwFcy41oxC%2b0xTFvOYy5ds%3d&risl=&pid=ImgRaw&r=0\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-13 09:10:47', 448);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (133, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"1\"],\"newsTitle\":[\"“四优先”为大学生参军开辟“绿色通道”\"],\"picurl\":[\"https://www.gfbzb.gov.cn/news/img/1599944121.jpg\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）</p>\"]}', NULL, 1, '\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'content\' at row 1\n### The error may exist in file [/Users/gaike/github_program/conscription/ruoyi-system/target/classes/mapper/system/AppFirstManageMapper.xml]\n### The error may involve com.ruoyi.system.mapper.AppFirstManageMapper.updateAppFirstManage-Inline\n### The error occurred while setting parameters\n### SQL: update app_first_manage          SET news_title = ?,             picurl = ?,             content = ?          where news_id = ?\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'content\' at row 1\n; Data truncation: Data too long for column \'content\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'content\' at row 1', '2023-04-14 09:17:27', 338);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (134, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"1\"],\"newsTitle\":[\"“四优先”为大学生参军开辟“绿色通道”\"],\"picurl\":[\"https://www.gfbzb.gov.cn/news/img/1599944121.jpg\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）</p>\"]}', NULL, 1, '\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'content\' at row 1\n### The error may exist in file [/Users/gaike/github_program/conscription/ruoyi-system/target/classes/mapper/system/AppFirstManageMapper.xml]\n### The error may involve com.ruoyi.system.mapper.AppFirstManageMapper.updateAppFirstManage-Inline\n### The error occurred while setting parameters\n### SQL: update app_first_manage          SET news_title = ?,             picurl = ?,             content = ?          where news_id = ?\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'content\' at row 1\n; Data truncation: Data too long for column \'content\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'content\' at row 1', '2023-04-14 09:17:43', 20);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (135, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"1\"],\"newsTitle\":[\"“四优先”为大学生参军开辟“绿色通道”\"],\"picurl\":[\"https://www.gfbzb.gov.cn/news/img/1599944121.jpg\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）</p>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:21:32', 92);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (136, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"1\"],\"newsTitle\":[\"“四优先”为大学生参军开辟“绿色通道”\"],\"picurl\":[\"https://www.gfbzb.gov.cn/news/img/1599944121.jpg\"],\"content\":[\"<p>&nbsp; &nbsp; &nbsp; &nbsp;4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。</p><p>&nbsp; &nbsp; &nbsp;会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。</p><p>&nbsp; &nbsp; &nbsp;今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）</p>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:22:56', 140);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (137, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"1\"],\"newsTitle\":[\"“四优先”为大学生参军开辟“绿色通道”\"],\"picurl\":[\"https://www.gfbzb.gov.cn/news/img/1599944121.jpg\"],\"content\":[\"&nbsp;4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:23:46', 9);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (138, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"1\"],\"newsTitle\":[\"“四优先”为大学生参军开辟“绿色通道”\"],\"picurl\":[\"https://www.gfbzb.gov.cn/news/img/1599944121.jpg\"],\"content\":[\"4月26日，笔者从教育部、中央军委国防动员部联合在京召开的全国大学生征兵工作网络视频会议上获悉，各级兵役机关和教育部门、高校等今年将进一步为大学生应征入伍开辟“绿色通道”，做到大学生参军优先报名应征、优先体检政考、优先审批定兵、优先安排使用，实现从“校门”到“营门”的直通。会议主办方领导谈到,高校丰富的人才和教育资源,是军队优质兵员的战略储备基地,近年来军地各级切实把征集优秀大学生作为人才强国、人才兴军战略的基础工程来推进，千方百计创造良好条件，实施有力的政策引导、工作指导、检查督导，把一批又一批优秀大学生输送到部队，为建设世界一流军队提供优质兵员保证。今年，为使大学生应征入伍的“绿色通道”更加快捷畅通，军地各级各部门精准实施一系列有力举措。持续落实好现行政策规定，对国家出台的大学生优先征集、优待资助、选用培养、考试升学、就业服务等方面的一整套政策，对一些地方结合本地实际自主出台的就业创业、提高优待标准、放宽落户条件等优惠政策，按规定要求全面落实到位，让大学生感受到参军入伍带来的政策红利。做好政策宣传解读，设置征兵咨询电话或网上答疑平台，暑假期间也有专人值班，随时向大学生宣讲政策法规、报名条件和应征流程。完善高校征兵工作机构，在高校挂牌设立的征兵工作站，做到机构、人员、经费、场地四到位，确保与应征大学生实现无缝对接。强化入伍激励机制，各地各高校进一步拿出鼓励入伍、支持退役后升学复学、拓宽就业创业渠道的措施办法，做到校校有政策、事事有落实。加大跟踪指导服务力度，各地各高校为大学生报名应征和退役后复学、升学、就业等，实施“一站式”服务、“一条龙”办理，让大学生入伍安心，服役暖心，退伍放心。（刘国顺、张东华、任旭）\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:24:19', 29);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (139, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"2\"],\"newsTitle\":[\"携笔从戎卫世博，立足本职铸忠诚\"],\"picurl\":[\"https://t3.chei.com.cn/common/zbbm/images/0_02_01.png\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">我是复旦大学的一名学生汪航。父亲为我取这个名字，就是希望我能在汪洋大海里乘风破浪地航行。我的父亲是一名蓝天卫士，从小我就在部队大院中长大，和军队结下了不解之缘。看到解放军叔叔们的飒爽英姿，我非常地羡慕和向往，梦想着有一天我也能成为他们当中的一员，父亲从小就以一名军人的标准来要求我，使得我从小就有着一股不怕苦、不服输的军人气质。2008年，我没有辜负家人亲友的希望，成功地考上了复旦大学。记得那是大二刚开学的时候，徜徉在百年复旦静谧的林荫道上，我正盘算着这个学期该选些什么课，忽然感觉那天的校园有点不一样，原来是两旁参天的法国梧桐上那鲜艳的条幅。“响应世博召唤，接受祖国挑选”，看着热血沸腾的红色标语，我的心底激起了阵阵涟漪，小时候穿着父亲军装学敬礼的样子又浮现在脑海。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">作为一名复旦大学的在读生，为了自己的梦想，为了响应“参与世博、奉献世博、保卫世博”的号召，我毅然选择了暂停学业，投身到火热的警营和崇高而艰巨的世博安保任务中来的。记得我要参军的消息传开后，身边的同学朋友都不能理解，觉得放着好好的书不读，非要到部队“遭罪”何苦呢。都说“像你这样当过学生会主席，获得过上海市三好学生，钢琴乐理都十级，毕业后一定能找到一份称心的工作的，去部队不过是浪费时间而已”。但我不这样想，从军入伍是每名适龄青年的应尽义务，是每个热血男儿的应有之志，尤其是对于一名名牌大学的大学生来讲，更应当以报效国家为己任，在国家需要、世博需要的时候义无反顾的投身其中，让自己的闪亮青春在火热的警营中放射光芒。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">到了部队后，快节奏、高强度的警营生活让我感受到前所未有的压力和挑战，我暗暗下定决心：作为一个大学生士兵，能够来到这绿色的警营，就一定要发挥出我的优势，当好兵、站好岗，做一名合格的武警战士。两年来，在中队领导的精心培养和战友们的大力支持下，我积极利用自身特长为部队的宣传文化工作作出了应有的贡献。除了在中队主编队刊《征途》杂志，担任中队报道员、小广播员、教歌员等重要角色外，我还发挥自己的演讲特长，代表支队多次参加军地演讲活动，大力宣扬武警部队先进事迹，为支队赢得了不少荣誉。2010年8月，我作为官兵代表前往浦东新区上钢社区演讲，大力宣扬武警上海总队官兵在世博安保任务中的光荣事迹，受到了现场观众的高度肯定。在演讲会后的交流中，我还应领导和居民要求介绍并演唱了自己创作的队歌《战斗的青春》，让他们赞不绝口。在2011年6月武警上海总队举行的《嘹亮军歌献给党》建党90周年歌咏大赛上，我作为武警十支队合唱团钢琴伴奏和教歌员自己编写伴奏谱，并协助编排歌曲的艺术效果和动作，得到了上海师范大学专业艺术指导老师的肯定，也为支队代表队的成功演出作出了贡献。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:25:34', 14);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (140, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"3\"],\"newsTitle\":[\"从军中骄子到商界英才的万达董事长王健林\"],\"picurl\":[\"https://t1.chei.com.cn/common/zbbm/images/5_img.png,https://t4.chei.com.cn/common/zbbm/images/4_img.png\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">一、敢闯敢试</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">他是敢为天下先的地产大亨，他是与马云对赌一个亿的冒险家，他是中国的房地产首富，三年内，两次荣登“胡润房地产富豪榜”榜首，更是以集团形式捐款超过28亿的慈善家，他胆识过人，霸气外露，是血气方刚的企业家，他扬言只要万达进入的行业，其他的企业都没有机会做老大。他拒绝模仿，大胆创新，是名副其实的行动派。他就是大连万达集团董事长王健林。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">受家庭的影响，15岁的王健林就从四川来到东北，入伍参军，并且在28岁就成为了一名正团职干部。 在1987年，为了响应国家“百万裁军”的号召，王健林告别了自己18年的部队生活。转业后，王健林来到大连市西岗区区政府任办公室主任。但很快，本认为仕途无量的王健林竟弃政从商，通过企业改制的机会，创建了大连万达集团股份有限公司。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">迈入了房地产这个圈后，万达的第一桶金是大连市政府北门的棚户区改造。这是一个多少有些无奈的举措，作为一家民营企业，万达拿不到当时房地产开发项目所需的配额，只能承接旧城改造这个不被看好的工程。王健林作了大胆的尝试，铝合金窗，防盗门，改明厅，设洗手间，这些现在看来的“小儿科”，在当年都是创举。因为给每个房间设洗手间，万达还遭到了纪委的审查，其时这是局级以上干部住房才有的配置。万达在这个项目挣了近千万，更重要的是闯出了一条新路，成为全国首家进行旧城改造的企业，迅速做大了企业规模。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">成为全国房地产第一家跨区域发展的企业，也是万达大胆闯出来的。万达异地开发的第一站在广州，五六年下来，没挣到多少钱，但增强了信心，既然在当时所谓的圣地、房地产发源地都能站住脚，还有什么好怕?自此，万达“更多锻炼胆量，一发不可收拾”，成为全国跨区域最多的企业，遍布80多个城市。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, ', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:28:49', 87);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (141, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"4\"],\"newsTitle\":[\"招收军士的招收条件\"],\"picurl\":[\"https://t2.chei.com.cn/common/zbbm/images/banner.jpg\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">招收对象所学专业应当符合部队专业需要。所学专业在就读的普通高等学校已经开展职业技能鉴定的，应当取得中级以上职业资格证书。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">招收的普通高等学校毕业生年龄不超过24周岁。</p>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:31:00', 11);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (142, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"5\"],\"newsTitle\":[\"招收军士政策规定简介\"],\"picurl\":[\"http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg\"],\"content\":[\"<p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\"><b style=\\\"border: 0px; margin: 0px; padding: 0px;\\\">1.什么是招收军士？</b></p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">直接从非军事部门招收军士（简称招收军士），是指根据《兵役法》、《征兵工作条例》以及有关规定，直接招收普通高等学校毕业生入伍，作为志愿兵役制士兵到部队服现役。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\"><b style=\\\"border: 0px; margin: 0px; padding: 0px;\\\">2.招收军士有何条件要求？</b></p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">招收军士的对象为普通高等学校毕业生，所学专业符合部队专业需要，年龄不超过24周岁（截至招收当年12月31日）；政治和体格条件，按照征集义务兵有关规定执行。所学专业在就读的普通高等学校已经开展职业技能鉴定的，应当取得中级以上职业资格证书。</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\"><b style=\\\"border: 0px; margin: 0px; padding: 0px;\\\">3.如何报名应征招收军士？</b></p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">招收军士采取网上报名，普通高等学校男性应届毕业生可登录“全国征兵网”查询</p><p style=\\\"border: 0px; margin-bottom: 15px; padding: 0px; font-size: 14px; text-indent: 2em; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino San', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:32:04', 304);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (143, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"5\"],\"newsTitle\":[\"招收军士基本情况介绍\"],\"picurl\":[\"http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg\"],\"content\":[\"<span style=\\\"color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体; font-size: 14px; text-indent: 28px;\\\">我军现役士兵按兵役性质分为义务兵役制士兵和志愿兵役制士兵。义务兵役制士兵称为义务兵，志愿兵役制士兵称为军士。军士属于士兵军衔序列，但不同于义务兵役制士兵，是士兵中的骨干。义务兵实行供给制，发给津贴，军士实行工资制和定期增资制度。目前部队面向高校毕业生既招收军士，也招收义务兵，这是两个不同兵役性质的士兵系列。直接从非军事部门招收军士(简称招收军士)，是指根据《兵役法》、《征兵工作条例》以及有关规定，直接招收普通高等学校的毕业生入伍，作为志愿兵役制士兵到部队服现役。招收军士招收对象为全日制大专以上学历，所学专业符合部队专业需要，招收时间从每年8月份开始，9月底结束。</span>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:32:54', 26);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (144, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"6\"],\"newsTitle\":[\"招收军士的政治考核\"],\"picurl\":[\"http://xychead.xueyiche.vip/pic_1681351141083.jpg\"],\"content\":[\"<span style=\\\"color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体; font-size: 14px; text-indent: 28px;\\\">符合招收军士征集条件的往届高校毕业生需在户口所在地报名应征并参加政治考核。符合招收军士征集条件的应届高校毕业生既可在生源地(入读高校前户口所在地)报名应征，也可在毕业高校所在地报名应征，在生源地报名应征的，由生源地按有关规定组织政考，在毕业高校所在地报名应征的，无论户口是否转入学校，其政治考核一律由毕业学校所在地县(市、区)公安机关负责，由入学前户口所在地县(市、区)公安机关协查。</span>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:33:28', 40);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (145, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"6\"],\"newsTitle\":[\"招收军士的政治考核\"],\"picurl\":[\"https://t1.chei.com.cn/news/img/1867075652.jpg\"],\"content\":[\"符合招收军士征集条件的往届高校毕业生需在户口所在地报名应征并参加政治考核。符合招收军士征集条件的应届高校毕业生既可在生源地(入读高校前户口所在地)报名应征，也可在毕业高校所在地报名应征，在生源地报名应征的，由生源地按有关规定组织政考，在毕业高校所在地报名应征的，无论户口是否转入学校，其政治考核一律由毕业学校所在地县(市、区)公安机关负责，由入学前户口所在地县(市、区)公安机关协查。\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:35:04', 14);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (146, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"7\"],\"newsTitle\":[\"视力基本要求？\"],\"picurl\":[\"http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg,http://xychead.xueyiche.vip/pic_1681351141083.jpg\"],\"content\":[\"<p style=\\\"border: 0px; padding: 0px; font-size: 12px; line-height: 24px; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">任何一眼裸眼视力低于4.5，不合格。</p><p style=\\\"border: 0px; padding: 0px; font-size: 12px; line-height: 24px; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">任何一眼裸眼视力低于4.8，需进行矫正视力检查，任何一眼矫正视力低于4.8或矫正度数超过600度，不合格。</p><p style=\\\"border: 0px; padding: 0px; font-size: 12px; line-height: 24px; color: rgb(102, 102, 102); font-family: 微软雅黑, tahoma, arial, &quot;Hiragino Sans GB&quot;, 宋体;\\\">屈光不正经准分子激光手术（不含有晶体眼人工晶体植入术等其他术式）后半年以上，无并发症，任何一眼裸眼视力达到4.8，眼底检查正常，除条件兵外合格。条件兵视力合格条件按有关标准执行。</p><p></p>\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:40:03', 762);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (147, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"7\"],\"newsTitle\":[\"视力基本要求？\"],\"picurl\":[\"https://img0.baidu.com/it/u=2337897795,3598542586&fm=253&fmt=auto&app=138&f=JPEG?w=755&h=500,https://img1.baidu.com/it/u=2575148126,1483450288&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=332\"],\"content\":[\"任何一眼裸眼视力低于4.5，不合格。任何一眼裸眼视力低于4.8，需进行矫正视力检查，任何一眼矫正视力低于4.8或矫正度数超过600度，不合格。屈光不正经准分子激光手术（不含有晶体眼人工晶体植入术等其他术式）后半年以上，无并发症，任何一眼裸眼视力达到4.8，眼底检查正常，除条件兵外合格。条件兵视力合格条件按有关标准执行。\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:41:22', 211);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (148, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"7\"],\"newsTitle\":[\"视力基本要求？\"],\"picurl\":[\"https://www.ckxw.net/pic2_900_900/upfiles/2018-04/20180409233513413.jpg,https://img2.zjolcdn.com/pic/0/17/81/01/17810150_843343.jpg\"],\"content\":[\"任何一眼裸眼视力低于4.5，不合格。任何一眼裸眼视力低于4.8，需进行矫正视力检查，任何一眼矫正视力低于4.8或矫正度数超过600度，不合格。屈光不正经准分子激光手术（不含有晶体眼人工晶体植入术等其他术式）后半年以上，无并发症，任何一眼裸眼视力达到4.8，眼底检查正常，除条件兵外合格。条件兵视力合格条件按有关标准执行。\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:42:38', 8);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (149, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '111.42.61.169', 'XX XX', '{\"id\":[\"1\"],\"imgurl\":[\"https://www.hinews.cn/pic/0/10/57/66/10576686_629796.jpg\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:44:32', 14);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (150, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '111.42.61.169', 'XX XX', '{\"id\":[\"2\"],\"imgurl\":[\"https://img1.baidu.com/it/u=1044432704,3206383340&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:47:07', 24);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (151, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '111.42.61.169', 'XX XX', '{\"id\":[\"3\"],\"imgurl\":[\"https://www.chinanews.com.cn/fileftp/2009/10/2009-10-30/U225P4T47D11893F967DT20091030114157.jpg\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:48:05', 85);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (152, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '111.42.61.169', 'XX XX', '{\"id\":[\"4\"],\"imgurl\":[\"https://lres.cloudhubei.com.cn/c2/litedfs/resource/180cmsAttach/node2/20220211/8bb0fccc21a86ed3e3472b82f5cc054c96e1696cc6b04cf99ace3a738b080b59.jpg\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:48:33', 6);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (153, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '111.42.61.169', 'XX XX', '{\"id\":[\"5\"],\"imgurl\":[\"https://imagepphcloud.thepaper.cn/pph/image/72/635/115.jpg\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:49:10', 9);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (154, '轮播图', 2, 'com.ruoyi.web.controller.system.PictureUrlController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/url/edit', '111.42.61.169', 'XX XX', '{\"id\":[\"6\"],\"imgurl\":[\"https://inews.gtimg.com/newsapp_bt/0/13230928931/1000\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:50:07', 116);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (155, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"4\"],\"newsTitle\":[\"招收军士的招收条件\"],\"picurl\":[\"https://img1.gtimg.com/news/pics/hv1/54/58/1864/121221444.jpg,https://inews.gtimg.com/newsapp_bt/0/13099572106/1000.jpg\"],\"content\":[\"招收对象所学专业应当符合部队专业需要。所学专业在就读的普通高等学校已经开展职业技能鉴定的，应当取得中级以上职业资格证书。招收的普通高等学校毕业生年龄不超过24周岁。\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:51:33', 20);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (156, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"5\"],\"newsTitle\":[\"招收军士基本情况介绍\"],\"picurl\":[\"https://img1.baidu.com/it/u=630921100,2332819719&fm=253&fmt=auto&app=138&f=JPEG?w=660&h=312\"],\"content\":[\"我军现役士兵按兵役性质分为义务兵役制士兵和志愿兵役制士兵。义务兵役制士兵称为义务兵，志愿兵役制士兵称为军士。军士属于士兵军衔序列，但不同于义务兵役制士兵，是士兵中的骨干。义务兵实行供给制，发给津贴，军士实行工资制和定期增资制度。目前部队面向高校毕业生既招收军士，也招收义务兵，这是两个不同兵役性质的士兵系列。直接从非军事部门招收军士(简称招收军士)，是指根据《兵役法》、《征兵工作条例》以及有关规定，直接招收普通高等学校的毕业生入伍，作为志愿兵役制士兵到部队服现役。招收军士招收对象为全日制大专以上学历，所学专业符合部队专业需要，招收时间从每年8月份开始，9月底结束。\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:52:24', 19);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (157, '首页管理', 2, 'com.ruoyi.web.controller.system.AppFirstManageController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/manage/edit', '111.42.61.169', 'XX XX', '{\"newsId\":[\"5\"],\"newsTitle\":[\"招收军士基本情况介绍\"],\"picurl\":[\"https://www.hgdaily.com.cn/w/3/upfile/4/2020/12/24/20201224110546714002.png,https://pimage.cqcb.com/d/file/county/dadukouquxinwen/2020-12-29/e8f35ac81a7c19c7c39539aa67084bbd.jpg\"],\"content\":[\"我军现役士兵按兵役性质分为义务兵役制士兵和志愿兵役制士兵。义务兵役制士兵称为义务兵，志愿兵役制士兵称为军士。军士属于士兵军衔序列，但不同于义务兵役制士兵，是士兵中的骨干。义务兵实行供给制，发给津贴，军士实行工资制和定期增资制度。目前部队面向高校毕业生既招收军士，也招收义务兵，这是两个不同兵役性质的士兵系列。直接从非军事部门招收军士(简称招收军士)，是指根据《兵役法》、《征兵工作条例》以及有关规定，直接招收普通高等学校的毕业生入伍，作为志愿兵役制士兵到部队服现役。招收军士招收对象为全日制大专以上学历，所学专业符合部队专业需要，招收时间从每年8月份开始，9月底结束。\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 09:53:23', 49);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (158, '报名审核', 2, 'com.ruoyi.web.controller.system.AppShenheController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/shenhe/edit', '127.0.0.1', '内网IP', '{\"id\":[\"1233\"],\"userId\":[\"1\"],\"pic\":[\"picurl\"],\"minzu\":[\"汉族\"],\"age\":[\"18\"],\"zzmm\":[\"群众\"],\"jiguan\":[\"哈尔滨\"],\"hyzk\":[\"未婚\"],\"xlxx\":[\"大学\"],\"cylb\":[\"IT\"],\"dszv\":[\"独生子女\"],\"name\":[\"周杰伦\"],\"phone\":[\"1365555555\"],\"sfzid\":[\"2301871987498237\"],\"address\":[\"黑龙江哈尔滨江北\"],\"type\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-14 20:48:29', 168);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (159, '用户管理', 1, 'com.ruoyi.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"100\"],\"userName\":[\"zhengbing\"],\"deptName\":[\"若依科技\"],\"phonenumber\":[\"\"],\"email\":[\"\"],\"loginName\":[\"zhengbing\"],\"sex\":[\"0\"],\"role\":[\"2\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-15 14:24:15', 193);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (160, '角色管理', 2, 'com.ruoyi.web.controller.system.SysRoleController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/role/edit', '127.0.0.1', '内网IP', '{\"roleId\":[\"2\"],\"roleName\":[\"普通角色\"],\"roleKey\":[\"common\"],\"roleSort\":[\"2\"],\"status\":[\"0\"],\"remark\":[\"普通角色\"],\"menuIds\":[\"2000,2001,2002,2004,2007,2029,2030,2031,2032,2033,2008,2017,2018,2019,2020,2021,2009,2023,2024,2025,2026,2027,2010,2011,2012,2013,2014,2015\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-15 14:25:38', 76);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (161, '个人信息', 2, 'com.ruoyi.web.controller.system.SysProfileController.updateAvatar()', 'POST', 1, 'zhengbing', '若依科技', '/system/user/profile/updateAvatar', '127.0.0.1', '内网IP', '', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-04-15 14:26:19', 182);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (162, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/menu/add', '127.0.0.1', '内网IP', '{\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"房间管理\"],\"url\":[\"\"],\"target\":[\"menuItem\"],\"perms\":[\"\"],\"orderNum\":[\"10\"],\"icon\":[\"fa fa-institution\"],\"visible\":[\"0\"],\"isRefresh\":[\"1\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 21:24:55', 197);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (163, '代码生成', 6, 'com.ruoyi.generator.controller.GenController.importTableSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/importTable', '127.0.0.1', '内网IP', '{\"tables\":[\"app_room\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 21:25:11', 153);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (164, '代码生成', 2, 'com.ruoyi.generator.controller.GenController.editSave()', 'POST', 1, 'admin', '研发部门', '/tool/gen/edit', '127.0.0.1', '内网IP', '{\"tableId\":[\"6\"],\"tableName\":[\"app_room\"],\"tableComment\":[\"房间大厅\"],\"className\":[\"AppRoom\"],\"functionAuthor\":[\"ChrisGai\"],\"remark\":[\"\"],\"columns[0].columnId\":[\"42\"],\"columns[0].sort\":[\"1\"],\"columns[0].columnComment\":[\"id\"],\"columns[0].javaType\":[\"Long\"],\"columns[0].javaField\":[\"roomId\"],\"columns[0].isInsert\":[\"1\"],\"columns[0].isEdit\":[\"1\"],\"columns[0].isList\":[\"1\"],\"columns[0].queryType\":[\"EQ\"],\"columns[0].htmlType\":[\"input\"],\"columns[0].dictType\":[\"\"],\"columns[1].columnId\":[\"43\"],\"columns[1].sort\":[\"2\"],\"columns[1].columnComment\":[\"用户id\"],\"columns[1].javaType\":[\"String\"],\"columns[1].javaField\":[\"userId\"],\"columns[1].isInsert\":[\"1\"],\"columns[1].isEdit\":[\"1\"],\"columns[1].isList\":[\"1\"],\"columns[1].queryType\":[\"EQ\"],\"columns[1].htmlType\":[\"input\"],\"columns[1].dictType\":[\"\"],\"columns[2].columnId\":[\"44\"],\"columns[2].sort\":[\"3\"],\"columns[2].columnComment\":[\"房间密码\"],\"columns[2].javaType\":[\"String\"],\"columns[2].javaField\":[\"roomPass\"],\"columns[2].isInsert\":[\"1\"],\"columns[2].isEdit\":[\"1\"],\"columns[2].isList\":[\"1\"],\"columns[2].queryType\":[\"EQ\"],\"columns[2].htmlType\":[\"input\"],\"columns[2].dictType\":[\"\"],\"columns[3].columnId\":[\"45\"],\"columns[3].sort\":[\"4\"],\"columns[3].columnComment\":[\"房间标题\"],\"columns[3].javaType\":[\"String\"],\"columns[3].javaField\":[\"roomTitle\"],\"columns[3].isInsert\":[\"1\"],\"columns[3].isEdit\":[\"1\"],\"columns[3].isList\":[\"1\"],\"columns[3].isQuery\":[\"1\"],\"columns[3].queryType\":[\"EQ\"],\"columns[3].htmlType\":[\"input\"],\"columns[3].dictType\":[\"\"],\"columns[4].columnId\":[\"46\"],\"columns[4].sort\":[\"5\"],\"columns[4].columnComment\":[\"房间图片\"],\"columns[4].javaType\":[\"String\"],\"columns[4].javaField\":[\"roomUrl\"],\"columns[4].isInsert\":[\"1\"],\"columns[4].isEdit\":[\"1\"],\"columns[4].isList\":[\"1\"],\"columns[4].queryType\":[\"EQ\"],\"columns[4].htmlType\":[\"input\"],\"columns[4].dictType\":[\"\"],\"columns[5].columnId\":[\"47\"],\"columns[5].sort\":[\"6\"],\"columns[5].columnComment\":[\"创建时间\"],\"columns[5].javaType\":[\"Date\"],\"columns[5].javaField\":[\"roomtime\"],\"columns[5].isInsert\":[\"1\"],\"columns[5].isEdit\":[\"1\"],\"c', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 21:28:00', 69);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (165, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.download()', 'GET', 1, 'admin', '研发部门', '/tool/gen/download/app_room', '127.0.0.1', '内网IP', '\"app_room\"', NULL, 0, NULL, '2023-05-11 21:28:06', 491);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (166, '代码生成', 8, 'com.ruoyi.generator.controller.GenController.download()', 'GET', 1, 'admin', '研发部门', '/tool/gen/download/app_room', '127.0.0.1', '内网IP', '\"app_room\"', NULL, 0, NULL, '2023-05-11 21:28:09', 542);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (167, '房间大厅', 1, 'com.ruoyi.web.controller.system.AppRoomController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/room/add', '127.0.0.1', '内网IP', '{\"roomId\":[\"1\"],\"userId\":[\"9\"],\"roomPass\":[\"111\"],\"roomTitle\":[\"111\"],\"roomUrl\":[\"111\"],\"roomtime\":[\"\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 21:36:41', 134);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (168, '用户管理', 1, 'com.ruoyi.web.controller.system.SysUserController.addSave()', 'POST', 1, 'admin', '研发部门', '/system/user/add', '127.0.0.1', '内网IP', '{\"deptId\":[\"103\"],\"userName\":[\"toupiao\"],\"deptName\":[\"研发部门\"],\"phonenumber\":[\"\"],\"email\":[\"\"],\"loginName\":[\"toupiao\"],\"sex\":[\"0\"],\"role\":[\"2\"],\"remark\":[\"\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"4\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 21:37:42', 60);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (169, '角色管理', 2, 'com.ruoyi.web.controller.system.SysRoleController.editSave()', 'POST', 1, 'admin', '研发部门', '/system/role/edit', '127.0.0.1', '内网IP', '{\"roleId\":[\"2\"],\"roleName\":[\"普通角色\"],\"roleKey\":[\"common\"],\"roleSort\":[\"2\"],\"status\":[\"0\"],\"remark\":[\"普通角色\"],\"menuIds\":[\"2035,2036,2037,2038,2039,2040\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 21:38:13', 53);
INSERT INTO `sys_oper_log` (`oper_id`, `title`, `business_type`, `method`, `request_method`, `operator_type`, `oper_name`, `dept_name`, `oper_url`, `oper_ip`, `oper_location`, `oper_param`, `json_result`, `status`, `error_msg`, `oper_time`, `cost_time`) VALUES (170, '房间大厅', 3, 'com.ruoyi.web.controller.system.AppRoomController.remove()', 'POST', 1, 'admin', '研发部门', '/system/room/remove', '127.0.0.1', '内网IP', '{\"ids\":[\"1,2\"]}', '{\"msg\":\"操作成功\",\"code\":0}', 0, NULL, '2023-05-11 22:42:47', 138);
COMMIT;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
BEGIN;
INSERT INTO `sys_post` (`post_id`, `post_code`, `post_name`, `post_sort`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_post` (`post_id`, `post_code`, `post_name`, `post_sort`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_post` (`post_id`, `post_code`, `post_name`, `post_sort`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2023-04-09 07:35:56', '', NULL, '');
INSERT INTO `sys_post` (`post_id`, `post_code`, `post_name`, `post_sort`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2023-04-09 07:35:56', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '超级管理员', 'admin', 1, '1', '0', '0', 'admin', '2023-04-09 07:35:56', '', NULL, '超级管理员');
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '普通角色', 'common', 2, '2', '0', '0', 'admin', '2023-04-09 07:35:56', 'admin', '2023-05-11 21:38:13', '普通角色');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_dept` (`role_id`, `dept_id`) VALUES (2, 100);
INSERT INTO `sys_role_dept` (`role_id`, `dept_id`) VALUES (2, 101);
INSERT INTO `sys_role_dept` (`role_id`, `dept_id`) VALUES (2, 105);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2035);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2036);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2037);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2038);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2039);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2040);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) DEFAULT '' COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户 01注册用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `pwd_update_date` datetime DEFAULT NULL COMMENT '密码最后更新时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '/profile/avatar/2023/04/09/blob_20230409081043A001.png', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '127.0.0.1', '2023-05-11 22:42:36', '2023-04-09 07:35:56', 'admin', '2023-04-09 07:35:56', '', '2023-05-11 22:42:36', '管理员');
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '/profile/avatar/2023/04/09/blob_20230409075518A001.png', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '0', '127.0.0.1', '2023-04-09 07:35:56', '2023-04-09 07:35:56', 'admin', '2023-04-09 07:35:56', '', '2023-04-09 07:55:18', '测试员');
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (100, NULL, 'paul', 'paul', '00', '', '', '0', '', '117e18fb209c87972146ed284f1e4548', '9b0b12', '0', '0', '', NULL, NULL, 'admin', '2023-04-09 07:50:53', '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (101, NULL, 'paul1', 'paul1', '00', '', '', '0', '', '73a523f0ff1c65be990a9c67a862530a', '0d2f65', '0', '0', '', NULL, NULL, 'admin', '2023-04-09 07:51:22', '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (102, 100, 'zhengbing', 'zhengbing', '00', '', '', '0', '/profile/avatar/2023/04/15/blob_20230415142619A001.png', '07aedd5b16df21629a695f3002e4abf1', '140edb', '0', '0', '127.0.0.1', '2023-05-11 21:24:09', NULL, 'admin', '2023-04-15 14:24:15', '', '2023-05-11 21:24:08', NULL);
INSERT INTO `sys_user` (`user_id`, `dept_id`, `login_name`, `user_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `salt`, `status`, `del_flag`, `login_ip`, `login_date`, `pwd_update_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (103, 103, 'toupiao', 'toupiao', '00', '', '', '0', '', '5875b8b4b9e5398f9a8bc5b7753436f0', '5d0260', '0', '0', '', NULL, NULL, 'admin', '2023-05-11 21:37:42', '', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='在线用户记录';

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_post` (`user_id`, `post_id`) VALUES (1, 1);
INSERT INTO `sys_user_post` (`user_id`, `post_id`) VALUES (2, 2);
INSERT INTO `sys_user_post` (`user_id`, `post_id`) VALUES (103, 4);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (100, 2);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (101, 2);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (102, 2);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (103, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
