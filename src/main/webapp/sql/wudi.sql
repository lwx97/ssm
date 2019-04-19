/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : wudi

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-04-19 09:18:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `class_id` varchar(255) NOT NULL,
  `class_name` varchar(255) default NULL,
  `class_qq` varchar(255) default NULL,
  `class_master` varchar(255) default NULL,
  `class_master_phone` varchar(255) default NULL,
  `class_title` varchar(255) default NULL,
  `school_name` varchar(255) default NULL,
  PRIMARY KEY  (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1231', '19级软件工程2班', '123456', '李季', '18893842410', '天道酬勤！', '兰州理工大学');

-- ----------------------------
-- Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` varchar(255) NOT NULL default '',
  `college_name` varchar(255) NOT NULL,
  `college_text` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '计算机与通信学院', '计算机与通信学院沿袭湖南工程学院的发展历程，经过多年坚持不懈的努力，现开设有计算机科学与技术、软件工程、网络工程和通信工程4个本科专业。 设置了计算机科学与技术教研室、软件工程教研室、网络工程教研室、通信工程教研室、基础教研室和实验教研室共6个教研室。学院实验室面积超过3000㎡，实验设备总价值达2200多万元。博士生导师、硕士生导师指导在读研究生11人，在校全日制本科学生1100余人。\r\n</br>\r\n学院拥有湖南省普通高校实践教学示范中心1个，计算机类专业大学生创新创业教育中心1个，网络与通信技术虚拟仿真实验教学中心1个，校级协同创新中心1个，校级重点学科1个。计算机科学与技术专业于2013年获批教育部“卓越工程师教育培养计划”第三批试点专业。学院在动力工程（风电系统控制技术方向）、纺织工程（服装CAD及应用方向）两个专业从2012年开始招收全日制硕士专业学位研究生 。\r\n</br>\r\n学院近年来在师资队伍、教学设施、研究条件、课程设置等方面日益充实与完备。学院现有教职工68人，专任教师中博士生导师1人，硕士研究生导师7人，教授5人，副教授23人，博士20人，湖南省青年骨干教师5人，湖南省“121”人才工程1人，省青年教学能手1人，校优秀教师3人，受学生欢迎的“十佳教师”4人，校级优秀教学团队2个。专任教师中具有硕士以上学位的教师占70%以上。\r\n</br>\r\n近三年来，计算机与通信学院主持国家自然科学基金项目6项，省自然科学基金项目12项，湖南省科技计划项目8项，湖南省教育厅青年和重点项目8项，省级教学改革研究项目11项，主持湖南省大学生研究性学习和创新性实验计划10项，主持校级精品课程建设项目6项，获得湖南省优秀教学成果奖6项。近五年来，在《计算机学报》、《软件学报》、《通信学报》等国内外学术期刊和会议上发表科研论文400多篇，三大检索收录150余篇。主、参编规划教材10余本，出版学术著作6部。\r\n</br>\r\n学院以计算机应用技术校级重点学科为平台，建立了人工智能研究所和计算机应用技术研究所。拥有中央与地方共建实验中心5个；湖南省示范实验室1个（网络工程与通信实验中心），网络工程实训室（思科网络技术学院）1个。\r\n</br>\r\n与美国惠普网络公司组建了处于国际先进水平的联合实验中心（湖南工程学院—惠普网络实验中心），成为惠普网络中国地区用户和经销商的技术培训和支持基地。搭建了计算机与通信课程实践教学和科研平台，与中国电信等企业建立了战略合作伙伴关系，开展产学研合作，并在校外建立了26个长期稳定的实习基地。\r\n</br>\r\n学院坚持应用型本科办学定位，以学生为本、以教师为尊，紧紧围绕人才培养、科学研究、服务社会的职能积极探索与实践，开展了多渠道多方位的国内外交流与合作。学院高度重视学生工程实践能力和创新能力的培养，构建了“四层递进三结合”模式的实践教学体系，组建了15个学生创新创业团队，近年来学生先后获得全国大学生电子设计大赛一等奖、 “挑战杯”湖南省大学生课外学术科技作品竞赛、思科网院杯大学生网络技术竞赛CCNA赛等多项奖励。全院师生将继续发扬湖南工程学院优良传统，为实现建设有特色高水平应用型大学而努力奋斗！');
INSERT INTO `college` VALUES ('2', '软件学院', '*');
INSERT INTO `college` VALUES ('3', '经管学院', '*');
INSERT INTO `college` VALUES ('4', '材料学院', '*');
INSERT INTO `college` VALUES ('5', '土木学院', '*');
INSERT INTO `college` VALUES ('6', '外国语学院', '*');

-- ----------------------------
-- Table structure for `img`
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` varchar(255) NOT NULL default '',
  `img_title` varchar(100) default NULL,
  `img_url` varchar(255) default NULL,
  `others_id` varchar(255) default NULL,
  `img_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('1', '美丽校园', '\\img\\1.jpg', null, '2019-02-27 10:17:01');
INSERT INTO `img` VALUES ('2', '美丽宜海', '\\img\\2.jpg', null, '2018-02-22 10:17:07');
INSERT INTO `img` VALUES ('3', '小树林', '\\img\\3.jpg', null, '2019-01-01 10:17:12');
INSERT INTO `img` VALUES ('4', '田径场风光', '\\img\\4.jpg', null, '2019-01-18 10:17:27');

-- ----------------------------
-- Table structure for `info`
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `info_id` varchar(255) NOT NULL default '',
  `info_name` varchar(255) default NULL,
  `info_value` varchar(255) default NULL,
  `master_id` varchar(255) default NULL,
  `ps` varchar(255) default NULL,
  PRIMARY KEY  (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', '按时报到', '1', '1', null);
INSERT INTO `info` VALUES ('2', '延时报到', '2', '1', null);
INSERT INTO `info` VALUES ('3', '无法报到', '3', '1', null);
INSERT INTO `info` VALUES ('4', '火车站乘坐校车', '1', '2', null);
INSERT INTO `info` VALUES ('5', '飞机场乘坐校车', '2', '2', null);
INSERT INTO `info` VALUES ('6', '自己到校', '3', '2', null);
INSERT INTO `info` VALUES ('7', '准备复读', '1', '3', null);
INSERT INTO `info` VALUES ('8', '其他原因导致无法报到', '2', '3', null);

-- ----------------------------
-- Table structure for `master_info`
-- ----------------------------
DROP TABLE IF EXISTS `master_info`;
CREATE TABLE `master_info` (
  `master_id` varchar(255) NOT NULL default '',
  `master_name` varchar(255) default NULL,
  `master_value` varchar(255) default NULL,
  `ps` varchar(255) default NULL,
  PRIMARY KEY  (`master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_info
-- ----------------------------
INSERT INTO `master_info` VALUES ('1', '报到状态', 'report_status', null);
INSERT INTO `master_info` VALUES ('2', '到校方式', 'report_type', null);
INSERT INTO `master_info` VALUES ('3', '无法报到原因', 'noReport', null);

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(255) NOT NULL default '',
  `type_id` varchar(255) default NULL,
  `menu_name` varchar(255) default NULL,
  `menu_value` text,
  `ps` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '1', '学院简历', '        兰州理工大学坐落于甘肃省省会兰州市，是甘肃省人民政府、教育部、国家国防科技工业局共建高校，国家“中西部高等教育振兴计划”重点建设高校，“国家大学生创新型实验计划”和教育部“卓越工程师计划”入选高校，入选2016年国家国防教育特色学校，东南大学对口支援高校。\r\n        学校前身是1919年的甘肃省立工艺学校；1958年，在组建兰州工学院的基础上，将甘肃交通大学并入，定名为甘肃工业大学；1965年，学校划归第一机械工业部，同时将东北重型机械学院和北京机械学院的水力机械、化工机械、石油矿场机械和焊接工艺及设备专业成建制全部迁入，并从湖南大学、合肥工业大学抽调一批教师来校工作；1998年，转制为“中央与地方共建，以地方管理为主”的院校；2003年，正式更名为兰州理工大学。经过近百年的建设与发展，学校已成为一所工科实力雄厚、理科水平不断提高、文科具有特色的多学科协调发展的理工科大学。\r\n        学校现有两个校区，占地面积2430亩，校舍建筑面积108.9万平方米，图书馆馆藏图书223万册，电子图书55000GB。\r\n        学校坚持立德树人根本任务，突出人才培养的中心地位，加强创新创业教育，完善质量保障体系，人才培养质量稳步提高，入选了“全国首批99个深化创新创业教育改革示范高校”。学校设有19个学院、1个教学研究部，设有研究生院、温州研究生分院。有2个国家级教学团队、3个国家级实验教学示范中心，是教育部首批示范性网络社区（易班网）试点高校，面向全国招生，有全日制在校生27075人，在2006年教育部组织的本科教学工作水平评估中获得“优秀”，在2017年本科教学工作审核评估中，获得专家好评。毕业生就业率连续多年保持在97％以上，被教育部授予“2009年度全国毕业生就业典型经验高校”称号。2015年，在解放军四总部组织的、有117所国防生培养地方高校参加的国防生军政素质基础达标考核中，我校国防生以全优的成绩位列第一名。\r\n        学校有教职工2309人，专任教师1412人，其中高级职称813人，博士生导师151人，博士学位教师478人。有共享院士4人，“长江学者”特聘教授2人、国家杰出青年基金获得者2人、中国科学院“百人计划”入选者3人、教育部新世纪优秀人才1人。有享受国务院特殊津贴30人、“百万人才工程”国家级人选2人，有“全国先进工作者”、 “全国师德标兵”、“全国优秀教师”1人。有甘肃省领军人才35人、“飞天学者”23人，省级“教学名师”11人。入选首批全国高校黄大年式教学团队\r\n        学校是我国首批学士、硕士学位授权高校，是甘肃省第一所具有工学博士学位授予权、第一所设置工学博士后科研流动站的高校。现有9个学科门类，涵盖了工学、理学、管理学、文学、法学、教育学、医学、艺术学、经济学。有16个省级重点学科，4个国防特色学科方向。“工程学”、“材料科学”两个学科进入“ESI排名全球前1%”。在全国第四轮学科评估中，土木工程、机械工程、材料科学与工程、控制科学与工程4个学科进入B档。冶金工程、动力工程及工程热物理在第三轮学科评估中分别位列全国高校第11位、26位。有5个博士后科研流动站、6个一级学科博士点、46个二级学科博士点、23个一级学科硕士点、170个二级学科硕士点，有6个硕士专业学位类别，有工程硕士（18个授权领域）、工商管理硕士、会计硕士、国际商务硕士、法律硕士、艺术硕士专业学位授予权。学校有66个本科专业，其中有6个国家特色专业建设点，2个教育部战略性新兴产业相关专业，1个国家级专业综合改革试点专业；机械设计制造及其自动化、过程装备与控制工程、化学工程与工艺和材料成型及控制工程4个专业通过了工程教育专业认证，土木工程、工程管理、建筑学3个专业通过住建部专业评估。\r\n        学校大力推进学研产深度融合，主动服务国家和区域经济社会发展，在有色金属新材料及先进加工、高端装备及数控加工设备、新能源技术及装备、石油化工流程装备、工业控制及信息技术、土木工程及防灾减灾等研究方向形成了鲜明特色。学校现有“长江学者和创新团队发展计划”创新团队2个、国家级科技创新平台4个、教育部科研基地6个，省部级科研机构36个。学校有“省部共建有色金属先进加工与再利用国家重点实验室”，有经国家发改委批准成立的“有色金属合金加工国家地方联合工程实验室”，高新技术成果推广中心是首批国家级技术转移示范机构，大学科技园是国家级大学科技园，有经工信部批准的国家中小企业公共服务示范平台，是甘肃省首家拥有“军品三证”的高校。学校承担了包括“973”、“863”在内的多项国家重大科技项目，近五年承担国家级科研项目336项，入围了中国大学及科研院所研究影响力200强，2017年科技经费达到1.4亿元；SCI收录论文在全国高校排名达到140位，EI收录论文在全国高校排名达到71位。\r\n        学校与兰州市、酒泉市、白银市、金昌市、温州市等20余个省内外城市建立了全面合作关系，与酒钢公司、金川公司、兰州石化公司、兰石集团等200多家企业建立了稳定的产学研合作关系。学校积极深化与地方政府、企业的合作，成立了“兰州理工大学——金川集团股份有限公司镍钴金属新材料协同创新中心”、“西北低碳城镇支撑技术协同创新中心 ”、“甘肃省工业经济发展研究院”、“甘肃生态建设与环境保护研究中心”、“中国国际电子商务培训学院——甘肃省分院”、“兰州理工大学兰州新区产业发展研究院”、“兰州理工大学—金川集团股份有限公司工程技术研究院”、“兰理工大学温州泵阀工程研究院”、 “兰州理工大学白银新材料研究院”、“兰州理工大学兰石研究院”、“敦煌研究院—兰州理工大学文化遗产数字保护与再利用联合实验室”等科研机构，助推经济社会发展。\r\n        学校稳步推进国际化战略，主动服务“一带一路”倡议，与美国、俄罗斯、英国、澳大利亚等40余所大学建立了合作关系，是上海合作组织大学中方项目院校，加入了“一带一路”高校战略联盟，与台湾中正大学、昆山科技大学、静宜大学等签署了校际间的合作交流协议，与东南大学签署了第二轮（2018—2022年）对口支援协议。学校通过国家公派留学项目、西部特别项目、“2+2”、“1+2+1”等交流项目，每年派出200多名师生赴国外学习交流。学校具有中国政府奖学金留学生招生资格，来自35个国家的320多名国际学生在校学习。\r\n        学校秉承“奋进求是”的校训，大力弘扬以“艰苦奋斗，自强不息，求真务实，开拓创新”为主要内涵的“红柳精神”，党的建设、思想政治工作和精神文明建设成绩喜人，荣获“全国先进基层党组织”、“全国党建和思想政治工作先进高等学校”、“全国精神文明建设先进单位”、“全国文明单位”、 “易班共建示范高校”等荣誉。2017年荣获首届“全国文明校园”称号，成为甘肃省首家获此殊荣的高校。 “十三五”时期，学校将继续高举中国特色社会主义伟大旗帜，以马克思列宁主义、毛泽东思想、邓小平理论、“三个代表”重要思想、科学发展观、习近平新时代中国特色社会主义思想为指导，贯彻落实国家中长期教育改革和发展规划纲要，按照“四个全面”战略布局和五大发展理念，落实全国高校思想政治工作会议精神，以立德树人为根本，以支撑创新驱动发展战略、服务经济社会发展为导向，努力在2019年建校百年之际，把学校建设成为具有一流工科、坚实理科、特色文科的国内高水平教学研究型大学。 （资料更新：2018年7月） ', null);
