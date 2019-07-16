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

