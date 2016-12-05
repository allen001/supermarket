/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.11 : Database - supermarket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarket` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `supermarket`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `login_id` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '账户',
  `login_password` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `create_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';

/*Data for the table `t_admin` */

insert  into `t_admin`(`login_id`,`login_password`,`create_by`,`create_time`) values ('admin','111111','111','2016-11-17 16:27:21'),('admin1','111111','10000','2016-11-23 16:53:37');

/*Table structure for table `t_buy` */

DROP TABLE IF EXISTS `t_buy`;

CREATE TABLE `t_buy` (
  `buy_id` char(12) COLLATE utf8_bin NOT NULL COMMENT '进货单号(yyyyMMdd001)',
  `good_id` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '商品编号',
  `supp_id` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '供货商编号',
  `sum` int(11) DEFAULT NULL COMMENT '数量',
  `amount` decimal(18,2) DEFAULT NULL COMMENT '单价',
  `total_amount` decimal(18,2) DEFAULT NULL COMMENT '总金额',
  `buy_time` datetime DEFAULT NULL COMMENT '进货日期',
  `others` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`buy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='进货表';

/*Data for the table `t_buy` */

insert  into `t_buy`(`buy_id`,`good_id`,`supp_id`,`sum`,`amount`,`total_amount`,`buy_time`,`others`,`create_by`,`create_time`) values ('20161117001','000001','000001',111,'3.50','388.50','2016-11-18 00:00:00','',NULL,NULL),('20161118001','000001','000001',11,'3.50','38.50','2016-11-18 00:00:00','111','10000','2016-11-18 15:15:30'),('20161118002','000001','000001',111,'3.50','388.50','2016-11-19 00:00:00','11','10000','2016-11-18 15:27:19'),('20161118003','000001','000001',1,'3.50','3.50','2016-11-10 00:00:00','111','10000','2016-11-18 15:53:09'),('B20161118001','000001','000001',111,'3.50','388.50','2016-11-11 00:00:00','11','10000','2016-11-18 16:18:19');

/*Table structure for table `t_goods` */

DROP TABLE IF EXISTS `t_goods`;

CREATE TABLE `t_goods` (
  `merch_id` char(6) COLLATE utf8_bin NOT NULL COMMENT '商品编号',
  `supp_id` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '供货商编号',
  `merch_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  `kind` varchar(4) COLLATE utf8_bin DEFAULT NULL COMMENT '类别',
  `unit_cost` decimal(18,2) DEFAULT NULL COMMENT '单价',
  `merch_addr` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '产地',
  `others` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`merch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品信息';

/*Data for the table `t_goods` */

insert  into `t_goods`(`merch_id`,`supp_id`,`merch_name`,`kind`,`unit_cost`,`merch_addr`,`others`,`create_by`,`create_time`) values ('000001','000001','脉动','3','3.50','北京','本月主打','10000','2016-11-16 18:57:26');

/*Table structure for table `t_member` */

DROP TABLE IF EXISTS `t_member`;

CREATE TABLE `t_member` (
  `member_id` char(20) COLLATE utf8_bin NOT NULL COMMENT '会员编号',
  `member_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `idcard` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证',
  `member_discount` int(4) DEFAULT NULL COMMENT '折扣',
  `others` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='会员信息';

/*Data for the table `t_member` */

insert  into `t_member`(`member_id`,`member_name`,`sex`,`idcard`,`member_discount`,`others`,`create_by`,`create_time`) values ('000001','王五','0','132202199101112211',11,'VIP客户','10000','2016-11-16 18:19:14');

/*Table structure for table `t_sell` */

DROP TABLE IF EXISTS `t_sell`;

CREATE TABLE `t_sell` (
  `sell_id` char(12) COLLATE utf8_bin NOT NULL COMMENT '销售单号(yyyyMMdd001)',
  `supp_id` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '供货商编号',
  `good_id` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '商品编号',
  `sum` int(11) DEFAULT NULL COMMENT '数量',
  `amount` decimal(18,2) DEFAULT NULL COMMENT '单价',
  `total_amount` decimal(18,2) DEFAULT NULL COMMENT '总金额',
  `sell_time` datetime DEFAULT NULL COMMENT '销售日期',
  `others` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `creat_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`sell_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_sell` */

insert  into `t_sell`(`sell_id`,`supp_id`,`good_id`,`sum`,`amount`,`total_amount`,`sell_time`,`others`,`creat_by`,`creat_time`) values ('20161118001','000001','000001',111,'3.50','388.50','2016-11-24 00:00:00','11','10000','2016-11-18 16:15:00'),('S20161118001','000001','000001',23,'3.50','80.50','2016-11-02 00:00:00','1','10000','2016-11-18 16:18:48');

/*Table structure for table `t_staffbill` */

DROP TABLE IF EXISTS `t_staffbill`;

CREATE TABLE `t_staffbill` (
  `staff_id` char(6) COLLATE utf8_bin NOT NULL COMMENT '职工编号',
  `stall_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '职工姓名',
  `stall_password` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '职工密码',
  `sex` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '性别 0:男 1:女',
  `idcard` varchar(18) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证',
  `others` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='职员信息';

/*Data for the table `t_staffbill` */

insert  into `t_staffbill`(`staff_id`,`stall_name`,`stall_password`,`sex`,`idcard`,`others`,`create_by`,`create_time`) values ('000001','张三','123','0','132202199101112211','备注','10000','2016-11-16 17:26:07'),('000002','李四','234','1','13220219930221214','','10000','2016-11-16 17:26:38');

/*Table structure for table `t_supplier` */

DROP TABLE IF EXISTS `t_supplier`;

CREATE TABLE `t_supplier` (
  `supp_id` char(6) COLLATE utf8_bin NOT NULL COMMENT '供货商编号',
  `supp_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `contact_person` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `telphone` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `address` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '联系地址',
  `others` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_by` char(6) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`supp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='供货商信息';

/*Data for the table `t_supplier` */

insert  into `t_supplier`(`supp_id`,`supp_name`,`contact_person`,`telphone`,`address`,`others`,`create_by`,`create_time`) values ('000001','北京微保金服','Jason.Meng','182222811122','北京市西直门','备注','10000','2016-11-16 17:09:30');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
