CREATE TABLE `brand`
(
    `modelid`    int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `modelname`  varchar(255) DEFAULT NULL COMMENT '模块名称',
    `createtime` datetime     DEFAULT NULL COMMENT '创建时间',
    `updatetime` datetime     DEFAULT NULL COMMENT '修改时间',
    `state`      int(11) DEFAULT '1' COMMENT '状态：0弃用，1启用',
    PRIMARY KEY (`modelid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


CREATE TABLE `picture`
(
    `pictreid`    int(11) NOT NULL AUTO_INCREMENT COMMENT ' 图片id',
    `websiteid`   int(11) DEFAULT NULL COMMENT '主站id',
    `websiteurl`  varchar(255) DEFAULT NULL COMMENT '主站url',
    `websitename` varchar(255) DEFAULT NULL COMMENT '主站名称',
    `articleurl`  varchar(255) DEFAULT NULL COMMENT '文章地址',
    `title`       varchar(255) DEFAULT NULL COMMENT '文章标题',
    `pictreurl`   varchar(255) DEFAULT NULL COMMENT '截图保存地址',
    `modelname`   varchar(64)  DEFAULT NULL COMMENT '类型',
    `level`       varchar(64)  DEFAULT NULL COMMENT '等级',
    `createtime`  datetime     DEFAULT NULL COMMENT '创建时间',
    `updatetime`  datetime     DEFAULT NULL COMMENT '修改时间',
    `state`       int(11) DEFAULT '1' COMMENT '状态',
    PRIMARY KEY (`pictreid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3183 DEFAULT CHARSET=utf8


CREATE TABLE `position`
(
    `locationid` int(11) NOT NULL AUTO_INCREMENT COMMENT '定位id',
    `websiteid`  int(11) DEFAULT NULL COMMENT '网站id',
    `region`     varchar(255) DEFAULT NULL COMMENT '定位xpath',
    `scrollarea` varchar(255) DEFAULT NULL COMMENT '滚动区域定位(鼠标停留位置)',
    `level`      varchar(255) DEFAULT NULL COMMENT '等级',
    PRIMARY KEY (`locationid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8


CREATE TABLE `reptile`
(
    `reptileid`  int(11) NOT NULL AUTO_INCREMENT COMMENT '爬虫id',
    `locationid` int(11) DEFAULT NULL COMMENT '定位id(这个爬虫规则的定位位置的信息)',
    `websiteid`  int(11) DEFAULT NULL COMMENT '这个爬虫所属网站',
    `divtitle`   varchar(255) DEFAULT NULL COMMENT '这个爬虫规则的区块（取这个里面的所有a标签）',
    PRIMARY KEY (`reptileid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8

CREATE TABLE `role`
(
    `roleid`     int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `modelid`    int(11) DEFAULT NULL COMMENT '车型id',
    `modelname`  varchar(255) DEFAULT NULL COMMENT '车型名称',
    `roletitle`  varchar(255) DEFAULT NULL COMMENT '规则，文章标题',
    `websiteid`  int(11) DEFAULT NULL COMMENT '网站id',
    `websiteurl` varchar(255) DEFAULT NULL COMMENT '网址',
    `createtime` datetime     DEFAULT NULL COMMENT '创建时间',
    `updatetime` datetime     DEFAULT NULL COMMENT '批改时间',
    `state`      int(11) DEFAULT '1' COMMENT '批改状态（0不可用，1可用，2未批改）',
    PRIMARY KEY (`roleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8

CREATE TABLE `website`
(
    `websiteid`   int(11) NOT NULL AUTO_INCREMENT COMMENT '网站id',
    `websitename` varchar(64) NOT NULL COMMENT '网站名称',
    `websiteurl`  varchar(64) NOT NULL COMMENT '网站url',
    `createtime`  datetime    NOT NULL COMMENT '创建时间',
    `updatetime`  datetime    NOT NULL COMMENT '修改时间',
    `state`       int(11) NOT NULL DEFAULT '1' COMMENT '状态',
    PRIMARY KEY (`websiteid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8



















