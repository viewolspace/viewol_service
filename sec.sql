CREATE TABLE `expo` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;


CREATE TABLE `expo_company` (
  `expo_id` INT(11) NOT NULL,
  `company_id` INT(11) NOT NULL,
  `c_time` DATETIME,
  PRIMARY KEY (`expo_id`,`company_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

CREATE TABLE `expo_product` (
  `expo_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `c_time` datetime,
  PRIMARY KEY (`expo_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

alter table `viewol`.`schedule`
   add column `expo_id` int(11) DEFAULT '1' NOT NULL after `seq`;

ALTER TABLE `viewol_ms`.`sys_user`
ADD COLUMN `expo_id` int(11) NULL COMMENT '展会ID' AFTER `company_id`;


alter table `viewol`.`info`
   add column `status` int(11) NULL COMMENT '-1 打回  0 待审 1 发布' after `md5_str`;

alter table `viewol`.`info`
   add column `m_time` datetime NULL   after `md5_str`;

alter table `viewol`.`info`
   add column `content` text NULL   after `md5_str`;

alter table `viewol`.`info`
   add column `classify` int(11) NULL DEFAULT '1' COMMENT '1 安防展  2 消防展' after `md5_str`;

alter table `viewol`.`info`
   add column `company_id` int(11) NULL after `classify`;

-------------2019-07-04---------------

CREATE TABLE `user_interact` (
  `id` INT(11) NOT NULL,
  `classify` INT(11) NOT NULL  COMMENT '1 展商 2 产品',
  `type` INT(11) NOT NULL  COMMENT '1 围观 2 点赞 3 评论',
  `third_id` INT(11) NOT NULL COMMENT '展商ID 或者 产品ID',
  `user_id` INT(11) NOT NULL,
  `user_name` VARCHAR(50) DEFAULT NULL,
  `head_img_url` VARCHAR(300) DEFAULT NULL,
  `comment` VARCHAR(200) DEFAULT NULL COMMENT '100字以内',
  `c_time` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;



alter table `viewol`.`product`
   add column `see_num` int(11) DEFAULT '0' NULL COMMENT '围观数量' after `top_num`,
   add column `praise_num` int(11) DEFAULT '0' NULL COMMENT '点赞数量' after `see_num`,
   add column `comment_num` int(11) DEFAULT '0' NULL COMMENT '评论数量' after `praise_num`;

alter table `viewol`.`company`
   add column `see_num` int(11) DEFAULT '0' NULL COMMENT '围观数量' after `top_num`,
   add column `praise_num` int(11) DEFAULT '0' NULL COMMENT '点赞数量' after `see_num`,
   add column `comment_num` int(11) DEFAULT '0' NULL COMMENT '评论数量' after `praise_num`;

alter table `viewol`.`company`
   add column `show` varchar(1000) NULL COMMENT '展商秀相关' after `comment_num`


------init-sql
INSERT INTO expo_company SELECT 1,id,NOW() FROM company;

INSERT INTO expo_product SELECT 1,id,NOW() FROM  product;


ALTER TABLE `viewol`.`company`
CHANGE COLUMN `show` `show_info` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展商秀相关' AFTER `comment_num`;

alter table `viewol`.`product`
   add column `award` int(11) DEFAULT '0' NULL COMMENT '0 未获奖 1获奖' after `comment_num`

--------2019-07-16 ----------
ALTER TABLE `viewol`.`user_interact`
MODIFY COLUMN `id` int(11) NOT NULL AUTO_INCREMENT FIRST;



--------2019-07-25 ----------
CREATE TABLE `product_idea` (
  `product_id` INT(11) NOT NULL,
  `company_id` INT(11) NOT NULL,
  `company_name` VARCHAR(200) NOT NULL,
  `company_place` VARCHAR(200) NOT NULL COMMENT '展位号',

  `liaison_man` VARCHAR(200) NOT NULL COMMENT '联系人',
  `phone` VARCHAR(200) NOT NULL  COMMENT '手机',
  `land_line` VARCHAR(200) NOT NULL COMMENT '座机',
  `website` VARCHAR(200) NOT NULL COMMENT '网站',
  `email` VARCHAR(200) NOT NULL COMMENT '邮箱',

  `category_id` VARCHAR(200) NOT NULL COMMENT '产品类别',
  `logo` VARCHAR(200) NOT NULL COMMENT '产品商标',

  `des` VARCHAR(200) NOT NULL COMMENT '产品概况',
  `quota` VARCHAR(200) NOT NULL COMMENT '关键技术指标',
  `idea_point` VARCHAR(200) NOT NULL COMMENT '产品创新点',
  `extend` VARCHAR(200) NOT NULL COMMENT '国内外市场推广情况',

  `product_pic` VARCHAR(200) NOT NULL COMMENT '展品图片',
  `com_logo` VARCHAR(200) NOT NULL COMMENT '公司logo',
  `ext` VARCHAR(200) NOT NULL COMMENT '相关证书(证书打包上传)',
  `c_time` DATETIME NULL DEFAULT NULL,
  `m_time` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;


alter table `viewol`.`product_idea`
   add column `product_name` varchar(200) NOT NULL after `product_id`;

alter table `viewol`.`product_idea`
   add column `model` varchar(100) NULL after `m_time`;

alter table `viewol`.`product_idea`
   add column `status` int(4) DEFAULT '0' NULL COMMENT '0 等待评选  1 评选通过 -1 评选失败' after `model`



#### 2019-07-29
alter table `viewol`.`f_user`
   add column `user_join` int(8) DEFAULT '0' NULL COMMENT '是否报名 0 未报名  1 已报名' after `head_img_url`

------2019-08-10---------
ALTER TABLE `viewol`.`product_idea`
ADD COLUMN `other_category` varchar(255) NULL COMMENT '自定义产品类别' AFTER `category_id`;

---------2019-08-12-----------------
ALTER TABLE `viewol`.`info`
ADD COLUMN `site` int(1) NULL COMMENT '1-站内 2-站外' AFTER `status`;

---------2019-08-15-----------------
ALTER TABLE `viewol`.`product_idea`
ADD COLUMN `promise_pic` varchar(255) NULL COMMENT '申报单位承诺，加盖图片地址' AFTER `status`;

ALTER TABLE `viewol`.`product_idea`
MODIFY COLUMN `des` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '产品概况' AFTER `logo`;

---------2019-08-21-----------------
alter table `viewol`.`schedule`
   add column `bbs` int(11) DEFAULT '0' NULL COMMENT '1 论坛  0 其他' after `expo_id`


---------2019-10-09-----------------



-----------20201015----------------------

CREATE TABLE `product_idea_new` (
  `product_id` INT(11) NOT NULL,
  `company_id` INT(11) NOT NULL,
  `company_name` VARCHAR(200) NOT NULL,
  `product_name` VARCHAR(200) NOT NULL,
  `address` VARCHAR(200) NOT NULL COMMENT '通信地址和邮编',
  `phone` VARCHAR(200) NOT NULL  COMMENT '联系人及移动电话',
  `category_id` VARCHAR(200) NOT NULL COMMENT '产品类别',
  `other_category` varchar(255) NULL COMMENT '自定义产品类别' ,
  `des` VARCHAR(200) NOT NULL COMMENT '申报消防技术产品的具体名称和规格、型号（每张申报表填写1项）',
  `quota` VARCHAR(200) NOT NULL COMMENT '采用了哪些新技术、新材料、新工艺，实现了哪些新功能或者开辟了哪些新的应用领域',
  `idea_point` VARCHAR(200) NOT NULL COMMENT '与同类技术产品比较，主要包括：性价比，适用性，安全性、可靠性，市场和应用前景如何',
  `achievement` VARCHAR(200) NOT NULL COMMENT '2019年1月1日至今，获得的发明专利或实用新型专利授权、软件著作权等',
  `achievement_zip` VARCHAR(200) NOT NULL COMMENT '专利，软著相关图片，多个请合并到一个图片上传',
  `standard` VARCHAR(200) NOT NULL COMMENT '针对申报的消防技术产品，是否已经编制发布了企业标准，标准名称、发布时间及编号',
  `core` VARCHAR(200) NOT NULL COMMENT '何时通过何种评价机构和评定方式，证明核心、关键技术指标达到国内领先或国际先进水平',
  `core_pic` VARCHAR(200) NOT NULL COMMENT '相关证明，多个图片合并',
  `promise_pic` varchar(255) NULL COMMENT '申报单位承诺，加盖图片地址',
  `product_pic` VARCHAR(200) NOT NULL COMMENT '展品图片',
  `com_logo` VARCHAR(200) NOT NULL COMMENT '公司logo',
  `status` INT(11) NOT NULL,
  `c_time` DATETIME NULL DEFAULT NULL,
  `m_time` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;


-----------20210412----------------------
alter table `viewol`.`company`
   add column `user_num` varchar(100) NULL COMMENT '企业信用代码' after `show_info`;

CREATE INDEX idx_user_num ON company(user_num);

alter table product
    add uuid varchar(64) not null comment '上游产品ID';

CREATE INDEX idx_uuid ON product(uuid);




------------20210502--------------------
alter table `viewol`.`product_idea_new`
   add column `ask` int(4) DEFAULT '0' NULL COMMENT '是否提供现场答疑 0 未选  1 不提供  2 提供' after `m_time`,
   add column `pro_view` int(4) DEFAULT '0' NULL COMMENT '是否提供产品展示 0 未选 1 不提供  2 提供' after `ask`,
   add column `pro_event` int(4) DEFAULT '0' NULL COMMENT '是否参与推荐活动 0 未选 1 不提供  2 提供' after `pro_view`,
   add column `video` varchar(200) NULL COMMENT '视频地址' after `pro_event`;


create table `viewol`.`ad_media`(
   `id` int(11) NOT NULL AUTO_INCREMENT ,
   `company_id` int(11) ,
   `company_name` varchar(300) ,
   `show_room` varchar(200) COMMENT '展厅',
   `item_name` varchar(200) COMMENT '项目名称',
   `num` varchar(200) COMMENT '序号',
   `size` varchar(200) COMMENT '尺寸',
   `price` varchar(200) COMMENT '价格',
   `phone` varchar(15) COMMENT '联系电话',
   `user_name` varchar(200) COMMENT '联系人',
   `c_time` datetime COMMENT '申请时间',
   PRIMARY KEY (`id`)
 )