초기 시작 시

src/main/resources/application.properties 파일의 데이터베이스를 세팅해야함.. 
커밋되어있는 소스는 비어있음
예시
spring.datasource.url=jdbc:mysql://192.129.301.2:3306/acl?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&useUnicode=true
spring.datasource.username=acl
spring.datasource.password=aclxptmxm2!




데이터 생성 후 테이블 2개 생성 필요
CREATE TABLE `icl_board` (
  `boardId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `title` varchar(128) DEFAULT NULL COMMENT 'title',
  `comment` varchar(256) DEFAULT NULL COMMENT 'comment',
  `userId` bigint(20) DEFAULT NULL COMMENT 'user id',
  `password` varchar(128) DEFAULT NULL COMMENT '비회원 패스워드',
  `isDelete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`boardId`),
  KEY `ix_ab180_new_url_created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `icl_user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `userName` varchar(64) DEFAULT NULL COMMENT 'user name',
  PRIMARY KEY (`userId`),
  KEY `ix_ab180_new_url_created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

현재 기본 세팅은 8090 포트를 통해 작동하도록 되어있다..
MainClass 는 src/main/com/icl/icl/IclApplication