INSERT INTO `menu` VALUES ('10', '2', '校园一卡通使用说明', '内容；；；；；；；；；；；', null);
INSERT INTO `menu` VALUES ('11', '3', '图书馆简介', '内容——————', null);
INSERT INTO `menu` VALUES ('12', '3', '学科建设', '内容。。。。。。', null);
INSERT INTO `menu` VALUES ('13', '3', '我的大学生活', '内容！！！！', null);
INSERT INTO `menu` VALUES ('14', '3', '学生管理规定', '内容；；；；。', null);
INSERT INTO `menu` VALUES ('15', '6', '校长介绍信', '亲爱的同学们：\r\n      XX大学，一个读书的好地方，一个圆梦的好家园。在此，我们向你发出热情邀请并郑重承诺： 我们将为每一个有梦想的学子搭建成长舞台，为每一个有追求的学子构筑心灵港湾，为每一个有准备的学子创造成功机遇。 热忱欢迎有志学子加入浙师人的行列！让我们相约金秋美丽浙师！ ', null);
INSERT INTO `menu` VALUES ('16', '6', '新生报到流程', '内容。。。。', null);
INSERT INTO `menu` VALUES ('17', '6', '迎新系统使用说明', '内容！！！', null);
INSERT INTO `menu` VALUES ('18', '6', '新生报道乘车路线', '内容......', null);
INSERT INTO `menu` VALUES ('19', '5', '新生入学须知', '内容！！！', null);
INSERT INTO `menu` VALUES ('2', '1', '校训和校歌', '        *', null);
INSERT INTO `menu` VALUES ('20', '5', '失物招领', 'res', null);
INSERT INTO `menu` VALUES ('21', '5', '学费一览', 'tuition', null);
INSERT INTO `menu` VALUES ('4', '1', '历史沿革', '***', null);
INSERT INTO `menu` VALUES ('5', '1', '现任领导', '***', null);
INSERT INTO `menu` VALUES ('6', null, '校长致辞', '亲爱的同学们：<br />\r\n       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;XX大学，一个读书的好地方，一个圆梦的好家园。在此，我们向你发出热情邀请并郑重承诺：\r\n	   我们将为每一个有梦想的学子搭建成长舞台，为每一个有追求的学子构筑心灵港湾，为每一个有准备的学子创造成功机遇。\r\n	   热忱欢迎有志学子加入浙师人的行列！让我们相约金秋美丽浙师！\r\n', 'xzzc');
INSERT INTO `menu` VALUES ('7', '2', '校园生活向导', '*********', null);
INSERT INTO `menu` VALUES ('8', '2', '心理咨询', '****心理咨询内容', null);
INSERT INTO `menu` VALUES ('9', '2', '学生公寓上网方式', '上网方式内容', null);

