CREATE DATABASE `test_service_a` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

use `test_service_a`;

DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`
(
    `id`   int(0)       NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NULL,
    `age`  int(0)       NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`
(
    `id`            bigint(20)                                                    NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20)                                                    NOT NULL,
    `xid`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `rollback_info` longblob                                                      NOT NULL,
    `log_status`    int(11)                                                       NOT NULL,
    `log_created`   datetime(0)                                                   NOT NULL,
    `log_modified`  datetime(0)                                                   NOT NULL,
    `ext`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `ux_undo_log` (`xid`, `branch_id`) USING BTREE
);


CREATE DATABASE `test_service_b` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

use `test_service_b`;

DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school`
(
    `id`   int(0)       NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`
(
    `id`            bigint(20)                                                    NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20)                                                    NOT NULL,
    `xid`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `rollback_info` longblob                                                      NOT NULL,
    `log_status`    int(11)                                                       NOT NULL,
    `log_created`   datetime(0)                                                   NOT NULL,
    `log_modified`  datetime(0)                                                   NOT NULL,
    `ext`           varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `ux_undo_log` (`xid`, `branch_id`) USING BTREE
);