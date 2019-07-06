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