-- ----------------------------
-- Table structure for `menu_type`
-- ----------------------------
DROP TABLE IF EXISTS `menu_type`;
CREATE TABLE `menu_type` (
  `id` varchar(255) NOT NULL,
  `type_name` varchar(255) default NULL,
  `type_value` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_type
-- ----------------------------
INSERT INTO `menu_type` VALUES ('1', '了解大学', null);
INSERT INTO `menu_type` VALUES ('2', '家在大学', null);
INSERT INTO `menu_type` VALUES ('3', '学在大学', null);
INSERT INTO `menu_type` VALUES ('4', '走进大学', null);
INSERT INTO `menu_type` VALUES ('5', '迎新公告', null);
INSERT INTO `menu_type` VALUES ('6', '迎新须知', null);
INSERT INTO `menu_type` VALUES ('7', '院系介绍', null);

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` varchar(255) NOT NULL default '',
  `news_title` varchar(255) default NULL COMMENT '要闻标题',
  `news_text` text COMMENT '要闻内容',
  `news_typeid` varchar(255) default NULL COMMENT '要闻类型',
  `news_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', 'XXXX大学召开2019年首次科技工作例会', '*', '1', '2019-03-07 13:52:39');
INSERT INTO `news` VALUES ('2', '学习召开领导班子专题研讨会 研究部署今年重点工作', '*', '1', '2019-03-07 13:53:22');
INSERT INTO `news` VALUES ('3', '我校XX教授赴四川讲学并调研高烈度区复杂隔震工程', '*', '1', '2018-10-11 13:53:42');
INSERT INTO `news` VALUES ('4', '15级新生军训开幕式', '*', '2', '2015-09-12 16:29:00');

-- ----------------------------
-- Table structure for `newsflash`
-- ----------------------------
DROP TABLE IF EXISTS `newsflash`;
CREATE TABLE `newsflash` (
  `id` varchar(255) NOT NULL default '',
  `nf_title` varchar(255) default NULL COMMENT '快讯标题',
  `nf_text` text COMMENT '快讯内容',
  `nf_typeid` varchar(255) default NULL COMMENT '快讯类型',
  `nf_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newsflash
-- ----------------------------
INSERT INTO `newsflash` VALUES ('1', '关注XX大学学生工作部微信公众号，查课表，查成绩，查校历。', '*', '3', '2019-03-07 11:00:33');
INSERT INTO `newsflash` VALUES ('2', '辅导员告诉你，大学该学什么？', '*', '4', '2019-03-07 11:01:01');

-- ----------------------------
-- Table structure for `news_type`
-- ----------------------------
DROP TABLE IF EXISTS `news_type`;
CREATE TABLE `news_type` (
  `id` varchar(255) NOT NULL default '',
  `news_type_name` varchar(255) default NULL COMMENT '新闻类型',
  `news_type` varchar(255) default NULL COMMENT '快讯还是要闻，快讯为1要闻为2',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_type
-- ----------------------------
INSERT INTO `news_type` VALUES ('1', '科技创新', '2');
INSERT INTO `news_type` VALUES ('2', '校园文化', '2');
INSERT INTO `news_type` VALUES ('3', '校园学习', '1');
INSERT INTO `news_type` VALUES ('4', '校园里的美食', '1');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` varchar(255) NOT NULL default '',
  `sc_xzhyx` text COMMENT '校长欢迎信',
  `sc_xsbdlc` text COMMENT '新生报到流程',
  `direction` text COMMENT '系统使用说明书',
  `route` text COMMENT '乘车路线',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for `outlay`
-- ----------------------------
DROP TABLE IF EXISTS `outlay`;
CREATE TABLE `outlay` (
  `id` varchar(255) NOT NULL default '',
  `outlay_type` varchar(255) default '' COMMENT '费用项目',
  `outlay_need` varchar(255) default NULL COMMENT '费用',
  `outlay_yes` varchar(255) default NULL COMMENT '已缴费用',
  `outlay_no` varchar(255) default NULL COMMENT '未交费用',
  `outlay_ps` varchar(255) default NULL,
  `stu_id` varchar(255) default NULL,
  `outlay_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outlay
-- ----------------------------
INSERT INTO `outlay` VALUES ('1', '第一年学费', '5500', '5500', '0', '1', '1516270255', '2019-04-10 16:14:00');
INSERT INTO `outlay` VALUES ('2', '教材费', '800', '0', '800', '0', '1516270255', null);
INSERT INTO `outlay` VALUES ('3', '学杂费', '400', '400', '0', '2', '1516270255', '2019-04-10 16:14:16');
INSERT INTO `outlay` VALUES ('4', '住宿费', '900', '500', '400', '0', '1516270255', '2019-04-09 16:14:21');

-- ----------------------------
-- Table structure for `report_info`
-- ----------------------------
DROP TABLE IF EXISTS `report_info`;
CREATE TABLE `report_info` (
  `id` varchar(255) NOT NULL default '',
  `report_title` varchar(255) default NULL,
  `report_time` datetime default NULL,
  `report_phone` varchar(255) default NULL,
  `report_type` varchar(255) default NULL,
  `report_text` varchar(255) default NULL,
  `report_status` varchar(255) default NULL,
  `noReport` varchar(255) default NULL,
  `info_id` varchar(255) default NULL,
  `ps` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report_info
-- ----------------------------
INSERT INTO `report_info` VALUES ('1cd465f012094ff6ba7c48bc74fd77e5', 'ç½ä¸æ¥å°ä¿¡æ¯', '2019-04-23 00:00:00', '18893842410', '1', 'test1111', '1', 'Unselected', '1516270255', null);

-- ----------------------------
-- Table structure for `res`
-- ----------------------------
DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
  `res_id` varchar(32) NOT NULL,
  `res_title` varchar(255) default NULL COMMENT '失物招领标题',
  `res_time` datetime default NULL COMMENT '丢失时间',
  `res_text` text COMMENT '文章内容',
  `res_image` varchar(320) default NULL COMMENT '物品图片',
  PRIMARY KEY  (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res
-- ----------------------------
INSERT INTO `res` VALUES ('1', '标题1', '2019-02-13 00:00:00', '内容1！', '/img/b1.jpg');
INSERT INTO `res` VALUES ('2', '标题2', '2019-03-13 00:00:00', '内容2', '/img/b2.jpg');
INSERT INTO `res` VALUES ('3', '标题3', '2019-03-04 00:00:00', '内容3', '/img/b3.jpg');
INSERT INTO `res` VALUES ('4', '标题4', '2019-02-04 00:00:00', '内容4', '/img/b4.jpg');
INSERT INTO `res` VALUES ('5', '标题5', '2019-03-04 00:00:00', '内容5', '/img/b5.jpg');
INSERT INTO `res` VALUES ('6', '标题6', '2019-01-15 00:00:55', '内容6', '/img/b6.jpg');
INSERT INTO `res` VALUES ('7', '标题7', '2019-03-13 00:00:00', '内容7', '/img/b1.jpg');
INSERT INTO `res` VALUES ('8', '标题8', '2019-03-18 00:00:00', '内容8', '/img/b3.jpg');
INSERT INTO `res` VALUES ('9', '标题9', '2019-03-17 00:00:00', '内容9', '/img/b4.jpg');

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `sc_id` varchar(32) NOT NULL COMMENT '学校ID',
  `sc_summary` text COMMENT '校园简介',
  `sc_motto` text COMMENT '校训',
  `sc_song` text COMMENT '校歌',
  `sc_history` text COMMENT '历史沿革',
  `sc_masterid` varchar(320) default NULL COMMENT '现任领导ID',
  `sc_guide` text COMMENT '校园向导',
  `sc_mind` text COMMENT '心理咨询',
  `sc_netplay` text COMMENT '上网方式',
  `sc_card` text COMMENT '一卡通',
  `sc_books` text COMMENT '图书馆简介',
  `sc_subject` varchar(320) default NULL COMMENT '学科建设id',
  `sc_life` text COMMENT '大学生活ID',
  `sc_regulations` text COMMENT '管理规定',
  `sc_rxxz` text COMMENT '入学须知',
  `sc_xzzc` text COMMENT '校长致辞',
  PRIMARY KEY  (`sc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('123', '        兰州理工大学坐落于甘肃省省会兰州市，是甘肃省人民政府、教育部、国家国防科技工业局共建高校，国家“中西部高等教育振兴计划”重点建设高校，“国家大学生创新型实验计划”和教育部“卓越工程师计划”入选高校，入选2016年国家国防教育特色学校，东南大学对口支援高校。\r\n        学校前身是1919年的甘肃省立工艺学校；1958年，在组建兰州工学院的基础上，将甘肃交通大学并入，定名为甘肃工业大学；1965年，学校划归第一机械工业部，同时将东北重型机械学院和北京机械学院的水力机械、化工机械、石油矿场机械和焊接工艺及设备专业成建制全部迁入，并从湖南大学、合肥工业大学抽调一批教师来校工作；1998年，转制为“中央与地方共建，以地方管理为主”的院校；2003年，正式更名为兰州理工大学。经过近百年的建设与发展，学校已成为一所工科实力雄厚、理科水平不断提高、文科具有特色的多学科协调发展的理工科大学。\r\n        学校现有两个校区，占地面积2430亩，校舍建筑面积108.9万平方米，图书馆馆藏图书223万册，电子图书55000GB。\r\n        学校坚持立德树人根本任务，突出人才培养的中心地位，加强创新创业教育，完善质量保障体系，人才培养质量稳步提高，入选了“全国首批99个深化创新创业教育改革示范高校”。学校设有19个学院、1个教学研究部，设有研究生院、温州研究生分院。有2个国家级教学团队、3个国家级实验教学示范中心，是教育部首批示范性网络社区（易班网）试点高校，面向全国招生，有全日制在校生27075人，在2006年教育部组织的本科教学工作水平评估中获得“优秀”，在2017年本科教学工作审核评估中，获得专家好评。毕业生就业率连续多年保持在97％以上，被教育部授予“2009年度全国毕业生就业典型经验高校”称号。2015年，在解放军四总部组织的、有117所国防生培养地方高校参加的国防生军政素质基础达标考核中，我校国防生以全优的成绩位列第一名。\r\n        学校有教职工2309人，专任教师1412人，其中高级职称813人，博士生导师151人，博士学位教师478人。有共享院士4人，“长江学者”特聘教授2人、国家杰出青年基金获得者2人、中国科学院“百人计划”入选者3人、教育部新世纪优秀人才1人。有享受国务院特殊津贴30人、“百万人才工程”国家级人选2人，有“全国先进工作者”、 “全国师德标兵”、“全国优秀教师”1人。有甘肃省领军人才35人、“飞天学者”23人，省级“教学名师”11人。入选首批全国高校黄大年式教学团队\r\n        学校是我国首批学士、硕士学位授权高校，是甘肃省第一所具有工学博士学位授予权、第一所设置工学博士后科研流动站的高校。现有9个学科门类，涵盖了工学、理学、管理学、文学、法学、教育学、医学、艺术学、经济学。有16个省级重点学科，4个国防特色学科方向。“工程学”、“材料科学”两个学科进入“ESI排名全球前1%”。在全国第四轮学科评估中，土木工程、机械工程、材料科学与工程、控制科学与工程4个学科进入B档。冶金工程、动力工程及工程热物理在第三轮学科评估中分别位列全国高校第11位、26位。有5个博士后科研流动站、6个一级学科博士点、46个二级学科博士点、23个一级学科硕士点、170个二级学科硕士点，有6个硕士专业学位类别，有工程硕士（18个授权领域）、工商管理硕士、会计硕士、国际商务硕士、法律硕士、艺术硕士专业学位授予权。学校有66个本科专业，其中有6个国家特色专业建设点，2个教育部战略性新兴产业相关专业，1个国家级专业综合改革试点专业；机械设计制造及其自动化、过程装备与控制工程、化学工程与工艺和材料成型及控制工程4个专业通过了工程教育专业认证，土木工程、工程管理、建筑学3个专业通过住建部专业评估。\r\n        学校大力推进学研产深度融合，主动服务国家和区域经济社会发展，在有色金属新材料及先进加工、高端装备及数控加工设备、新能源技术及装备、石油化工流程装备、工业控制及信息技术、土木工程及防灾减灾等研究方向形成了鲜明特色。学校现有“长江学者和创新团队发展计划”创新团队2个、国家级科技创新平台4个、教育部科研基地6个，省部级科研机构36个。学校有“省部共建有色金属先进加工与再利用国家重点实验室”，有经国家发改委批准成立的“有色金属合金加工国家地方联合工程实验室”，高新技术成果推广中心是首批国家级技术转移示范机构，大学科技园是国家级大学科技园，有经工信部批准的国家中小企业公共服务示范平台，是甘肃省首家拥有“军品三证”的高校。学校承担了包括“973”、“863”在内的多项国家重大科技项目，近五年承担国家级科研项目336项，入围了中国大学及科研院所研究影响力200强，2017年科技经费达到1.4亿元；SCI收录论文在全国高校排名达到140位，EI收录论文在全国高校排名达到71位。\r\n        学校与兰州市、酒泉市、白银市、金昌市、温州市等20余个省内外城市建立了全面合作关系，与酒钢公司、金川公司、兰州石化公司、兰石集团等200多家企业建立了稳定的产学研合作关系。学校积极深化与地方政府、企业的合作，成立了“兰州理工大学——金川集团股份有限公司镍钴金属新材料协同创新中心”、“西北低碳城镇支撑技术协同创新中心 ”、“甘肃省工业经济发展研究院”、“甘肃生态建设与环境保护研究中心”、“中国国际电子商务培训学院——甘肃省分院”、“兰州理工大学兰州新区产业发展研究院”、“兰州理工大学—金川集团股份有限公司工程技术研究院”、“兰理工大学温州泵阀工程研究院”、 “兰州理工大学白银新材料研究院”、“兰州理工大学兰石研究院”、“敦煌研究院—兰州理工大学文化遗产数字保护与再利用联合实验室”等科研机构，助推经济社会发展。\r\n        学校稳步推进国际化战略，主动服务“一带一路”倡议，与美国、俄罗斯、英国、澳大利亚等40余所大学建立了合作关系，是上海合作组织大学中方项目院校，加入了“一带一路”高校战略联盟，与台湾中正大学、昆山科技大学、静宜大学等签署了校际间的合作交流协议，与东南大学签署了第二轮（2018—2022年）对口支援协议。学校通过国家公派留学项目、西部特别项目、“2+2”、“1+2+1”等交流项目，每年派出200多名师生赴国外学习交流。学校具有中国政府奖学金留学生招生资格，来自35个国家的320多名国际学生在校学习。\r\n        学校秉承“奋进求是”的校训，大力弘扬以“艰苦奋斗，自强不息，求真务实，开拓创新”为主要内涵的“红柳精神”，党的建设、思想政治工作和精神文明建设成绩喜人，荣获“全国先进基层党组织”、“全国党建和思想政治工作先进高等学校”、“全国精神文明建设先进单位”、“全国文明单位”、 “易班共建示范高校”等荣誉。2017年荣获首届“全国文明校园”称号，成为甘肃省首家获此殊荣的高校。 “十三五”时期，学校将继续高举中国特色社会主义伟大旗帜，以马克思列宁主义、毛泽东思想、邓小平理论、“三个代表”重要思想、科学发展观、习近平新时代中国特色社会主义思想为指导，贯彻落实国家中长期教育改革和发展规划纲要，按照“四个全面”战略布局和五大发展理念，落实全国高校思想政治工作会议精神，以立德树人为根本，以支撑创新驱动发展战略、服务经济社会发展为导向，努力在2019年建校百年之际，把学校建设成为具有一流工科、坚实理科、特色文科的国内高水平教学研究型大学。 （资料更新：2018年7月） ', '校训', '校歌', '历史沿革', '1-2-3-4-', null, null, null, null, null, null, null, null, null, '亲爱的同学们：<br />\r\n       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;XX大学，一个读书的好地方，一个圆梦的好家园。在此，我们向你发出热情邀请并郑重承诺：\r\n	   我们将为每一个有梦想的学子搭建成长舞台，为每一个有追求的学子构筑心灵港湾，为每一个有准备的学子创造成功机遇。\r\n	   热忱欢迎有志学子加入浙师人的行列！让我们相约金秋美丽浙师！');

-- ----------------------------
-- Table structure for `stu_info`
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `id` varchar(255) NOT NULL default '',
  `sex` varchar(255) default NULL,
  `card` varchar(255) default NULL,
  `stu_id` varchar(255) default NULL,
  `exam_type` varchar(255) default NULL,
  `major_id` varchar(255) default NULL,
  `enrol_time` varchar(255) default NULL,
  `enrol_batch` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `phone2` varchar(255) default NULL,
  `qq` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `head_img` varchar(255) default NULL,
  `class_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('1', '男', '622626199503241212', '1516270255', '1', '1', '', '2015秋', '0', '18893842410', null, '2295346325', 'liwenx97@163.com', '甘肃省兰州市兰州理工大学本部', null, '1231');

-- ----------------------------
-- Table structure for `tuition`
-- ----------------------------
DROP TABLE IF EXISTS `tuition`;
CREATE TABLE `tuition` (
  `tu_id` varchar(32) NOT NULL,
  `coll_id` varchar(255) default NULL,
  `tu_major` varchar(255) default NULL COMMENT '专业名称',
  `tu_price1` varchar(255) default NULL COMMENT '学费价格',
  `tu_price2` varchar(255) default NULL,
  `tu_price3` varchar(255) default NULL,
  `tu_price4` varchar(255) default NULL,
  PRIMARY KEY  (`tu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuition
-- ----------------------------
INSERT INTO `tuition` VALUES ('1', '1', '软件工程', '5500', '5500', '14000', '14000');
INSERT INTO `tuition` VALUES ('2', '5', '土木工程', '5200', '5200', '5200', '5200');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(255) NOT NULL,
  `account` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `role` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `info_id` varchar(255) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'stu', '123456', '1', '某学生', '1516270255');
INSERT INTO `user` VALUES ('2', 'tea', '123456', '2', '某教师', null);
INSERT INTO `user` VALUES ('3', 'root', '123456', '3', '超级管理员', null);

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` varchar(32) NOT NULL,
  `v_title` varchar(100) default NULL,
  `v_url` varchar(100) default NULL,
  `v_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '2019年宜海音乐节', '1', '2019-02-06 14:08:40');
INSERT INTO `video` VALUES ('2', '工大2019年夏季运动会开幕式', 'http://vjs.zencdn.net/v/oceans.mp4', '2019-03-22 14:09:01');
INSERT INTO `video` VALUES ('3', '18级新生军训演出', '1', '2018-09-01 14:10:07');
